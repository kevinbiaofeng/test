<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<style>
<!--
form {
	color: black;
}
-->
</style>
<div id="showPanel">
<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc" style="width: 55%; visibility: visible; left: 15%; top: 10%; display: block;" aria-disabled="false" aria-pressed="false"><div class="bui-stdmod-header">
<div class="header-title"><c:if test="${depositOrderForm.status eq 'fail'}"><font color="red">拒绝存款提示框</font></c:if><c:if test="${depositOrderForm.status eq 'success'}"><font color="green">同意存款提示框</font></c:if></div></div>
<div class="bui-stdmod-body" style="height: 400px;">
<form id="ccForm">
	<input type="hidden" name="status" value="${depositOrderForm.status }"/>
	<input type="hidden" name="id" value="${depositOrderForm.id }"/>
  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
			    <tr>
			        <td width="130px"><b>存款编号：</b></td>
			        <td>
			        	${dto.orderNo }
			        </td>
			    </tr>
			    <tr>
			        <td><b>会员账号：</b></td>
			        <td>
			        	${dto.loginName }
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款人姓名：</b></td>
			        <td>
			        	${dto.fromBankAccount }
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款金额：</b></td>
			        <td>
			        	<fmt:formatNumber type="currency" pattern="#.##" value="${dto.tradeAmount }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款时间：</b></td>
			        <td>
			        	<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${dto.createTime }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款方式：</b></td>
			        <td>
			        	<xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}" />
			        </td>
			    </tr>
			    <tr>
			        <td><b>账户姓名：</b></td>
			        <td>
			        	${dto.toBankAccount }
			        </td>
			    </tr>
			    <tr>
			        <td><b>存入的银行账号：</b></td>
			        <td>
			        	${dto.toBankCard }
			        </td>
			    </tr>
			    <tr>
			        <td><b>备注：</b></td>
			        <td>
			        	<textarea rows="5" cols="45" name="remark" style="width: 392px; height: 48px;"></textarea>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
 </form>
</div><div class="bui-stdmod-footer"><button class="button button-primary" id="confirm">确定</button><button class="button button-primary cc">取消</button></div><a style="" class="bui-ext-close" role="button" href="javascript:void(&quot;关闭&quot;)" tabindex="0"><span class="bui-ext-close-x x-icon x-icon-normal cc">×</span></a></div>
</div>
<script>
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
   		$.ajax({
			type: "POST",
			url: "${ctx}/order/deposit/updateStatus",
			data: $("#ccForm").serialize(),
			dataType: "text",
			async: false,
		    success: function(data) {
		    	if(data == "1"){
		    		closePanel();
		    		if(typeof showCallback == "function"){
		   	   			showCallback();
		   	   		}
		    	}else{
		    		alert("提交失败!");
		    	}
		    }
    	});
    })
</script>
