<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<style>
<!--
form {
	color: black;
}
-->
</style>
	
<div class="doc-content">
   	<div class="panel">
        	
         <table class="table table-bordered table-hover definewidth">
		    <thead>
			    <tr>
			    	<th width="20px"><c:if test="${showPanelForm.k eq 'c'}"><input type="checkbox" id="allck"/></c:if></th>
			        <th width="15%">部门名称</th>
			    </tr>
		    </thead>
	    	<c:choose>
	    		<c:when test="${not empty page.dataList }">
	    			<tbody>
		    			<c:forEach var="dept" items="${page.dataList }">
						    	<tr class="tr">
						    		<td width="20px">
						    			<c:choose>
						    				<c:when test="${showPanelForm.k eq 'r'}">
						    					<input type="radio" value="${dept.id }" name="ck"/>
						    				</c:when>
						    				<c:when test="${showPanelForm.k eq 'c'}">
						    					<input type="checkbox" value="${dept.id }" name="ck"/>
						    				</c:when>
						    			</c:choose>
						    		</td>
						            <td id="loginName">${dept.name }</td>
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
</div>
<script>
$(function () {
	$("#keywords").focus();
});
$(".tr").click(function(){
	$(this).find("input[name='ck']").attr("checked", true);
})
</script>