<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>操作记录</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx }/operation/log/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">用户：</td>
					<td><input type="text" name="loginName" value="${form.loginName}"/></td>
					<td class="tableleft">时间：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime}" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime"  value="${form.endTime}" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">操作人：</td>
					<td><input type="text" name="createUserName" value="${form.createUserName}"/></td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>操作记录</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
						    <tr>
						        <th width="15%">会员账号</th>
						        <th width="30%">原有内容</th>
						        <th width="30%">新内容</th>
						        <th>时间</th>
						        <th>操作人</th>
						    </tr>
					    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr class="tr">
								    		<td>${dto.loginName }</td>
								            <td>${dto.oldData }</td>
								            <td>${dto.newData }</td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>${dto.createUserName }</td>
								        </tr>
						    	</c:forEach>
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