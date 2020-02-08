<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>待审核提款</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/withdrawal/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td><input type="text" name="loginName" value="${form.loginName}"/></td>
					<td class="tableleft">提款编号：</td>
					<td><input type="text" name="orderNo" value="${form.orderNo }" maxlength="25"/></td>
					<td class="tableleft">提款时间：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>
		  	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>待审核提款</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>会员账号</th>
					    	<th>提款编号</th>
					        <th>提款金额</th>
					         <th>申请时间</th>
					        <th>提款进度</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
							    	<tr>
							    		<td>${dto.loginName}</td>
							    		<td>${dto.orderNo}</td>
							    		<td>${dto.tradeAmount}</td>
							    		<td><fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
							    		<td>
							    			<c:choose>
							    				<c:when test="${empty dto.riskUser}">等待审核中</c:when>
							    				<c:when test="${not empty dto.riskUser}">财务出款中</c:when>
							    			</c:choose>
							    		</td>
							    		<td>
							    			<c:if test="${empty dto.riskUser}">
							    			 	<button type="button" class="btn btn-success jq-fk-audit-yes" data-id="${dto.id}"><i class="icon-white icon-ok"></i>风控同意</button>
							    			 	<button type="button" class="btn btn-danger jq-fk-audit-no" data-id="${dto.id}"><i class="icon-white icon-remove"></i>风控拒绝</button>
							    			 </c:if>
							    			 <c:if test="${not empty dto.riskUser}">
							    			 	<button type="button" class="btn btn-success jq-cw-audit-yes" data-id="${dto.id}"><i class="icon-white icon-ok"></i>财务同意</button>
							    			 	<button type="button" class="btn btn-danger jq-cw-audit-no" data-id="${dto.id}"><i class="icon-white icon-remove"></i>财务拒绝</button>
							    			 </c:if>
							    		</td>
							        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="9" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
	</div>
    
    <div id="show"></div>
	<script language="javascript">
		showCallback = function(){
			window.location.href = "/alone/withdrawal/list";
		}
	
		$(function () {
			/* 风控审核 */
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		$("button.jq-fk-audit-yes").click(function(){
	    			var _this = this;
					var id = $(this).data("id");
					
			    	var dialog = new Overlay.Dialog({
			    		closeAction: 'destroy', 
						title:'同意提款',
						width:500,
						height:450,
						loader : {
							url : '/alone/withdrawal/audit/show',
				            params : {"id": id, "flag" : 1},//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							if($(_this).data('isLock')){return;};
							$(_this).data('isLock', 1);
							setTimeout(function(){
								$(_this).data('isLock', 0);
							}, 3000);
							
							var url = "/alone/withdrawal/auditSuccess";
					    	var data = {"id" : id};
							$.post(url, data, function(result){
					    		if(result == "1"){
									BUI.Message.Alert('操作成功','success');
									window.location.href = "/alone/withdrawal/list";
					    		}else{
					    			BUI.Message.Alert('操作失败，请稍后再试','error');
					    		}
					    	}, "json")
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
			    });
	    		
	    		$("button.jq-fk-audit-no").click(function(){
	    			var _this = this;
					var id = $(this).data("id");
					
			    	var dialog = new Overlay.Dialog({
			    		closeAction: 'destroy', 
						title:'拒绝提款',
						width:500,
						height:450,
						loader : {
							url : '/alone/withdrawal/audit/show',
				            params : {"id": id, "flag" : 2},//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var remark = $("#withdrawalForm textarea[name=remark]").val();
							if(remark.length == 0){
								return !!BUI.Message.Alert('请输入备注','error');
							}
							
							if($(_this).data('isLock')){return;};
							$(_this).data('isLock', 1);
							setTimeout(function(){
								$(_this).data('isLock', 0);
							}, 3000);
							
							var url = "/alone/withdrawal/auditFail";
					    	var data = {"id" : id, "remark" : remark};
							$.post(url, data, function(result){
					    		if(result == "1"){
									BUI.Message.Alert('操作成功','success');
									window.location.href = "/alone/withdrawal/list";
					    		}else{
					    			BUI.Message.Alert('操作失败，请稍后再试','error');
					    		}
					    	}, "json")
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
			    });
	    		
	    		
	    		 $(".jq-cw-audit-yes").click(function() {
	    			 var id = $(this).data("id");
    				$.ajax({
    					type: "GET",
    					url: "${ctx}/order/withdraw/showDepositOrderPanel",
    					data: {"id" : id, "status" : "1", "userType" : "4"},
    					async: false,
    				    success: function(data) {
    				    	BUI.Mask.maskElement('body');
    		    		    $("#show").html(data);
    				    }
    		    	});
    			});
    			
				$(".jq-cw-audit-no").click(function(){
					var id = $(this).data("id");
					$.ajax({
						type: "GET",
    					url: "${ctx}/order/withdraw/showDepositOrderPanel",
    					data: {"id" : id, "status" : "0", "userType" : "4"},
    					async: false,
    				    success: function(data) {
    				    	BUI.Mask.maskElement('body');
    		    		    $("#show").html(data);
    				    }
    		    	});
    		    });
			});  
	    });
	</script>
</body>
</html>