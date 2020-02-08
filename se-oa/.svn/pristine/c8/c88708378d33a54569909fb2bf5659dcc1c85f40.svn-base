package com.xjw.controller.message;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.message.MessageUserForm;
import com.xjw.entity.po.message.Message;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.message.MessageService;
import com.xjw.service.message.MessageUserService;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/messageuser")
public class MessageUserController extends BaseController{
	private static Logger logger= LoggerFactory.getLogger(MessageUserController.class);
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageUserService messageUserService;
	
	@RequestMapping("list")
	public String list(MessageUserForm form, Model model){
		Message message = messageService.selectById(form.getMessageId());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("messageId", form.getMessageId());
		
		if(StringUtils.isNotBlank(form.getReceiveName())){
			params.put("receiveName", form.getReceiveName());
		}
		
		if(null == form.getReadStatus()){
			params.put("readStatus", form.getReadStatus());
		}
		
		try {
			Page<MessageUser> page = messageUserService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("message", message);
		model.addAttribute("form", form);
		return "xjw/message/messageuser-list";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save(MessageUser messageUser){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("messageId", messageUser.getMessageId());
		params.put("receiveName", messageUser.getReceiveName());
		long count = messageUserService.selectAllCount(params);
		if(count > 0){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "收件人已存在，不可重复添加");
			return jsonObject.toString();
		}
		
		messageUser.setReadStatus(Integer.valueOf(YesORNoEnum.NO.getCode()));
		messageUser.setCreateTime(Calendar.getInstance().getTime());
		
		try {
			messageUserService.save(messageUser);
		} catch (BizException e) {
		    logger.error(e.getMessage(), e);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "操作异常");
			
			return jsonObject.toString();
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", true);
		jsonObject.put("msg", "操作成功");
		return  jsonObject.toString();
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Long id){
		try {
			messageUserService.deleteById(id);
		} catch (BizException e) {
		    logger.error(e.getMessage(), e);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "操作异常");
			
			return jsonObject.toString();
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", true);
		jsonObject.put("msg", "操作成功");
		return  jsonObject.toString();
	}
}
