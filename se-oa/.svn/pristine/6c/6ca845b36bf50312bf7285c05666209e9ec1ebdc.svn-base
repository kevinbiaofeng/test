<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="dayProfitAmount" value="${dayDepositAmount - dayWithdrawAmount - dayMemberMoneyAmount}"/>
<c:set var="monthProfitAmount" value="${monthDepositAmount - monthWithdrawAmount - monthMemberMoneyAmount}"/>
<c:set var="allProfitAmount" value="${allDepositAmount - allWithdrawAmount - allMemberMoneyAmount}"/>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>本月统计</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>本月统计</strong>
			      </div>
		
					<table class="table table-bordered definewidth">
						<tr>
					        <td class="tableleft">今日注册人数：</td>
					        <td>${dayRegisterCount}</td>
					        <td class="tableleft">本月注册人数：</td>
							<td>${monthRegisterCount}</td>
							<td class="tableleft">总注册人数：</td>
							<td>${allRegisterCount}</td>
					    </tr>
					    <tr>
					        <td class="tableleft">今日投注总额：</td>
					        <td>${dayBetAmount}</td>
					        <td class="tableleft">本月投注总额：</td>
							<td colspan="3">${monthBetAmount}</td>
					    </tr>
						<tr>
							<td class="tableleft">今日存款总额：</td>
							<td style="color:green;">${dayDepositAmount} </td>
							<td class="tableleft">本月存款总额：</td>
							<td style="color:green;">${monthDepositAmount} </td>
							<td class="tableleft">总存款总额：</td>
							<td style="color:green;">${allDepositAmount}</td>
						</tr>	
						<tr>
							<td class="tableleft">今日提款总额：</td>
							<td style="color:red;">${dayWithdrawAmount} </td>
							<td class="tableleft">本月提款总额：</td>
							<td style="color:red;">${monthWithdrawAmount} </td>
							<td class="tableleft">总提款总额：</td>
							<td style="color:red;">${allWithdrawAmount}</td>
						</tr>
						<tr>
							<td class="tableleft">今日红利：</td>		
							<td style="color: ${dayMemberMoneyAmount > 0 ? 'green' : 'red'}">${dayMemberMoneyAmount}</td>
							<td class="tableleft">本月红利：</td>
							<td style="color: ${monthMemberMoneyAmount > 0 ? 'green' : 'red'}">${monthMemberMoneyAmount}</td>
							<td class="tableleft">总红利：</td>
							<td style="color: ${allMemberMoneyAmount > 0 ? 'green' : 'red'}">${allMemberMoneyAmount}</td>
						</tr>	
						<tr>
							<td class="tableleft">今日利润：</td>		
							<td style="color: ${dayProfitAmount > 0 ? 'green' : 'red'}">${dayProfitAmount}</td>
							<td class="tableleft">本月利润：</td>
							<td style="color: ${monthProfitAmount > 0 ? 'green' : 'red'}">${monthProfitAmount}</td>
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
