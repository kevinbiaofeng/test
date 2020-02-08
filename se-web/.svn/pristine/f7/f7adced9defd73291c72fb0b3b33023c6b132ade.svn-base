(function (factory) {
    "use strict";
    if (typeof define === 'function' && define.amd) {
        // using AMD; register as anon module
        define(['jquery'], factory);
    } else {
        // no AMD; invoke directly
        factory( (typeof(jQuery) != 'undefined') ? jQuery : window.Zepto );
    }
}(function($) {
	"use strict";
	
	//分页方法
	$.fn.Pagination = function(options){
		var settings = $.extend({}, defaults, options);

		return {
			render : function(options){
				options = options || {};
				settings = $.extend( {}, settings, options);
				render(settings);
			}
		}
	};
	
	//分页默认参数
	var defaults = {
		//容器ID
		containerId : "container",	
		// 请求URL
		url : "",
		// 请求参数
		data : {},
		// 每页数量
    	pageSize : 10,
    	// 当前页数
    	pageNo : 1
	};
	
	//渲染页面
	var render = function(settings){
		var data = $.extend({}, settings.data, {
			pageSize : settings.pageSize,
    		pageNo : settings.pageNo
    	});
		
		$("#" + settings.containerId).load(settings.url, data);
		$(document).off("click", "#" + settings.containerId + " ul.pagination a");
		$(document).on("click", "#" + settings.containerId + " ul.pagination a", function(){
			var num = $(this).data("num");
			if(num){
				settings.pageNo = num;
				render(settings);
			}
		});
	}
}));