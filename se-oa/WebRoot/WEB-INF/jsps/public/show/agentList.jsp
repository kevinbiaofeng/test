<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<style>
<!--
form {
	color: black;
}
-->
</style>
<form id="ccForm" action="${ctx}/showPanel/agentList" method="post">
	<input type="hidden" value="${showPanelForm.k }" name="k">
	<table class="table table-bordered">
		<tr>
			<td width="15%">关键字：</td>
			<td width="10%"><input type="text" placeholder="请输入代理账号" name="keywords" id="keywords" value="${showPanelForm.keywords }"/></td>
			<td>
				<button id="searchBut" type="button" class="btn btn-primary" onclick="ajaxCommonPageFormSubmit('ccForm', 0)"><i class="icon-white icon-search"></i>搜索</button>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>
	
  	<div class="doc-content">
    	<div class="panel">
	      <div class="panel-header">
	        	&nbsp;
	      </div>
	        	
          <table class="table table-bordered table-hover definewidth">
			    <thead>
				    <tr>
				    	<th width="20px"><c:if test="${showPanelForm.k eq 'c'}"><input type="checkbox" id="allck"/></c:if></th>
				        <th>代理帐号</th>
				        <th>状态</th>
				        <th>创建时间</th>
				    </tr>
			    </thead>
		    	<c:choose>
		    		<c:when test="${not empty page.dataList }">
		    			<tbody>
			    			<c:forEach var="agent" items="${page.dataList }">
							    	<tr class="tr" data-id="${agent.id}" data-name="${agent.loginName}">
							    		<td width="20px">
							    			<c:choose>
							    				<c:when test="${showPanelForm.k eq 'r'}">
							    					<input type="radio" value="${agent.id }" name="ck" id=ck/>
							    				</c:when>
							    				<c:when test="${showPanelForm.k eq 'c'}">
							    					<input type="checkbox" value="${agent.id }" name="ck"/>
							    				</c:when>
							    			</c:choose>
							    		</td>
							            <td id="loginName">${agent.loginName }</td>
							            <td style="color: ${agent.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${agent.status }" /></td>
							            <td><fmt:formatDate value="${agent.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							        </tr>
					    	</c:forEach>
				    	</tbody>
		    		</c:when>
		    		<c:otherwise>
		    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
		    		</c:otherwise>
		    	</c:choose>
		      </table>
		      
		      <div class='bui-grid'><div class='bui-grid-bbar'>
	    		  <xjw:pageTag page="${page}" formId="ccForm" isAjax="1"></xjw:pageTag>
			  </div></div>
	 	</div>
	 </div>
 </form>
<script>
$(function () {
	$("#keywords").focus();
	
	//回车查询
	$("#ccForm").keydown(function(e){
		if(e.which == 13) { 
			$("#ccForm #searchBut").click();
			$(this).blur();
	      	}
	});
});
$(".tr").click(function(){
	$(this).find("input[name='ck']").attr("checked", true);
})

</script>