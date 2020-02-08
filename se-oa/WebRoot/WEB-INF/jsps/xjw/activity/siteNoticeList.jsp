<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>网页公告列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<div class="well">
			<xjw:auth code="YWGL-QTGN-WYGGLB-XZGG">
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增公告</button>
			</xjw:auth>
		</div>
	
	
		<form id="objForm" action="${ctx}/site/notice/list" method="post">
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>网页公告列表</strong>
			      </div>
			        	
		          <table class="table list table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						        <th>公告标题</th>
						        <th>公告内容</th>
						        <th>开始时间</th>
						        <th>结束时间</th>
						        <th>操作</th>
						    </tr>
					    </thead>
		    			<c:choose>
						    <c:when test="${not empty page.dataList }">
				    			<tbody>
				    				<c:forEach var="dto" items="${page.dataList }">
									    	<tr>
									    		<td>${dto.name }</td>
									    		<td title="${dto.context }"><xjw:subStringTag input="${dto.context }" replace="......" size="10"/></td>
									            <td><fmt:formatDate value="${dto.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td><fmt:formatDate value="${dto.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td>
									            	<input type="hidden" name="ck" value="${dto.id }"/>
													<c:choose>
														<c:when test="${dto.status eq '1' }">
															<xjw:auth code="YWGL-QTGN-WYGGLB-BJ">
																<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
															</xjw:auth>
															<xjw:auth code="YWGL-QTGN-WYGGLB-QDGG">
																<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>启动公告</button>
															</xjw:auth>
														</c:when>
														<c:when test="${dto.status eq '2' }">
															<xjw:auth code="YWGL-QTGN-WYGGLB-ZTGG">
																<button type="button" class="btn btn-warning stop-but"><i class="icon-white icon-off"></i>暂停公告</button>
															</xjw:auth>
															<xjw:auth code="YWGL-QTGN-WYGGLB-GGXX">
																<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>公告下线</button>
															</xjw:auth>
														</c:when>
														<c:when test="${dto.status eq '3' }">
															<xjw:auth code="YWGL-QTGN-WYGGLB-BJ">
																<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
															</xjw:auth>
															<xjw:auth code="YWGL-QTGN-WYGGLB-QDGG">
																<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>启动公告</button>
															</xjw:auth>
															<xjw:auth code="YWGL-QTGN-WYGGLB-GGXX">
																<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>公告下线</button>
															</xjw:auth>
														</c:when>
														<c:otherwise>
															
														</c:otherwise>
													</c:choose>
									            </td>
									        </tr>
							    	</c:forEach>
						    	</tbody>
					    	</c:when>
					    	<c:otherwise>
				    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
			bindSkipClick("add", "${ctx}/site/notice/skipAdd");
	    });
	    
	    $(".modify-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/site/notice/skipEdit?id=" + id;
		});
	    
	    $(".start-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认启动公告？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/site/notice/start?id=" + id;
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	    
	    $(".stop-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认暂停公告？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/site/notice/stop?id=" + id;
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	    
	    $(".down-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认公告下线？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/site/notice/down?id=" + id;
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