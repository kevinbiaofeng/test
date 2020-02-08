<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>提款限额</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<div class="well">
			<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增设置</button>
		</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>提款限额列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>会员账号</th>
					        <th>单笔提款上限</th>
					        <th>每天提款上限</th>
					        <th>修改时间</th>
					        <th>备注</th>
					        <th>操作人</th>
					        <th>操作</th>
					    </tr>
				    </thead>
	    			<c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td>${dto.userId }</td>
								            <td>${dto.oneUp }</td>
								            <td>${dto.dayUp }</td>
								            <td><fmt:formatDate value="${dto.updateTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td title="${dto.remark }"><xjw:subStringTag input="${dto.remark }" replace="......" size="10"/></td>
								            <td>${dto.updateUser }</td>
								            <td>
								            	<input type="hidden" name="ck" value="${dto.id }"/>
								            	<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
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
		 
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/withdraw/limit/skipAdd");
	    });
	    
	    $(".modify-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/withdraw/limit/skipEdit?id=" + id;
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>