package com.xjw.controller.sys;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.RoleFunctionRel;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.RoleFunctionRelService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.util.TreeUtil;

@Controller
@RequestMapping("/sysauth/")
public class AuthController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(AuthController.class.getName());

  @Resource
  private FunctionService functionService;
  @Resource
  private RoleFunctionRelService roleFunctionRelService;
  @Resource
  private UserRoleRelService userRoleRelService;

  /**
   * 程序菜单加载
   * @param model
   * @param response
   */
  @RequestMapping(value = "/getFunctionList", method = RequestMethod.GET)
  public void getFunctionList(Model model, HttpServletResponse response) {
    PrintWriter out = null;
    try {
      User user = this.getCurrentUser();
      List<Function> funcList = functionService.getNormalFunctionList(user.getId());
      
      List<Function> firstMenuList = new ArrayList<Function>();
      for(Function func : funcList){
    	  if(0L == func.getParentId()){
    		  firstMenuList.add(func);
    	  }
      }
      
      String jsonMenu = null;
      JSONArray jsonArray = null;
      JSONObject jsonObj = new JSONObject();
      if(user.getType().byteValue() != Integer.valueOf(UserTypeAllEnum.GLY.getCode()).byteValue()){
        List<UserRoleRel> userRoleRel = userRoleRelService.getRoleIdsByUserId(user.getId());
        
        if(userRoleRel != null && userRoleRel.size() > 0){
              List<RoleFunctionRel> roleFuntionRelList = roleFunctionRelService.getRoleFunctionRelByRoleId(userRoleRel.get(0).getRoleId());
              List<Function> userFristMenu = new ArrayList<Function>();
              if(roleFuntionRelList != null && roleFuntionRelList.size() > 0){
                for (Function function : firstMenuList) {
                  for (RoleFunctionRel roleFunctionRel : roleFuntionRelList) {
                    if(function.getId().longValue() == roleFunctionRel.getFunctionId().longValue()){
                      userFristMenu.add(function);
                      break;
                    }
                  }
                }
                jsonArray = new JSONArray();
                for(Function function : userFristMenu) {
                	jsonArray.add(JSONObject.toJSON(function));
                }
                
                jsonObj.put("menuFirst", jsonArray);
                List<Function> userFunction = new ArrayList<Function>();
                  for (int i = 0; i < funcList.size(); i++) {
                    for (RoleFunctionRel roleFunctionRel : roleFuntionRelList) {
                      if(funcList.get(i).getId().longValue() == roleFunctionRel.getFunctionId().longValue()){
                        userFunction.add(funcList.get(i));
                        break;
                      }
                    }
                  }
                  jsonMenu = TreeUtil.treeList2Json(getBasePath(), userFunction);
              }
        }
        
      }else if(user.getType().byteValue() == Integer.valueOf(UserTypeAllEnum.GLY.getCode()).byteValue()){
    	  jsonArray = new JSONArray();
    	  for(Function function : firstMenuList) {
          	jsonArray.add(JSONObject.toJSON(function));
          }
    		  
    	  jsonObj.put("menuFirst", jsonArray);
    	  jsonMenu = TreeUtil.treeList2Json(getBasePath(), funcList);
      }
      
      jsonArray = JSONArray.parseArray(jsonMenu);
      jsonObj.put("menuTree", jsonArray);
      
      out = response.getWriter();
      out.write(jsonObj.toString());
    } catch (Exception e){
      logger.error(e.getMessage(), e);
    } finally{
      if(out != null){
        out.flush();
        out.close();
      }
    }
  }
}
