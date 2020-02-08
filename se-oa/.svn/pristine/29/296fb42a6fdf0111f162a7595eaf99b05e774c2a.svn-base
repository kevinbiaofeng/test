<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			      	<strong>存款审批流程</strong>
			      </div>
		
				  <form id="objForm">
				  	<input id="aaa_row" type="hidden"/>
					<table class="table table-bordered definewidth" id="aaa_1">
					    <tr>
					        <td width="10%" class="tableleft">测试1：</td>
					        <td>
					        	<input name="userId_1" id="userId_1" type="hidden" value="100"/>
					        	<input name="userName_1" id="userName_1" type="text" class="showPanel"/>
					        </td>
					        <td class="tableleft">测试2：</td>
					        <td>
					        	<xjw:selectBar name="tradeMode_1" clazz="com.xjw.kzenum.user.order.TradeModeEnum" 
					           myClass="" type="radio" value="" id="tradeMode_1"></xjw:selectBar>
							</td>
					    </tr>
					    
					    <tr>
					        <td class="tableleft">测试3：</td>
					        <td>
								<input type="text" name="tradeAmount_1" id="tradeAmount_1"/>
							</td>
							<td class="tableleft">测试4：</td>
					        <td>
					        	<xjw:selectBarByDB name="fromBankType_1" id="fromBankType_1" code="USER_BANK_TYPE" myClass="" type="select" value=""/>
					        </td>
					    </tr>
					    
					    <tr>
					        <td class="tableleft">测试5：</td>
					        <td>
								<input type="checkbox" name="check_1" id="check_1" value="1"/> <span>aaaa</span>
								<input type="checkbox" name="check_1" id="check_1" value="2"/> <span>bbbb</span>
								<input type="checkbox" name="check_1" id="check_1" value="3"/> <span>cccc</span>
							</td>
							<td class="tableleft">测试6：</td>
					        <td>
					        	<input type="radio" name="radio_1" id="radio_1" value="1"/><span>111</span>
					        	<input type="radio" name="radio_1" id="radio_1" value="2"/><span>222</span>
3					        	<input type="radio" name="radio_1" id="radio_1" value="3"/><span>333</span>
					        </td>
					    </tr>
					    
					    <tr>
					        <td colspan="4" style="text-align: right;">
					        	<div style=" margin: 0 100px">
						            <button type="button" class="button button-success" onclick="createDataListRow('aaa', 'objForm')">添加</button> 
						            &nbsp;&nbsp;
						            <button type="button" class="button" onclick="dataListReset('objForm', 'aaa')">重置</button>
					            </div>
					        </td>
					    </tr>
					</table>
					
					<table class="table table-bordered table-hover definewidth" id="aaa">
					    <thead>
						    <tr>
						    	<th id="userId_2" style="display: none;">111</th>
						    	<th id="userName_2">测试1</th>
						    	<th id="tradeMode_2">测试2</th>
						    	<th id="tradeAmount_2">测试3</th>
						        <th id="fromBankType_2">测试4</th>
						        <th id="check_2">测试5</th>
						        <th id="radio_2">测试6</th>
						        <th width="200px">操作</th>
						    </tr>
					    </thead>
					    <tbody>
					    </tbody>
