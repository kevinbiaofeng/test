<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>站内信-用户列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/messageuser/list" method="post">
			<input type="hidden" name="messageId" value="${form.messageId}"/>
		
			<table class="searchTable">
				<tr>
					<td class="tableleft">收件人账号：</td>
					<td><input type="text" name="receiveName" value="${form.receiveName}"/></td>
					<td class="tableleft">阅读状态：</td>
					<td><xjw:selectBar name="readStatus" id="readStatus" clazz="com.xjw.kzenum.sys.YesORNoEnum" myClass="" type="select" value="${form.readStatus}"/></td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button id="btnBack" type="button" class="btn btn-primary"><i class="icon-white icon-search"></i>返回</button>
				<button id="btnNew" type="button"class="btn btn-info" id="btnAdd"><i class="icon-white icon-plus"></i>新增用户</button>
			</div>
		 </form>
		
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>站内信-用户列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>ID</th>
					    	<th>站内信ID</th>
					    	<th>收件人账号</th>
					    	<th>阅读状态</th>
					        <th>阅读时间</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td>${dto.id}</td>
								    		<td>${message.title}</td>
								    		<td>${dto.receiveName}</td>
								    		<td><xjw:enumBar clazz="com.xjw.kzenum.sys.YesORNoEnum" code="${dto.readStatus}"/></td>
								            <td><fmt:formatDate value="${dto.readTime}" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td>
								            	<button type="button" class="btn btn-danger" data-id="${dto.id}"><i class="icon-white icon-remove-sign"></i>删除</button>
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
	  </div>
      
      <div id="showDialog"></div>
      
      <script>
	    $(function(){
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		$("#btnBack").click(function(){
	    			window.location.href = "${ctx}/message/list"
	    		});
	    		
				//新增
	    		$("#btnNew").click(function(){
			    	$.ajax({
						type: "POST",
						url: "${ctx}/showPanel/openDialog",
						data: {"op" : "customerList", "k" : "r", "inputId" : "tmpUserId", "inputName" : "tmpUsername"},
						async: false,
					    success: function(data) {
					    	BUI.use(['bui/mask'],function(Mask){
					    		 Mask.maskElement('body');
					    		 $("#showDialog").html(data);
					    	});
					    }
			    	});
	    		});
				
				//用户弹窗回调
	    		showCallback = function(id, name){
	    			var url = "${ctx}/messageuser/save";
					var data = {messageId: ${form.messageId}, receiveUser: id, receiveName: name}
					
	    			$.post(url, data, function(json){
						BUI.Message.Alert(json.msg,'success');
						if(json.isSuccess){
							window.location.reload();
						}
					}, "json");
	    		}
	    		
	    		//删除按钮
	    		$("button.btn-danger").click(function(){
	    			var id = $(this).data("id");
	    			
	    			BUI.Message.Confirm('是否确定删除？',function(){
						var url = "${ctx}/messageuser/delete";
						var data = {id: id}
						$.post(url, data, function(json){
							BUI.Message.Alert(json.msg,'success');
							if(json.isSuccess){
								window.location.reload();
							};
						}, "json");
				    },'question');
	    		});
		    });
		});
	</script>
	<%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>