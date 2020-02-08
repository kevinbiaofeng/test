<%@page import="org.apache.commons.lang3.time.DateFormatUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<c:set var="HEADER_MENU" value="${typeName }"></c:set>
<c:set var="ORDER_BY" value="${orderBy }"></c:set>

<div class="header">
		<div class="left">
			<div class="home">
				<ul>
					<li style="width: 200px;margin-top:2px;">
						<a href="${ctx }" href="javascript:;" style="font-size: 18px;">
							<img src="${statics }/images/logo.png" alt="logo" title="${keywords }"/>
						</a>
					</li>
					<li style="width: 400px;">
					   <div class="search-box pull-right">
					   		<c:set var="search">
							    <spring:message code="header.search"/>
						 	</c:set>
							<input id="searchName" class="form-control white-input" style="color:#fff;font-size: 12px;border-radius: 30px;padding: 6px 80px;" placeholder="${search }" type="text" >
							<i id="btnQueryGame" class="fa fa-search" style="cursor:pointer;position: absolute;"></i>
					   </div>
					</li>
				</ul>
			</div>
		</div>
		<c:if test="${empty memberUser }">
			<div class="right">
				<ul>
					<li>
						<c:choose>
							<c:when test="${lang eq 'zh_HK' }">
								<a href="#" id="language"><img src="${statics }/images/country/hk.png" alt="<spring:message code="header.traditional"/>" /></a>
							</c:when>
							<c:otherwise>
								<a href="#" id="language"><img src="${statics }/images/country/cn.png" alt="<spring:message code="header.simplified"/>" /></a>
							</c:otherwise>
						</c:choose>
					</li>
					<li>
						<div class="dd">
							<a href="javascript:;" class="jq_login"><i class="fa fa-user"></i>&nbsp;<spring:message code="header.logAndreg"/></a>
						</div>
					</li>
				</ul>
				
				<div class="country-list" style="display:none;">
					<ul class="icon-ul">
<!-- 						<li class="icon-li"> -->
<!-- 							<a href="javascript:;"> -->
<%-- 								<img src="${statics }/images/country/en.png" alt="English" /> English --%>
<!-- 							</a> -->
<!-- 						</li> -->
						<li class="icon-li">
							<a href="?lang=zh_CN">
								<img src="${statics }/images/country/cn.png" alt="<spring:message code="header.simplified"/>" /> ${lang }<spring:message code="header.simplified"/>
							</a>
						</li>
						<li class="icon-li">
							<a href="?lang=zh_HK">
								<img src="${statics }/images/country/hk.png" alt="<spring:message code="header.traditional"/>" /> <spring:message code="header.traditional"/>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty memberUser }">
			<div class="right">
				<ul>
					<li class="bigma">
						<div class="text">
							<a class="exit" href="javascript:se.logout('${ctx}');"><i class="glyphicon glyphicon-off"></i> <spring:message code="header.logout"/></a>
						</div>
					</li>
					<li class="bigma">
						<div class="text">
							<a class="user-center" href="${ctx}/member/skipUserCenterAccount"><i class="glyphicon glyphicon-user"></i> <spring:message code="header.user.center"/></a>
						</div>
					</li>
					<li class="bigma">
						<div class="text">
							<a class="toolbar-usercenter" href="${ctx }/member/skipSign"><i class="fa fa-calendar"></i> <spring:message code="header.sign"/></a>
						</div>
					</li>
					<li class="bigma" style="font-size: 16px;color:#fff;margin-right: 50px;">
						<div class="text">
							<spring:message code="header.domain"/>：www.lsj510.vip
						</div>
					</li>
				</ul>
			</div>
		</c:if>
</div>

<div class="menu navigation" id="main-menu">
	<div class="container">
		<div class="menu_bar">
			<ul>
				<li>
					<a href="${ctx}">首頁</a>
				</li>
				<li>
					<a href="${ctx }/media/list/歐美/newVideo/1/" class="${HEADER_MENU eq '歐美' ? 'current' : ''}">歐美</a>
				</li>
				<li>
					<a href="${ctx }/media/list/港台/newVideo/1/" class="${HEADER_MENU eq '港台' ? 'current' : ''}">港台</a>
				</li>
				<li>
					<a href="${ctx }/media/list/日韓/newVideo/1/" class="${HEADER_MENU eq '日韓' ? 'current' : ''}">日韓</a>
				</li>
				<li>
					<a href="${ctx }/media/list/中國大陸/newVideo/1/" class="${HEADER_MENU eq '中國大陸' ? 'current' : ''}">中國大陸</a>
				</li>
				<li>
					<a href="${ctx }/media/list/動漫/newVideo/1/" class="${HEADER_MENU eq '動漫' ? 'current' : ''}">動漫</a>
				</li>
				<li>
					<a href=" ${ctx }/media/list/VIP區/newVideo/1/" class="${HEADER_MENU eq 'VIP區' ? 'current' : ''}">VIP區</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<script type="text/template" id="loginTemplate">
	<div  class="user-content">
		<div class="login">
			<h2>登 錄</h2>
			<form class="login-form">
				<div class="login-panel">
						<ul>
							<li><input type="text" id="loginName" placeholder="用戶名" maxlength="15"/></li>
							<li><input type="password" id="loginPwd" placeholder="密碼" maxlength="15"/></li>
						</ul>
				</div>
				<div class="send-button">
      				<form>
       			 		<input value="立即登錄" type="button" onclick="javascript:se.login.popup.submit('${ctx}');">
      				</form>
    			</div>
			</form>
		</div>

		<div class="register">
    			<h2>注 冊</h2>
    			<form class="register-form">
     				 <input name="regName" id="regName" placeholder="用戶名" type="text">
					 <input name="regPwd" id="regPwd" placeholder="密碼" type="password">
      				 <input name="email" id="email" placeholder="郵箱" type="text">
    			</form>
    			<div class="send-button">
     				<form>
       			 		<input value="免費註冊" type="button" onclick="javascript:se.reg.popup.submit('${ctx}');">
      				</form>
    			</div>
  			</div>
	</div>
</script>
<div id="header-clear" style="height: 50px;display: block;width: 100%;line-height: 50px;"></div>
<script src="${statics }/plugins/jquery/1.11.1/jquery.min.js"></script>
<link href="${statics }/plugins/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<script src="${statics }/plugins/layer/layer.js" type="text/javascript"></script>
<script src="${statics }/js/common.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	$(document).on("click", ".jq_login", function(){
		if(${empty sessionScope.memberUser}){
			se.login.popup.dialog();
			return false;
		}
		return true;
	});
	
	$("#language").click(function(){
		if($(".country-list").css("display")=="none"){
			$(".country-list").show();
		}else{
			$(".country-list").hide();
		}
	})
	
	$("#btnQueryGame").click(function(){
		var searchName = $("#searchName").val();
		window.location.href = "${ctx}/media/list/"+searchName+"/newVideo/1/?searchName=" + searchName;
	})
	
	$(window).scroll(function() {
		 if ($(document).scrollTop() < 40) {
             $("#main-menu").css("height", "45px");
             $("#main-menu").css("line-height", "45px");
         }else{
         	$("#main-menu").css("height", "45px");
         	$("#main-menu").css("line-height", "45px");
         	$(".dropmenus-box").css("margin-top", "-37px");
         }
	 });
	
})

</script>