package com.xjw.controller.sys;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.sys.Dept;
import com.xjw.entity.po.sys.User;
import com.xjw.kzenum.sys.LoginLogNetworkTypeEnum;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.sys.DeptService;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.UserLoginLogService;
import com.xjw.service.sys.UserService;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.IpUtil;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/user/")
public class LoginController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(LoginController.class.getName());
  @Resource
  private UserService userService;
  @Resource
  private DeptService deptService;
  @Resource
  private UserLoginLogService userLoginLogService;
  @Resource
  private FunctionService functionService;
  
  
  @SuppressWarnings("static-access")
  @RequestMapping("/login")
  public String myUser(User u, Model model, HttpServletRequest request, HttpServletResponse response){
      try{
        String verifyCode = request.getParameter("verifyCode");
        String resVerifyCode = String.valueOf(request.getSession().getAttribute("verifyCode"));
        if(StringUtil.isNotBlank(verifyCode) && verifyCode.toUpperCase().equals(resVerifyCode)){
            User user = userService.selectByLoginNameAndPwd(u);
            if(user != null && !UserTypeAllEnum.KH.getCode().equals(String.valueOf(user.getType())) && !UserTypeAllEnum.DL.getCode().equals(String.valueOf(user.getType()))){
              if(user.getStatus() == Integer.valueOf(StatusEnum.LOCK.getCode())){
                model.addAttribute("msg", this.getMsg(request, "user.loginName.lock"));
                return "/login";
              }else if(user.getStatus() == Integer.valueOf(StatusEnum.DEL.getCode())){
                model.addAttribute("msg", this.getMsg(request, "logNameAndPwd.error"));
                return "/login";
              }else{
                request.getSession(true).setAttribute(Constant.USER_SESSION, user);
                
                if(user.getDeptId() != null){
                  Dept dept = deptService.selectById(user.getDeptId());
                  request.getSession(true).setAttribute(Constant.DEPT_SESSION, dept);
                }
                CurrentUserHolder.initSystemUserInfo(user.getId());
                //添加登录日志
                userLoginLogService.saveUserLoginLog(user, IpUtil.getIpAddr(request), Integer.valueOf(LoginLogNetworkTypeEnum.NW.getCode()));
                //获取用户权限
                Map <String, Object> authMap = functionService.getFunctionMapByUserId(user.getId());
                request.getSession(true).setAttribute(Constant.AUTH_MAP_SESSION, authMap);
                return "redirect:/user/index";
              }
            }else{
              model.addAttribute("msg", this.getMsg(request, "logNameAndPwd.error"));
              return "/login";
            }
        }else{
            model.addAttribute("msg", this.getMsg(request, "verifyCode.error"));
            return "/login";
        }
      }catch(Exception e){
        model.addAttribute("msg", this.getMsg(request, "logNameAndPwd.error"));
        e.printStackTrace();
        logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
        return "/login";
      }
  }
  
  @RequestMapping("/index")
  public String index(){
    return "/index";
  }
  
  
  @RequestMapping("/exit")
  public String exit(HttpServletRequest request){
    request.getSession().removeAttribute(Constant.USER_SESSION);
    return "/login";
  }
}
