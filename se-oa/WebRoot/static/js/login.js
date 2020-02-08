$(function(){
	$("#code").click(function() {
		$(this).attr("src", "${ctx}/code.img?" + new Date().getTime());
	});

	$("#objForm").validate({
		rules : {
			loginName : {
				required : true
			},
			pwd : {
				required : true,
				rangelength : [ 6, 16 ]
			},
			verifyCode : {
				required : true
			}
		},
		messages : {
			loginName : {
				required : "帐号为必填项"
			},
			pwd : {
				required : "密码为必填项",
				rangelength : "密码长度只能在6-16位之间"
			},
			verifyCode : {
				required : "验证码为必填项"
			}
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.siblings("span"));
		}
	});
	
	$("#pwd").click(function(){
		 $("#msg").hide();
	});
});