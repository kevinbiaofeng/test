<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
<style>
<!--
form {
	color: black;
}
label.error {
    background: rgba(0, 0, 0, 0) url("${statics}/img/valda_error.gif") no-repeat scroll 0 0;
    color: #ea5200;
    font-size: 12px;
    font-weight: bold;
    padding-left: 24px;
    display: inline-block;
	padding: 0 24px;
	vertical-align: middle;
}
-->
</style>
<div id="showPanel">
	<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc" style="width: 55%; visibility: visible; left: 15%; top: 10%; display: block;" aria-disabled="false" aria-pressed="false">
	<div class="bui-stdmod-header">
		<div class="header-title">复制提款内容</div>
	</div>
	<div class="bui-stdmod-body" style="height: 200px;">
	<form id="ccForm">
	  	<div class="doc-content">
	    	<div class="panel">
				<div align="left">
					<div>${dto.loginName }----withdrawal</div>
					<div>Username： ${dto.loginName }</div>
					<div>Order no (订单号)： ${dto.orderNo }</div>
					<div>Bank (银行名称)： <xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/> </div>
					<div>Account Name (取款人姓名)： ${dto.toBankAccount }</div>
					<div>Account Number (银行卡号)： ${dto.toBankCard }</div>
					<div>WD Amount (取款金额)：  <fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/></div><br/>
				</div>
		 	</div>
		 </div>
	 </form>
 	</div>
 	<a style="" class="bui-ext-close" role="button" href="javascript:void(&quot;关闭&quot;)" tabindex="0">
 		<span class="bui-ext-close-x x-icon x-icon-normal cc">×</span>
 	</a>
	</div>
</div>
<script>
   	$(".cc").click(function(){
   		closePanel();
    });
   	
    function closePanel(){
    	BUI.Mask.unmaskElement('body');
   		$("#showPanel").hide();
   	}
</script>