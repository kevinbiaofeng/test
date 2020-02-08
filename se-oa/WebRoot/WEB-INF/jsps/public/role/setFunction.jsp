<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>权限设置</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>权限设置</strong>
			      </div>
		
				  <form id="objForm">
				  		<input type="hidden" name="roleId" value="${role.id }"/>
					    <table class="table table-bordered">
					    	<tr>
					    		<td class="tableleft">角色名称</td>
					    		<td>${role.name }</td>
					    	</tr>
					        <tr>
					            <td class="tableleft">权限列表</td>
					            <td>
					                <c:choose>
							    		<c:when test="${not empty list }">
							    			<ul>
								    			<c:forEach var="func" items="${list }">
								    				<c:if test="${func.parentId eq 0}">
								    					<li style="margin-left:-35px;">
								    						<label style="background-color: gray; color: white; <c:if test="${func.showFlag == 2}"> background: #ffccff</c:if>">
								    							<input id="first" type="checkbox" name="functionId" value="${func.id}" <c:if test="${func.possess eq '1'}">checked</c:if> />${func.name }
								    						</label>
										                <ul>
													    <c:forEach var="funcF" items="${list }">
													    	<c:if test="${funcF.parentId eq func.id}">
													              <li>
													              	<label style="<c:if test="${funcF.showFlag == 2}">background: #ffccff</c:if>">
													              		<input type="checkbox" id="second" class="second" name="functionId" value="${funcF.id}" <c:if test="${funcF.possess eq '1'}">checked</c:if>/>${funcF.name }
													              	</label>
													              	<ul>
															        <c:forEach var="funcC" items="${list }">
															        	<c:if test="${funcC.parentId eq funcF.id}">
																        	<li>
																        	    <label style="<c:if test="${funcC.showFlag == 2}">background: #ffccff</c:if>">
																        		  <input class="third" id="third" type="checkbox"  name="functionId" value="${funcC.id}" <c:if test="${funcC.possess eq '1'}">checked</c:if>/>${funcC.name }
																        		</label>
																        			<ul>
																        			<c:forEach var="funcD" items="${list }">
																        				<c:if test="${funcD.parentId eq funcC.id}">
																        					<li>
																        					    <label style="<c:if test="${funcD.showFlag == 2}">background: #ffccff</c:if>">
																        						  <input class="third" id="fourth" type="checkbox"  name="functionId" value="${funcD.id}" <c:if test="${funcD.possess eq '1'}">checked</c:if>/>${funcD.name }
																        						</label>
																        					</li>
																        				</c:if>
																        			</c:forEach>
																        			</ul>
																        	</li>
																	    </c:if>
															        </c:forEach>
														       	 	</ul>
														       	 </li>
														     </c:if>
												        </c:forEach>
												        </ul></li>
									    			</c:if>
											   </c:forEach>
											</ul>
											<span class="error"></span>
							    		</c:when>
							    		<c:otherwise>
							    			<tr><td colspan="9" class="notdata"><spring:message code="page.text.notData" /></td></tr>
							    		</c:otherwise>
							    	</c:choose>
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
	        $(":checkbox").click(function () {
	        	if($(this).attr("id") == "first")
	            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
	        	else if($(this).attr("id") == "second"){
        			$(':checkbox', $(this).parent().parent()).prop('checked', this.checked);
        			var firstCheckObj = $(this).parent().parent().parent().parent().find("#first");
//         			if($(this).parent().parent().parent().parent().find(".second:checked").length == 0){
//         				firstCheckObj.attr('checked', false);
// 	        		}else{
	        			firstCheckObj.attr('checked', true);
// 	        		}
        			
	        	}else{
// 	        		var h = $(this).parent().parent().parent().parent().parent().parent();
// 	        		if($(this).attr("checked") == "checked"){
// 		        		h.find("#first").attr("checked", true);
// 		        		h.find("#second").attr("checked", true);
// 	        		}else{
// 	        			var count = $(this).parent().parent().parent().find(":checkbox:checked").length;
// 	        			if(count == 0){
// 	        				h.find("#first").attr("checked", false);
// 			        		h.find("#second").attr("checked", false);
// 	        			}
// 	        		}
	        	}
	        });
			
	        $("#objForm").validate({
	 			rules: {
	 				functionId: {
	 					required: true
	 				}
	 			},messages:{
	 				functionId: {
	 					required: "最少选择一项权限"
	 				}
	 			},errorPlacement:function(error, element){
               		error.appendTo(element.parent().parent().parent().parent().parent().find("span"));
                }
	 		});
	        
	        bindSkipClick("backId", "${ctx}/sysrole/list");
	    	bindClick("save", "${ctx}/sysrole/setFunctions");
	    });
	</script>
	<%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
