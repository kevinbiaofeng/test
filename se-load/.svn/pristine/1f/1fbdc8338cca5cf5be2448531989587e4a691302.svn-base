package com.xjw.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.sys.AdvertWebsite;
import com.xjw.service.sys.AdvertWebsiteService;

/**
 * 网页公告列表
 */
@Controller
@RequestMapping("/notice/")
public class AdvertWebsiteController extends BaseController{
	private static Logger logger= LoggerFactory.getLogger(AdvertWebsiteController.class.getName());
	  @Resource
	  private AdvertWebsiteService advertWebsiteService;
	  
	  
	  @RequestMapping("/list")
	  @ResponseBody
	  public String list(Model model, HttpServletRequest request){
		  try {
		      Map<String, Object> conditionParam = new HashMap<String, Object>();
		      conditionParam.put("status", "2");
		      List<AdvertWebsite> list = advertWebsiteService.selectAll(conditionParam);
		      JSONArray array  = new JSONArray();
		      for (AdvertWebsite advertWebsite : list) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("id", advertWebsite.getId());
					jsonObj.put("content", advertWebsite.getContext());
					array.add(jsonObj);
		      }
		      return String.valueOf(array);
		  } catch (Exception e) {
			  logger.error(e.getMessage(), e);
			  return "";
		  }
	  }
	  
}
