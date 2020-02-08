package com.xjw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.EmailSmsForm;
import com.xjw.entity.po.sys.EmailSms;
import com.xjw.service.sys.EmailSmsService;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/emailsms/")
public class EmailSmsController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(EmailSmsController.class);
	
	@Autowired
	private EmailSmsService emailSmsService;
	
	@RequestMapping("list")
	public String list(EmailSmsForm form, Model model){
		Map<String, Object> params = new HashMap<String, Object>();
		if(null != form){
			if(StringUtils.isNotBlank(form.getLoginName())){
				params.put("loginName", form.getLoginName());
			}
			
			if(StringUtils.isNotBlank(form.getEmail())){
				params.put("email", form.getEmail());
			}
			
			if(null != form.getType()){
				params.put("type", form.getType());
			}
		}
		
		try {
			Page<EmailSms> page = emailSmsService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "public/sms/emailsms-list";
	}
}
