<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>邮箱验证码列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/emailsms/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">用户账号：</td>
					<td><input type="text" name="loginName" value="${form.loginName}"/></td>
					<td class="tableleft">邮箱：</td>
					<td><input type="text" name="email" value="${form.email}"/></td>
					<td class="tableleft">类别：</td>
					<td><xjw:selectBar name="type" clazz="com.xjw.kzenum.sys.EmailSmsType" myClass="" type="select" value="${form.type}"/></td>
					
					
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>			
		
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>邮箱验证码列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>ID</th>
					    	<th>类别</th>
					    	<th>用户ID</th>
					    	<th>用户账号</th>
					    	<th>用户邮箱</th>
					        <th>验证码</th>
					        <th>过期时间</th>
					        <th>使用状态</th>
					        <th>使用时间</th>
					        <th>创建时间</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td>${dto.id}</td>
								    		<td><xjw:enumBar clazz="com.xjw.kzenum.sys.EmailSmsType" code="${dto.type}"/></td>
								    		<td>${dto.userId}</td>
								            <td>${dto.loginName}</td>
								            <td>${dto.email}</td>
								            <td>${dto.sendCode}</td>
								            <td><fmt:formatDate value="${dto.expireTime}" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.sys.SmsUseStatus" code="${dto.useStatus}"/></td>
								            <td><fmt:formatDate value="${dto.useTime}" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td><fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="12" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
			BUI.use('bui/overlay');
	    });
	 
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>