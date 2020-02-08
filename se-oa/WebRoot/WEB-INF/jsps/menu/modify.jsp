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
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
		      <div class="panel-header">
	        	<strong>编辑</strong>
		      </div>
	
			  <form id="objForm">
			  		<input type="hidden" name="id" id="id" value="${menu.id}"/>
				  	<input type="hidden" name="parentId" value="${menu.parentId}"/>
				  	
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">名称：</td>
					        <td><input type="text" name="name" value="${menu.name}" /></td>
					    </tr>
					    <tr>
					        <td class="tableleft">编号（唯一）：</td>
					        <td><input type="text" name="code" value="${menu.code}" id="code"/></td>
					    </tr>
					    <c:if test="${menu.parentId ne '0' }">
						    <tr>
						        <td class="tableleft">跳转链接（URL）：</td>
						        <td><input type="text" name="url" value="${menu.url}"/></td>
						    </tr>
					    </c:if>
					    <c:if test="${menu.parentId eq '0'}">
						    <tr>
						        <td class="tableleft">样式：</td>
						        <td><input type="text" name="cssName" value="${menu.cssName}"/></td>
						    </tr>
					    </c:if>
					    <c:if test="${menu.parentId ne '0' }">
						    <tr>
						        <td class="tableleft">排序级别：</td>
						        <td><input type="text" name="sort" value="${menu.sort}"/></td>
						    </tr>
					    </c:if>
					    <c:choose>
					    	<c:when test="${menu.parentId eq '0' }">
					    		<tr>
							        <td class="tableleft">主排序级别：</td>
							        <td><input type="text" name="level" value="${menu.level}" /></td>
							    </tr>
					    	</c:when>
					    	<c:otherwise>
					    		<input type="hidden" name="level" value="${menu.level }"/>
					    	</c:otherwise>
					    </c:choose>
					    <tr>
                            <td class="tableleft">显示状态：</td>
                            <td>
                               <input type="radio" name="showFlag" value="1" <c:if test="${menu.showFlag == 1}">checked</c:if>/> 显示 
                               &nbsp;&nbsp;
                               <input type="radio" name="showFlag" value="2" <c:if test="${menu.showFlag == 2}">checked</c:if>/> 隐藏
                            </td>
                        </tr>
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
	 				name: {required:true, maxlength:30},
	 				code: {
	 					required:true, maxlength:30,
	 					remote:{
		 		               type:"GET",
		 		               url:"${ctx}/sysmenu/validateCode?id=" + $("#id").val(),
		 		               data:{code:function(){
		 		            	   return $("#code").val();
		 		               }
		 		            }
		 		        }
	 				},
	 				level: {required:true, maxlength:2, digits: true},
	 				sort: {maxlength:2, digits: true},
	 				url: {maxlength:100},
	 				cssName: {maxlength:20}
	 			},messages:{
	 				name: {
	 					required: "名称为必填项",
	 					maxlength:"名称不能超过30个字符"
	 				},code: {
	 					required: "编号为必填项",
	 					maxlength:"编号不能超过30个字符",
	 					remote:"编号已存在"
	 				},url: {
	 					maxlength:"跳转链接不能超过100个字符"
	 				},level: {
	 					required: "主排序级别为必填项",
	 					maxlength:"主排序级别不能超过2个字符",
	 					digits:"主排序级别只能是数字"
	 				},sort: {
	 					maxlength:"排序级别不能超过2个字符",
	 					digits:"排序级别只能是数字"
	 				},cssName: {
	 					maxlength:"样式不能超过20个字符"
	 				}
	 			}
	 		});
	    	
	    	bindClick("modify", "${ctx}/sysmenu/modify");
	    	bindSkipClick("backId", "${ctx}/sysmenu/list");
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
