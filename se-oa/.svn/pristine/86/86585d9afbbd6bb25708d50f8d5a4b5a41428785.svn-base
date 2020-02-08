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
	<div class="pageContent">
		<form id="J_Form" action="${ctx}/sysrole/userList" method="post">
			<input type="hidden" name="roleId" id="roleId" value="${form.roleId }"/>
			<input type="hidden" name="deptId" id="deptId" value="${form.deptId }"/>
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
				<button type="button" class="btn btn-inverse" id="set"><i class="icon-white icon-ok"></i>批量设置角色</button>
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<div style="float: right;">
					<button type="button" class="btn btn-inverse" id="backId"><i class="icon-white icon-home"></i>返回列表</button>
				</div>
			</div>	
		</form>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>用户列表</strong>
			        
		      </div>
		        	
	        	<table class="table table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="20px"><input type="checkbox" id="allck"/></th>
					        <th>登录帐号</th>
<!-- 					        <th>用户编号</th> -->
<!-- 					        <th>用户类型</th> -->
					        <th>角色</th>
					        <th>状态</th>
					        <th>创建时间</th>
					        <th>最后登录时间</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty list }">
			    			<tbody>
				    			<c:forEach var="user" items="${list }">
								    	<tr>
								    		<th width="20px"><input type="checkbox" value="${user.id }" name="ck"/></th>
								            <td>${user.loginName }</td>
<%-- 								            <td>${user.code }</td> --%>
<%-- 								            <td><xjw:enumBar clazz="com.xjw.kzenum.sys.UserTypeEnum" code="${user.type }" /></td> --%>
								            <td style="color: blue">${user.roleNames }</td>
								            <td style="color: ${user.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${user.status }" /></td>
								            <td><fmt:formatDate value="${user.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${user.loginTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
			    		</c:when>
			    		<c:otherwise>
			    			<tr><td colspan="9" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
	    });
	    
	    $("#backId").click(function(){
	    	window.parent.back();
		});
	    
	    $('#set').click(function() {
	    	var ckValues =[];
    		$('input[name="ck"]:checked').each(function(){
    		  ckValues.push($(this).val());
    		});
    		if(ckValues.length == 0){
    			BUI.Message.Alert('请选择一个设置项！','warning');
    		}else{
    			BUI.Message.Show({
	   		   		 msg : '是否确认设置这些用户？',
	   		   		 icon : 'question',
	   		   		 buttons : [{
	   		   		 text:'是',
	   		   		 elCls : 'button button-primary',
	   		   		 handler : function(){
	   		   			 window.location.href = "${ctx}/sysrole/setUserAuth?ids=" + ckValues + "&roleId=" + $("#roleId").val() + "&deptId=" + $("#deptId").val();
	   		   			 this.close();
	   		   		 }},{
	   		   		 text:'否',
	   		   		 elCls : 'button',
	   		   		 handler : function(){
	   		   			 this.close();
	   		   		 }} ]
	   		   	});
    		}
		});
	  </script>
</body>
</html>