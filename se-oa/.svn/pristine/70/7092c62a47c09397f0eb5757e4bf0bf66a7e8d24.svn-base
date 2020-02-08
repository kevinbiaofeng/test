<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>红包详情</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	
	<script type="text/javascript" src="${statics }/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="${statics }/js/kindeditor/prettify.js"></script>
	<script type="text/javascript" src="${statics }/js/kindeditor/zh_CN.js"></script>
	<script type="text/javascript" src="${statics }/js/uploadPreview.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${statics }/css/kindeditor/prettify.css" />
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>
	        				新增红包
			        	</strong>
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
					    <tr id="actTR">
					        <td class="tableleft">优惠活动：</td>
					        <td>
					        	<input type="hidden" name="actId" id="actId"/>
					        	<input type="text" name="actName" id="actName" readonly="readonly" style="width: 250px;"/>
					        	<img src="${statics }/img/b_cng1_8.gif" id="actPanel" class="imgShowPanel"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr id="actTR">
					        <td class="tableleft">红包金额：</td>
					        <td>
					        	<input type="text" name="money" id="money"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button class="button button-primary" type="button" id="save">保存</button> 
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
	    	BUI.use(['bui/mask']);
	    	bindSkipClick("backId", "${ctx}/redbonus/info/list");
	    	bindClick("save", "${ctx}/redbonus/info/save");
	    	
	    	$("#objForm").validate({
	    		rules: {
	    			name: {
	    				required:true
	    			},
	    			actName: {
	    				required:true
	    			},
	    			money: {
	    				required:true, maxlength:10, number:true
	    			}
	    		},messages:{
	    			name: {
	    				required:"会员账户为必填项"
	    			},
	    			actName: {
	    				required:"优惠活动为必填项"
	    			},
	    			money: {
	    				required:"红包金额为必填项",maxlength:"红包金额不能超过5个字符",number:"红包金额必须为数字"
	    			}
	    		},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	    	});
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
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
