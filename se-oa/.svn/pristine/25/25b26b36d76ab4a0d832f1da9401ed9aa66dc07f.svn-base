<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<html>

<head>
	<script type="text/javascript" src="${statics }/js/jquery-1.8.1.min.js?number=Math.random()"></script>
	<script type="text/javascript" src="${statics }/js/jquery.jplayer.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="refresh" content="111">
	<script type="text/javascript">
	$(document).ready(function(){
		$.get("${ctx}/sysmsg/getNotice", function(data){
			if(data > 0){
				$("#msgImage").attr("src", "${statics }/img/msg_new.png");
				$("#jplayer_1").jPlayer({
				  ready: function () {
					  $(this).jPlayer("setMedia", {
						  mp3: "${statics}/wav/new_notice.mp3"
					  }).jPlayer("play");
				  },
				  swfPath: "${statics}/swf",
				  supplied: "mp3",
				  volume: 100
			  	});
			}else{
				$("#msgImage").attr("src", "${statics }/img/msg.png");
				//$("#msgImage").attr("onclick", "");
			}
		}, "text");
	 });
	
	function skipMsgPage(){
		window.parent.skipMsgPage();
	}
	</script>
</head>


<body>
	<img id="msgImage" src="${statics }/img/msg.png" onclick="skipMsgPage()"></img>
	<div id="jplayer_1"></div>
</body>
</html>