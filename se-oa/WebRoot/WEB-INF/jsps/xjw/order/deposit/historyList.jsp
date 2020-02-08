<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>存款记录</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/order/deposit/historyList" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						会员账号：
					</td>
					<td><input type="text" name="keywords" id="keywords" value="${form.keywords }" maxlength="20"/></td>
					<td class="tableleft">
						存款编号：
					</td>
					<td><input type="text" name="orderNo" id="orderNo" value="${form.orderNo }" maxlength="25"/></td>
					<td class="tableleft">
						存款类型：
					</td>
					<td>
						<xjw:selectBar name="tradeMode" id="tradeMode" myClass="" clazz="com.xjw.kzenum.order.TradeModeEnum" type="select" value="${form.tradeMode }"></xjw:selectBar>
					</td>
				</tr>
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">结果：</td>
					<td>
						<xjw:selectBar name="status" clazz="com.xjw.kzenum.order.OrderStatusEnum" 
					           myClass="" type="select" value="${form.status }" id="status" exclude="1"></xjw:selectBar>
					</td>
					<td class="tableleft">操作类型：</td>
					<td>
						<xjw:selectBar name="operationType" id="operationType" clazz="com.xjw.kzenum.order.OperationTypeEnum" 
					           myClass="" type="select" value="${form.operationType }" ></xjw:selectBar>
					</td>
				</tr>
				<tr>
					<td class="tableleft">操作人：</td>
					<td>
					    <select name="updateUserName" id="updateUserName">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="user" items="${list.dataList }">
					    		<c:if test="${form.updateUserName == user.id }">
					    			<option value="${user.id }" selected="selected">${user.loginName }</option>
					    		</c:if>
					    		<c:if test="${form.updateUserName != user.id }">
					    			<option value="${user.id }">${user.loginName }</option>
					    		</c:if>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button><!-- 
				<button type="button" class="btn btn-success yes-but" id="dowmloadExcel"><i class="icon-white icon-fullscreen"></i>存款记录导出</button> -->
				<xjw:auth code="YWGL-ZJGL-CKJL-DCCKJL">
					<button type="button" class="btn btn-success yes-but" id="downExcel"><i class="icon-white icon-fullscreen"></i>存款记录导出</button>
				</xjw:auth>
			</div>
		
	    <div class="panel">
		      <div class="panel-header">
		        	<strong>存款记录</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>存款编号</th>
					        <th>会员账号</th>
					        <th>存款人姓名</th>
					        <th>存款金额</th>
					        <th>存款时间</th>
					        <th>存款类型</th>
					        <th>存入银行</th>
					        <th>账户姓名</th>
					        <th>存入账号</th>
					        <th>结果</th>
					        <th>操作类型</th>
					        <th>完成时间</th>
					        <th>操作人</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:set var="countTradeAmount" value="0" />
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td title="${dto.remark }">
								    			<div style="border: 1; color: <c:if test="${not empty dto.remark }">#e22d3e</c:if>">${dto.orderNo }</div>
								    		</td>
								    		<td>${dto.loginName }</td>
								            <td>${dto.fromBankAccount}</td>
								            <td>
								            	<c:set var="countTradeAmount" value="${dto.tradeAmount +  countTradeAmount}"/>
								            	<fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/>
								            </td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}" /></td>
								            <td>
							            		<xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/>
								            </td>
								            <td>${dto.toBankAccount }</td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.toBankCard eq 'tiantianlee123@gmail.com' }">
								            			6212262008016966740
								            		</c:when>
								            		<c:otherwise>
								            			<xjw:subStringTag input="${dto.toBankCard }" replace="****" type="" size="7"/>
								            		</c:otherwise>
								            	</c:choose>
								            </td>
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
								            <td>
								            	<xjw:enumBar clazz="com.xjw.kzenum.order.OperationTypeEnum" code="${dto.operationType}" />
								            </td>
								            <td><fmt:formatDate value="${dto.updateTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<c:if test="${dto.operationType eq '1'}">
								            		${dto.updateUserName}
								            	</c:if>
								            </td>
								        </tr>
						    	</c:forEach>
						    	<tr>
						    		<td colspan="2">&nbsp;</td>
						    		<td style="font-weight: bold;">汇总金额: </td>
						    		<td style="font-weight: bold;">
						    			<fmt:formatNumber value="${countTradeAmount }" type="currency" pattern="#.##"/>
						    		</td>
						    		<td colspan="9">&nbsp;</td>
						    	</tr>
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
		 </form>
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
	    });
	    
	    
	    $("#dowmloadExcel").click(function(){
	    	location.href="${ctx}/order/deposit/dowmloadExcel";   
	    })

	 /*    $("#downExcel").click(function(){
	   		$.ajax({
				type: "POST",
				url: "${ctx}/order/deposit/downExcel",
				data: $("#objForm").serialize()
	    	})
	    }); */
	    $("#downExcel").click(function(){
	    	var beginTime = $("#beginTime").val();
	    	var endTime = $("#endTime").val();
	    	var keywords = $("#keywords").val();
	    	var orderNo = $("#orderNo").val();
	    	var tradeMode = $("#tradeMode").val();
	    	var status = $("#status").val();
	    	location.href="${ctx}/order/deposit/downExcel?beginTime="+beginTime+"&endTime="+endTime+"&keywords="+keywords+"&orderNo="+orderNo+"&tradeMode="+tradeMode+"&status="+status;   
	    }) 

	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>