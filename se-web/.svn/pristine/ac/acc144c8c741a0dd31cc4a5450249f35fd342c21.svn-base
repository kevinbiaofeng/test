package com.xjw.controller.message;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.message.MessageService;
import com.xjw.service.message.MessageUserService;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageUserService messageUserService;
	
	@RequestMapping("index")
	public String index(Model model){
		return "xjw/user/message-index";
	}
	
	@RequestMapping("list")
	public String list(MessageForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model){
		User user = SessionManager.getUserSession(request);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("receiveUser", user.getId());
		
		if(null != form.getReadStatus()){
			params.put("readStatus", form.getReadStatus());
		}
		
		try {
			Page<Message> page = messageService.getPage(params, pageNo, pageSize);
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "xjw/user/message-list";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(@RequestParam("ids") Long[] ids){
		User user = SessionManager.getUserSession(request);
		
		try{
			for(Long id : ids){
				messageUserService.delete(id, user.getId());
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "删除发生错误，请您稍后尝试!");
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", true);
		jsonObject.put("msg", "删除成功！");
		return  jsonObject.toString();
	}
	
	@RequestMapping("detail")
	@ResponseBody
	public String detail(@RequestParam("id") Long id){
		User user = SessionManager.getUserSession(request);
		
		try {
			Message message = messageService.queryOne(id, user.getId());
			if(YesORNoEnum.NO.getCode().equals(message.getReadStatus().toString())){
				messageUserService.updateByRead(message.getId(), user.getId());
			}
			
			JSONObject jsonObjet = new JSONObject();
			jsonObjet.put("title", message.getTitle());
			jsonObjet.put("content", message.getContent());
			return jsonObjet.toString();
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}
}