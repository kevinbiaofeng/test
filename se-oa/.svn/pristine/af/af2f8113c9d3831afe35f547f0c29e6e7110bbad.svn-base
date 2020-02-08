<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>${empty log.id ? '新增' : '编辑' }昨日派彩金额</strong>
			      </div>
		
				  <form id="objForm">
				  	<input type="hidden" name="id" id="id" value="${log.id}"/>
				  	
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">派彩时间：</td>
					        <td>
					        	<input type="text" id="statTime" name="statTime" value='<fmt:formatDate value="${log.statTime}" type="both" pattern="yyyy-MM-dd"/>'
					        			class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-{%d-1}'})" readonly/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">派彩金额：</td>
					        <td><input type="text" name="dayAmount" id="dayAmount" value="${log.dayAmount}"/></td>
					    </tr>

					     <tr>
					        <td class="tableleft">次日金额范围：</td>
					        <td>
					        	<input type="text" name="minAmount" id="minAmount" value="${log.minAmount}"/> -
					        	<input type="text" name="maxAmount" id="maxAmount" value="${log.maxAmount}"/>
					        
					        </td>
					    </tr>
					    
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button type="button" class="button button-primary" id="save">保存</button> 
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
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	$("#objForm").validate({
	 			rules: {
	 				statTime: {required:true, date:true},
	 				dayAmount: {required:true, number:true},
	 				minAmount: {required:true, digits:true},
	 				maxAmount: {required:true, digits:true}
	 			},messages:{
	 				statTime: {
	 					required: "派彩时间为必填项",
	 					date: "中奖时间格式 yyyy-MM-dd"
	 				}, dayAmount: {
	 					required: "派彩总额为必填项",
	 					number:"派彩总额只能为数字"
	 				}, minAmount: {
	 					required: "次日金额范围-最小值为必填项",
	 					digits:"次日金额范围-最小值只能为整数"
	 				},maxAmount: {
	 					required: "次日金额范围-最大值为必填项",
	 					digits:"次日金额范围-最大值只能为整数"
	 				}
	 			}
 			});
	    	
	    	bindSkipClick("backId", "${ctx}/yestdayamountlog/list");
	    	bindClick("save", "${ctx}/yestdayamountlog/save");
	    });
	    
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
