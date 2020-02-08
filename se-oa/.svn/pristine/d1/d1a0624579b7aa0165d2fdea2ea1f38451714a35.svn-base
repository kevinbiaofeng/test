<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>账变列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx }/accountChange/log/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						会员账号：
					</td>
					<td><input type="text" name="userName" value="${form.userName }" maxlength="15"/></td>
					<td class="tableleft">
						变账类型：
					</td>
					<td><xjw:selectBar name="type" clazz="com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum" myClass="" type="select" value="${form.type }" id="type"/></td>
					<td class="tableleft">平台类型：</td>
					<td>
						<xjw:selectBar name="platformType" id="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" myClass="" type="select" value="${form.platformType }" exclude="6"/>
					</td>
				</tr>
				<tr>
					<td class="tableleft">
						显示条数：
					</td>
					<td>
						<xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/>
					</td>
					<td class="tableleft">时间：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime }" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime }" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>变账列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>用户名</th>
					        <th width="155px">变账类型</th>
					        <th width="100px">平台类型</th>
					        <th width="80px">主平台余额</th>
					        <th width="90px">游戏平台余额</th>
					        <th width="60px">变账金额</th>
					        <th width="135px">变账时间</th>
					        <th width="100px">订单号</th>
					        <th width="50px">活动ID</th>
					        <th width="30px">红利</th>
					        <th width="70px">流水倍数</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
					    	<c:set var="moneyUpTotal" value="0"/>
					    	<c:set var="moneyDownTotal" value="0"/>
					    	<c:set var="moneyRedTotal" value="0"/>
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr class="tr">
								            <td>${dto.userName }</td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.type eq '4'}">
								            			主平台 一》 <xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${dto.gameType }"/>
								            		</c:when>
								            		<c:when test="${dto.type eq '5'}">
								            			<xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${dto.gameType }"/> 一》 主平台
								            		</c:when>
								            		<c:otherwise>
								            			<xjw:enumBar clazz="com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum" code="${dto.type }"/>	
								            		</c:otherwise>
								            	</c:choose>
								            </td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${dto.gameType}"/></td>
								            <td style="color: <c:if test="${dto.money < 0}">red</c:if><c:if test="${dto.money > 0}">green</c:if>">
								            	<fmt:formatNumber value="${dto.totalMoney }" type="currency" pattern="#.##"/>
								            </td>
								            <td style="color: <c:if test="${dto.money > 0}">red</c:if><c:if test="${dto.money < 0}">green</c:if>">
								            	<fmt:formatNumber value="${dto.platformBalance }" type="currency" pattern="#.##"/>
								            </td>
								            <td>
												<c:if test="${dto.money > 0 }">
													<c:set var="moneyUpTotal" value="${dto.money + moneyUpTotal}"/>
													<font color="green"><fmt:formatNumber value="${dto.money }" type="currency" pattern="#.##"/></font>
												</c:if>
												<c:if test="${dto.money < 0 }">
													<c:set var="moneyDownTotal" value="${dto.money + moneyDownTotal}"/>
													<font color="red"><fmt:formatNumber value="${dto.money }" type="currency" pattern="#.##"/></font>
												</c:if>
											</td>
											<td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											<td>${dto.orderNo }</td>
								    		<td>${dto.actId }</td>
								            <td>
								            	<fmt:formatNumber value="${dto.redProfit }" type="currency" pattern="#.##"/>
								            	<c:set var="moneyRedTotal" value="${moneyRedTotal + dto.redProfit}"/>
								            </td>
								            <td>
								            	<fmt:formatNumber value="${dto.multiple }" type="currency" pattern="#.##"/>
								            </td>
								        </tr>
						    	</c:forEach>
						    	<tr>
    								<td class="tableleft">总计：</td>
    								<td colspan="4"></td>
			    					<td><fmt:formatNumber value="${moneyUpTotal + moneyDownTotal }" type="currency" pattern="#.##"/></td>
			    					<td colspan="5"></td>
			    				</tr>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
			BUI.use('bui/overlay');
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>