<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="profitAmount" value="${depositAmount - withdrawAmount - memberMoneyAmount}"/>
<c:set var="allProfitAmount" value="${allDepositAmount - allWithdrawAmount - allMemberMoneyAmount}"/>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查询统计</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/info/querystat" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" value="${beginTime}" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${endTime}" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>
	
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>查询统计</strong>
			      </div>
		
					<table class="table table-bordered definewidth">
						<tr>
					        <td class="tableleft">注册人数：</td>
					        <td>${registerCount}</td>
							<td class="tableleft">总注册人数：</td>
							<td>${allRegisterCount}</td>
					    </tr>
					    <tr>
					        <td class="tableleft">投注总额：</td>
							<td colspan="3">${betAmount}</td>
					    </tr>
						<tr>
							<td class="tableleft">存款总额：</td>
							<td style="color:green;">${depositAmount} </td>
							<td class="tableleft">总存款总额：</td>
							<td style="color:green;">${allDepositAmount}</td>
						</tr>	
						<tr>
							<td class="tableleft">提款总额：</td>
							<td style="color:red;">${withdrawAmount} </td>
							<td class="tableleft">总提款总额：</td>
							<td style="color:red;">${allWithdrawAmount}</td>
						</tr>
						<tr>
							<td class="tableleft">红利：</td>		
							<td style="color: ${memberMoneyAmount > 0 ? 'green' : 'red'}">${memberMoneyAmount}</td>
							<td class="tableleft">总红利：</td>
							<td style="color: ${allMemberMoneyAmount > 0 ? 'green' : 'red'}">${allMemberMoneyAmount}</td>
						</tr>
						<tr>
							<td class="tableleft">利润：</td>		
							<td style="color: ${profitAmount > 0 ? 'green' : 'red'}">${profitAmount}</td>
							<td class="tableleft">总利润：</td>
							<td style="color: ${allProfitAmount > 0 ? 'green' : 'red'}">${allProfitAmount}</td>
						</tr>
							
					</table>
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	  </div>

	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
