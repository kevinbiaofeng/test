package com.xjw.controller.ws;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.kzenum.RestServiceErrorEnum;
import com.xjw.util.GetAddressByIp;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.SHAUtil;
import com.xjw.utility.StringUtil;
import com.xjw.utility.ValidatorParameterUtil;

@Controller
@RequestMapping("/rest/ip/")
public class IpAddressController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(IpAddressController.class.getName());
  
  /**
   * 
   * @param request
   * @param response
   * @param ip
   */
  @RequestMapping(method=RequestMethod.GET, value="/{ip}/{token}/getCityInfoByIp.json")
  public void getCityInfoByIp(HttpServletRequest request, HttpServletResponse response, @PathVariable("ip") String ip, @PathVariable("token") String token) {
	  String key = ContextPropsLoad.getValByKey("TEST.KEY");
	  String getToken = SHAUtil.shaEncode(key + ip);
	  JSONObject jsonObj = new JSONObject();
	  if(getToken.equals(token)){
		  if(StringUtil.isNotBlank(ip) && ValidatorParameterUtil.valIp(ip)){
			  String data = GetAddressByIp.GetAddressByIp01(ip);
			  if(data.equals("0")){
				  //错误IP地址
				  jsonObj.put("code", "0");
				  jsonObj.put("data", RestServiceErrorEnum.FORMAT.getName());
			  }else{
				  jsonObj.put("code", "1");
				  jsonObj.put("data", data);
			  }
			  
		  }else{
			  jsonObj.put("code", "0");
			  jsonObj.put("data", "IP Address" + RestServiceErrorEnum.NOT_FIND.getName());
		  }
	  }else{
		  jsonObj.put("code", "0");
		  jsonObj.put("data", RestServiceErrorEnum.TOKEN.getName());
	  }
	  
	  try {
		  printWriter(jsonObj.toString(), "text/html;charset=utf-8");
	  } catch (IOException e) {
		  e.printStackTrace();
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	  }
  }
  
  @RequestMapping(value = "/getAreasByCode.json", method = RequestMethod.GET)
  public void getAreasByCode(String parentCode, HttpServletResponse response, HttpServletRequest request){
    JSONArray json = new JSONArray();
    try {
      this.write(String.valueOf(json), response);
    } catch (IOException e) {
    	logger.error(e.getMessage(), e);
    }
  }
}