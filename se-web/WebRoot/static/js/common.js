var se = {};
se.login = {};

se.login.quick = {};
se.login.quick.isLock = false;
se.login.quick.submit = function(){
	var loginName = $.trim($("div.header #loginName").val());
	var loginPwd  = $.trim($("div.header #loginPwd").val());
	
	if(!loginName){
		return layer.tips('請輸入用戶名', "div.header #loginName", {tips: [1, '#0088fe'],time: 4000});
	}else if(!loginPwd){
		return layer.tips('請輸入密碼', "div.header #loginPwd", {tips: [1, '#0088fe'],time: 4000});
	}
	
	if(se.login.quick.isLock){return;}
	se.login.quick.isLock = true;
	
	layer.load(0, {shade: [0.1, '#333']});
	var url = "/user/login";
	var data = {'loginName' : loginName, 'loginPwd' : loginPwd};
	$.post(url, data, function(data){
		se.login.quick.isLock = false;
		layer.closeAll();
		
		if(data.code == "1"){
    		window.location.reload();
    	}else{
    		layer.tips(data.msg, "div.header #loginPwd", {tips: [1, '#0088fe'], time: 4000});
    	}
	},"json");
	
};

se.login.popup = {};
se.login.popup.isLock = false;
se.login.popup.dialog = function(){
	layer.open({
		type: 1,
		title: false,
		shadeClose: true,
		content: $("#loginTemplate").html(),
		area: ['600px', '380px']
	});
	$("form.login-form #loginName").focus();
};


se.login.popup.submit = function(url){
	var loginName = $.trim($("form.login-form #loginName").val());
	var loginPwd = $.trim($("form.login-form #loginPwd").val());
	if(loginName == ""){
		layer.tips("請輸入用戶名", 'form.login-form #loginName', {tips: [1, '#0088fe'],time: 4000});
		return;
	}
	if(loginPwd == ""){
		layer.tips("請輸入密碼", 'form.login-form #loginPwd', {tips: [1, '#0088fe'],time: 4000});
		return;
	}
	if(se.login.popup.isLock){return;}
	se.login.popup.isLock = true;
	
	layer.load(1, {shade: [0.8, '#393D49']});
	url += "/user/login";
	var data = {'loginName' : loginName, 'loginPwd' : loginPwd};
	$.post(url, data, function(json){
		se.login.popup.isLock = false;
		layer.closeAll('loading');
		
		if(json.code == "1"){
			layer.closeAll();
			window.location.reload();
    	}else{
    		layer.tips(json.msg, 'form.login-form #loginPwd', {tips: [1, '#0088fe'],time: 4000});
    	}
	}, "json");
}

se.reg = {};
se.reg.popup = {};
se.reg.popup.isLock = false;
se.reg.popup.submit = function(url){
	var regName = $.trim($("form.register-form #regName").val());
	var regPwd = $.trim($("form.register-form #regPwd").val());
	var email = $.trim($("form.register-form #email").val());
	if(regName == ""){
		layer.tips("請輸入用戶名", 'form.register-form #regName', {tips: [1, '#0088fe'],time: 4000});
		return;
	}
	if(regPwd == ""){
		layer.tips("請輸入密碼", 'form.register-form #regPwd', {tips: [1, '#0088fe'],time: 4000});
		return;
	}
	if(email == ""){
		layer.tips("請填寫郵箱", 'form.register-form #email', {tips: [1, '#0088fe'],time: 4000});
		return;
	}
	if(se.reg.popup.isLock){return;}
	se.reg.popup.isLock = true;
	
	layer.load(1, {shade: [0.8, '#393D49']});
	url += "/user/register";
	var data = {'regName' : regName, 'regPwd' : regPwd, 'email' : email};
	$.post(url, data, function(json){
		se.reg.popup.isLock = false;
		layer.closeAll('loading');
		
		if(json.code == "1"){
			layer.closeAll();
			window.location.reload();
    	}else{
    		layer.tips(json.msg, 'form.register-form #email', {tips: [1, '#0088fe'],time: 4000});
    	}
	}, "json");
}

se.logout = function(url){
	layer.confirm('是否確定退出登錄？', {
	  	btn: ['確定','取消']
	}, function(){
		$.post(url + "/user/exit",{},function(data){
    		window.location.href = url;
		},"text");
	}, function(){});
}