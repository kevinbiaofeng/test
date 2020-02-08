<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>资金调整详情</title>
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
					        	<input type="text" id="name" name="name" readonly="readonly"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="userPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">存款编号：</td>
					        <td>
					        	<input type="hidden" name="depositId" id="depositId"/>
					        	<input type="text" name="depositOrderNo" id="depositOrderNo" readonly="readonly"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="depositPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
								<label id="deposit-error" class="error" style="display: none;"></label>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">提款编号：</td>
					        <td>
					        	<input type="hidden" name="withdrawalId" id="withdrawalId"/>
					        	<input type="text" name="withdrawalOrderNo" id="withdrawalOrderNo" readonly="readonly"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="withdrawalPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
								<label id="withdrawal-error" class="error" style="display: none;"></label>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">金额：</td>
					        <td>
					        	<input type="text" name="money" id="money" placeholder="加入至主平台金额"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">流水倍数：</td>
					        <td>
					        	<input type="text" name="multiple" id="multiple" value="1"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">提款积分：</td>
					        <td>
					        	<input type="text" name="integral" id="integral" placeholder="玩家提款积分=金额*倍数"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">调整类别：</td>
					        <td>
					        	<select name="changeType" id="changeType">
					        		<option value="">---请选择---</option>
					        	  	<c:forEach items="${changeTypeList}" var="changeType">
					        	  		<option value="${changeType.code}">${changeType.name}</option>
					        	  	</c:forEach>
					        	</select>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr id="actTR" style="display:none">
					        <td class="tableleft">优惠活动：</td>
					        <td>
					        	<input type="hidden" name="actId" id="actId"/>
					        	<input type="text" name="actName" id="actName" readonly="readonly" style="width: 250px;"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="actPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">选择平台：</td>
					        <td>
					        	<xjw:selectBar id="platformType" name="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" myClass="form-control-select" type="select" value="" exclude="6,10"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">备注：</td>
					        <td>
					        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5" placeholder="请填写真实说明，玩家可以看见备注信息。"></textarea>
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
	    	
	    	jQuery.validator.addMethod("actRequired", function(value, element){
	    		if($("#changeType").val() == '1' && $("#actId").val() == '' || value == ''){
					return false;
	    		}
	    		return true;
	    	}, "请选择优惠活动");
	    	
	    	$("#objForm").validate({
	 			rules: {
	 				name: {
	 					required:true
	    			},
	    			platformType: {
	 					required:true
	    			},
	    			money: {
	    				required:true,number:true
	 				},
	    			multiple: {
	    				required:true,number:true
	 				},
	 				integral: {
	 					required:true,number:true
	 				},
	 				changeType: {required: true},
	 				actName:{actRequired: true},
	 				remark: {required:true,maxlength:250}
	 			},messages:{
	 				name: {
	 					required: "会员账户为必填项"
	 				},
	 				platformType: {
	 					required: "转入平台为必填项"
	 				},
	 				money: {
	 					required: "金额为必填项",number: "金额必须为数字"
	 				},
	 				multiple: {
	 					required: "流水倍数为必填项",number: "流水倍数为数字"
	 				},
	 				integral: {
	 					required: "提款积分为必填项",number: "提款积分为数字"
	 				},
	 				changeType: {required: "调整类别为必填项"},
	 				actName:{actRequired: "请选择优惠活动"},
	 				remark: {
	 					required:"说明为必填项",
	 					maxlength:"说明不能超过250个字符"
	 				}
	 			},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	 		});
	    	bindSkipClick("backId", "${ctx}/bankroll/change/list");
	    	bindClick("save", "${ctx}/bankroll/change/save");
	    });
	    
	    //用户列表
	    $("#userPanel").click(function(){
	    	$.ajax({
				type: "POST",
				url: "${ctx}/showPanel/openDialog",
				data: {"op" : "customerList", "k" : "r", "inputId" : "userId", "inputName" : "name"},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#show").html(data);
			    	});
			    }
	    	});
	    })
	    
	    //活动列表
	    $("#actPanel").click(function(){
	    	$.ajax({
				type: "POST",
				url: "${ctx}/showPanel/openDialog",
				data: {"op" : "actList", "k" : "r", "inputId" : "actId", "inputName" : "actName"},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#show").html(data);
			    	});
			    }
	    	});
	    })
	    
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
	    
	     $("#withdrawalPanel").click(function(){
	    	var userId = $("#userId").val();
	    	if(userId == ""){
	    		$("#withdrawal-error").html("请选择一个会员账户");
	    		$("#withdrawal-error").show();
	    	}else{
	    		$.ajax({
					type: "POST",
					url: "${ctx}/showPanel/openDialog",
					data: {"op" : "withdrawalList", "k" : "r", "inputId" : "withdrawalId", "inputName" : "withdrawalOrderNo", "otherInput": $("#userId").val()},
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
	    
	    
	    
	    $("#changeType").change(function(){
	    	$("#actId").val("");
	    	$("#actName").val("");
	    	
	    	if($(this).val() == 1){
	    		$("#actTR").show()
	    	}else{
	    		$("#actTR").hide()
	    	}
	    });
	    
	    function showCallback(id , name){
	    	//回调函数，此处无用
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
