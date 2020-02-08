<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>反水设置</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
<!-- 		</form> -->
		<div class="well">
			<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增反水</button>
		</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>返水设置</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>活动名称</th>
					        <th>账户类别</th>
					        <th>平台</th>
					        <th>百分比</th>
					        <th>反水下限</th>
					        <th>反水上限</th>
					        <th>活动开始时间</th>
					        <th>活动结束时间</th>
					        <th>备注</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td>${dto.name }</td>
								            <td>
								            	<xjw:enumBar clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" code="${dto.memberStart}" />
								            	-
								            	<xjw:enumBar clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" code="${dto.memberEnd}" />
								            </td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${dto.platformType}" /></td>
								            <td>${dto.percent}</td>
								            <td>${dto.up }</td>
								            <td>${dto.lower }</td>
								            <td><fmt:formatDate value="${dto.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${dto.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td title="${dto.remark }"><xjw:subStringTag input="${dto.remark }" replace="......" size="10"/></td>
								            <td>
								            	<input type="hidden" name="ck" value="${dto.id }"/>
												<c:choose>
													<c:when test="${dto.status eq '1' }">
														<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
														<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>活动启动</button>
													</c:when>
													<c:when test="${dto.status eq '2' }">
														<button type="button" class="btn btn-warning stop-but"><i class="icon-white icon-off"></i>活动暂停</button>
														<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>活动下线</button>
													</c:when>
													<c:when test="${dto.status eq '3' }">
														<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
														<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>活动启动</button>
														<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>活动下线</button>
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
		 
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/rebate/info/skipAdd");
	    });
	    
	    $(".modify-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/rebate/info/skipEdit?id=" + id;
		});
	    
	    $(".start-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认活动启动？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/rebate/info/start?id=" + id;
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
				 msg : '是否确认活动暂停？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/rebate/info/stop?id=" + id;
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
				 msg : '是否确认活动下线？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/rebate/info/down?id=" + id;
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