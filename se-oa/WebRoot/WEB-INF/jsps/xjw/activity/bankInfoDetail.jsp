<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>
	        				新增
			        	</strong>
			      </div>
		
				  <form id="objForm">
				  	<input type="hidden" name="type" value="${form.type }"/>
				  	<input type="hidden" name="isDefault" value="2"/>
				  	<input type="hidden" name="status" value="2"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">银行类型：</td>
					        <td>
					        	<xjw:selectBarByDB name="bankType" code="USER_BANK_TYPE" myClass="" type="select" value="${userBankInfoForm.bankType }"/>
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">账户名：</td>
					        <td><input type="text" name="accountName"/></td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">银行卡号：</td>
					        <td><input type="text" name="bankCardNo"/></td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">银行地址：</td>
					        <td><input type="text" name="bankAddress"/></td>
					    </tr>
<!-- 					    <tr> -->
<!-- 					        <td class="tableleft">状态：</td> -->
<!-- 					        <td> -->
<%-- 					        	<xjw:selectBar name="status" clazz="com.xjw.kzenum.activity.UserBankInfoStatusEnum" myClass="" type="radio" value="1" exclude="3"></xjw:selectBar> --%>
<!-- 					        </td> -->
<!-- 					    </tr> -->
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
      
      <script>
      var datas;
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	
	    	$("#objForm").validate({
	 			rules: {
	 				bankType: {
	 					required:true
	    			},
	    			accountName: {
	 					required:true,maxlength:5
	 				},
	 				bankCardNo: {
	 					required:true,maxlength:25
	 				},
	 				bankAddress: {
	 					required:true,maxlength:50
	 				}
	 			},messages:{
	 				bankType: {
	 					required: "银行类型为必填项"
	 				},
	 				accountName: {
	 					required: "账户名为必填项",
	 					maxlength: "账户名不能超过5个字符"
	 				},
	 				bankCardNo: {
	 					required: "银行卡号为必填项",
	 					maxlength:"银行卡号不能超过25个字符"
	 				},
	 				bankAddress: {
	 					required: "银行地址为必填项",
	 					maxlength:"银行地址不能超过50个字符"
	 				}
	 			}
	 		});
	    	bindSkipClick("backId", "${ctx}/bank/info/list");
	    	bindClick("save", "${ctx}/bank/info/save");
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
