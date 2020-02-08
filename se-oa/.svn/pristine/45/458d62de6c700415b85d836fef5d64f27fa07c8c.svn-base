<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>编辑</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<c:set var="showText" />
	<c:choose>
		<c:when test="${userDept eq 'agents'}">
			<c:set var="showText" value="代理"/>
		</c:when>
		<c:when test="${userDept eq 'customer'}">
			<c:set var="showText" value="客户"/>
		</c:when>
		<c:otherwise>
			<c:set var="showText" value="用户"/>
		</c:otherwise>
	</c:choose>
	<div class="pageContent">
		<div class="doc-content m10">
<!-- 			<ul class="nav-tabs"> -->
<!-- 				<li style="margin-left:-40px;" class="active" onclick="changeTab('userinfo')" id="userinfo"><a href="#" style="">用户信息</a></li> -->
<!-- 				<li onclick="changeTab('bankinfo')" id="bankinfo"><a href="#">银行卡信息</a></li> -->
<!-- 			</ul> -->
	    	<div class="panel">
		      <div class="panel-header">
	        	<strong>&nbsp;</strong>
		      </div>
			 
			  <form id="objForm">
			  <!----------------------------- 用户信息------------------------ -->
			  <div id="userinfoPanel">
					  	<input type="hidden" name="id" value="${user.id }"/>
					  	<input type="hidden" id="deptId" name="oldDeptId" value="${deptId }"/>
					  	<input type="hidden" name="userDept" id="userDept" value="${userDept }"/>
						<table class="table table-bordered definewidth">
							<c:choose>
								<c:when test="${empty userDept }">
									<tr>
								        <td width="10%" class="tableleft">机构：</td>
								        <td><select id="tree" name="deptId" class="easyui-combotree" style="width:156px;"/></td>
								    </tr>
							    </c:when>
							    <c:otherwise>
							    	<input type="hidden" name="deptId" value="${deptId }"/>
							    </c:otherwise>
							</c:choose>
						    <tr>
						        <td width="10%" class="tableleft">登录名：</td>
						        <td>${user.loginName }</td>
						    </tr>
						    <tr>
						        <td class="tableleft">密码：</td>
						        <td><input type="password" name="pwd" value="${user.pwd }" /></td>
						    </tr>
<!-- 						    <tr> -->
<!-- 						        <td class="tableleft">用户名：</td> -->
<%-- 						        <td><input type="text" name="userName" value="${user.userName }" /></td> --%>
<!-- 						    </tr> -->
							 
							<c:if test="${deptId == 65 }">
								<tr>
									<td class="tableleft">代理用户</td>
									<td>
										<select name="agentId" id="agentId" multiple="multiple" style="height: 280px;">
											<option value="0">--请选择--</option>
											<c:forEach var="dto" items="${agent}">
											 	<c:if test="${dto.id == dto.agentId}">
													<option value="${dto.id }" selected>${dto.loginName }</option>
												</c:if>
												<c:if test="${dto.id != dto.agentId}">
													<option value="${dto.id }" >${dto.loginName }</option>
												</c:if> 
											</c:forEach>
										</select>
									</td>
								</tr>
							</c:if> 
							
						    <tr>
						        <td class="tableleft">状态：</td>
						        <td>
						        	<xjw:selectBar name="status" clazz="com.xjw.kzenum.sys.StatusEnum" 
							           myClass="" type="radio" value="${user.status }" id="status" exclude="3"></xjw:selectBar>
						        </td>
						    </tr>
