package com.xjw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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

@Controller
@RequestMapping("/syslog/")
public class LogController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(LogController.class.getName());

  @Resource
  private UserLoginLogService userLoginLogService;
  
  @RequestMapping("/delUserLoginLog")
  public String delUserLoginLog(LogForm logForm) {
    try {
      Map<String, Object> param = new HashMap<String, Object>();
      param.put("ids", StringUtil.getListFromStr(logForm.getIds()));
      userLoginLogService.deleteOne(param);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "redirect:/syslog/listUsrloginLog";
  }

  @RequestMapping("/listUsrloginLog")
  public String listUsrloginLog(Model model, LogForm logForm) {
    Map<String, Object> conditionParam = new HashMap<String, Object>();
    if(StringUtils.isNotBlank(logForm.getKeywords())){
      conditionParam.put("keywords", logForm.getKeywords());
    }
    conditionParam.put("networkType", LoginLogNetworkTypeEnum.NW.getCode());
    try {
      Page<UserLoginLog> page = userLoginLogService.getPage(conditionParam, logForm.getPageNo(), 20);
      model.addAttribute("page", page);
    } catch (BizException e) {
    	logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("logForm", logForm);
    return "public/log/userLoginList";
  }
}
