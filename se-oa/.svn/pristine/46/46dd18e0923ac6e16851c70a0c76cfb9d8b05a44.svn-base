<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<link href="${statics }/css/main-min.css" rel="stylesheet" type="text/css" />
	<link href="${statics }/css/bui-min.css" rel="stylesheet" type="text/css" />
  	<link href="${statics }/css/dpl-min.css" rel="stylesheet" type="text/css" />
  	<style>
  		#modifyPwdForm label.error{color:red}
  	</style>
</head>

<body onload="loadingMsg()"> 
	<div class="header">
		<div class="dl-title">
			后台管理系统
		</div>
		<div class="dl-log">
			欢迎您，<span class="dl-log-user">${sessionScope.user.loginName}</span>
			
			<a id="btnModifyPwd" href="javascript:void(0)" title="修改密码" class="dl-log-quit">[修改密码]</a>
			<a href="${ctx}/user/exit" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
		<div class="dl-msg">
			<img id="msgImage" src="${statics }/img/msg.png" onclick="skipMsgPage()"></img>
			<div id="jplayer_1"></div>
		</div>
	</div>
	
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten"></ul>
	</div>
	
	
	<!-- 修改密码-->
    <div id="modifyPwdShow" style="display:none">
		<form id="modifyPwdForm" class="form-horizontal" action="/sysuser/modifypwd" method="post">
        	<div class="row">
				<div class="control-group">
	            	<label class="control-label">原始密码：</label>
	            	<div class="controls">
	            		<input type="password" id="oldPwd" name="oldPwd" class="input-normal control-text" axlength="20"/>
	            	</div>
	          	</div>
	          	<div class="control-group">
	            	<label class="control-label">新密码：</label>
	            	<div class="controls">
	              		<input type="password" id="newPwd" name="newPwd" class="input-normal control-text" maxlength="20"/>
	            	</div>
	          	</div>
				<div class="control-group">
            		<label class="control-label">确认密码：</label>
            		<div class="controls">
              			<input type="password" id="confirmPwd" name="confirmPwd" class="input-normal control-text" maxlength="20"/>
            		</div>
          		</div>
			</div>
      	</form>
    </div>
	
	<script type="text/javascript" src="${statics }/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery.form.min.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery.jplayer.min.js"></script>
	<script type="text/javascript" src="${statics }/js/jquery.timers-1.2.js"></script>
	<script type="text/javascript" src="${statics }/js/bui-min.js"></script>
	<script type="text/javascript" src="${statics }/js/config-min.js"></script>
	<script type="text/javascript" src="${statics }/js/common/main-min.js"></script>
	<script>
		$(document).ready(function(){
			BUI.use('common/page');
			$("#jplayer_1").jPlayer({
				  ready: function () {
					  $(this).jPlayer("setMedia", {
						  mp3: "${statics}/wav/new_notice.mp3"
					  });
				  },
				  swfPath: "${statics}/swf",
				  supplied: "mp3",
				  volume: 100,
				  autoPlay:true//是否自动播放
			  	});
		});
		
		BUI.use(['bui/overlay'],function(Overlay){
			var dialog = new Overlay.Dialog({
				title:'修改密码',
				width:500,
		        height:320,
				contentId:'modifyPwdShow',	//配置DOM容器的编号
				success:function () {
					$("#modifyPwdForm").submit();
				}
			});
			
			$("#modifyPwdForm").validate({
				rules: {
					oldPwd:{required:true},
					newPwd:{required:true, minlength:6},
					confirmPwd:{equalTo: "#newPwd"}
				},
				messages:{
					oldPwd:{required:"原始密码不能为空"},
					newPwd:{required:"新密码不能为空", minlength:"新密码最小长度为6位"},
					confirmPwd:{equalTo: "新密码和确认密码不同"}
				},
				submitHandler: function(form) {
	                $(form).ajaxSubmit({
	                	dataType:"json",
	                    success: function(json){
	                    	alert(json.msg);
							
							if(json.code == '1'){
								dialog.close();
							}
	                    }
	                });
	            }
			});
			
			$('#btnModifyPwd').on('click',function () {
				$("#modifyPwdForm")[0].reset();
				dialog.show();
			});
		});
		
		$('body').everyTime('180s', function() {  
			loadingMsg();
        }); 
		
		$.get("${ctx}/sysauth/getFunctionList", function(data){
			$("#J_Nav").html("");
			$(data.menuFirst).each(function(){
				$("#J_Nav").append('<li class="nav-item dl-selected"><div class="nav-item-inner '+$(this).attr("cssName")+'">'+$(this).attr("name")+'</div></li>');
			});
			BUI.use('common/main',function(){
				new PageUtil.MainPage({
		        	modulesConfig : data.menuTree
		        });
			});
		}, "json");
		
		function skipMsgPage(){
			top.topManager.openPage({
			    id : '99999',
			    href : '${ctx}/sysmsg/list',
			    title : '系统消息'
		  	});
		}
		
		function loadingMsg(){
			$.get("${ctx}/sysmsg/getNotice", function(data){
				if(data > 0){
					$("#msgImage").attr("src", "${statics }/img/msg_new.png");
					$("#jplayer_1").jPlayer("play");
				}else{
					$("#msgImage").attr("src", "${statics }/img/msg.png");
				}
			}, "text");
		}
  </script>
</body>
</html>