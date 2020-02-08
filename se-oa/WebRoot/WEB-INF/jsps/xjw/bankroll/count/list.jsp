<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="profitAmount" value="${activity.activityCountAmount + fsAmount + tsjjAmount + qtAmount}"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>资金调整统计</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/fundadjustment/count/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime }" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime }" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
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
			        	<strong>资金调整统计</strong>
			      </div>
		
					<table class="table table-bordered definewidth" cellpadding="0" border="1">
						<%--
						<c:set var="hdTotalAmount" value="0" />
						 <tr>
						<c:forEach items="${list }" var="dto" >
							<c:set var="hdTotalAmount" value="${dto.money +  hdTotalAmount }" />
					        <td class="tableleft">${dto.actId } :  ${dto.money }</td>
						</c:forEach>
						</tr> --%>
						
						<tr>
							<td class="tableleft">
								${activity.name9 }：   <font style="color: ${activity.money9 > 0 ? 'red' : 'green'}">${activity.money9}</font>
							</td>
							 <td class="tableleft">
							 	${activity.name5 }：   <font style="color: ${activity.money5 > 0 ? 'red' : 'green'}">${activity.money5}</font>
							 </td>
							<td class="tableleft">
								${activity.name10 }：   <font style="color: ${activity.money10 > 0 ? 'red' : 'green'}">${activity.money10}</font>
							</td>
							<td class="tableleft">
								${activity.name12 }：  <font style="color: ${activity.money12 > 0 ? 'red' : 'green'}">${activity.money12}</font>
							</td>
							<td class="tableleft">
								${activity.name13 }：   <font style="color: ${activity.money13 > 0 ? 'red' : 'green'}">${activity.money13}</font>
							</td>
							<td class="tableleft">
								${activity.name14 }：   <font style="color: ${activity.money14 > 0 ? 'red' : 'green'}">${activity.money14}</font>
							</td>
					    </tr>
					    <tr>
					    	<td class="tableleft">
					    		${activity.name15 }：   <font style="color: ${activity.money15 > 0 ? 'red' : 'green'}">${activity.money15}</font>
					    	</td>
							<td class="tableleft">
								${activity.name16 }：   <font style="color: ${activity.money16 > 0 ? 'red' : 'green'}">${activity.money16}</font>
							</td>
							<td class="tableleft">
							 	${activity.name17 }：  <font style="color: ${activity.money17 > 0 ? 'red' : 'green'}">${activity.money17}</font>
							</td>
							<td class="tableleft">
								${activity.name18 }：   <font style="color: ${activity.money18 > 0 ? 'red' : 'green'}">${activity.money18}</font>
							</td>
							<td class="tableleft">
								${activity.name19 }：   <font style="color: ${activity.money19 > 0 ? 'red' : 'green'}">${activity.money19}</font>
							</td>
							<td class="tableleft">
								${activity.name21 }：   <font style="color: ${activity.money21 > 0 ? 'red' : 'green'}">${activity.money21}</font>
							</td>
					    </tr>
					    <tr>
							<td class="tableleft">
								${activity.name22 }：   <font style="color: ${activity.money22 > 0 ? 'red' : 'green'}">${activity.money22}</font>
							</td>
							<td class="tableleft">
								${activity.name24 }：  <font style="color: ${activity.money24 > 0 ? 'red' : 'green'}">${activity.money24}</font>
							</td>
							<td class="tableleft">
								${activity.name25 }：   <font style="color: ${activity.money25 > 0 ? 'red' : 'green'}">${activity.money25}</font>
							</td>
							<td class="tableleft">
								${activity.name28 }： <font style="color: ${activity.money28 > 0 ? 'red' : 'green'}">${activity.money28}</font>
							</td>
							<td class="tableleft">
								${activity.name30 }：  <font style="color: ${activity.money30 > 0 ? 'red' : 'green'}">${activity.money30}</font>
							</td>
							<td class="tableleft">
								${activity.name31 }：  <font style="color: ${activity.money31 > 0 ? 'red' : 'green'}">${activity.money31}</font>
							</td>
					    </tr>
					    <tr>
							<td class="tableleft">
								${activity.name32 }：   <font style="color: ${activity.money32 > 0 ? 'red' : 'green'}">${activity.money32}</font>
							</td>
							<td class="tableleft">
								${activity.name33 }：  <font style="color: ${activity.money33 > 0 ? 'red' : 'green'}">${activity.money33}</font>
							</td>
							<td class="tableleft">
								${activity.name34 }：   <font style="color: ${activity.money34 > 0 ? 'red' : 'green'}">${activity.money34}</font>
							</td>
							<td class="tableleft">
								${activity.name35 }：    <font style="color: ${activity.money35 > 0 ? 'red' : 'green'}">${activity.money35}</font>
							</td>
							<td class="tableleft">
								${activity.name36 }：   <font style="color: ${activity.money36 > 0 ? 'red' : 'green'}">${activity.money36}</font>
							</td>
							<td class="tableleft">
								${activity.name38 }：  <font style="color: ${activity.money38 > 0 ? 'red' : 'green'}">${activity.money38}</font> 
							</td>
					    </tr>
						
						<tr>
					        <td class="tableleft">活动总金额：</td>
							<td colspan="5">${activity.activityCountAmount}</td>
					    </tr>
					    <tr>
					        <td class="tableleft">返水总金额：</td>
							<td colspan="5">${fsAmount}</td>
					    </tr>
						<tr>
							<td class="tableleft">特殊奖金总金额：</td>
							<td colspan="5" style="color:green;">${tsjjAmount} </td>
						</tr>	
						<tr>
							<td class="tableleft">其它总金额：</td>
							<td colspan="5" style="color:red;">${qtAmount} </td>
						</tr>
						<tr>
							<td class="tableleft">总金额：</td>		
							<td colspan="5" style="color: ${profitAmount > 0 ? 'green' : 'red'}">${profitAmount}</td>
						</tr>
							
					</table>
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	 </div>

	 <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>