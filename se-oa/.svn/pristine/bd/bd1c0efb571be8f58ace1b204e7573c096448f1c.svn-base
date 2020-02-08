<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
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
			        		公告
			        	</strong>
			      </div>
		
				  <form id="objForm">
				  	<input name="id" type="hidden" value="${dto.id }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">公告标题：</td>
					        <td><input type="text" name="name" value="${dto.name }"/><span class="error"></span></td>
					    </tr>
					    <tr>
					        <td class="tableleft">活动时间段：</td>
					        <td>
		    					<input type="text" name="startTime" value="<fmt:formatDate value="${dto.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" id="startTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
								一
								<input type="text" name="endTime" value="<fmt:formatDate value="${dto.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:'2020-10-01'})"/>
								<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">公告内容：</td>
					        <td>
					        	<textarea name="context" class="uneditable-textarea" cols="45" rows="5">${dto.context}</textarea>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">状态：</td>
					        <td>
					        	<xjw:selectBar name="status" clazz="com.xjw.kzenum.activity.ActivityStatusEnum" 
					           myClass="" type="radio" value="${dto.status}" exclude="4,5"/>
					           <span class="error"></span>
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
	    			},startTime: {
	 					required: true
	 				},endTime: {
	 					required: true
	 				},context: {
	 					maxlength: 500
	 				},status: {
	    				required: true
	    			}
	 			},messages:{
	 				name: {
	 					required: "活动名称为必填项",
	 					maxlength:"活动名称不能超过10个字符"
	 				},startTime: {
	    				required:"活动开始时间为必填项"
	    			},endTime: {
	    				required:"活动结束时间为必填项"
	    			},context: {
	 					maxlength:"说明不能超过500个字符"
	 				},status: {
	    				required:"状态为必填项"
	    			}
	 			},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	 		});
	    	bindClick("save", "${ctx}/site/notice/save");
	    	bindSkipClick("backId", "${ctx}/site/notice/list");
	    	//bindClick("save", "${ctx}/sysrole/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
