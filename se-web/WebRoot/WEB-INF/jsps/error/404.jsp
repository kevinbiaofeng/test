<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<html>
<head>
<title>正在为你跳转</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${statics }/css/404.css" rel="stylesheet"/>
<script type="text/javascript">
    var i=5;
    var timehwnd=setInterval("Countdown()",5000);
    function Countdown(){
        window.location.href="${ctx}";
    }
</script>
</head>

<body>
	<div class="errorContainer">
		<h2>出现错误啦，正在为你跳转到首页...</h2>
		
		<button class="btn btn-primary btn-large" onClick="document.location.href = '${ctx}';">點擊返回首頁</button>
	</div>
</body>
</html>