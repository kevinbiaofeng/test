<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>视频管理</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/video/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">ID：</td>
					<td colspan="1"><input type="text" name="id" value="${form.id}" style="width:250px;" maxlength="32"/></td>
					<td class="tableleft">CODE：</td>
					<td><input type="text" name="code" value="${form.code}"/></td>
					<td class="tableleft">标题：</td>
					<td><input type="text" name="title" value="${form.title}"/></td>
				</tr>
				<tr>
					<td class="tableleft">主演：</td>
					<td><input type="text" name="star" value="${form.star}"/></td>
					<td class="tableleft">类型：</td>
					<td><xjw:selectBar name="type" myClass="" clazz="com.xjw.kzenum.media.VideoTypeEnum" type="select" value="${form.type}"/></td>
				</tr>
				<tr>
					<td class="tableleft">VIP：</td>
					<td><xjw:selectBar name="vipFlag" myClass="" clazz="com.xjw.kzenum.sys.YesORNoEnum" type="select" value="${form.vipFlag}"/></td>
					<td class="tableleft">显示：</td>
					<td><xjw:selectBar name="status" myClass="" clazz="com.xjw.kzenum.sys.YesORNoEnum" type="select" value="${form.status}"/></td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
		
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<a href="${ctx}/video/new" class="btn btn-info"><i class="icon-white icon-plus"></i>新增</a>
			</div>
		</form>
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>视频列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>ID</th>
					    	<th>原名</th>
					        <th>标题</th>
					        <th>类型</th>
					        <th>主演</th>
					        <th>VIP</th>
					        <th>显示</th>
					        <th>创建时间</th>
					        <th>编辑时间</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
							    	<tr bgcolor="${dto.status==1 ? '' : '#ff9900'}">
							    		<td>${dto.id}</td>
							    		<td>${dto.originalName}</td>
						    			<td>${dto.title}</td>
							    		<td><xjw:enumBar clazz="com.xjw.kzenum.media.VideoTypeEnum" code="${dto.type}" /></td>
							    		<td>${dto.star}</td>
							    		<td><xjw:enumBar clazz="com.xjw.kzenum.sys.YesORNoEnum" code="${dto.vipFlag}"/></td>
							    		<td><xjw:enumBar clazz="com.xjw.kzenum.sys.YesORNoEnum" code="${dto.status}"/></td>
							    		<td><fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
							    		<td><fmt:formatDate value="${dto.updateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
							    		<c:if test="${dto.status ne '3'}">
								    		<td><a href="${ctx}/video/edit?id=${dto.id}">编辑</a> &nbsp; &nbsp;<a href="${ctx}/video/del?id=${dto.id}">关闭</a></td>
							    		</c:if>
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
					<c:if test="${not empty page.dataList}">
	   					<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  	</c:if>
			  	</div>
			  </div>
		 </div>
	  </div>
      
      <script>
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask', 'bui/uploader'],function(Overlay){
				
	    	});
	    });
	 
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>