<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>待审核存款</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/deposit/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td><input type="text" name="loginName" value="${form.loginName}" maxlength="20"/></td>
					<td class="tableleft">存款编号：</td>
					<td><input type="text" name="orderNo" value="${form.orderNo }" maxlength="25"/></td>
					<td class="tableleft">存款时间：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>待审核存款</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>会员账号</th>
					    	<th>存款编号</th>
					        <th>存款人姓名</th>
					        <th>存款金额</th>
					        <th>存款时间</th>
					        <th>存款类型</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td>${dto.loginName }</td>
								    		<td>${dto.orderNo }</td>
								            <td>${dto.fromBankAccount}</td>
								            <td><fmt:formatNumber value="${dto.tradeAmount}" type="currency" pattern="#.##"/></td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}" /></td>
								            <td>
								            	<button type="button" class="btn btn-success jq-audit-yes" data-id="${dto.id}"><i class="icon-white icon-ok"></i>同意</button>
								            	<button type="button" class="btn btn-danger jq-audit-no" data-id="${dto.id}"><i class="icon-white icon-remove"></i>拒绝</button>
								            </td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="11" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
		 </form>
		 
	  </div>
      <div id="show"></div>
      <script type="text/javascript">
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		$("button.jq-audit-yes").click(function(){
	    			var _this = this;
	    			
					var id = $(this).data("id");
			    	var dialog = new Overlay.Dialog({
			    		closeAction: 'destroy', 
						title:'同意存款',
						width:500,
						height:500,
						loader : {
							url : '/alone/deposit/audit/show',
				            params : {"id": id},//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var id = $("#depositForm input:hidden[name=id]").val();
		                	var remark = $("#depositForm textarea[name=remark]").val();
		                	var status = 2;
							fnAudit(_this, id, status, remark);
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
			    });
	    		
	    		$("button.jq-audit-no").click(function(){
	    			var _this = this;
	    			
					var id = $(this).data("id");
			    	var dialog = new Overlay.Dialog({
			    		closeAction: 'destroy', 
						title:'拒绝存款',
						width:500,
						height:500,
						loader : {
							url : '/alone/deposit/audit/show',
				            params : {"id": id},//附加的参数
				            autoLoad : false, //不自动加载
				            lazyLoad : false, //不延迟加载
				            mask: false
						},
						success: function(){
							var id = $("#depositForm input:hidden[name=id]").val();
		                	var remark = $("#depositForm textarea[name=remark]").val();
		                	var status = 3;
							fnAudit(_this, id, status, remark);
						}
					});
			    	
			    	dialog.show();
			    	dialog.get('loader').load();
			    });
			});  
	    });
	    
	    
	    fnAudit = function(_this, id, status, remark){
			if($(_this).data('isLock')){return;};
			$(_this).data('isLock', 1);
			setTimeout(function(){
				$(_this).data('isLock', 0);
			}, 3000);
	    	
	    	var url = "/alone/deposit/audit";
	    	var data = {"id" : id, "status" : status, "remark" : remark};
	    	$.post(url, data, function(result){
	    		if(result == "1"){
					BUI.Message.Alert('操作成功','success');
					window.location.href = "/alone/deposit/list";
	    		}else{
	    			BUI.Message.Alert('操作失败，请稍后再试','error');
	    		}
	    	}, "json")
	    }
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>