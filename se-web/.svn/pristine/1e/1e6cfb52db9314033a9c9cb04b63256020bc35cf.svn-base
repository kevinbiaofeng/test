<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />	
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1" />
		<title>老司机510-修改密码</title>
    	<meta name="keywords" content="老司机,老司机510,老司机2018,老司机小电影,老司机精品,老司机网,老司机福利,老司机电影网,老司机什么意思" />
    	<meta name="description" content="老司机510是汇集全球视频，及时收录各国视频内容的一家永久免费在线看片平台。看片，从老司机510平台开始。" />
    	<link href="${statics }/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${statics }/css/common.css" rel="stylesheet" />
    	<link href="${statics }/css/user-center.css" rel="stylesheet" />
    	<link rel="shortcut icon" href="${statics }/images/favicon.ico" type="image/x-icon" />

    	<!--[if lte IE 9]>
		<script src="${statics}/js/respond.min.js"></script>
		<script src="${statics}/js/html5shiv.min.js"></script>
		<![endif]-->
	</head>
	<body>
    	<%@ include file="/WEB-INF/jsps/commons/header.jsp"%>
    	
    	<div class="user-center">
    		<div class="container">
    			<%@ include file="/WEB-INF/jsps/commons/user-center-left.jsp"%>
	    		
	    		<div class="center-right">
	    			<div class="center-title">
	    				 我的資料
	    			</div>
	    			<div class="center-content">
	    				<div class="detail-title">
	    					修改密碼
	    				</div>
	    				<form id="repwdForm" action="javascript:;">
		    				<div class="detail-info">
	    						<div class="form-group col-sm-12">
		    						<label class="col-sm-2 control-label">
		    							<b>原始密碼：</b>
		    						</label>
									<div class="col-sm-10">
										<input id="oldPwd" name="oldPwd" type="password" maxlength="12"/>
									</div>
								</div>
								<div class="form-group col-sm-12">
		    						<label class="col-sm-2 control-label">
		    							<b>新 密 碼：</b>
		    						</label>
									<div class="col-sm-10">
										<input id="newPwd" name="newPwd" type="password" maxlength="12"/>
									</div>
								</div>
								<div class="form-group col-sm-12">
									<label class="col-sm-2 control-label">
										<b>密碼確認：</b>
									</label>
						   			<div class="col-sm-10">
						   				 <input id="reNewPwd" name="reNewPwd" type="password" maxlength="12"/>
						   			</div>
						   		</div>
						   		<div class="form-group col-sm-12">
						   			<label class="col-sm-2 control-label" style="">&nbsp;</label>
									<div class="col-sm-10">
										<button type="button" name="updatePwdBut" id="updatePwdBut" style="height: 30px;width: 80px;">確認修改</button>
									</div>
								</div>
	    					</div>
    					</form>
	    			</div>
	    		</div>
    		</div>
    	</div>
		
		<%@ include file="/WEB-INF/jsps/commons/footer.jsp"%>
		<script src="${statics }/plugins/jquery/1.11.1/jquery.min.js"></script>
		<script src="${statics }/plugins/layer/layer.js" type="text/javascript"></script>
		<script src="${statics }/plugins/jquery.validate/1.16.0/jquery.validate.min.js" type="text/javascript"></script>
    	<script src="${statics }/js/jquery.validate.methods.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function() {
			
				$("#updatePwdBut").click(function(){ 
					$("#repwdForm").submit();
				});
				
				$("#repwdForm").validate({
					//debug: true,
					onkeyup: false,
					onclick: false,
					//光标离开表单元素
					onfocusout: false,
					//onfocusout: function(element){$(element).valid();},
					
					rules: {
						oldPwd: {
							required: true,
							rangelength: [6, 20],
							alphanumeric: true
						}, newPwd: {
							required: true,
							rangelength: [6, 20],
							alphanumeric: true,
							notEqualTo: "#oldPwd"
						}, reNewPwd: {
							required: true,
							rangelength: [6, 20],
							equalTo: "#newPwd"
						}
					}, messages: {
						oldPwd: {
							required: "原始密码不能为空",
							rangelength: "原始密码由{0}-{1}位字母、数字组成",
							alphanumeric: "原始密码只能输入字母、数字"
						}, newPwd: {
							required: "新密码不能为空",
							rangelength: "新密码由{0}-{1}位字母、数字组成",
							alphanumeric: "新密码只能输入字母、数字",
							notEqualTo: "新密码和原始密码不能一样"
						}, reNewPwd: {
							required: "确认密码不能为空",
							rangelength: "确认密码由{0}-{1}位字母、数字组成",
							equalTo: "您两次输入的密码不一致"
						}
					}, showErrors: function(errorMap, errorList){
						if(errorList.length > 0){
							var msg = errorList[0].message;
							layer.tips(msg, '#' + errorList[0].element.name, {tips: [1, '#0088fe'],time: 4000});
						}
					}, submitHandler: function(form){
						if($(form).data("isLock")){return false;}
						$(form).data("isLock", 1);
						
						$.post("${ctx}/member/updatePwd", $(form).serialize(), function(data){
							$(form).data("isLock", 0);
							
							if(data == "1"){
					    		$('#repwdForm')[0].reset();
					    		layer.alert("修改密码成功，请重新登录。", {icon: 1});
					    	}else{
					    		layer.alert("尊敬的客户，您修改密码失败了。", {icon: 2});
					    	}
						});
						return false;
					}
				});
				
			});
			
		</script>
	</body>
</html>