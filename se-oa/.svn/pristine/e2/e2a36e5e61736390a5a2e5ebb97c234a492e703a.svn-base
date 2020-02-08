<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>提款详情</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx }/order/timecount/details" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="hidden" id="type" name="type" value="${form.type }"/>
						<input type="hidden" id="userId" name="userId" value="${form.userId }"/>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-primary" id="backId"><i class="icon-white icon-search"></i>返回列表</button>
			</div>
	
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>提款详情</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>提款编号</th>
					        <th>提交时间</th>
					        <th>风控时间</th>
					        <th>财务时间</th>
					        <th>结果</th>
					        <th>风控</th>
					        <th>风控用时<font style="color:red;">(分钟)</font></th>
					        <th>财务</th>
					        <th>财务用时<font style="color:red;">(分钟)</font></th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td title="${dto.remark }"><div style="border: 1;color: <c:if test="${not empty dto.remark }">#e22d3e</c:if>">${dto.orderNo }</div></td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${dto.riskTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${dto.financeTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.status eq '2'}">
								            			<font color="green">成功</font>
								            		</c:when>
								            		<c:otherwise>
								            			<font color="red">失败</font>
								            		</c:otherwise>
								            	</c:choose>
								            </td>
								            <td>${dto.riskUserName}</td>
								            <td><font style="color:red;">${dto.riskUserTime}</font></td>
								            <td>${dto.financeUserName}</td>
								            <td><font style="color:red;">${dto.financeUserTime}</font></td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="14" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
		 </form>
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("backId", "${ctx}/order/timecount/list");
	    });
	    
	    $("#downExcel").click(function(){
	    	var beginTime = $("#beginTime").val();
	    	var endTime = $("#endTime").val();
	    	var keywords = $("#keywords").val();
	    	var orderNo = $("#orderNo").val();
	    	var status = $("#status").val();
	    	location.href="${ctx}/order/withdraw/downExcel?beginTime="+beginTime+"&endTime="+endTime+"&keywords="+keywords+"&orderNo="+orderNo+"&status="+status;   
	    })
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>