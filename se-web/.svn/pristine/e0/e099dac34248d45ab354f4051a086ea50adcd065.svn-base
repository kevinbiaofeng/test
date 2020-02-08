package com.xjw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.util.CookieManager;
import com.xjw.utility.RequestResponseContextUtil;

public abstract class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String getMsg(HttpServletRequest request, String msgName) {
		RequestContext requestContext = new RequestContext(request);
		return requestContext.getMessage(msgName);
	}
	
	protected String getMsg(HttpServletRequest request, String msgName, Object...args) {
		RequestContext requestContext = new RequestContext(request);
		return requestContext.getMessage(msgName, args);
	}

	protected String getMsg(String msgName) {
		RequestContext requestContext = new RequestContext(getRequest());
		return requestContext.getMessage(msgName);
	}

	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	protected String getBasePath() {
		HttpServletRequest request = getRequest();
		StringBuffer fullurl = new StringBuffer();
		try {
			fullurl = request.getRequestURL();
			fullurl.delete(fullurl.indexOf(request.getRequestURI()), fullurl.length());
			fullurl.append(request.getContextPath());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return fullurl.toString();
	}

	protected void writerJSONData(String result, String message, String _butText, String actionUrl) {
		Map<String, Object> params = new HashMap<String, Object>();
		writerJSONData(result, message, _butText, actionUrl, params);
	}

	protected void writerJSONData(String result, String message, String _butText, String actionUrl, Map<String, Object> params) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("message", message);
		json.put("butText", StringUtils.isNotBlank(_butText) ? _butText : "返回列表");
		json.put("url", getBasePath() + actionUrl);
		if (CollectionUtils.isEmpty(params) == false) {
			JSONArray param = new JSONArray();
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				param.add(entry.getKey() + "=" + entry.getValue());
			}
			json.put("param", param);
		}
		try {
			printWriter(json.toString(), "text/html;charset=utf-8");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void setBasicResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
	}

	protected void printWriter(String data) throws IOException {
		HttpServletResponse response = RequestResponseContextUtil.getResponse();
		setBasicResponseHeader(response);
		response.setContentType("text/json;charset=utf-8");
		write(data, response);
	}

	protected void printWriter(String data, String contentType) throws IOException {
		if (contentType == null) {
			printWriter(data);
		} else {
			HttpServletResponse response = RequestResponseContextUtil.getResponse();
			setBasicResponseHeader(response);
			response.setContentType(contentType);
			write(data, response);
		}
	}

	protected void write(String data, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.write(data);
		printWriter.flush();
		printWriter.close();
	}
	
	
	@RequestMapping("/exit")
	@ResponseBody
	public String exit(HttpServletRequest request, HttpServletResponse response){
		  CookieManager.delCookie(request, response, "un");
		  CookieManager.delCookie(request, response, "ui");
		  CookieManager.delCookie(request, response, "s");
		  request.getSession().removeAttribute(Constant.USER_SESSION);
		  return "1";
	}
	
	protected void setToken(HttpServletRequest request) {
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
	}
	
	protected boolean isTokenTrue(HttpServletRequest request, String token){
		String sessionToken = (String)request.getSession().getAttribute("token");
		
		request.getSession().removeAttribute("token");
		return (StringUtils.equals(sessionToken, token));
	}
}
