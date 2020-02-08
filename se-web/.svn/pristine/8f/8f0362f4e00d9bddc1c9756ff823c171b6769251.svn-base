$(function(){
	$(document).keydown(function (event) {
        if (event.keyCode == 116) {  
        	$.cookie("isNotF5", "true"); 
        }
    });
	
	if($.cookie('isNotF5') == null || $.cookie('isNotF5') == "false"){
		var t = $(window).scrollTop();
		$('body,html').animate({'scrollTop':t + 500},1500)
	}
	
	$.cookie("isNotF5", "false"); 
})