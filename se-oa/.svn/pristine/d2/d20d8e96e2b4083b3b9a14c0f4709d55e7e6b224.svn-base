<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>提款时间统计</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/order/timecount/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>提款时间统计</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>操作人</th>
					        <th>角色</th>
					        <th>统计数</th>
					        <th>详情</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page }">
			    						<c:if test="${dto.type eq 'finance' }">
			    							<tr>
									    		<td>${dto.loginName}</td>
									    		<td>财务</td>
									    		<td>${dto.countUser}</td>
									            <td><a href="${ctx}/order/timecount/details?type=finance&userId=${dto.userId}&beginTime=${form.beginTime}&endTime=${form.endTime}">详情</a></td>
									        </tr>
			    						</c:if>
			    						<c:if test="${dto.type eq 'risk' }">
			    							<tr>
									    		<td>${dto.loginName}</td>
									    		<td>风控</td>
									    		<td>${dto.countUser}</td>
									            <td>
									            	<a href="${ctx}/order/timecount/details?type=risk&userId=${dto.userId}&beginTime=${form.beginTime}&endTime=${form.endTime}">详情</a>
									            </td>
									        </tr>
			    						</c:if>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			  </table>
			      
			  <%-- <div class='bui-grid'>
			  	<div class='bui-grid-bbar'>
	    		  <c:if test="${not empty page }">
	   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  </c:if>
			  	</div>
			  </div> --%>
			      
		 	</div>
		 </div>
		 
		 </form>
	  </div>
	  
      <div id="show"></div>
      <script>
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		 // 显示用户详细信息
	    	    $("a.jq-show-info").click(function(){
	    			var userId = $(this).data("userid"); 
	    	    	var dialog = new Overlay.Dialog({
	    	    		closeAction: 'destroy', 
	    				title:'会员详细信息',
	    				width:400,
	    				height:300,
	    				loader : {
	    					url : '/member/info/showInfo',
	    		            params : {userId: userId},//附加的参数
	    		            autoLoad : false, //不自动加载
	    		            lazyLoad : false, //不延迟加载
	    				},
	    				success: function(){}
	    			});
	    	    	
	    	    	dialog.show();
	    	    	dialog.get('loader').load();
	    	    });
	    	});
	    	
	    });
	    
	    
	    function showCallback(){
	    	window.location.href = "${ctx}/order/withdraw/list";
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>