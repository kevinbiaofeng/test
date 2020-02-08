<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<style>
<!--
form {
	color: black;
}
-->
</style>
<form id="ccForm" action="${ctx}/showPanel/withdrawalList" method="post">
	<input type="hidden" value="${showPanelForm.k }" name="k">
	<input type="hidden" value="${showPanelForm.otherInput }" name="otherInput">
	<table class="table table-bordered">
		<tr>
			<td width="15%">关键字：</td>
			<td width="10%"><input type="text" placeholder="用户名模糊查询" name="keywords" id="keywords" value="${showPanelForm.keywords }" style="width: 180px;"/></td>
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
				        <th>提款编号</th>
				        <th>会员账号</th>
				        <th>提款人姓名</th>
				        <th>提款账号</th>
				        <th>提款金额</th>
				        <th>提交时间</th>
				        <th>结果</th>
				    </tr>
			    </thead>
		    	<c:choose>
		    		<c:when test="${not empty page.dataList }">
		    			<tbody>
			    			<c:forEach var="dto" items="${page.dataList }">
							    	<tr class="tr" data-id="${dto.id}" data-name="${dto.orderNo}">
							    		<td width="20px">
							    			<c:choose>
							    				<c:when test="${showPanelForm.k eq 'r'}">
							    					<input type="radio" value="${user.id }" name="ck" id=ck/>
							    				</c:when>
							    				<c:when test="${showPanelForm.k eq 'c'}">
							    					<input type="checkbox" value="${user.id }" name="ck"/>
							    				</c:when>
							    			</c:choose>
							    		</td>
							            <td title="${dto.remark }"><div style="border: 1;color: <c:if test="${not empty dto.remark }">#e22d3e</c:if>">${dto.orderNo }</div></td>
								    		<td>${dto.loginName }</td>
								            <td>${dto.toBankAccount}</td>
								            <td>${dto.toBankCard}</td>
								            <td>
						            			<fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/>
								            </td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.status eq '2'}">
								            			<font color="green">成功</font>
								            		</c:when>
								            		<c:otherwise>
								            			<font color="red">失败</font>
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