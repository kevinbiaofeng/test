<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style>
	<!--
	form {
		color: black;
	}
	-->
	</style>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>
<body>
<div id="showPanel">
<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc" style="width: 40%; visibility: visible; left: 15%; top: 10%; display: block;" aria-disabled="false" aria-pressed="false"><div class="bui-stdmod-header">
<div class="header-title">会员信息编辑</div></div>
<div class="bui-stdmod-body" style="height: 300px;">
<form id="ccForm">
	<input type="hidden" name="user.id" id="userId" value="${dto.id }"/>
  	<input type="hidden" name="member.id" value="${dto.memberId }"/>
  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
			    <tr>
			        <td width="130px"><b>真实姓名：</b></td>
			        <td>
			        	<input type="text" name="member.userName" value="${dto.name }"/>
			        </td>
			    </tr>
<!-- 			    <tr> -->
<!-- 			        <td><b>性别：</b></td> -->
<!-- 			        <td> -->
<%-- 			        	<xjw:selectBar name="member.sex" clazz="com.xjw.kzenum.user.SexTypeEnum"  --%>
<%-- 					           myClass="" type="select" value="${dto.sex }"/> --%>
<!-- 			        </td> -->
<!-- 			    </tr> -->
			    <tr>
			        <td><b>联系电话：</b></td>
			        <td>
			        	<input type="text" name="member.phone" value="${dto.phone }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>QQ：</b></td>
			        <td>
			        	<input type="text" name="member.qq" value="${dto.qq }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>邮箱：</b></td>
			        <td>
			        	<input type="text" name="member.email" value="${dto.email }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>会员状态：</b></td>
			        <td>
			        	<xjw:selectBar name="user.status" clazz="com.xjw.kzenum.sys.StatusEnum" 
					           myClass="" type="select" value="${dto.status }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>会员类别：</b></td>
			        <td>
			        	<xjw:selectBar name="member.vipType" clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" 
					           myClass="" type="select" value="${dto.vipType }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>生日：</b></td>
			        <td>
			        	<input type="text" name="member.birthday" class="datepicker" value="<fmt:formatDate value="${dto.birthday }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',skin:'whyGreen', readOnly:true})"/>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
</form>
</div><div class="bui-stdmod-footer"><button class="button button-primary" id="confirm">确定</button><button class="button button-primary cc">取消</button></div><a style="" class="bui-ext-close" role="button" href="javascript:void(&quot;关闭&quot;)" tabindex="0"><span class="bui-ext-close-x x-icon x-icon-normal cc">×</span></a></div>
</div>
<script>
   	$(".cc").click(function(){
   		closePanel();
    });
    
    function closePanel(){
   		BUI.use(['bui/mask'],function(Mask){
   			Mask.unmaskElement('body');
   		});
   		$("#showPanel").hide();
   	}
   	
   	$("#confirm").click(function(){
   		var userId = $("#userId").val();
   		$.ajax({
			type: "POST",
			url: "${ctx}/member/info/save",
			data: $("#ccForm").serialize(),
			dataType: "text",
			async: false,
		    success: function(data) {
		    	if(data == "1"){
		    		closePanel();
		    		
		    		window.location.href = "${ctx}/member/info/detail?id=" + userId;
		    	}else{
		    		alert("提交失败!");
		    	}
		    }
    	});
    })
</script>
</body>
</html>