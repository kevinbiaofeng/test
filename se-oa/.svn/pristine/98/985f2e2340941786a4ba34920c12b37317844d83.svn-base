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
<div class="bui-dialog bui-overlay bui-ext-position x-align-cc-cc" style="width: 55%; visibility: visible; left: 15%; top: 10%; display: block;" aria-disabled="false" aria-pressed="false"><div class="bui-stdmod-header">
<div class="header-title"><c:if test="${form.status eq '0'}"><font color="red">拒绝提款提示框</font></c:if><c:if test="${form.status eq '1'}"><font color="green">同意提款提示框</font></c:if></div></div>
<div class="bui-stdmod-body" style="height: <c:if test="${userType eq '4'}">380px;</c:if><c:if test="${userType eq '3'}">330px;</c:if>">
<form id="ccForm">
	<input type="hidden" name="id" value="${form.id }"/>
	<input type="hidden" name="status" id="status" value="${form.status }"/>
	<input type="hidden" name="userType" value="${form.userType }"/>
  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
				<tr>
			        <td width="180px"><b>提款编号：</b></td>
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
			        <td><b>提款人姓名：</b></td>
			        <td>
			        	${dto.toBankAccount }
			        </td>
			    </tr>
			    <tr>
			        <td><b>提款银行：</b></td>
			        <td>
			        	<xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>提款账号：</b></td>
			        <td>
			        	${dto.toBankCard }
			        </td>
			    </tr>
			    <tr>
			        <td><b>提款金额：</b></td>
			        <td>
			        	<fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>提款时间：</b></td>
			        <td>
			        	<fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
			        </td>
			    </tr>
			    <c:if test="${form.userType eq '4' && form.status eq '1' }">
				    <tr>
				        <td><b><font color="red">*</font>出款银行：</b><br/><font color="#ccc" size="3">Transfer Bank</font></td>
				        <td>
				        	<xjw:selectBarByDB name="frombankType" id="frombankType" code="USER_BANK_TYPE" myClass="" type="select" value=""/>
				        </td>
				    </tr>
				    <tr>
				        <td><b><font color="red">*</font>出款银行账号：</b><br/><font color="#ccc" size="3">Transfer Bank Number</font></td>
				        <td>
				        	<select name="fromBankCard" id="fromBankCard"></select><font color="#ccc"></font>
				        </td>
				    </tr>
				    <tr>
				        <td><b><font color="red">*</font>提款手续费：</b><br/><font color="#ccc" size="3">Bank charges</font></td>
				        <td>
				        	<input name="poundage" type="text"/>
				        </td>
				    </tr>
			    </c:if>
			    <c:if test="${form.status eq '0' }">
			    	<c:if test="${form.userType eq '4'}">
				    	<tr>
					        <td><b><font color="red">*</font>拒绝原因：</b><br/><font color="#ccc" size="3">Reasons for refusal</font></td>
					        <td>
					        	<select id="info" name="info">
					        		<option value=''>--请选择--</option>
					        		<option>银行维护</option>
					        		<option>提款银行卡信息有误</option>
					        		<option>不支持此种银行转账</option>
					        		<option>资金存在相关问题</option>
					        	</select>
					        </td>
					    </tr>
				    </c:if>
				    <tr>
				        <td><b><font color="red">*</font>备注：</b></td>
				        <td>
				        	<textarea rows="5" cols="45" name="remark" style="width: 400px; height: 55px;" id="remark"></textarea>
				        </td>
				    </tr>
			    </c:if>
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
   	
   	$("#info").change(function(){
   		if($(this).val() != "")
   		$("#remark").val($(this).find("option:selected").text());
   	});
    
    function closePanel(){
    	BUI.Mask.unmaskElement('body');
   		$("#showPanel").hide();
   	}
   	
   	$("#confirm").click(function(){
   		$("#ccForm").validate({
 			rules: {
 				remark: {
 					maxlength: 250,
 					required:true
 				},
 				poundage: {
 					required: true,
 					digits: true
 				},
 				frombankType: {
 					required: true
 				},
 				fromBankCard: {
 					required: true
 				},
 				info: {
 					required: true
 				}
 			},messages:{
 				remark: {
 					maxlength:"备注不能超过100个字符",
 					required: "备注为必填项"
 				},
 				poundage: {
 					required: "提款手续费为必填项"
 				},
 				frombankType: {
 					required: "出款银行为必填项"
 				},
 				fromBankCard: {
 					required: "出款银行账号为必填项"
 				},
 				info: {
 					required: "拒绝原因为必填项"
 				}
 			}
 		});
   		
   		var requestUrl = "";
   		if($("#status").val() == "1"){
   			requestUrl = "${ctx}/order/withdraw/fkExamineSuccess";
   		}else{
   			requestUrl = "${ctx}/order/withdraw/fkExamineFail";
   		}
   		
   	 	if($("#ccForm").valid()){
	   	 	$.ajax({
				type: "POST",
				url: requestUrl,
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
     	}
    });
    
   	$("#frombankType").change(function(){
   		var fromBankCard = $("#fromBankCard");
   		$.ajax({
            type: "GET",
            url: "${ctx}/bank/info/getOutBankListByBankType",
            data: {"bankType" : $(this).val()},
            dataType: "json",
            success: function(data) {
            	if(data != null){
            		var code = data.code;
            		if(code == "1"){
            			fromBankCard.empty();
            			fromBankCard.append("<option value=''>--请选择--</option>");
                    	$.each(data.list, function(i, item){
                    		fromBankCard.append("<option value='" + item.id + "'>" + item.bankCardNo + "</option>");
                    	});
            		}else{
            			fromBankCard.empty();
            			fromBankCard.append("<option value=''>--NO DATA--</option>");
            		}
            		
            	}
            }
        });
    })
</script>
