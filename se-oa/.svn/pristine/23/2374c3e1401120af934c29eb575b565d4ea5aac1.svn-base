<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录日志列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>


<body>
	
	<div class="pageContent">
		<form id="objForm" action="${ctx}/syslog/listUsrloginLog" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">关键字：</td>
					<td colspan="3"><input type="text" name="keywords" value="${logForm.keywords}" placeholder="用户名称模糊查询"/></td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-danger" id="delAll"><i class="icon-white icon-trash"></i>批量删除</button>
			</div>	
		
	
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>登录日志列表</strong>
				        
			      </div>
			        	
		        	<table class="table table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						    	<th width="20px"><input type="checkbox" id="allck"/></th>
						        <th>登录名称</th>
						        <th>登录时间</th>
						        <th>登录IP地址</th>
						        <th width="430px">操作</th>
						    </tr>
					    </thead>
				    	<c:choose>
				    		<c:when test="${not empty page.dataList }">
				    			<tbody>
					    			<c:forEach var="log" items="${page.dataList }">
									    	<tr>
									    		<th width="20px"><input type="checkbox" value="${log.id }" name="ck"/></th>
									            <td>${log.loginName }</td>
									            <td><fmt:formatDate value="${log.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td>${log.ipAddress }</td>
									            <td>
									            	<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
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
				      
				      <div class='bui-grid'><div class='bui-grid-bbar'>
				      <c:if test="${not empty page.dataList }">
		   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
					  </c:if>
					  </div></div>
				      
			 	</div>
			 </div>	
			 
			 
		 </form>
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindDelAllClick("delAll", "${ctx}/syslog/delUserLoginLog");
	    });
		    
		$(".del-but").click(function() {
			var ckValue = $(this).parent().parent().find("input[name='ck']").val();
			delRow(ckValue, "${ctx}/syslog/delUserLoginLog");
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>