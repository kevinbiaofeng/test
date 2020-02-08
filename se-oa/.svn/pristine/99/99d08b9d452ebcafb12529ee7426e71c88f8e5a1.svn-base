package com.xjw.controller.log;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.log.UserOperationLogForm;
import com.xjw.entity.po.log.UserOperationLog;
import com.xjw.service.log.UserOperationLogService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * 用户操作日志
 */
@Controller
@RequestMapping("/operation/log/")
public class UserOperationLogController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(UserOperationLogController.class.getName());
  @Resource
  private UserOperationLogService userOperationLogService;
  
  @RequestMapping("/list")
  public String list(Model model, UserOperationLogForm userOperationLogForm, HttpServletRequest request){
	  try {
		  Map<String, Object> conditionParam = new HashMap<String, Object>();
	      String loginName = userOperationLogForm.getLoginName();
	      if(loginName != null && StringUtil.isNotBlank(loginName)){
	    	  conditionParam.put("loginName", loginName);
	      }
	      String createUserName = userOperationLogForm.getCreateUserName();
	      if(createUserName != null && StringUtil.isNotBlank(createUserName)){
	    	  conditionParam.put("createUserName", createUserName);
	      }
	      String beginTime = userOperationLogForm.getBeginTime();
	      if(beginTime != null && StringUtil.isNotBlank(beginTime)){
	    	  conditionParam.put("beginTime", beginTime);
	      }
	      String endTime = userOperationLogForm.getEndTime();
	      if(endTime != null && StringUtil.isNotBlank(endTime)){
	    	  conditionParam.put("endTime", endTime);
	      }
	      String type = userOperationLogForm.getType();
	      if(type != null && StringUtil.isNotBlank(type)){
	    	  conditionParam.put("type", type);
	      }
	      Page<UserOperationLog> page = userOperationLogService.getPage(conditionParam, userOperationLogForm.getPageNo(), userOperationLogForm.getPageSize());
	      model.addAttribute("page", page);
	  } catch (BizException e) {
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	  }
	  model.addAttribute("form", userOperationLogForm);
	  return "xjw/log/userInfoEdit/list";
  }
}
