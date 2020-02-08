	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员近期列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/memberamount/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td><input type="text" name="keywords" value="${form.keywords}"/></td>
					<td class="tableleft">时间范围：</td>
					<td>
						<select name="dayType">
							<option value="">---请选择---</option>
							<option value="1" <c:if test="${form.dayType == 1}">selected</c:if>>今天</option>
							<option value="2" <c:if test="${form.dayType == 2}">selected</c:if>>昨天</option>
							<option value="3" <c:if test="${form.dayType == 3}">selected</c:if>>最近一周</option>
							<option value="4" <c:if test="${form.dayType == 4}">selected</c:if>>最近两周</option>
							<option value="5" <c:if test="${form.dayType == 5}">selected</c:if>>最近一月</option>
							<option value="0" <c:if test="${form.dayType == 0}">selected</c:if>>所有</option>
						</select>
					</td>
					
					<td class="tableleft">时间区间：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime }" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime }" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
				<tr>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
					<td class="tableleft">VIP：</td>
					<td>
						<xjw:selectBar name="vipType" id="vipType" clazz="com.xjw.kzenum.sys.VipEnum" myClass="" type="select" value="${form.vipType }"/>
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
		        	<strong>会员近期列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>会员ID</th>
					    	<th>会员账号</th>
					        <th>存款</th>
					        <th>提款</th>
					        <th>存提款</th>
					        <th>奖金</th>
					        <th>返水</th>
					        <th>注册时长</th>
					        <th>注册时间</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td>${dto.userId}</td>
								    		<td>${dto.loginName}</td>
								    		<td><fmt:formatNumber value="${dto.depositAmount}" pattern="#.##"/></td>
								    		<td><fmt:formatNumber value="${dto.withdrawAmount}" pattern="#.##"/></td>
								    		<td>
								    			<c:choose>
								    				<c:when test="${dto.depositAmount - dto.withdrawAmount > 0}">
								    					<font color="green">+<fmt:formatNumber value="${dto.depositAmount - dto.withdrawAmount}" pattern="#.##"/></font>
								    				</c:when>
								    				<c:when test="${dto.depositAmount - dto.withdrawAmount < 0}">
								    					<font color="red"><fmt:formatNumber value="${dto.depositAmount - dto.withdrawAmount}" pattern="#.##"/></font>
								    				</c:when>
								    				<c:otherwise><fmt:formatNumber value="${dto.depositAmount - dto.withdrawAmount}" pattern="#.##"/></c:otherwise>
								    			</c:choose>
								    		</td>
								    		<td><fmt:formatNumber value="${dto.awardAmount}" pattern="#.##"/></td>
								    		<td><fmt:formatNumber value="${dto.rakeAmount}" pattern="#.##"/></td>
								    		<td>${dto.registerDays}</td>
								    		<td><fmt:formatDate value="${dto.registerTime}" pattern="yyyy-MM-dd"/></td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="6" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			  </table>
		 	</div>
		 	
		 	<div class='bui-grid'>
			  	<div class='bui-grid-bbar'>
	    		  	<c:if test="${not empty page.dataList }">
	   					<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  	</c:if>
			  	</div>
			</div>
		 </div>
	  </div>
      
      <script>
	    $(function () {
			$("input:text[name=beginTime], input:text[name=endTime]").change(function(){
				$("select[name=days] option:first").prop("selected", true);
			});
	    });
	 
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>