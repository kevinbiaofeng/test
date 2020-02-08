<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	<link rel="stylesheet" type="text/css" href="${statics }/css/jquery-ui-1.8.17.custom.css" />
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery-ui-1.8.17.custom.min.js"></script>
	
	<style>
        body {
            font-size: 14px;
        }
        fieldset {
            width: 388px;
            margin: 0 auto;
            text-align: right;
        }
        fieldset div {
            margin: 15px auto;
        }
        .cbo .ui-button-text {
            line-height: 1.3;
            padding-top: 0;
            padding-bottom: 0;
        }
        .cbo .ui-autocomplete-input {
            width: 7.2em;
        }
    </style>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>
			        		<c:choose>
			        			<c:when test="${op eq 'add' }">
			        				新增
			        			</c:when>
			        			<c:when test="${op eq 'edit' }">
			        				编辑
			        			</c:when>
			        		</c:choose>
			        	</strong>
			      </div>
		
				  <form id="objForm">
				  	<input name="id" type="hidden" value="${dto.id }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">会员账号：</td>
					        <td>
					        	<input type="hidden" name="userId" value="${dto.userId }"/>
					        	<input type="text" name="keywords" id="keywords" value="${dto.userId }"/>
<!-- 					        	<input type="checkbox"/>所有会员 -->
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">单笔提款上限：</td>
					        <td><input type="text" name="oneUp" value="${dto.oneUp }"/></td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">每天提款上限：</td>
					        <td><input type="text" name="dayUp" value="${dto.dayUp }"/>
					    </tr>
					    <tr>
					        <td class="tableleft">备注：</td>
					        <td>
					        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5">${dto.remark }</textarea>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button class="button button-primary" type="button" id="save">确定</button> 
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
      var datas;
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	$("#keywords").autocomplete({
				source:"${ctx}/member/info/memberComplete",
				select: function(event, ui) {
					event.preventDefault();
	                return false;
	            }
			});
	    	
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
	    	bindSkipClick("backId", "${ctx}/withdraw/limit/list");
	    	bindClick("save", "${ctx}/withdraw/limit/save");
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
