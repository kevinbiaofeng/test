<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>VIP配置列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/vipconfig/list" method="post">
			<table class="searchTable">
				<tr>					
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
		        	<strong>VIP配置列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>会员等级</th>
					    	<th>月累计存款</th>
					        <th>周有效投注</th>
					        <th>每月免费筹码</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList}">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td>${dto.level}</td>
								    		<td>${dto.monthDepositAmount}</td>
								            <td>${dto.weekBetAmount}</td>
								            <td>${dto.monthChipAmount}</td>
								    		<td>
								    			<button type="button" class="btn btn-edit" data-id="${dto.id}"><i class="icon-white icon-edit"></i>编辑</button>
								    		</td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="5" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
	    	BUI.use(['bui/overlay'],function(Overlay){ //,'bui/mask'

	    		//编辑游戏
				$("button.btn-edit").click(function() {
					var id = $(this).data("id");
					var url = '${ctx}/vipconfig/edit';
					var params = {"id" : id};
					fnSave(url, params);
				});
	    		
	    		//保存方法
	    		var fnSave = function(url, params){
	    			var dialog = new Overlay.Dialog({
	    				closeAction: 'destroy', 
						title:'VIP配置编辑',
						width:400,
						height:350,
						loader : {
							url : url,
				            params : params,//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var monthDepositAmount = $("#editSlotForm input[name=monthDepositAmount]");
							if($.trim(monthDepositAmount.val()) == ''){
								return !!BUI.Message.Alert('月累计存款不能为空', 'error');
							}
							
							var weekBetAmount = $("#editSlotForm input[name=weekBetAmount]");
							if($.trim(weekBetAmount.val()) == ''){
								return !!BUI.Message.Alert('周有效投注不能为空', 'error');
							}
							
							var monthChipAmount = $("#editSlotForm input[name=monthChipAmount]");
							if($.trim(monthChipAmount.val()) == ''){
								return !!BUI.Message.Alert('每月免费筹码不能为空', 'error');
							}
							var url = "${ctx}/vipconfig/save";
							var data = $("#editSlotForm").serialize();
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