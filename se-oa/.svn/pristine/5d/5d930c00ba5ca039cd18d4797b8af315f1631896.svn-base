<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>存款订单详情</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<style type="text/css">
		input[type="text"], input[type="password"], input[type="email"] {
		    width: 170px;
		}
		
		select {
		    width: 182px;
		}
	</style>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>新增</strong>
			      </div>
		
				  <form id="objForm" method="post">
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">会员账户：</td>
					        <td>
					        	<input type="hidden" name="userId" id="userId"/>
					        	<input type="text" id="loginName" name="loginName" readonly="readonly"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="userPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <%-- <tr>
					        <td class="tableleft">存款编号：</td>
					        <td>
					        	<input type="hidden" name="depositId" id="depositId"/>
					        	<input type="text" name="orderNo" id="orderNo" />
					        	<img src="${statics }/img/b_cng1_8.gif" id="depositPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
								<label id="deposit-error" class="error" style="display: none;"></label>
					        </td>
					    </tr> --%>
					    <tr>
					        <td class="tableleft">存款人名称：</td>
					        <td>
					        	<input type="text" name="fromBankAccount" id="fromBankAccount" readonly="readonly"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="depositUserNamePanel" class="imgShowPanel"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">存款金额：</td>
					        <td>
					        	<input type="text" name="tradeAmount" id="tradeAmount" placeholder="0.0"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <!-- <tr>
					        <td class="tableleft">存款时间：</td>
					        <td>
					        	<input type="text" name="createTime" id="createTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'createTime\')||\'2020-10-01\'}'})"/>
					        	<span class="error"></span>
					        </td>
					    </tr> -->
					    <tr>
					        <td class="tableleft">存款类型：</td>
					        <td>
					        	<xjw:selectBar name="tradeMode" myClass="" clazz="com.xjw.kzenum.order.BackgroundDepositEnum" type="select" value="${form.tradeMode }"></xjw:selectBar>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button class="button button-primary" type="button" id="save">确定</button> 
					            &nbsp;&nbsp;
					            <button type="button" class="button" id="backId">返回列表</button>
					        </td>
					    </tr>
					</table>
			    </form>
			  
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	  </div>
	  
      <div id="show"></div>
      <script>
	    $(function () {
	    	BUI.use('bui/overlay');
	    	
	    	$("#objForm").validate({
	 			rules: {
	 				loginName: {
	 					required:true
	    			},
	    			orderNo: {
	 					required:true
	    			},
	    			fromBankAccount:{
	    				required:true
	    			},
	    			tradeAmount: {
	    				required:true,number:true
	 				},
	 				tradeMode: {required: true}
	 			},messages:{
	 				loginName: {
	 					required: "会员账户为必填项"
	 				},
	 				orderNo: {
	 					required: "存款编号为必填项"
	 				},
	 				fromBankAccount: {
	 					required: "存款人名称为必填项"
	 				},
	 				tradeAmount: {
	 					required: "存款金额为必填项",number: "存款金额必须为数字"
	 				},
	 				tradeMode: {required: "存款类型为必填项"}
	 			},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	 		});
	    	bindSkipClick("backId", "${ctx}/order/deposit/list");
	    	bindClick("save", "${ctx}/order/deposit/save");
	    });
	    
	    //用户列表
	    $("#userPanel").click(function(){
	    	$.ajax({
				type: "POST",
				url: "${ctx}/showPanel/openDialog",
				data: {"op" : "customerList", "k" : "r", "inputId" : "userId", "inputName" : "loginName"},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#show").html(data);
			    	});
			    }
	    	});
	    })
	    
	    //存款编号
	    $("#depositPanel").click(function(){
	    	var userId = $("#userId").val();
	    	if(userId == ""){
	    		$("#deposit-error").html("请选择一个会员账户");
	    		$("#deposit-error").show();
	    	}else{
	    		$.ajax({
					type: "POST",
					url: "${ctx}/showPanel/openDialog",
					data: {"op" : "depositList", "k" : "r", "inputId" : "depositId", "inputName" : "depositOrderNo", "otherInput": $("#userId").val()},
					async: false,
				    success: function(data) {
				    	BUI.use(['bui/mask'],function(Mask){
				    		 Mask.maskElement('body');
				    		 $("#show").html(data);
				    	});
				    }
		    	});
	    	}
	    })
	    
	    //存款人名称
	    $("#depositUserNamePanel").click(function(){
	    	var userId = $("#userId").val();
	    	if(userId == ""){
	    		$("#deposit-error").html("请选择一个存款人名称");
	    		$("#deposit-error").show();
	    	}else{
	    		$.ajax({
					type: "POST",
					url: "${ctx}/showPanel/openDialog",
					data: {"op" : "depositUserName", "k" : "r",  "inputName" : "fromBankAccount", "otherInput": userId},
					async: false,
				    success: function(data) {
				    	BUI.use(['bui/mask'],function(Mask){
				    		 Mask.maskElement('body');
				    		 $("#show").html(data);
				    	});
				    }
		    	});
	    	}
	    })
	    
	    function showCallback(id , name){
	    	//回调函数，此处无用
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>