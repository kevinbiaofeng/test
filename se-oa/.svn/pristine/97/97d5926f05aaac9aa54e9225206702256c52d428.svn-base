<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function delRow(ckValues, url, params){
	 BUI.Message.Show({
		 msg : '是否确认删除？',
		 icon : 'question',
		 buttons : [{
		 text:'是',
		 elCls : 'button button-primary',
		 handler : function(){
			 window.location.href = url + "?ids=" + ckValues + (params == null? "": params);
			 this.close();
		 }},{
		 text:'否',
		 elCls : 'button',
		 handler : function(){
			 this.close();
		 }} ]
	});
}
</script>