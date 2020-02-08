<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>站内信</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/message/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">标题：</td>
					<td><input type="text" name="likeTitle" value="${form.likeTitle}" placeholder="模糊匹配"/></td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button id="btnNew" type="button"class="btn btn-info" id="btnAdd"><i class="icon-white icon-plus"></i>新增</button>
				<button id="btnDelete" type="button" class="btn btn-danger"><i class="icon-white icon-remove-sign"></i>批量删除</button>
			</div>
		 </form>			
		
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>站内信列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th><input type="checkbox" id="allCbx"/>全选</th>
					    	<th>ID</th>
					    	<th>标题</th>
					    	<th>收件人总数</th>
					        <th>创建时间</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td><input type="checkbox" name="cbx" value="${dto.id}"/></td>
								    		<td>${dto.id}</td>
								    		<td>${dto.title}</td>
								    		<td>${dto.receiveCount}</td>
								            <td><fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td>
								            	<button type="button" class="btn btn-info jq_btn_receive" data-id="${dto.id}"><i class="icon-white icon-search"></i>收件人管理</button>
								            	<button type="button" class="btn btn-edit jq_btn_edit" data-id="${dto.id}"><i class="icon-white icon-edit"></i>编辑</button>
												<button type="button" class="btn btn-danger jq_btn_delete" data-id="${dto.id}"><i class="icon-white icon-remove-sign"></i>删除</button>
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
      
      <script>
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		$("button.jq_btn_receive").click(function(){
	    			var id = $(this).data("id");
	    			window.location.href = "${ctx}/messageuser/list?messageId=" + id; 
	    		});
	    		
	    		//全选
	    		$("#allCbx").change(function(){
	    			$("input:checkbox[name=cbx]").prop("checked", $(this).is(":checked"));
	    		});
	    		
	    		//新增
	    		$("#btnNew").click(function(){
	    			var url = '${ctx}/message/new';
					fnSave(url);
	    		});
	    		
	    		//批量删除
	    		$("#btnDelete").click(function(){
	    			var ids = []; 
	    			$("input:checkbox[name=cbx]:checked").each(function(){
	    				ids.push($(this).val());
	    			});
	    			
	    			if(ids.length > 0){
	    				var url = "${ctx}/message/delete";
						var data = $.param({ids: ids}, true);
	    			
	    				$.post(url, data, function(json){
							BUI.Message.Alert(json.msg,'success');
							if(json.isSuccess){
								window.location.reload();
							};
						}, "json");			
	    			}
	    		});
				
	    		//删除按钮
	    		$("button.jq_btn_delete").click(function(){
	    			var id = $(this).data("id");
	    			
	    			BUI.Message.Confirm('是否确定删除？',function(){
						var url = "${ctx}/message/delete";
						var data = $.param({ids: id}, true);
						$.post(url, data, function(json){
							BUI.Message.Alert(json.msg,'success');
							if(json.isSuccess){
								window.location.reload();
							};
						}, "json");
				    },'question');
	    		});
	    		
	    		//编辑
				$("button.jq_btn_edit").click(function() {
					var id = $(this).data("id");
					
					var url = '${ctx}/message/edit';
					var params = {"id" : id};
					fnSave(url, params);
				});
				
	    		//保存方法
	    		var fnSave = function(url, params){
	    			var dialog = new Overlay.Dialog({
	    				closeAction: 'destroy', 
						title:'站内信编辑',
						width:500,
						height:300,
						loader : {
							url : url,
				            params : params,//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var title = $("#editForm input[name=title]");
							if($.trim(title.val()) == ''){
								return !!BUI.Message.Alert('请输入标题', 'error');
							}
							
							var content = $("#editForm textarea[name=content]");
							if($.trim(content.val()) == ''){
								return !!BUI.Message.Alert('游戏类别不能为空', 'error');
							}
						
							var url = "${ctx}/message/save";
							var data = $("#editForm").serialize();
							$.post(url, data, function(json){
								BUI.Message.Alert(json.msg,'success');
								if(json.isSuccess){
									window.location.reload();
								}
							}, "json");
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
	    		}
		    });
		});
	</script>
	<%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>