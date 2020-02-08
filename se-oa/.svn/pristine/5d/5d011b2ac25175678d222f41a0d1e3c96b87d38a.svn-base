<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<c:set var="showText" />
	<c:choose>
		<c:when test="${form.userDept eq 'agents'}">
			<c:set var="showText" value="代理"/>
		</c:when>
		<c:when test="${form.userDept eq 'customer'}">
			<c:set var="showText" value="客户"/>
		</c:when>
		<c:otherwise>
			<c:set var="showText" value="用户"/>
		</c:otherwise>
	</c:choose>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/sysuser/list" method="post">
			<input type="hidden" name="deptId" id="deptId" value="${form.deptId }"/>
			<input type="hidden" name="userDept" id="userDept" value="${form.userDept}"/>
			<table class="table table-bordered definewidth" width="96%">
				<tr>
					<td class="tableleft">关键字：</td>
					<td><input type="text" placeholder="登录帐户、用户名模糊查询" name="keywords" value="${form.keywords }"/></td>
					<td class="tableleft">状态：</td>
					<td>
						<xjw:selectBar name="status" clazz="com.xjw.kzenum.sys.StatusEnum" 
					           myClass="" type="select" value="${form.status }" id="status" exclude="3"></xjw:selectBar>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增${showText }</button>
				<button type="button" class="btn btn-danger" id="delAll"><i class="icon-white icon-trash"></i>批量删除</button>
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>	
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>${showText }列表</strong>
		      </div>
		        	
	        	<table class="table table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="20px"><input type="checkbox" id="allck"/></th>
<!-- 					        <th>用户名</th> -->
					        <th>登录帐号</th>
<!-- 					        <th>用户编号</th> -->
<!-- 					        <th>用户类型</th> -->
					        <th>角色</th>
					        <th>状态</th>
					        <th>创建时间</th>
					        <th>最后登录时间</th>
					        <th>操作</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty list }">
			    			<tbody>
				    			<c:forEach var="user" items="${list }">
								    	<tr>
								    		<td width="20px"><input type="checkbox" value="${user.id }" name="ck"/></td>
<%-- 								            <td>${user.userName }</td> --%>
								            <td>${user.loginName }</td>
<%-- 								            <td>${user.code }</td> --%>
<%-- 								            <td><xjw:enumBar clazz="com.xjw.kzenum.sys.UserTypeEnum" code="${user.type }" /></td> --%>
								            <td style="color: blue;">${user.roleNames }</td>
								            <td style="color: ${user.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${user.status }" /></td>
								            <td><fmt:formatDate value="${user.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${user.loginTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
												<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
												<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
												<c:if test="${form.deptCode eq 'KH'}">
													<button type="button" class="user-bank">
														<i class="icon-share"></i>
														设置银行卡
													</button>
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
			bindSkipClick("add", "${ctx}/sysuser/skipAdd?deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val());
			bindDelAllClick("delAll", "${ctx}/sysuser/del", "&deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val());
	    });
		
		$(".del-but").click(function() {
			var ckValue = $(this).parent().parent().find("input[name='ck']").val();
			delRow(ckValue, "${ctx}/sysuser/del", "&deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val());
		});
		
		$(".modify-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/sysuser/skipModify?id=" + id + "&deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val();
		});
		
		$(".user-bank").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			//window.location.href = "${ctx}/user/bankinfo/skipSetBankInfo?id=" + id + "&deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val();
			window.location.href = "${ctx}/user/bankinfo/list?userId=" + id + "&deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val();
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>