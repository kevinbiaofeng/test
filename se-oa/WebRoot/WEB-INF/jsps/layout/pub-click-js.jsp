<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function bindClick(buttonId, url){
	
	jQuery("#" + buttonId).click(function() {
		if($("#objForm").validate().form()){
			var sender = BUI.Mask.maskElement("body");
			$("#objForm").ajaxSubmit({
				type: "POST",
				url: url,
		        dataType:'json',
		        success: function(data) {
		        	sender.remove();
				    if(data.status == "1"){
				    	var text = "[";
				    	if("0" != data.addUrl){
				    		text += "{text:'"+data.addText+"',icon : 'success',elCls : 'btn btn-success',handler : function(){ window.location.href='" + data.addUrl + getParams(data.param) + "'; this.close();}},";
				    	}
						if("0" != data.modifyUrl){
							text += "{text:'"+data.modifyText+"',elCls : 'btn btn-info',handler : function(){ window.location.href='" + data.modifyUrl + getParams(data.param) + "'; this.close();}},";		
				    	}
						if("0" != data.listUrl){
							text += "{text:'"+data.listText+"',elCls : 'btn btn-primary',handler : function(){ window.location.href='" + data.listUrl + getParams(data.param) + "'; this.close();}},";
						}
						text += "]";
				    	
				    	var dialog = new BUI.Overlay.Dialog({
				    		title:'提示框',
				    		width:300,
				    		height:150,
				    		buttons:eval("("+ text + ")"),
				    		bodyContent: data.message,
				    		success:function () {
					    		this.close();
			    		 	}
		    		 	});
				    	dialog.show();
				    }else{
				    	var dialog = new BUI.Overlay.Dialog({
				    		 title:'提示框',
				    		 width:300,
				    		 height:150,
				    		 buttons:[
								eval("("+ "{text:'"+data.butText+"',elCls : 'btn btn-inverse',handler : function(){ window.location.href='" + data.url  + getParams(data.param) + "'; this.close();}}" + ")")
							],
				    		bodyContent: data.message,
				    		success:function () {
					    		this.close();
			    		 	}
		    		 	});
				    	dialog.show();
				    }
				   
			    }
		    });
// 			$.ajax({
// 				type: "POST",
// 				url: url,
// 				data:$('#objForm').serialize(),
// 				async: false,
// 				dataType: "json",
// 			    success: function(data) {
// 			    	sender.remove();
// 				    if(data.status == "1"){
// 				    	var text = "[";
// 				    	if("0" != data.addUrl){
// 				    		text += "{text:'"+data.addText+"',icon : 'success',elCls : 'btn btn-success',handler : function(){ window.location.href='" + data.addUrl + getParams(data.param) + "'; this.close();}},";
// 				    	}
// 						if("0" != data.modifyUrl){
// 							text += "{text:'"+data.modifyText+"',elCls : 'btn btn-info',handler : function(){ window.location.href='" + data.modifyUrl + getParams(data.param) + "'; this.close();}},";		
// 				    	}
// 						if("0" != data.listUrl){
// 							text += "{text:'"+data.listText+"',elCls : 'btn btn-primary',handler : function(){ window.location.href='" + data.listUrl + getParams(data.param) + "'; this.close();}},";
// 						}
// 						text += "]";
				    	
// 				    	var dialog = new BUI.Overlay.Dialog({
// 				    		title:'提示框',
// 				    		width:300,
// 				    		height:150,
// 				    		buttons:eval("("+ text + ")"),
// 				    		bodyContent: data.message,
// 				    		success:function () {
// 					    		this.close();
// 			    		 	}
// 		    		 	});
// 				    	dialog.show();
// 				    }else{
// 				    	var dialog = new BUI.Overlay.Dialog({
// 				    		 title:'提示框',
// 				    		 width:300,
// 				    		 height:150,
// 				    		 buttons:[
// 								eval("("+ "{text:'"+data.butText+"',elCls : 'btn btn-inverse',handler : function(){ window.location.href='" + data.url  + getParams(data.param) + "'; this.close();}}" + ")")
// 							],
// 				    		bodyContent: data.message,
// 				    		success:function () {
// 					    		this.close();
// 			    		 	}
// 		    		 	});
// 				    	dialog.show();
// 				    }
				   
// 			    }
// 			});
		}
		
	});
}
</script>