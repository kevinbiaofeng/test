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
import com.xjw.entity.form.log.UserAccountIntegralChangeLogForm;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * 账变信息
 */
@Controller
@RequestMapping("/accountChange/log/")
public class UserAccountIntegralChangeLogController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(UserAccountIntegralChangeLogController.class);
  @Resource
  private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
  
  @RequestMapping("/list")
  public String list(Model model, UserAccountIntegralChangeLogForm userAccountIntegralChangeLogForm, HttpServletRequest request){
	  try {
		  Map<String, Object> conditionParam = new HashMap<String, Object>();
	      String userName = userAccountIntegralChangeLogForm.getUserName();
	      if(userName != null && StringUtil.isNotBlank(userName)){
	    	  conditionParam.put("userName", userName);
	      }
	      String beginTime = userAccountIntegralChangeLogForm.getBeginTime();
	      if(beginTime != null && StringUtil.isNotBlank(beginTime)){
	    	  conditionParam.put("beginTime", beginTime);
	      }
	      String endTime = userAccountIntegralChangeLogForm.getEndTime();
	      if(endTime != null && StringUtil.isNotBlank(endTime)){
	    	  conditionParam.put("endTime", endTime);
	      }
	      String type = userAccountIntegralChangeLogForm.getType();
	      if(type != null && StringUtil.isNotBlank(type)){
	    	  conditionParam.put("type", type);
	      }
	      String platformType = userAccountIntegralChangeLogForm.getPlatformType();
	      if(platformType != null && StringUtil.isNotBlank(platformType)){
	    	  conditionParam.put("gameType", platformType);
	      }
	      
	      Page<UserAccountIntegralChangeLog> page = userAccountIntegralChangeLogService.getPage(conditionParam, userAccountIntegralChangeLogForm.getPageNo(), userAccountIntegralChangeLogForm.getPageSize());;
	      
	      model.addAttribute("page", page);
	  } catch (BizException e) {
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	  }
	  model.addAttribute("form", userAccountIntegralChangeLogForm);
	  return "xjw/log/accountChange/list";
  }
}
