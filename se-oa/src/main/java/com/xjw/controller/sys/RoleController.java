package com.xjw.controller.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.RoleForm;
import com.xjw.entity.form.sys.UserForm;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.Role;
import com.xjw.entity.po.sys.RoleFunctionRel;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.vo.UserVo;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.RoleFunctionRelService;
import com.xjw.service.sys.RoleService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.service.sys.UserService;
import com.xjw.utility.BeanToMapUtil;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/sysrole/")
public class RoleController extends BaseController {
  private static Logger logger = LoggerFactory.getLogger(RoleController.class.getName());
  @Resource
  private RoleService roleService;
  @Resource
  private FunctionService functionService;
  @Resource
  private RoleFunctionRelService roleFunctionRelService;
  @Resource
  private UserService userService;
  @Resource
  private UserRoleRelService userRoleRelService;

  private static final String addPage = "/sysrole/skipAdd";
  private static final String editPage = "/sysrole/skipModify";
  private static final String listPage = "/sysrole/list";
  private static final String setFunctionPage = "/sysrole/skipSetFunction";

  @RequestMapping("/validateCode")
  public void validateCode(HttpServletResponse response, RoleForm roleForm) throws IOException{
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("code", roleForm.getCode());
    params.put("statusList", StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode().toString()));
    List<Role> list = roleService.selectAll(params);
    if(list != null && list.size() > 0){
      if(StringUtils.isNotBlank(roleForm.getId())){
        if(list.get(0).getId().toString().equals(roleForm.getId())){
          response.getWriter().print(true);
        }else{
          response.getWriter().print(false);
        }
      }else{
        response.getWriter().print(false);
      }
    }else{
      response.getWriter().print(true);
    }
  }
  
  @RequestMapping("/skipAdd")
  public String skipAdd() {
    return "public/role/add";
  }

  @RequestMapping("/skipModify")
  public String skipModify(RoleForm roleForm, Model model) {
    Role role = roleService.selectById(Long.valueOf(roleForm.getId()));
    model.addAttribute("role", role);
    return "public/role/modify";
  }

  @RequestMapping("/save")
  public void save(Role role, Model model, HttpServletResponse response) {
    try {
      roleService.save(role);
      this.writerSuccessJSONDataById("新增成功", addPage, null, listPage, null);
    } catch (Exception e) {
      writerJSONData("failure", "新增失败", null, listPage);
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }

  @RequestMapping("/modify")
  public void modify(Role role, Model model, HttpServletResponse response) {
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("id", role.getId());
    try {
      roleService.update(role);
      this.writerSuccessJSONDataById("编辑成功", null, editPage, listPage, param);
    } catch (Exception e) {
      writerJSONData("failure", "编辑失败", null, listPage, param);
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }

  @SuppressWarnings("unchecked")
  @RequestMapping("/del")
  public String del(RoleForm roleForm) {
    try {
      roleService.delete(StringUtil.getListFromStr(roleForm.getIds()));
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "redirect:/sysrole/list";
  }

  @RequestMapping("/list")
  public String list(Model model, RoleForm roleForm) {
    Map<String, Object> conditionParam = new HashMap<String, Object>();
    if(StringUtils.isNotBlank(roleForm.getKeywords())){
      conditionParam.put("keywords", roleForm.getKeywords());
    }
    try {
      Page<Role> page = roleService.getPage(conditionParam, roleForm.getPageNo(), 20);
      model.addAttribute("list", page.getDataList());
      model.addAttribute("page", page);
    } catch (BizException e) {
    	logger.error(e.getMessage(), e);
  	  logger.error("---fill---:" + e.fillInStackTrace());
  	  logger.error("---msg---:"+ e.getMessage());
  	  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("roleForm", roleForm);
    return "public/role/list";
  }

  @SuppressWarnings("unchecked")
  @RequestMapping("/skipSetFunction")
  public String skipSetFunction(RoleForm roleForm, Model model) {
	User user = super.getCurrentUser();
	  
    List<Function> functionList = functionService.getNormalFunctionList(user.getId());
    String roleId = roleForm.getRoleId();
    Role role = roleService.selectById(Long.valueOf(roleId));

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleId", roleId);
    List<RoleFunctionRel> roleFuntionRelList = roleFunctionRelService.selectAll(params);

    List<Map<String, Object>> functionMapList = new ArrayList<Map<String, Object>>();
    for (Function function : functionList) {
      try {
        Map<String, Object> funcMap = BeanToMapUtil.convertBean(function);
        for (RoleFunctionRel roleFunctionRel : roleFuntionRelList) {
          if (function.getId().longValue() == roleFunctionRel.getFunctionId().longValue()) {
            funcMap.put("possess", Constant.CommonManage.YES);
            funcMap.put("dataAuthType", roleFunctionRel.getDataAuthType());
            break;
          } else {
            funcMap.put("possess", Constant.CommonManage.NO);
          }
        }
        functionMapList.add(funcMap);
      } catch (Exception e) {
    	  logger.error(e.getMessage(), e);
    	  logger.error("---fill---:" + e.fillInStackTrace());
    	  logger.error("---msg---:"+ e.getMessage());
    	  logger.error("---e---:" + e.toString());
      }
    }
    model.addAttribute("role", role);
    model.addAttribute("list", functionMapList);
    return "public/role/setFunction";
  }

  @RequestMapping("/setFunctions")
  public void setFunctions(RoleForm roleForm, Model model, HttpServletRequest request, HttpServletResponse response) {
    try {
      String[] functionIds = request.getParameterValues("functionId");
      Map<String, Object> map = new HashMap<String, Object>(); 
      for (String functionId : functionIds) {
        String dataAuthType = request.getParameter("dataAuthType" + functionId);
        if(StringUtils.isNotBlank(dataAuthType)){
          map.put(functionId, dataAuthType);
        }
      }
      String roleId = roleForm.getRoleId();
      roleFunctionRelService.saveNewRecordBatch(functionIds, Long.valueOf(roleId), map);
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("roleId", roleId);
      writerSuccessJSONData("角色功能设置成功", "继续设置", setFunctionPage, null, null, null, listPage, params);
    } catch (Exception e) {
      writerJSONData("failure", "设置失败", null, listPage);
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }

  @RequestMapping("/userList")
  public String userList(Model model, UserForm userForm) {
    Map<String, Object> params = new HashMap<String, Object>();
    if(StringUtils.isNotBlank(userForm.getDeptId())){
      params.put("deptId", userForm.getDeptId());
      if(StringUtils.isNotBlank(userForm.getKeywords())){
        params.put("keywords", userForm.getKeywords());
      }
      if(StringUtils.isNotBlank(userForm.getStatus())){
        params.put("status", userForm.getStatus());
      }
      try {
        Page<User> page = userService.getPage(params, userForm.getPageNo(), userForm.getPageSize());
        List<UserVo> userVoList = roleService.selectRoleNameByUserList(page.getDataList());
        model.addAttribute("list", userVoList);
        model.addAttribute("page", page);
      } catch (BizException e) {
        e.printStackTrace();
        logger.error(e.getMessage(), e);
  	  logger.error("---fill---:" + e.fillInStackTrace());
  	  logger.error("---msg---:"+ e.getMessage());
  	  logger.error("---e---:" + e.toString());
      }
      model.addAttribute("form", userForm);
    }
    
    return "public/role/user/list";
  }

  @RequestMapping("/skipSetUserAuthIndex")
  public String skipSetUserAuthIndex(RoleForm roleForm, Model model) {
    model.addAttribute("roleId", roleForm.getRoleId());
    return "public/role/user/index";
  }

  @RequestMapping("/setUserAuth")
  public String setUserAuth(RoleForm roleForm, Model model) {
    try {
      userRoleRelService.saveNewRecordBatch(roleForm.getIds(), Long.valueOf(roleForm.getRoleId()));
    } catch (Exception e) {
    	logger.error(e.getMessage(), e);
  	  logger.error("---fill---:" + e.fillInStackTrace());
  	  logger.error("---msg---:"+ e.getMessage());
  	  logger.error("---e---:" + e.toString());
    }
    return "redirect:/sysrole/userList?roleId=" + roleForm.getRoleId() + "&deptId=" + roleForm.getDeptId();
  }

}