<%-- 						    <c:choose> --%>
<%-- 						    	<c:when test="${sessionScope.user.type eq '1'}"> --%>
<!-- 							    	<tr> -->
<!-- 								        <td class="tableleft">是否管理员：</td> -->
<!-- 								        <td> -->
<%-- 								        	<xjw:selectBar name="type" clazz="com.xjw.kzenum.sys.YesORNoEnum"  --%>
<%-- 									           myClass="" type="radio" value="${user.type eq '1' ? '1' : '2' }" id="type"></xjw:selectBar> --%>
<!-- 								        </td> -->
<!-- 								    </tr> -->
<%-- 						    	</c:when> --%>
<%-- 						    	<c:otherwise> --%>
<!-- 						    		<input type="hidden" name="type" value="2"/> -->
<%-- 						    	</c:otherwise> --%>
<%-- 						    </c:choose> --%>
						</table>
				</div>
				<!----------------------------- 用户信息------------------------ -->
<!-- 				--------------------------- 银行卡信息------------------------ -->
<!-- 				<div id="bankinfoPanel" style="display: none;"> -->
<!-- 					<table class="table table-bordered definewidth"> -->
<!-- 						<tr> -->
<!-- 					        <td width="10%" class="tableleft">登录名：</td> -->
<%-- 					        <td>${user.loginName }</td> --%>
<!-- 					        <td class="tableleft">密码：</td> -->
<%-- 					        <td><input type="password" name="pwd" value="${user.pwd }" /></td> --%>
<!-- 					    </tr> -->
<!-- 					    <tr> -->
<!-- 					        <td class="tableleft">select：</td> -->
<!-- 					        <td> -->
<!-- 					        	<select> -->
<!-- 					        		<option value="">请选择</option> -->
<!-- 					        		<option value="1">sssfd</option> -->
<!-- 					        		<option value="2">sadfsdf</option> -->
<!-- 					        	</select> -->
<!-- 					        </td> -->
<!-- 					        <td colspan="2"> -->
<!-- 					        	<button type="button" class="modify-but"> -->
<!-- 									添加 -->
<!-- 								</button> -->
<!-- 					        </td> -->
<!-- 					    </tr> -->
<!-- 					</table> -->
					
<!-- 					<table class="table definewidth"> -->
<!-- 						<thead> -->
<!-- 						    <tr> -->
<!-- 						    	<th>test1</th> -->
<!-- 						        <th>test2</th> -->
<!-- 						        <th>test3</th> -->
<!-- 						        <th>操作</th> -->
<!-- 						    </tr> -->
<!-- 					    </thead> -->
<!-- 					    <tbody> -->
<!-- 					    	<tr> -->
<!-- 						    	<td><input name="1212" name="bankCardNo" type="text" value="1" style="border:0px"/></td> -->
<!-- 					            <td><input name="1212" name="bankType" type="text" value="1" style="border:0px"/></td> -->
					            
<!-- 						    </tr> -->
<!-- 						    <tr> -->
<!-- 						    	<td><input name="1212" name="bankCardNo" type="text" value="1" style="border:0px"/></td> -->
<!-- 					            <td><input name="1212" name="bankType" type="text" value="1" style="border:0px"/></td> -->
<!-- 						    </tr> -->
<!-- 					    </tbody> -->
<!-- 					</table> -->
<!-- 				</div> -->
				<!----------------------------- 银行卡信息------------------------ -->
				
				<table class="table table-bordered definewidth">
					<tr>
				        <td class="tableleft"></td>
				        <td>
				            <button type="button" class="button button-primary" id="modify">保存</button> 
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
	 				pwd: {required:true, maxlength:50, minlength:6}
	 			},messages:{
	 				pwd: {
	 					required: "密码为必填项",
	 					minlength:"密码不能少于6个字符",
	 					maxlength:"密码不能超过50个字符"
	 				}
	 			}
	 		});
	    	
	    	bindClick("modify", "${ctx}/sysuser/modify");
	    	bindSkipClick("backId", "${ctx}/sysuser/list?deptId=" + $("#deptId").val() + "&userDept=" + $("#userDept").val());
	    });
	    
	    $("#tree").combotree({
            url: "${ctx }/sysdept/getTree",
            method: "get",
            onLoadSuccess: function () {
            	$("#tree").combotree("setValue", "${deptId}");
            }
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
