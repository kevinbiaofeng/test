<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>1</title>
<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
<script type="text/javascript" src="${statics }/js/jquery.easyui.min.js?number=Math.random()"></script>
<script type="text/javascript" src="${statics }/js/jquery-1.8.1.min.js?number=Math.random()"></script>
<script type="text/javascript" src="${statics }/js/jquery.jplayer.min.js"></script>

<!-- <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css" /> -->
<script type="text/javascript">
	 $(document).ready(function(){
	  	$("#jplayer_1").jPlayer({
		  ready: function () {
			  $(this).jPlayer("setMedia", {
				  mp3: "${statics}/wav/Taylor Swift - Red.mp3" //音乐路径
			  }).jPlayer("play");
		  },
		  swfPath: "${statics}/swf", //特别要主意jplayer插件的路径！
		  supplied: "mp3"
	  	});
	 });
	</script>
</head>


<body>
<!-- 	<div id="dlg" class="easyui-dialog" style="width:500px;height:250px;padding:10px 30px;" -->
<!-- 			title="Register" buttons="#dlg-buttons"> -->
<!-- 		<h2>Account Information</h2> -->
<!-- 		<form id="ff" method="post"> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Name:</td> -->
<!-- 					<td><input type="text" name="name" style="width:350px;"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Address:</td> -->
<!-- 					<td><input type="text" name="address" style="width:350px;"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>City:</td> -->
<%-- 					<td><select id="tree" class="easyui-combotree" data-options="url:'${ctx }/test/getTree', method:'post'" name="city" style="width:156px;"/></td> --%>
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- 	<div id="dlg-buttons"> -->
<!-- 		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="savereg()">Submit</a> -->
<!-- 		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a> -->
<!-- 	</div> -->
	
	
	<div id="jplayer_1"></div>   <!--播放音频的flash隐藏窗口-->
		<div id="jp_container_1">
		 <a href="#" class="jp-play">Play</a>
		 <a href="#" class="jp-pause">Pause</a>
		</div>
</body>
</html>


