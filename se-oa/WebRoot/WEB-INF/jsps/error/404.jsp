<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>404 - Aries Premium Admin Template</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  
  <body> 
    <div class="errorContainer">
        <h1>404</h1>
        <h2>Page not Found!无法找到页面!</h2>
        <button class="btn btn-primary btn-large" onClick="document.location.href = '${ctx}';">回到首页</button>
    </div>
  </body>
</html>
