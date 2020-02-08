package com.xjw.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;

@Controller
@RequestMapping("/proxy/")
public class ProxyController extends BaseController{
  private static Logger logger = LoggerFactory.getLogger(ProxyController.class.getName());
  
  @RequestMapping("/login")
  public String login(HttpServletRequest request){
	  return "/";
  }
}
