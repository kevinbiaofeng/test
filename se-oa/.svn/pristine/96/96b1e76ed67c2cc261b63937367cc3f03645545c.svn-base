<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx }/member/info/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						关键字：
					</td>
					<td><input type="text" name="keywords" value="${form.keywords }" maxlength="15"/></td>
					<td class="tableleft">注册时间：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime }" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime }" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
				<tr>
					<td class="tableleft">
						会员状态：
					</td>
					<td>
						<xjw:selectBar name="status" myClass="" clazz="com.xjw.kzenum.sys.StatusEnum" type="select" value="${form.status }"></xjw:selectBar>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
<%-- 				<xjw:auth code="YWGL-HYGL-USER-EXP"> --%>
<!-- 					<button type="button" class="btn btn-success yes-but"><i class="icon-white icon-fullscreen"></i>用户名单导出</button> -->
<%-- 				</xjw:auth> --%>
			</div>
		 
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>会员列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>会员账号</th>
					        <th>真实姓名</th>
					        <th>性别</th>
					        <th>账户类别</th>
					        <th>主平台余额</th>
					        <th>提款积分</th>
					        <th>总存款</th>
					        <th>总提款</th>
					        <th>注册时间</th>
					        <th>注册IP地址</th>
					        <th>会员状态</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr class="tr" <c:if test="${dto.status == 3}">bgcolor="#f4f4f4"</c:if>>
								    		<td><a href="${ctx}/member/info/detail?id=${dto.id}">${dto.loginName }</a></td>
								            <td>
							            		${dto.name}
								            </td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.user.SexTypeEnum" code="${dto.sex }"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" code="${dto.vipType }"/></td>
								            <td style="color:<c:if test="${dto.totalMoney > 0 }">green</c:if>">
							            		<fmt:formatNumber value="${dto.totalMoney }" type="currency" pattern="#.##"/>
								            </td>
								            <td>
								            	<fmt:formatNumber value="${dto.integral }" type="currency" pattern="#.##"/>
								            </td>
								            <td style="color:<c:if test="${dto.depositAmount > 0 }">green</c:if>">
								            	<c:if test="${empty dto.depositAmount }">0</c:if>
								            	<fmt:formatNumber value="${dto.depositAmount }" type="currency" pattern="#.##"/>
								            </td>
								            <td style="color:<c:if test="${dto.withdrawalAmount > 0 }">green</c:if>">
								            	<c:if test="${empty dto.withdrawalAmount }">0</c:if>
								            	<fmt:formatNumber value="${dto.withdrawalAmount }" type="currency" pattern="#.##"/>
								            </td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td>${dto.registerIp }</td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.status == 1}">
								            			<font color="green">
								            				<xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${dto.status }"/>
								            			</font>
								            		</c:when>
								            		<c:when test="${dto.status == 2}">
								            			<font color="#faa732">
								            				<xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${dto.status }"/>
								            			</font>
								            		</c:when>
								            		<c:otherwise>
								            			<font color="red">
								            				<xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${dto.status }"/>
								            			</font>
								            		</c:otherwise>
								            	</c:choose>
								            </td>
							            	<td>
							            		<xjw:auth code="YWGL-HYGL-LIST-GBHY">
							            			<c:if test="${dto.status == 1 || dto.status == 2}">
							            				<a href="javascript:;" class="but jq-status-close" style="color:red" data-id="${dto.id}">关闭</a>
							            			</c:if>
							            		</xjw:auth>
							            		<xjw:auth code="YWGL-HYGL-LIST-JDHY">
							            			<c:if test="${dto.status == 2}">
							            				<a href="javascript:;" class="but jq-status-unlock" style="color:green" data-id="${dto.id}">解冻</a>
							            			</c:if>
							            		</xjw:auth>
							            	</td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="13" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			  </table>
			      
			  <div class='bui-grid'>
			  	<div class='bui-grid-bbar'>
	    		  <c:if test="${not empty page.dataList }">
	   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  </c:if>
			  	</div>
			  </div>
			   
		 	</div>
		 </div>
		 </form>
	  </div>
     
	<script>
		$(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
				// 显示用户详细信息
	    	    $("a.jq-show-info").click(function(){
	    			var id = $(this).data("id"); 
	    	    	var dialog = new Overlay.Dialog({
	    	    		closeAction: 'destroy', 
	    				title:'会员详细信息',
	    				width:400,
	    				height:300,
	    				loader : {
	    					url : '/member/info/showInfo',
	    		            params : {userId: id},//附加的参数
	    		            autoLoad : false, //不自动加载
	    		            lazyLoad : false, //不延迟加载
	    				},
	    				success: function(){}
	    			});
	    	    	
	    	    	dialog.show();
	    	    	dialog.get('loader').load();
				});
				
				 //关闭用户
				 $("a.jq-status-close").click(function(){
					 var id = $(this).data("id");
					 
					 BUI.Message.Confirm('确认要关闭该会员么？',function(){
						 $.get("/member/info/close", {id: id}, function(data){
							 if(data == '1'){
								 BUI.Message.Alert('关闭会员成功！','success');
								 commonPageFormSubmit("objForm", ${page.pageNo});
							 }else{
								 BUI.Message.Alert('关闭会员失败，请联系管理员！','error');
							 }
						 });
					 });
				 });
				 
				 //解冻用户
				 $("a.jq-status-unlock").click(function(){
					 var id = $(this).data("id");
					 BUI.Message.Confirm('确认要解冻该会员么？',function(){
						 $.get("/member/info/unlock", {id: id}, function(data){
							 if(data == '1'){
								 BUI.Message.Alert('解冻会员成功！','success');
								 commonPageFormSubmit("objForm", ${page.pageNo});
							 }else{
								 BUI.Message.Alert('解冻会员失败，请联系管理员！','error');
							 }
						 });
					 });
				 });
		    });
		});
	</script>
	<%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>