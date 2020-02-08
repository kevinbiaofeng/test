package com.xjw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.entity.po.sys.User;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;
import com.xjw.utility.RequestResponseContextUtil;

public abstract class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class.getName());
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }
    
    protected String getMsg(HttpServletRequest request, String msgName) {
        RequestContext requestContext = new RequestContext(request);
        return requestContext.getMessage(msgName);
    }

    protected String getMsg(String msgName) {
        RequestContext requestContext = new RequestContext(getRequest());
        return requestContext.getMessage(msgName);
    }

    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
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

    protected User getCurrentUser() {
        HttpServletRequest request = getRequest();
        User user = SessionManager.getUserSession(request);
        try {
            if (user == null) {
                throw new BizException("登录已超时,请重新登录.");
            }
        } catch (BizException e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }

    protected Long getCurrentUserId() {
        try {
            return getCurrentUser().getId();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /** 获取系统权限 **/
    protected Map<String, Object> getCurrentAuth() {
        HttpServletRequest request = getRequest();
        Map<String, Object> mapAuth = SessionManager.getAuthSession(request);
        return mapAuth;
    }

    protected boolean isSysOperator() {
        User user = getCurrentUser();
        return Integer.valueOf(UserTypeAllEnum.GLY.getCode()).equals(user.getType());
    }

    protected void writerJSONData(String result, String message, String _butText, String actionUrl) {
        Map<String, Object> params = new HashMap<String, Object>();
        writerJSONData(result, message, _butText, actionUrl, params);
    }

    protected void writerJSONData(String result, String message, 
                                    String _butText, String actionUrl,
                                    Map<String, Object> params) {
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

    protected void writerSuccessJSONDataById(String message, String createUrl, String editUrl, String listUrl,
            Map<String, Object> params) throws IOException {
        writerSuccessJSONData(message, null, createUrl, null, editUrl, null, listUrl, params);
    }

    // protected void writerSuccessJSONDataById(String message, String
    // createUrl, String editUrl, String listUrl, String paramName, Long id)
    // throws IOException {
    // Map<String, Object> params = new HashMap<String, Object>();
    // if (id != null)
    // params.put("id", id);
    // writerSuccessJSONData(message, null, createUrl, null, editUrl, null,
    // listUrl, params);
    // }

    protected void writerSuccessJSONData(String message, String addButText, String addUrl, String modifyText,
            String modifyUrl, String listText, String listUrl, Map<String, Object> params) throws IOException {
        JSONObject json = new JSONObject();
        json.put("status", Constant.CommonManage.YES);
        json.put("message", message);
        String contextPath = getBasePath();
        if (StringUtils.isNotBlank(addUrl) && !addUrl.equals("0")) {
            json.put("addText", StringUtils.isNotBlank(addButText) ? addButText : "继续新增");
            json.put("addUrl", contextPath + addUrl);
        } else {
            json.put("addUrl", "0");
        }
        if (StringUtils.isNotBlank(modifyUrl) && !modifyUrl.equals("0")) {
            json.put("modifyText", StringUtils.isNotBlank(modifyText) ? modifyText : "返回修改");
            json.put("modifyUrl", contextPath + modifyUrl);
        } else {
            json.put("modifyUrl", "0");
        }
        if (StringUtils.isNotBlank(listUrl)) {
            json.put("listText", StringUtils.isNotBlank(listText) ? listText : "返回列表页");
            json.put("listUrl", contextPath + listUrl);
        } else {
            json.put("listUrl", "0");
        }
        if (CollectionUtils.isEmpty(params) == false) {
            JSONArray param = new JSONArray();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                param.add(entry.getKey() + "=" + entry.getValue());
            }
            json.put("param", param);
        }
        printWriter(json.toString(), "text/html;charset=utf-8");
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

    protected static Long getUserParentId(User user) {
        Long parentId = null;
        if (user != null) {
            if (UserTypeAllEnum.DL.getCode().equals(String.valueOf(user.getType()))) {
                parentId = user.getId();
            } else if (!UserTypeAllEnum.GLY.getCode().equals(String.valueOf(user.getType()))) {
                parentId = user.getParentId();
            }
        }
        return parentId;
    }
}
