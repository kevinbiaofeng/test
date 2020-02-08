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
			        	<strong>新增角色</strong>
			      </div>
		
				  <form id="objForm">
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">角色名称：</td>
					        <td><input type="text" name="name" id="name"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">角色编号：</td>
					        <td><input type="text" name="code" id="code"/></td>
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
	 				name: {
	 					required:true,maxlength:10
	    			},
	 				code: {
	 					required:true,maxlength:10,
	 					remote:{
		 		               type:"GET",
		 		               url:"${ctx}/sysrole/validateCode",
		 		               data:{code:function(){
		 		            	   return $("#code").val();
		 		            	}
		 		            }
		 		        }
	 				},
	 				remark: {maxlength:130}
	 			},messages:{
	 				name: {
	 					required: "角色名称为必填项",
	 					maxlength:"角色名称不能超过10个字符"
	 				},code: {
	 					required: "角色编号为必填项",
	 					maxlength:"角色编号不能超过15个字符",
	 					remote:"角色编号已存在"
	 				},remark: {
	 					maxlength:"说明不能超过130个字符"
	 				}
	 			}
	 		});
	    	bindSkipClick("backId", "${ctx}/sysrole/list");
	    	bindClick("save", "${ctx}/sysrole/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
