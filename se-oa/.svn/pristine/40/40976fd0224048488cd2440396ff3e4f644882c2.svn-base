package com.xjw.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.LogForm;
import com.xjw.entity.po.sys.UserLoginLog;
import com.xjw.kzenum.sys.LoginLogNetworkTypeEnum;
import com.xjw.service.sys.UserLoginLogService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * IP登录列表
 * @author KevinZ
 */
@Controller
@RequestMapping("/member/ip/")
public class MemberIpLogController extends BaseController{
  private static Logger logger = LoggerFactory.getLogger(MemberIpLogController.class.getName());
  @Resource
  private UserLoginLogService userLoginLogService;
  
//  private static final String addPage = "/sysuser/skipAdd";
//  private static final String editPage = "/sysuser/skipModify";
//  private static final String listPage = "/sysuser/list";
  
  
  @RequestMapping("/list")
  public String list(Model model, LogForm logForm, HttpServletRequest request){
	 	Map<String, Object> conditionParam = new HashMap<String, Object>();
	    if(StringUtils.isNotBlank(logForm.getKeywords())){
	      conditionParam.put("keywords", logForm.getKeywords());
	    }
	    String beginTime = logForm.getBeginTime();
        if(beginTime != null && StringUtil.isNotBlank(beginTime)){
    	  conditionParam.put("beginTime", beginTime);
        }
        String endTime = logForm.getEndTime();
        if(endTime != null && StringUtil.isNotBlank(endTime)){
        	conditionParam.put("endTime", endTime);
        }
        String searchIp = logForm.getSearchIp();
        if(searchIp != null && StringUtil.isNotBlank(searchIp)){
        	conditionParam.put("searchIp", searchIp);
        }
        String userId = logForm.getUserId();
        if(userId != null && StringUtil.isNotBlank(userId)){
        	conditionParam.put("userId", userId);
        }
        String ipAddress = logForm.getIpAddress();
        if(ipAddress != null && StringUtil.isNotBlank(ipAddress)){
        	conditionParam.put("ipAddress", ipAddress);
        }
	    conditionParam.put("networkType", LoginLogNetworkTypeEnum.WW.getCode());
	    try {
	    	Page<UserLoginLog> page= userLoginLogService.getPage(conditionParam, logForm.getPageNo(), 20);
		    
	        model.addAttribute("page", page);
	    } catch (BizException e) {
	    	logger.error(e.getMessage(), e);
	    }
	    model.addAttribute("form", logForm);
	    return "xjw/member/ip/list";
  }
  
  @RequestMapping("/groupData")
  public String groupData(Model model, LogForm logForm, HttpServletRequest request){
	 	Map<String, Object> conditionParam = new HashMap<String, Object>();
	    if(StringUtils.isNotBlank(logForm.getKeywords())){
	      conditionParam.put("keywords", logForm.getKeywords());
	    }
        String searchIp = logForm.getSearchIp();
        if(searchIp != null && StringUtil.isNotBlank(searchIp)){
        	conditionParam.put("searchIp", searchIp);
        }
        String userId = logForm.getUserId();
        if(userId != null && StringUtil.isNotBlank(userId)){
        	conditionParam.put("userId", userId);
        }
        String ipAddress = logForm.getIpAddress();
        if(ipAddress != null && StringUtil.isNotBlank(ipAddress)){
        	conditionParam.put("ipAddress", ipAddress);
        }
	    conditionParam.put("networkType", LoginLogNetworkTypeEnum.WW.getCode());
	    try {
	      List<UserLoginLog> list = userLoginLogService.getGroupData(conditionParam);
	      model.addAttribute("list", list);
	    } catch (Exception e) {
	    	logger.error(e.getMessage(), e);
	    	logger.error("---fill---:" + e.fillInStackTrace());
	    	logger.error("---msg---:"+ e.getMessage());
	    	logger.error("---e---:" + e.toString());
	    }
	    model.addAttribute("form", logForm);
	    return "xjw/member/ip/groupList";
  }
}
