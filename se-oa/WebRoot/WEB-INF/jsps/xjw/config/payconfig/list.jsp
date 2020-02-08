<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>支付配置列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/payconfig/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
		
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-info" id="btnAdd"><i class="icon-white icon-plus"></i>新增</button>
			</div>
		</form>
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>支付配置列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>支付名称</th>
					        <th>启用状态</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td><xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}"/></td>
								    		<td>
								    			<c:choose>
								    				<c:when test="${dto.status == 1}"><font color="green">已开启</font></c:when>
								    				<c:when test="${dto.status == 2}"><font color="red">已关闭</font></c:when>
								    			</c:choose>
								    
								    		</td>
								    		<td>
								    			<select class="jq_status" data-id="${dto.id}">
								    				<option value="1" <c:if test="${dto.status == 1}">selected</c:if>>开启</option>
													<option value="2" <c:if test="${dto.status == 2}">selected</c:if>>关闭</option>
								    			</select>
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
					<c:if test="${not empty page.dataList}">
	   					<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  	</c:if>
			  	</div>
			  </div>
		 </div>
	  </div>
      
      <script>
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
				$("#btnAdd").click(function(){
					var dialog = new Overlay.Dialog({
			    		closeAction: 'destroy', 
						title:'新增支付配置',
						width:350,
						height:200,
						loader : {
							url : '/payconfig/new',
				            params : {},//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var tradeMode = $("#payConfigForm select[name=tradeMode]");
							if(tradeMode.val() == ''){
								return !!BUI.Message.Alert('请选择支付类别', 'error');
							}
							
							var status = $("#payConfigForm select[name=status]");
							if(tradeMode.val() == ''){
								return !!BUI.Message.Alert('请选择启用状态', 'error');
							}
							
							var url = "${ctx}/payconfig/save";
							var data = $("#payConfigForm").serialize();
							$.post(url, data, function(json){
								if(json.isSuccess){
									BUI.Message.Alert(json.msg,'success');
									window.location.reload();
								}else{
									BUI.Message.Alert(json.msg,'error');
								}
							}, "json");
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
				});
				
				$("select.jq_status").change(function(){
					var id = $(this).data("id");
					var status = $(this).val();
					
					var url = "${ctx}/payconfig/save";
					var data = {id: id, status: status};
					$.post(url, data, function(json){
						BUI.Message.Alert(json.msg,'success');
						if(json.isSuccess){
							window.location.reload();
						}
					}, "json");
				});
	    	});
	    });
	 
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>