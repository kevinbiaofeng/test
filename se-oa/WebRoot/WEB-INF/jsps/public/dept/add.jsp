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
	        	<strong>新增机构</strong>
		      </div>
		
			  <form id="objForm">
				  	<input type="hidden" name="parentId" id="parentId" value="${parentId}"/>
					<table class="table table-bordered definewidth">
						<c:if test="${name ne 'undefined'}">
							<tr>
						        <td width="10%" class="tableleft">上级机构名称：</td>
						        <td style="color: blue;">${name }</td>
						    </tr>
						</c:if>
						<tr>
					        <td width="10%" class="tableleft">机构：</td>
					        <td>
					        	<xjw:selectBarByDB name="deptType" code="SYS_USER_TYPE" id="deptType" myClass="" type="select" value="" exclude="${deptCodes }"></xjw:selectBarByDB>
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">机构名称：</td>
					        <td><input type="text" name="name" readonly="readonly"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">机构代码：</td>
					        <td><input type="text" name="code" id="code" readonly="readonly"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">说明：</td>
					        <td>
					        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5"></textarea>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button class="button button-primary" type="button" id="save">保存</button>
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
	 				name: {required:true, maxlength:10},
	 				code: {
	 					required:true, maxlength:15,
	 					remote:{
		 		               type:"GET",
		 		               url:"${ctx}/sysdept/validateCode",
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
	    	bindTreeClick("save", "${ctx}/sysdept/save");
	    	bindSkipClick("backId", "${ctx}/sysdept/skipModify?id=" + $("#parentId").val());
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
