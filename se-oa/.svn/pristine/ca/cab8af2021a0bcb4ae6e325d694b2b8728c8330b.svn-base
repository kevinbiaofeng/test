<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function bindTreeClick(buttonId, url){
	jQuery("#" + buttonId).click(function() {
		if($("#objForm").validate().form()){
			var sender = BUI.Mask.maskElement("body");
			$.ajax({
				type: "POST",
				url: url,
				data:$('#objForm').serialize(),
				async: false,
				dataType: "json",
			    success: function(data) {
			    	sender.remove();
				    if(data.status == "1"){
						window.parent.flushTree();
				    }else{
				    	 BUI.Message.Show({
				    		 msg : data.message,
				    		 icon : 'error',
				    		 buttons : [],
				    		 autoHide : true,
				    		 autoHideDelay : 2000
			    		 });
				    }
				   
			    }
			});
		}
	});
}
function bindTreeDelClick(buttonId, url){
	jQuery("#" + buttonId).click(function() {
	   	BUI.Message.Show({
	   		 msg : '是否确认删除？',
	   		 icon : 'question',
	   		 buttons : [{
	   		 text:'是',
	   		 elCls : 'button button-primary',
	   		 handler : function(){
	   			var sender = BUI.Mask.maskElement("body");
	   			$.ajax({
	   				type: "POST",
	   				url: url,
	   				data: $('#objForm').serialize(),
	   				async: false,
	   				dataType: "json",
	   			    success: function(data) {
	   			    	sender.remove();
	   				    if(data.status == "1"){
	   						window.parent.flushTree();
	   				    }else{
	   				    	 BUI.Message.Show({
	   				    		 msg : data.message,
	   				    		 icon : 'error',
	   				    		 buttons : [],
	   				    		 autoHide : true,
	   				    		 autoHideDelay : 2000
	   			    		 });
	   				    }
	   				   
	   			    }
	   			});
	   			this.close();
	   		 }},{
	   		 text:'否',
	   		 elCls : 'button',
	   		 handler : function(){
	   			 this.close();
	   		 }} ]
	   	 });
    });
}
</script>