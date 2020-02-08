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
			        		反水活动
			        	</strong>
			      </div>
		
				  <form id="objForm">
				  	<input name="id" type="hidden" value="${dto.id }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">活动名称：</td>
					        <td><input type="text" name="name" value="${dto.name }"/><span class="error"></span></td>
					    </tr>
					    <tr>
					        <td class="tableleft">会员类别：</td>
					        <td>
					        	<xjw:selectBar name="memberStart" clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" 
					           myClass="" type="select" value="${dto.memberStart }"/>
					         	  一
					         	<xjw:selectBar name="memberEnd" clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" 
					           myClass="" type="select" value="${dto.memberEnd }"/>
					           <span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">平台：</td>
					        <td>
					        	<xjw:selectBar name="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" 
					           myClass="" type="select" value="${dto.platformType }"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">百分比：</td>
					        <td><input type="text" name="percent" value="${dto.percent }"/> <font color="blue">%</font><span class="error"></span></td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">反水下限：</td>
					        <td><input type="text" name="lower" value="${dto.lower }"/><span class="error"></span></td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">反水上限：</td>
					        <td><input type="text" name="up" value="${dto.lower }"/><span class="error"></span></td>
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
					        <td class="tableleft">备注：</td>
					        <td>
					        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5">${dto.remark}</textarea>
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
	    			},memberStart: {
	 					required:true
	 				},memberEnd: {
	 					required:true
	 				},platformType: {
	 					required:true
	 				},percent: {
	 					required: true, maxlength:3, number:true
	 				},up: {
	 					required: true, maxlength:10, number:true
	 				},lower: {
	 					required: true, maxlength:10, number:true
	 				},startTime: {
	 					required: true
	 				},endTime: {
	 					required: true
	 				},remark: {
	 					maxlength: 250
	 				},status: {
	    				required: true
	    			}
	 			},messages:{
	 				name: {
	 					required: "活动名称为必填项",
	 					maxlength:"活动名称不能超过10个字符"
	 				},memberStart: {
	 					required: "会员类别为必填项"
	 				},memberEnd: {
	 					required: "会员类别为必填项"
	 				},platformType: {
	 					required: "平台为必填项"
	 				},percent: {
	 					required: "百分比为必填项",maxlength:"百分比不能超过3个字符",number:"百分比必须为数字"
	 				},up: {
	 					required: "反水上限为必填项",maxlength:"反水上限不能超过10个字符",number:"反水上限必须为数字"
	 				},lower: {
	 					required: "反水下限为必填项",maxlength:"反水下限不能超过10个字符",number:"反水下限必须为数字"
	 				},startTime: {
	    				required:"活动开始时间为必填项"
	    			},endTime: {
	    				required:"活动结束时间为必填项"
	    			},remark: {
	 					maxlength:"说明不能超过250个字符"
	 				},status: {
	    				required:"状态为必填项"
	    			}
	 			},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	 		});
	    	bindSkipClick("backId", "${ctx}/rebate/info/list");
	    	bindClick("save", "${ctx}/rebate/info/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
