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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.message.MessageForm;
import com.xjw.entity.po.message.Message;
import com.xjw.service.message.MessageService;
import com.xjw.utility.BizException;
import com.xjw.utility.CurrentUserHolder;


@Controller
@RequestMapping("/message")
public class MessageController extends BaseController{
	private static Logger logger= LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("list")
	public String list(MessageForm form, Model model){
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(form.getLikeTitle())){
			params.put("likeTitle", form.getLikeTitle());
		}
		
		try {
			Page<Message> page = messageService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "xjw/message/message-list";
	}
	
	/**
	 * 新增页面
	 */
	@RequestMapping("new")
	public String editNew(){
		return "xjw/message/message-edit";
	}
	
	/**
	 * 新增页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam("id") Long id, Model model){
		Message message = messageService.selectById(id);
		
		model.addAttribute("message", message);
		return "xjw/message/message-edit";
	}
	
	/**
	 * 保存数据 
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Message message){
		try {
			//新增
			if(null == message.getId()){
				message.setReceiveCount(0);
				message.setCreateUser(CurrentUserHolder.getCurrentUserId());
				message.setCreateTime(Calendar.getInstance().getTime());
				messageService.save(message);
			}else{	//更新
				message.setUpdateUser(CurrentUserHolder.getCurrentUserId());
				message.setUpdateTime(Calendar.getInstance().getTime());
				messageService.update(message);
			}
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
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(@RequestParam("ids") Long[] ids){
		try {
			for(Long id : ids){
				messageService.deleteById(id);
			}
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
				
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "操作异常");
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", true);
		jsonObject.put("msg", "操作成功");
		return  jsonObject.toString();
	}
}