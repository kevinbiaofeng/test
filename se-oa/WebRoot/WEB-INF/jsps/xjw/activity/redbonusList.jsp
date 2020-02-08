<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>红包列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/redbonus/info/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">活动ID：</td>
					<td><input type="text" name="id" id="id" value="${form.id}"/></td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<xjw:auth code="XTGL-XTPZ-HBFF-HBFF">
					<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
					<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增红包</button>
				</xjw:auth>
			</div>
		
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>红包列表</strong>
			      </div>
			        	
		          <table class="table list table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						    	<th>ID</th>
						        <th>用户名称</th>
						        <th>红包金额</th>
						        <th>活动名称</th>
						        <th>用户是否打开</th>
						        <th>打开时间</th>
						        <th>创建人</th>
						        <th>创建时间</th>
						        <th>操作</th>
						    </tr>
					    </thead>
					    <c:choose>
						    <c:when test="${not empty page.dataList }">
				    			<tbody>
				    				<c:forEach var="dto" items="${page.dataList }">
				    					<tr>
					    					<td>${dto.id }</td>
					    					<td>${dto.userName }</td>
					    					<td>${dto.money }</td>
					    					<td title="${dto.actName }"><xjw:subStringTag input="${dto.actName }" replace="......" size="8"/></td>
					    					<td style="color:<c:if test="${dto.isOpen eq '2'}">red</c:if><c:if test="${dto.isOpen eq '1'}">green</c:if>">
					    						<c:choose>
													<c:when test="${dto.endDays > 3}">
														该活动已过期
													</c:when>
													<c:otherwise>
														<xjw:enumBar clazz="com.xjw.kzenum.sys.YesORNoEnum" code="${dto.isOpen}"/>
													</c:otherwise>
												</c:choose>
					    					</td>
					    					<td><fmt:formatDate value="${dto.openTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					    					<td>${dto.createUserName }</td>
					    					<td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					    					<td>
					    						<input type="hidden" name="ck" value="${dto.id }"/>
					    						<button type="button" class="btn btn-danger remove-but"><i class="icon-white icon-remove"></i>删除</button>
					    					</td>
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
		 </form>
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/redbonus/info/skipAdd");
	    });
	    
	    $(".modify-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/redbonus/info/skipEdit?id=" + id;
		});
	    
	    $(".remove-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认删除该红包？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/redbonus/info/delById?id=" + id;
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>