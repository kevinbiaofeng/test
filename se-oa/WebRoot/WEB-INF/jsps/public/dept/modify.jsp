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
			<c:if test="${not empty id}">
				<div class="well">
					<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增机构</button>
					<c:if test="${id ne '0' }">
        				<button type="button" class="btn btn-danger" id="del"><i class="icon-white icon-trash"></i>删除机构</button>
        			</c:if>
				</div>
			</c:if>
			
			<form id="objForm">
				<input type="hidden" name="id" id="id" value="${id}"/>
				<c:if test="${not empty dept}">
			    	<div class="panel">
				        <div class="panel-header">
			        		<strong>编辑机构</strong>
				        </div>
						<table class="table table-bordered definewidth">
							<tr>
						        <td width="10%" class="tableleft">上级机构：</td>
						        <td><select id="tree" name="parentId" class="easyui-combotree" style="width:156px;"/></td>
						    </tr>
						    <tr>
						        <td width="10%" class="tableleft">机构：</td>
						        <td>
						        	<xjw:selectBarByDB name="deptType" code="SYS_USER_TYPE" id="deptType" myClass="" type="select" value="" exclude="${deptCodes }"></xjw:selectBarByDB>
						        </td>
						    </tr>
						    <tr>
						        <td width="10%" class="tableleft">机构名称：</td>
						        <td><input type="text" name="name" id="name" value="${dept.name}" readonly="readonly"/></td>
						    </tr>
						    <tr>
						        <td class="tableleft">机构编号：</td>
						        <td><input type="text" name="code" value="${dept.code}" id="code" readonly="readonly"/></td>
						    </tr>
						    <tr>
						        <td class="tableleft">说明：</td>
						        <td>
						        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5">${dept.remark}</textarea>
						        </td>
						    </tr>
						    <tr>
						        <td class="tableleft"></td>
						        <td>
						        	<button class="button button-primary" type="button" id="modify">保存</button>
						        </td>
						    </tr>
						</table>
							   
					  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
				 	</div>
		 	 </c:if>
	 	  </form>
	 </div>	
	</div>      
    <script>
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	$("#objForm").validate({
	 			rules: {
	 				name: {required:true, maxlength:10},
	 				code: {
	 					required:true, maxlength:15,
	 					remote:{
		 		               type:"GET",
		 		               url:"${ctx}/sysdept/validateCode?id=" + $("#id").val(),
		 		               data:{code:function(){
		 		            	   return $("#code").val();
		 		               }
		 		            }
		 		        }
	 				},
	 				remark: {maxlength:130}
	 			},messages:{
	 				name: {
	 					required: "机构名称为必填项",
	 					maxlength:"机构名称不能超过10个字符"
	 				},code: {
	 					required: "机构编号为必填项",
	 					maxlength:"机构编号不能超过15个字符",
	 					remote:"机构编号已存在"
	 				},remark: {
	 					maxlength:"说明不能超过130个字符"
	 				}
	 			}
	 		});
	    	bindTreeClick("modify", "${ctx}/sysdept/modify");
	    	bindSkipClick("add", "${ctx}/sysdept/skipAdd?id=" + $("#id").val() + "&name=" + $("#name").val());
	    	bindTreeDelClick("del", "${ctx}/sysdept/del");
	    	$("#tree").combotree({
	            url: "${ctx }/sysdept/getTree",
	            method: "get",
	            onLoadSuccess: function () {
	            	$("#tree").combotree("setValue", "${dept.parentId}");
	            }
		    });
	    });
	    $("#deptType").change(function(){
	    	if($(this).val() != ""){
	    		$("input[name='name']").val($(this).find("option:selected").text());
		    	$("input[name='code']").val($(this).val());
	    	}else{
	    		$("input[name='name']").val("");
	    		$("input[name='code']").val("");
	    	}
    	});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-tree-click-js.jsp"%>
</body>
</html>
