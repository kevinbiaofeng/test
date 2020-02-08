package com.xjw.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.user.Sign;
import com.xjw.entity.po.user.User;
import com.xjw.service.user.SignService;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;
import com.xjw.utility.DateUtil;
import com.xjw.utility.DateUtil.IntevalType;
/**
 * 签到
 */
@Controller
@RequestMapping("/sign/")
public class SignController extends BaseController{
  private static Logger logger = LoggerFactory.getLogger(SignController.class);
  
  @Autowired
  private SignService signService;
  
  /**
   * 跳转到会员签到页面
   * @param request
   * @return
   */
  @RequestMapping("/getMonthSign")
  @ResponseBody
  public String getMonthSign(HttpServletRequest request, Model model){
	  User user = SessionManager.getUserSession(super.getRequest());
	  Map<String, Object> condition = new HashMap<String, Object>();
	  condition.put("userId", user.getId());
	  condition.put("month", "1");
	  List<Sign> signList = signService.selectAll(condition);
	  String signJsonList = JSON.toJSONString(signList);
	  return signJsonList;
  }
  
  /**
   * 今天签到
   * @return
   */
  @RequestMapping("/today")
  @ResponseBody
  public String today(HttpServletRequest request, Model model){
	  JSONObject json = new JSONObject();
	  User user = SessionManager.getUserSession(super.getRequest());
	  System.out.println(DateUtil.getInterval(user.getCreateTime(), IntevalType.DAY) + "=========");
	  if(DateUtil.getInterval(user.getCreateTime(), IntevalType.DAY) >= 3){
		  try {
			String code = signService.modifySignToday(user.getId());
			json.put("code", code);
		  } catch (BizException e) {
			json.put("code", "341");
			e.printStackTrace();
		  }
	  }else{
		  json.put("code", "783");
	  }
	  
	  return json.toJSONString();
  }
  
}
