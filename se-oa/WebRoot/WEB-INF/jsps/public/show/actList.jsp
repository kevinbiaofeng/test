<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<style>
<!--
form {
	color: black;
}
-->
</style>
<form id="ccForm" action="${ctx}/showPanel/actList" method="post">
	<input type="hidden" value="${showPanelForm.k }" name="k">
	
	<table class="table table-bordered">
		<tr>
			<td width="15%">活动D ：</td>
			<td width="10%"><input type="text" placeholder="请输入活动ID" name="keywords" id="keywords" value="${showPanelForm.keywords }"/></td>
			<td>
				<button type="button" class="btn btn-primary" onclick="ajaxCommonPageFormSubmit('ccForm', 0)"><i class="icon-white icon-search"></i>搜索</button>
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
				    	<th>ID</th>
				        <th>活动名称	</th>
				        <th>活动类型</th>
				        <th>开始时间</th>
				        <th>结束时间</th>
				    </tr>
			    </thead>
		    	<c:choose>
		    		<c:when test="${not empty page.dataList }">
		    			<tbody>
			    			<c:forEach var="act" items="${page.dataList}">
							    	<tr class="tr" data-id="${act.id}" data-name="${act.name}">
							    		<td width="20px">
							    			<c:choose>
							    				<c:when test="${showPanelForm.k eq 'r'}">
							    					<input type="radio" value="${act.id}" name="ck" id=ck/>
							    				</c:when>
							    				<c:when test="${showPanelForm.k eq 'c'}">
							    					<input type="checkbox" value="${act.id }" name="ck"/>
							    				</c:when>
							    			</c:choose>
							    		</td>
							    		<td>${act.id}</td>
							            <td>${act.name}</td>
							            <td>
							    			<c:choose>
							            		<c:when test="${act.comeFrom eq '1' }">
							            			<font color="green">
							            			<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${act.comeFrom}"/>
							            			</font>
							            		</c:when>
							            		<c:when test="${act.comeFrom eq '2' }">
							            			<font color="red">
							            				<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${act.comeFrom}"/>
							            			</font>
							            		</c:when>
							            		<c:otherwise>
							            			<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${act.comeFrom}"/>
							            		</c:otherwise>
							            	</c:choose>
							    		</td>
							            <td><fmt:formatDate value="${act.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							            <td><fmt:formatDate value="${act.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
});
$(".tr").click(function(){
	$(this).find("input[name='ck']").attr("checked", true);
})
</script>