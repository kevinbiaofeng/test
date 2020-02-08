/*
 * jquery.validate.js 验证方法扩展
 */
$(function(){
	// 英文和数字 
	jQuery.validator.addMethod("alphanumeric", function(value, element) { 
		return this.optional( element ) || /^\w+$/i.test( value );
	}, "只能输入英文和数字"); 
	
	// 输入值不能相同
	jQuery.validator.addMethod("notEqualTo", function(value, element, param) { 
		var target = $(param);
		if ( this.settings.onfocusout && target.not( ".validate-equalTo-blur" ).length ) {
			target.addClass( "validate-equalTo-blur" ).on( "blur.validate-equalTo", function() {
				$(element).valid();
			} );
		}
			
		return value != $(param).val();     
  }, "不能输入同样的值");
});