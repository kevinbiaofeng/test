<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${statics }/css/login.css" />
</head>

<body>
	<h1>
		后台管理系统<sup>V2.0正式版</sup>
	</h1>

	<div class="login" style="margin-top:50px;">
	    <div class="header">
	        <div class="switch" id="switch">
	        	<a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">登录</a>
	        </div>
	    </div>    
	  
	    <div class="qlogin">
		    <div class="web_login">
		    	<form id="objForm" accept-charset="utf-8"  action="${ctx }/user/login" method="post">
		        	<ul class="reg_form" id="reg-ul">
		        		<div id="userCue" class="cue">登录请注意输入格式</div>
		                <li>
		                    <label for="user"  class="input-tips2">用户名：</label>
		                    <div class="inputOuter2">
		                        <input type="text" id="loginName" name="loginName" maxlength="12" class="inputstyle2"/>
		                        <span class="error"></span>
		                    </div>
		                </li>
		                
		                <li>
		                	<label for="passwd" class="input-tips2">密码：</label>
		                    <div class="inputOuter2">
		                        <input type="password" id="pwd" name="pwd" maxlength="20" class="inputstyle2"/>
		                        <span class="error">${msg}</span>
		                    </div>
		                </li>
		                
		                <li>
		                	<label for="passwd2" class="input-tips2">验证码：</label>
		                    <div class="inputOuter2">
		                        <input type="text" name="verifyCode" maxlength="5" class="inputstyle3" title="点击更换验证码"/>
		                        <div class="codestyle">
		                        	<img id="code" border="0" src="${ctx }/code.img" title="点击更换验证码" />
		                        </div>
		                    </div>
		                </li>
		                <li>
		                    <div style="padding-left:85px;margin-top:30px;text-align: center;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
		                    </div>
		                </li>
		                
<!-- 		                <li> -->
<!-- 		                    <div style="padding-left:5px;margin-top:-7px;text-align: center;" id="msg"> -->
<%-- 		                    	<label class="error" generated="true">${msg}</label> --%>
<!-- 		                    </div> -->
<!-- 		                </li> -->
		            </ul>
		        </form>
		    </div>
	    </div>
	    
	</div>
	<div class="jianyi">*推荐使用火狐Firefox浏览器或Chrome内核浏览器访问本站</div>
	<script type="text/javascript" src="${statics }/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="${statics }/js/ckform.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${statics }/js/login.js"></script>
</body>
</html>