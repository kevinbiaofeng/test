<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>新增用户</strong>
			      </div>
		
				  <form id="objForm">
				  	<input type="hidden" name="deptId" id="deptId" value="${deptId }"/>
				  	<input type="hidden" name="userDept" id="userDept" value="${userDept }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">登录名：</td>
					        <td><input type="text" name="loginName" id="loginName"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">密码：</td>
					        <td><input type="password" name="pwd" /></td>
					    </tr>
<!-- 					    <tr> -->
<!-- 					        <td class="tableleft">用户名：</td> -->
<!-- 					        <td><input type="text" name="userName" /></td> -->
<!-- 					    </tr> -->
						<!-- deptId == 65 表示销售部 -->
						<c:if test="${deptId == 65 }">
						<tr>
							<td class="tableleft">代理用户</td>
							<td>
								<select name="agentId" id="agentId" multiple="multiple" style="height: 280px;">
									<option>--请选择--</option>
									<c:forEach var="dto" items="${agent}">
										<option value="${dto.id }" >${dto.loginName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						</c:if>
					    <tr>
					        <td class="tableleft">状态：</td>
					        <td>
					        	<xjw:selectBar name="status" clazz="com.xjw.kzenum.sys.StatusEnum" 
					           myClass="" type="radio" value="1" id="status" exclude="3"></xjw:selectBar>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button type="button" class="button button-primary" id="save">保存</button> 
					            &nbsp;&nbsp;
					            <button type="button" class="button" id="backId">返回列表</button>
					        </td>
					    </tr>
					</table>
			    </form>
			  
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	  </div>
      
      <script>
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	$("#objForm").validate({
	 			rules: {
	 				loginName: {
	 					required:true, maxlength:12, minlength:6,
	 					remote:{
	 		               type:"GET",
	 		               url:"${ctx}/sysuser/validateLoginName",
	 		               data:{loginName:function(){
	 		            	   return $("#loginName").val();
	 		               }}
	 		            }
	 				},
	 				pwd: {required:true, maxlength:25, minlength:6}
	 			},messages:{
	 				loginName: {
	 					required: "登录名为必填项",
	 					minlength:"登录名不能少于6个字符",
	 					maxlength:"登录名不能超过12个字符",
	 					remote:"该用户名已被注册"
	 				},pwd: {
	 					required: "密码为必填项",
	 					minlength:"密码不能少于6个字符",
	 					maxlength:"密码不能超过25个字符"
	 				}
	 			}
 			});
	    	
	    	bindSkipClick("backId", "${ctx}/sysuser/list?deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val());
	    	bindClick("save", "${ctx}/sysuser/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
