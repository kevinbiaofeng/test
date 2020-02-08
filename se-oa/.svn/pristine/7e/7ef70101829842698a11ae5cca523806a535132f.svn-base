<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>角色列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>


<body>
	
	<div class="pageContent">
		<form id="objForm" action="${ctx}/sysrole/list" method="post">
			<table class="table table-bordered definewidth" width="96%">
				<tr>
					<td class="tableleft">关键字：</td>
					<td colspan="3"><input type="text" name="keywords" value="${roleForm.keywords}" placeholder="角色名称、角色编号模糊查询"/></td>
				</tr>
			</table>
			<div class="well">
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增角色</button>
				<button type="button" class="btn btn-danger" id="delAll"><i class="icon-white icon-trash"></i>批量删除</button>
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>	
		
	
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>用户列表</strong>
				        
			      </div>
			        	
		        	<table class="table table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						    	<th width="20px"><input type="checkbox" id="allck"/></th>
						        <th>角色名称</th>
						        <th>角色编号</th>
						        <th>创建时间</th>
						        <th>状态</th>
						        <th width="430px">操作</th>
						    </tr>
					    </thead>
				    	<c:choose>
				    		<c:when test="${not empty list }">
				    			<tbody>
					    			<c:forEach var="role" items="${list }">
									    	<tr>
									    		<th width="20px"><input type="checkbox" value="${role.id }" name="ck"/></th>
									            <td>${role.name }</td>
									            <td>${role.code }</td>
									            <td><fmt:formatDate value="${role.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td style="color: ${role.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${role.status }" /></td>
									            <td>
													<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
													<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
													<button type="button" class="btn btn-success auth-but"><i class="icon-white icon-share"></i>设置角色功能</button>
													<button type="button" class="btn btn-success user-but"><i class="icon-white icon-share"></i>设置用户</button>
									            </td>
									        </tr>
							    	</c:forEach>
						    	</tbody>
				    		</c:when>
				    		<c:otherwise>
				    			<tr><td colspan="6" class="notdata"><spring:message code="page.text.notData" /></td></tr>
				    		</c:otherwise>
				    	</c:choose>
				      </table>
				      
				      <div class='bui-grid'><div class='bui-grid-bbar'>
				      <c:if test="${not empty list }">
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
			bindSkipClick("add", "${ctx}/sysrole/skipAdd");
			bindDelAllClick("delAll", "${ctx}/sysrole/del");
	    });
		    
		$(".del-but").click(function() {
			var ckValue = $(this).parent().parent().find("input[name='ck']").val();
			delRow(ckValue, "${ctx}/sysrole/del");
		});
		
		$(".modify-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/sysrole/skipModify?id=" + id;
		});
		
		$(".auth-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/sysrole/skipSetFunction?roleId=" + id;
		});
		
		$(".user-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/sysrole/skipSetUserAuthIndex?roleId=" + id;
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>