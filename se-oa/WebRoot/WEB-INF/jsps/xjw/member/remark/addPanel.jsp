<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<div id="showPanel">
	<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc"
		style="width: 800px; visibility: visible; left: 15%; top: 25px; display: block;"
		aria-disabled="false" aria-pressed="false">
		<div class="bui-stdmod-header">
			<div class="header-title">添加备注</div>
		</div>
			<div class="pageContent" style="height: 220px">
		    	<div class="panel">
				      <div class="panel-header">
				        	<strong>&nbsp;</strong>
				      </div>
					
					  	<input id="userId" type="hidden" value="${userId }"/>
						<table class="table table-bordered definewidth">
						    <tr>
						        <td width="10%" class="tableleft">类别：</td>
						        <td>
						        	<xjw:selectBar name="titleType" clazz="com.xjw.kzenum.user.RemarkTitleTypeEnum" myClass="" type="select" value="" id="titleType"/>
						        	<span class="error" style="display: none;" id="errType">
										<label class="error">类别为必填项</label>
									</span>
						        </td>
						    </tr>
						    <tr>
						        <td class="tableleft">内容：</td>
						        <td>
						        	<textarea id="remark" name="remark" class="uneditable-textarea" cols="45" rows="5"></textarea>
						        	<span class="error" style="display: none;" id="errContent">
										<label class="error">内容为必填项</label>
									</span>
						        </td>
						    </tr>
						</table>
					
				  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
			 	</div>
		  </div>
			<div class="bui-stdmod-footer">
				<button class="button button-primary" id="confirm">确定</button>
				<button class="button button-primary cc">取消</button>
			</div>
		<a style="" class="bui-ext-close" role="button"
			href="javascript:void(&quot;关闭&quot;)" tabindex="0"><span
			class="bui-ext-close-x x-icon x-icon-normal cc">×</span>
		</a>
	</div>
</div>
<script>
   	$(function () {
   		BUI.use('bui/overlay');
  		BUI.use(['bui/mask']);
   	});
     	
   	$(".cc").click(function(){
   		closePanel();
    })
    
    function closePanel(){
   		BUI.use(['bui/mask'],function(Mask){
   			Mask.unmaskElement('body');
   		});
   		$("#showPanel").hide();
   	}
   	
   	$("#confirm").click(function(){
		if($("#titleType").val() == ""){
			$("#errType").show();
			return false;
		}else if($("#remark").val() == ""){
			$("#errType").hide();
			$("#errContent").show();
			return false;
		}else{
			var userId = $("#userId").val();
			$("#errType").hide();
			$("#errContent").hide();
			$.ajax({
				type: "POST",
				url: "${ctx}/member/remark/save",
				data: {"userId" : userId, "titleType" : $("#titleType").val(), "remark" : $("#remark").val()},
				async: false,
			    success: function(data) {
			    	closePanel();
			    	if(typeof showCallback == "function"){
			   			showCallback(userId);
			   		}
			    }
	    	});
	   		
		}
	})
   	
   	
</script>