<!-- 					    <tr> -->
<!-- 					    	<td>111<input type="hidden" value="11111" name="ck"/></td> -->
<!-- 					    	<td>收款银行</td> -->
<!-- 					    	<td>银行账号</td> -->
<!-- 					        <td>账号类型</td> -->
<!-- 					    </tr> -->
<%-- 			    		<c:choose> --%>
<%-- 				    		<c:when test="${not empty page.dataList }"> --%>
<!-- 				    			<tbody> -->
<%-- 					    			<c:forEach var="bankInfo" items="${page.dataList }"> --%>
<!-- 									    	<tr> -->
<%-- 									    		<td width="20px"><input type="checkbox" value="${bankInfo.id }" name="ck"/></td> --%>
<!-- 									            <td> -->
<!-- 									            	<input type="text" name="userID"  style="border:0px;background-color:transparent;"/> -->
<!-- 										    	</td> -->
<!-- 									            <td> -->
<%-- 									            	${bankInfo.bankCardNo} --%>
<!-- 									            </td> -->
<!-- 									            <td> -->
<%-- 									            	<xjw:nameByValTagByDB type="FINAL" code="ACCOUNT_TYPE" value="${bankInfo.accountType}"/> --%>
<!-- 									            </td> -->
<!-- 									        </tr> -->
<%-- 							    	</c:forEach> --%>
<!-- 						    	</tbody> -->
<%-- 				    		</c:when> --%>
<%-- 				    		<c:otherwise> --%>
<!-- 				    			<tr><td colspan="4" class="notdata"><spring:message code="page.text.notData" /></td></tr> -->
<%-- 				    		</c:otherwise> --%>
<%-- 				    	</c:choose> --%>
				    </table>
			    </form>
			  	
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>
	  </div>
      
      <div id="panel"></div>
      <script>
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    });
	    
	    function createDataListRow(tableId, formId){
	    	var row = $("#" + tableId + "_row").val();
	    	var tableAppendTr = "";
	    	var tableRowCount = $("#" + tableId + " tr").length;
	    	var trData = "";
	    	var count = "";
	    	if(row != ""){
	    		count = row-1;
	    	}else{
	    		count = tableRowCount - 1;
	    	}
	    	
	    	var trHtmlCode = "<tr>";
	    	var colomnCount = 0;
	    	$("#" + tableId + " tr :first th").each(function () {
	    		var id = $(this).attr("id");
	    		if(id != null){
	    			var inputName = id.substring(0, id.length - 2);
		    		var input = $("#" + tableId + "_1").find("#" + inputName + "_1");
		    		
		    		var type = input.attr("type");
	    			if(type == "text"){
	    				trHtmlCode += "<td>";
	    				trHtmlCode += input.val();
	    				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + input.val() + "'/>";
	    				trHtmlCode += "</td>";
	    			}else if(type == "hidden"){
	    				trHtmlCode += "<td style='display:none'>";
	    				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + input.val() + "'/>";
	    				trHtmlCode += "</td>";
	    			}else if(type == "select"){
	    				trHtmlCode += "<td>";
	    				if(input.val() != ""){
	    					trHtmlCode += input.find("option:selected").text();
	        				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + input.val() + "'/>";
	    				}
	    				trHtmlCode += "</td>";
	    			}else if(type == "checkbox"){
	    				trHtmlCode += "<td>";
	    				var vals = [];
	    				var texts = [];
	    				var fcount = 0;
	    				
	    				$("input[name='" + inputName + "_1']:checked").each(function(){
	    					vals.push($(this).val());
	    					texts.push($(this).next().text());
	    					++fcount;
	    				});
	    				if(fcount > 0){
	    					trHtmlCode += texts;
	        				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + vals + "'/>";
	    				}
	    				
	    				trHtmlCode += "</td>";
	    			}else if(type == "radio"){
	    				trHtmlCode += "<td>";
	    				$("input[name='" + inputName + "_1']:checked").each(function(){
	    					if($(this).attr("checked") == "checked"){
	    						trHtmlCode += $(this).next().text();
	            				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + $(this).val() + "'/>";
	    						return false;
	    					}
	    				});
	    				trHtmlCode += "</td>";
	    			}
	    			++colomnCount;
	    		}
	    	});
	    	trHtmlCode += "<td><button type='button' onclick='editDataListRow(\"" + tableId + "\", \"" + (count + 1) + "\");'><i class='icon-edit'></i>编辑</button>  <button type='button' onclick='delDataListRow(\"" + tableId + "\", \"" + (count + 1) + "\");leo(\""+tableId+"\")'><i class='icon-remove-sign'></i>删除</button></td>";
	    	trHtmlCode += "</tr>";
	    	if(row != ""){
	    		delDataListRow(tableId, row);
	    		if(row == 1 && $("#" + tableId + " tbody tr").length == 0){
	    			$("#" + tableId + " tbody").append(trHtmlCode);
	    		}else if(row == 1 && $("#" + tableId + " tbody tr").length > 0){
					$("#" + tableId + " tbody tr").eq(row - 1).before(trHtmlCode);
				}else {
					$("#" + tableId + " tbody tr").eq(row - 2).after(trHtmlCode);
				}
	    	}else{
	    		$("#" + tableId + " tbody").append(trHtmlCode);
	    	}
	    	dataListReset(formId, tableId);
	    }
	    
	    function editDataListRow(tableId, i){
	    	$("#" + tableId).find("tr").eq(i).find("td").each(function () {
	    		var dataInput = $(this).find("input");
	    		var name = dataInput.attr("name");
	    		if(name != null){
	    			var inputName = name.substring(name.indexOf(".") + 1, name.length);
	    			var input = $("#" + inputName + "_1");
	    			var type = input.attr("type");
	    			if(type == "text" || type == "select"){
	    				input.val(dataInput.val());
	    			}else if(type == "radio"){
	    				$("input[name='" + inputName + "_1']").each(function(){
	    					if($(this).val() == dataInput.val()){
	    						$(this).attr("checked", true);
	    						return false;
	    					}
	    				});
	    			}else if(type == "checkbox"){
	    				var ss = dataInput.val().split(",");
	    				$("input[name='" + inputName + "_1']").each(function(){
	    					var check = $(this);
	    					check.attr("checked", false);
    						$.each(ss, function(i, k) {
    							if(check.val() == ss[i]){
    								check.attr("checked", true);
    	    						return false;
    	    					}
    			            });
	    				});
	    				
	    			}
	    			
	    		}
	    	});
	    	$("#" + tableId + "_row").val(i);
	    }
	    
	    function delDataListRow(tableId, i){
	    	var tb = document.getElementById(tableId);
	    	tb.deleteRow(i);
	    }
	    
	    function leo(tableId){
	    	$("#" + tableId).find("tr").each(function (i) {
                $(this).find("td").each(function (j) {
                	if($(this).find("input").attr("type") == "hidden"){
                		var name = $(this).find("input").attr("name");
                		$(this).find("input").attr("name", name.substring(0, name.indexOf("[")+1) + i + name.substring(name.indexOf("]"), name.length));
                	}
                	$(this).find(":button").each(function () {
                		if($(this).text() == "编辑"){
                			$(this).attr("onclick", "editDataListRow('"+tableId+"','"+(i)+"');");
                		}else if($(this).text() == "删除"){
                			$(this).attr("onclick", "delDataListRow('"+tableId+"','"+(i)+"');leo('"+tableId+"')");
                		}
                	});
                });
            });
    	}
	    
	    function dataListReset(formId, tableId){
	    	$("#" + formId)[0].reset();
	    	$("#" + formId).find("#" + tableId + "_row").val("");
	    	$("#" + formId).find("input[type='radio']").attr("checked", false);
	    	$("#" + formId).find("input[type='checkbox']").attr("checked", false);
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
