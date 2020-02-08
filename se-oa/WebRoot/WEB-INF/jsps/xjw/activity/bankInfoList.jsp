<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>银行卡信息列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/bank/info/list" method="post">
			<input type="hidden" name="type" id="type" value="${from.type }"/>
			<table class="table table-bordered" width="96%">
				<tr>
					<td class="tableleft">银行类型：</td>
					<td>
						<xjw:selectBarByDB name="bankType" code="USER_BANK_TYPE" myClass="" type="select" value="${from.bankType }"/>
					</td>
					<td class="tableleft">状态：</td>
					<td>
						<xjw:selectBar name="status" clazz="com.xjw.kzenum.activity.UserBankInfoStatusEnum" myClass="" type="select" value="${from.status }" id="status" exclude="3"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增银行卡</button>
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>银行卡信息列表</strong>
			      </div>
			        	
		          <table class="table list table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						        <th>银行类型</th>
						        <th>账户名</th>
						        <th>银行卡号</th>
						        <th>银行地址</th>
						        <th>状态</th>
						        <th width="300px">操作</th>
						    </tr>
					    </thead>
		    			<c:choose>
						    <c:when test="${not empty page.dataList }">
				    			<tbody>
				    				<c:forEach var="dto" items="${page.dataList }">
									    	<tr>
									    		<td><xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.bankType}"/></td>
									    		<td>
									            	${dto.accountName}
									            </td>
									            <td>
									            	${dto.bankCardNo}
									            </td>
									            <td title="${dto.bankAddress }">
									            	<xjw:subStringTag input="${dto.bankAddress }" replace="......" size="10"/>
									            </td>
									            <td style="color: ${dto.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.activity.UserBankInfoStatusEnum" code="${dto.status }" /></td>
									            <td>
									            	<input type="hidden" name="ck" value="${dto.id }"/>
									            	<c:if test="${dto.status eq '1' }">
								            			<button type="button" class="btn btn-danger stop-but"><i class="icon-white icon-stop"></i>禁用</button>
									            	</c:if>
									            	
									            	<c:if test="${dto.status eq '2' }">
								            			<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>启用</button>
									            	</c:if>
									            	
									            	<c:if test="${dto.status eq '2' }">
							            				<button class="btn btn-danger remove-but" type="button"><i class="icon-white icon-remove-sign"></i>删除</button>
							            			</c:if>
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
			bindSkipClick("add", "${ctx}/bank/info/skipAdd?type=${from.type}");
	    });
	    
	    $(".start-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			var type = $("#type").val();
			BUI.Message.Show({
				 msg : '是否确认启用此银行卡？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/bank/info/start?id=" + id + "&type=" + type;
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
	    	var type = $("#type").val();
			BUI.Message.Show({
				 msg : '是否确认禁用此银行卡？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/bank/info/stop?id=" + id + "&type=" + type;
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	    
	    $(".remove-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
	    	var type = $("#type").val();
			BUI.Message.Show({
				 msg : '是否确定删除该银行卡？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/bank/info/delById?id=" + id + "&type=" + type;
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