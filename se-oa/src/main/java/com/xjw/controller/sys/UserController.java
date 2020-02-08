package com.xjw.controller.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.UserForm;
import com.xjw.entity.po.sys.Dept;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Agent;
import com.xjw.entity.vo.UserVo;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.DeptService;
import com.xjw.service.sys.RoleService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.AgentService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/sysuser/")
public class UserController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private DeptService deptService;
    @Autowired
    private HttpServletRequest request;
    @Resource
    private AgentService agentService;

    private static final String addPage = "/sysuser/skipAdd";
    private static final String editPage = "/sysuser/skipModify";
    private static final String listPage = "/sysuser/list";

    @RequestMapping("/validateLoginName")
    public void validateLoginName(HttpServletResponse response, UserForm userForm, HttpServletRequest request)
            throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loginName", userForm.getLoginName());
        params.put("statusList",
                StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode() + "," + StatusEnum.LOCK.getCode()));
        long count = userService.selectAllCount(params);
        if (count > 0) {
            response.getWriter().print(false);
        } else {
            response.getWriter().print(true);
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "public/user/index";
    }

    @RequestMapping("/skipAdd")
    public String skipAdd(UserForm userForm, Model model) {
        model.addAttribute("deptId", userForm.getDeptId());
        model.addAttribute("userDept", userForm.getUserDept());

        if ("65".equals(userForm.getDeptId())) {// 销售部添加代理用户
            Map<String, Object> conditionParam = new HashMap<String, Object>();
            conditionParam.put("statusList", StringUtil.getListFromStr("1,3"));
            List<Agent> ListAgent = (List<Agent>) agentService.selectAll(conditionParam);
            model.addAttribute("agent", ListAgent);
        }
        return "public/user/add";
    }

    @RequestMapping("/skipModify")
    public String skipModify(UserForm userForm, Model model) {
        User user = userService.selectById(Long.valueOf(userForm.getId()));
        model.addAttribute("deptId", userForm.getDeptId());
        model.addAttribute("user", user);
        model.addAttribute("userDept", userForm.getUserDept());

        if ("65".equals(userForm.getDeptId())) {// 销售部加代理用户功能
            Map<String, Object> conditionParam = new HashMap<String, Object>();
            conditionParam.put("statusList", StringUtil.getListFromStr("1,3"));
            List<Agent> ListAgent = (List<Agent>) agentService.selectAll(conditionParam);
            model.addAttribute("agent", ListAgent);

            Map<Long, Long> map = new HashMap<Long, Long>();
            String agentIds = user.getAgentId();
            if (StringUtils.isNotBlank(agentIds)) {
                String[] agentId = agentIds.split(",");
                for (int i = 0; i < agentId.length; i++) {
                    map.put(new Long(agentId[i]), new Long(agentId[i]));
                }
            }

            for (Agent agent : ListAgent) {// 把前台选中的值设置到这个对象中，用AgentId和Id来比较,如果相同就选中
                Long id = map.get(agent.getId());
                if (null != id && id.longValue() == id.longValue()) {
                    agent.setAgentId(agent.getId());
                }
            }
        }

        return "public/user/modify";
    }

    @RequestMapping("/save")
    public void save(User user, UserForm userForm, Model model, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deptId", userForm.getDeptId());
        params.put("userDept", userForm.getUserDept());
        try {
            userService.saveUserAndDeptRel(user, Long.valueOf(userForm.getDeptId()));
            this.writerSuccessJSONDataById("新增成功", addPage, null, listPage, params);
        } catch (Exception e) {
            writerJSONData("failure", "新增失败", null, listPage, params);
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping("/modify")
    public void modify(User user, UserForm userForm, Model model, HttpServletResponse response) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", user.getId());
        param.put("deptId", userForm.getDeptId());
        param.put("userDept", userForm.getUserDept());
        try {
            userService.updateUserAndDeptRel(user, Long.valueOf(userForm.getDeptId()),
                    Long.valueOf(userForm.getOldDeptId()));
            this.writerSuccessJSONDataById("编辑成功", null, editPage, listPage, param);
        } catch (Exception e) {
            writerJSONData("failure", "编辑失败", null, listPage, param);
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping("/del")
    public String del(UserForm userForm) {
        try {
            userService.deleteUserAndDeptRel(userForm.getIds());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:/sysuser/list?deptId=" + userForm.getDeptId();
    }

    @RequestMapping("/list")
    public String list(Model model, UserForm userForm, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (StringUtils.isNotBlank(userForm.getKeywords())) {
            params.put("keywords", userForm.getKeywords());
        }
        if (StringUtils.isNotBlank(userForm.getStatus())) {
            params.put("searchStatus", userForm.getStatus());
        }
        params.put("statusList",
                StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode() + "," + StatusEnum.LOCK.getCode()));
        String deptId = null;

        deptId = userForm.getDeptId();
        if (StringUtil.isNotBlank(deptId)) {
            Dept dept = deptService.selectById(Long.valueOf(deptId));
            if (dept != null) {
                userForm.setDeptCode(dept.getCode());
                userForm.setUserDept(dept.getName());
            }
            params.put("deptId", userForm.getDeptId());
        }

        if (StringUtils.isNotBlank(deptId)) {
            try {
                Page<User> page = userService.getPage(params, userForm.getPageNo(), userForm.getPageSize());
                List<UserVo> userVoList = roleService.selectRoleNameByUserList(page.getDataList());

                model.addAttribute("list", userVoList);
                model.addAttribute("page", page);
            } catch (BizException e) {
                logger.error(e.getMessage(), e);
            }
            model.addAttribute("form", userForm);
        }

        return "public/user/list";
    }

    @RequestMapping("modifypwd")
    @ResponseBody
    public String modifypwd(@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd) {
        User user = super.getCurrentUser();

        try {
            userService.modifyPwd(user, oldPwd, newPwd);
        } catch (BizException e) {
            logger.error(e.getMessage(), e);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", e.getMessage());
            return jsonObject.toString();
        }

        User newUser = userService.selectById(user.getId());
        request.getSession(true).setAttribute(Constant.USER_SESSION, newUser);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        jsonObject.put("msg", "密码修改成功");
        return jsonObject.toString();
    }
}
