<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<div id="showPanel">
<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc" style="width: 60%; visibility: visible; left: 284px; top: 28px; display: block;" aria-disabled="false" aria-pressed="false"><div class="bui-stdmod-header"><div class="header-title">数据列表<font id="errorMsg" color="red" style="display: none;">&nbsp;&nbsp;*(请至少选择一项)</font></div></div><div class="bui-stdmod-body" style="height: 400px;">
<div id="showData"></div>
</div><div class="bui-stdmod-footer"><button class="button button-primary" id="confirm">确定</button><button class="button button-primary cc">取消</button></div><a style="" class="bui-ext-close" role="button" href="javascript:void(&quot;关闭&quot;)" tabindex="0"><span class="bui-ext-close-x x-icon x-icon-normal cc">×</span></a></div>
</div>
<script>
	var op = "${showPanelForm.op}";
	var k = "${showPanelForm.k}";
	var otherInput = "${showPanelForm.otherInput}";
	var inputId = "${showPanelForm.inputId}";
	var inputName = "${showPanelForm.inputName}";
   	$(function () {
   		BUI.use('bui/overlay');
  		BUI.use(['bui/mask']);
   		loadData("", op);
   	});
     	
    function ajaxCommonPageFormSubmit(formId, pageNo){
    	if(pageNo == '0'){
    		pageNo = $("#pageNo").val();
    	}
   		var form = $("#" + formId);
   		var actionUrl = form.attr("action");
   		$("#pageNo").remove();
   		if(actionUrl.indexOf("&") > 1){
   			actionUrl += "&pageNo=" + pageNo;
   		}else{
   			actionUrl += "?pageNo=" + pageNo;
   		}
   		loadData(actionUrl);
    }
     
   	function loadData(actionUrl, op){
    	$.ajax({
			type: "POST",
			url: actionUrl==""?"${ctx}/showPanel/findSkipPage?op="+op+"&k="+k+"&otherInput="+otherInput : actionUrl,
			data: $('#ccForm').serialize(),
			async: false,
			dataType: "html",
		    success: function(data) {
		    	$("#showData").html(data);
		    }
    	});
    }
     	
   	$(".cc").click(function(){
   		closePanel();
    });
    
    function closePanel(){
   		BUI.use(['bui/mask'],function(Mask){
   			Mask.unmaskElement('body');
   		});
   		$("#showPanel").hide();
   	}
   	
   	$("#confirm").click(function(){
   		if($("input[name='ck']:checked").val() == null){
   			$("#errorMsg").show();
   		}else{
   			var tr = $("input[name='ck']:checked").parents("tr");
   			var id = tr.data("id");
   	   		var name = tr.data("name");
   	   		$("#" + inputId).val(id);
   	   		$("#" + inputName).val(name);
   	   		closePanel();
   	   		if(typeof showCallback == "function"){
   	   			showCallback(id, name);
   	   		}
   		}
    })
</script>
