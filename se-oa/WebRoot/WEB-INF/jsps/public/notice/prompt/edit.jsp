<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>${empty prompt.id ? '新增' : '编辑' }弹窗消息</strong>
			      </div>
		
				  <form id="objForm">
				  	<input type="hidden" name="id" id="id" value="${prompt.id}"/>
				  	
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">用户名：</td>
					        <td><input type="text" name="name" id="name" value="${prompt.name}"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">中奖金额：</td>
					        <td><input type="text" name="amount" id="amount" value="${prompt.amount}"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">中奖时间：</td>
					        <td>
					        	<input type="text" id="winTime" name="winTime" value='<fmt:formatDate value="${prompt.winTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>'
					        			class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly/>
					        </td>
					    </tr>
					     <tr>
					        <td class="tableleft">游戏名：</td>
					        <td><input type="text" name="content" id="content" value="${prompt.content}"/></td>
					    </tr>
					    <tr>
					        <td class="tableleft">平台类型：</td>
					        <td>
					        	<xjw:selectBar id="platformType" name="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" 
					          					myClass="" type="select" value="${prompt.platformType}" />
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
	 				name: {required:true, minlength:6,  maxlength:12},
	 				amount: {required:true, number:true},
	 				winTime: {required:true, date:true},
	 				content: {required:true, minlength:2,  maxlength:20},
	 				platformType: {required:true}
	 			},messages:{
	 				name: {
	 					required: "用户名为必填项",
	 					minlength:"用户名不能少于6个字符",
	 					maxlength:"登录名不能超过12个字符"
	 				}, amount: {
	 					required: "中奖金额为必填项",
	 					number:"中奖金额只能为数字"
	 				}, winTime: {
	 					required: "中奖时间为必填项",
	 					date: "中奖时间格式 yyyy-MM-dd HH:mm"
	 				},content: {
	 					required: "游戏名称为必填项", 
	 					minlength: "游戏名称不能少于2个字",  
	 					maxlength: "游戏名称不能超过20个字"
	 				},platformType: {
	 					required: "平台类别为必填项"
	 				}
	 			}
 			});
	    	
	    	bindSkipClick("backId", "${ctx}/notice/prompt/list");
	    	bindClick("save", "${ctx}/notice/prompt/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
