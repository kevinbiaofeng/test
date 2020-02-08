<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>官网活跃会员</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx }/officialmember/count/activemembers" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td>
						<input type="hidden" name="userId" value="${form.userId}"/>
						<input type="text" name="loginName" value="${form.loginName}" maxlength="15"/>
					</td>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime}" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime}" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-primary" id="backId">返回官网统计页</button>
			</div>
    		<div class="panel">
	          <table class="table list table-bordered table-hover definewidth">
			  	<thead>
				    <tr>
				        <th>会员账号</th>
				        <th>存款金额</th>
				        <th>存款笔数</th>
				        <th>提款金额</th>
				        <th>提款笔数</th>
				        <th>红利金额</th>
				        <th>注册时间</th>
				    </tr>
			    </thead>
		    	<c:choose>
				    <c:when test="${not empty page.dataList }">
		    			<tbody>
		    				<c:set var="depositAmoutAll" value="0"/>
		    				<c:set var="depositCountAll" value="0"/>
		    				<c:set var="withdrawalAmoutAll" value="0"/>
		    				<c:set var="withdrawalCountAll" value="0"/>
		    				<c:set var="hlmoneyAll" value="0"/>
		    				<c:forEach var="dto" items="${page.dataList }">
						    	<tr class="tr">
						    		<td>${dto.loginName }</td>
						            <td>
						            	<c:set var="depositAmoutAll" value="${depositAmoutAll +  dto.depositAmout}"/>
						            	${dto.depositAmout }
						            </td>
						            <td>
						            	<c:set var="depositCountAll" value="${depositCountAll +  dto.depositCount}"/>
						            	${dto.depositCount }
						            </td>
						            <td>
						            	<c:set var="withdrawalAmoutAll" value="${withdrawalAmoutAll +  dto.withdrawalAmout}"/>
						            	${dto.withdrawalAmout }
						            </td>
						            <td>
						            	<c:set var="withdrawalCountAll" value="${withdrawalCountAll +  dto.withdrawalCount}"/>
						            	${dto.withdrawalCount }
						            </td>
						            <td>
						            	<c:set var="hlmoneyAll" value="${hlmoneyAll +  dto.hlmoney}"/>
						            	${dto.hlmoney }
						            </td>
						            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						        </tr>
					    	</c:forEach>
					    	<tr>
					    		<td>汇总</td>
					    		<td>${depositAmoutAll}</td>
					    		<td>${depositCountAll}</td>
					    		<td>${withdrawalAmoutAll}</td>
					    		<td>${withdrawalCountAll}</td>
					    		<td>${hlmoneyAll}</td>
					    		<td>&nbsp;</td>
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
		 </form>
		 
	  </div>
       <script>
		$(function () {
			BUI.use('bui/overlay');
			bindSkipClick("backId", "${ctx}/officialmember/count/query");
		});
	</script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>