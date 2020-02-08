<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>历史提款列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/withdrawal/historylist" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td><input type="text" name="loginName" value="${form.loginName}"/></td>
					<td class="tableleft">提款编号：</td>
					<td><input type="text" name="orderNo" value="${form.orderNo}" maxlength="25"/></td>
					<td class="tableleft">状态：</td>
					<td><xjw:selectBar name="status" clazz="com.xjw.kzenum.order.OrderStatusEnum" myClass="" type="select" value="${form.status}" id="status" exclude="1"></xjw:selectBar></td>
				</tr>
				<tr>
					<td class="tableleft">提款时间：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>
		  	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>会员提款列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>会员账号</th>
					        <th>提款编号</th>
					        <th>交易金额</th>
					        <th>状态</th>
					        <th>提款时间</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
							    	<tr>
							    		<td>${dto.loginName}</td>
							    		<td>${dto.orderNo}</td>
							    		<td>${dto.tradeAmount}</td>
							    		<td>
							    			<c:choose>
							            		<c:when test="${dto.status == 2}"><font color="green">成功</font></c:when>
							            		<c:when test="${dto.status == 3}"><font color="red">失败</font></c:when>
							            		<c:otherwise>---</c:otherwise>
							            	</c:choose>
							    		</td>
							    		<td><fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
							        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="9" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
	</div>
      
	<script>
		$(function () {
			BUI.use('bui/overlay');
	    });
	</script>
</body>
</html>