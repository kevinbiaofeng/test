<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>提款订单</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/order/withdraw/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						会员账号：
					</td>
					<td><input type="text" name="keywords" value="${form.keywords }" maxlength="20"/></td>
					<td class="tableleft">
						提款编号：
					</td>
					<td><input type="text" name="orderNo" value="${form.orderNo }" maxlength="25"/></td>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>提款订单列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>提款编号</th>
					        <th>会员账号</th>
					        <th>提款人姓名</th>
					        <th>提款银行</th>
					        <th>提款银行账号</th>
					        <th>分支行地址</th>
					        <th>提款金额</th>
					        <th>提款时间</th>
					        <th>状态</th>
				        	<th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
			    					<c:choose>
			    						<c:when test="${((user.type eq '5' || user.type eq '3') && empty dto.riskUser)}">
			    							<tr>
									    		<td>${dto.orderNo}</td>
									    		<td>
									    			<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX">
									    				<c:if test="${dto.drawalCount != 0}">
										    				${dto.loginName}
										    			</c:if>
										    			<c:if test="${dto.drawalCount == 0}">
										    				<a href="javascript:;" class="jq-show-info" data-userid="${dto.userId}">${dto.loginName}</a>
										    			</c:if>
									    			</xjw:auth>
									    			<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX" isHave="false">
									    				${dto.loginName}
									    			</xjw:auth>
									    		</td>
									            <td>${dto.toBankAccount}</td>
									            <td><xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/></td>
									            <td>${dto.toBankCard}</td>
									            <td>${dto.toBankAddress}</td>
									            <td><fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/></td>
									            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td>
									            	<c:if test="${empty dto.riskUser }">
									            		风控审核中
									            	</c:if>
									            </td>
									            <td>
									            	<input type="hidden" name="fkId" value="${dto.id }"/>
									            	<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-TY">
														<button type="button" class="btn btn-success fk-yes-but"><i class="icon-white icon-ok"></i>风控同意</button>
													</xjw:auth>
													<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-JJ">
														<button type="button" class="btn btn-danger fk-no-but"><i class="icon-white icon-remove"></i>风控拒绝</button>
													</xjw:auth>
													<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-CP">
														<button type="button" class="btn btn-success fk-copy"><i class="icon-white"></i>复制</button>
													</xjw:auth>
									            </td>
									        </tr>
			    						</c:when>
			    						<c:when test="${(user.type eq '4' && not empty dto.riskUser)}">
			    							<tr>
									    		<td>${dto.orderNo }</td>
									    		<td>
										    		<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX">
										    			<c:if test="${dto.drawalCount != 0}">
										    				${dto.loginName}
										    			</c:if>
										    			<c:if test="${dto.drawalCount == 0}">
										    				<a href="javascript:;" class="jq-show-info" data-userid="${dto.userId}">${dto.loginName}</a>
										    			</c:if>
									    			</xjw:auth>
									    			<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX" isHave="false">
									    				${dto.loginName}
									    			</xjw:auth>
								    			</td>
									            <td>${dto.toBankAccount}</td>
									            <td><xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/></td>
									            <td>${dto.toBankCard}</td>
									            <td>${dto.toBankAddress}</td>
									            <td><fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/></td>
									            <td>
									            	<fmt:formatDate value="${dto.riskTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
									            </td>
									            <td>
									            	<c:if test="${not empty dto.riskUser}">
									            		财务出款中
									            	</c:if>
									            </td>
									            <td>
									            	<input type="hidden" name="cwId" value="${dto.id }"/>
									            	<xjw:auth code="YWGL-ZJGL-TKDDTJ-CW-TY">
														<button type="button" class="btn btn-success cw-yes-but"><i class="icon-white icon-ok"></i>财务同意</button>
													</xjw:auth>
													<xjw:auth code="YWGL-ZJGL-TKDDTJ-CW-JJ">
														<button type="button" class="btn btn-danger cw-no-but"><i class="icon-white icon-remove"></i>财务拒绝</button>
													</xjw:auth>
									            </td>
									        </tr>
			    						</c:when>
			    						<c:otherwise>
			    							<c:if test="${user.type eq '1'}">
				    							<tr>
										    		<td>${dto.orderNo }</td>
										    		<td>
											    		<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX">
										    				<c:if test="${dto.drawalCount != 0}">
											    				${dto.loginName}
											    			</c:if>
											    			<c:if test="${dto.drawalCount == 0}">
											    				<a href="javascript:;" class="jq-show-info" data-userid="${dto.userId}">${dto.loginName}</a>
											    			</c:if>
										    			</xjw:auth>
										    			<xjw:auth code="YWGL-ZJGL-TKDDTJ-TCHYXX" isHave="false">
										    				${dto.loginName}
										    			</xjw:auth>
									    			</td>
										            <td>${dto.toBankAccount}</td>
										            <td><xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/></td>
										            <td>${dto.toBankCard}</td>
										            <td>${dto.toBankAddress}</td>
										            <td><fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/></td>
										            <td>
										            	<c:if test="${empty dto.riskUser}">
										            		<fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
										            	</c:if>
										            	<c:if test="${not empty dto.riskUser}">
										            		<fmt:formatDate value="${dto.riskTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
										            	</c:if>
										            </td>
										            <td>
										            	<c:if test="${empty dto.riskUser}">
										            		风控审核中
										            	</c:if>
										            	<c:if test="${not empty dto.riskUser}">
										            		财务出款中
										            	</c:if>
										            </td>
										            <td>
											            <c:if test="${empty dto.riskUser}">
											            	<input type="hidden" name="fkId" value="${dto.id }"/>
											            	<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-TY">
																<button type="button" class="btn btn-success fk-yes-but"><i class="icon-white icon-ok"></i>风控同意</button>
															</xjw:auth>
															<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-JJ">
																<button type="button" class="btn btn-danger fk-no-but"><i class="icon-white icon-remove"></i>风控拒绝</button>
															</xjw:auth>
															<xjw:auth code="YWGL-ZJGL-TKDDTJ-FK-CP">
																<button type="button" class="btn btn-success fk-copy"><i class="icon-white"></i>复制</button>
															</xjw:auth>
											            </c:if>
											            <c:if test="${not empty dto.riskUser}">
											            	<input type="hidden" name="cwId" value="${dto.id }"/>
											            	<xjw:auth code="YWGL-ZJGL-TKDDTJ-CW-TY">
																<button type="button" class="btn btn-success cw-yes-but"><i class="icon-white icon-ok"></i>财务同意</button>
															</xjw:auth>
															<xjw:auth code="YWGL-ZJGL-TKDDTJ-CW-JJ">
																<button type="button" class="btn btn-danger cw-no-but"><i class="icon-white icon-remove"></i>财务拒绝</button>
															</xjw:auth>
											            </c:if>
										            </td>
										        </tr>
									        </c:if>
			    						</c:otherwise>
			    					</c:choose>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			  </table>
			      
			  <div class='bui-grid'>
			  	<div class='bui-grid-bbar'>
	    		  <c:if test="${not empty page.dataList }">
	   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  </c:if>
			  	</div>
			  </div>
			      
		 	</div>
		 </div>
		 
		 
		 </form>
	  </div>
	  
      <div id="show"></div>
      <script>
	    $(function () {
	    	BUI.use(['bui/overlay','bui/mask'],function(Overlay){
	    		 // 显示用户详细信息
	    	    $("a.jq-show-info").click(function(){
	    			var userId = $(this).data("userid"); 
	    	    	var dialog = new Overlay.Dialog({
	    	    		closeAction: 'destroy', 
	    				title:'会员详细信息',
	    				width:400,
	    				height:300,
	    				loader : {
	    					url : '/member/info/showInfo',
	    		            params : {userId: userId},//附加的参数
	    		            autoLoad : false, //不自动加载
	    		            lazyLoad : false, //不延迟加载
	    				},
	    				success: function(){}
	    			});
	    	    	
	    	    	dialog.show();
	    	    	dialog.get('loader').load();
	    	    });
	    	});
	    });
	    
	    //**********************风控方法
	    $(".fk-yes-but").click(function() {
			var id = $(this).parent().find("input[name='fkId']").val();
			$.ajax({
				type: "GET",
				url: "${ctx}/order/withdraw/showDepositOrderPanel",
				data: {"id" : id, "status" : "1", "userType" : "3"},
				async: false,
			    success: function(data) {
			    	BUI.Mask.maskElement('body');
	    		    $("#show").html(data);
			    }
	    	});
		});
	    
	    $(".fk-no-but").click(function(){
	    	var id = $(this).parent().find("input[name='fkId']").val();
	    	$.ajax({
				type: "GET",
				url: "${ctx}/order/withdraw/showDepositOrderPanel",
				data: {"id" : id, "status" : "0", "userType" : "3"},
				async: false,
			    success: function(data) {
			    	BUI.Mask.maskElement('body');
	    		    $("#show").html(data);
			    }
	    	});
	    });
	    
	    $(".fk-copy").click(function(){//复制提款信息显示
	    	var id = $(this).parent().find("input[name='fkId']").val();
	    	$.ajax({
				type: "GET",
				url: "${ctx}/order/withdraw/showDepositOrderCopy",
				data: {"id" : id, "status" : "0", "userType" : "3"},
				async: false,
			    success: function(data) {
			    	BUI.Mask.maskElement('body');
	    		    $("#show").html(data);
			    }
	    	});
	    });
	    
	    //**********************财务方法
	    $(".cw-yes-but").click(function() {
			var id = $(this).parent().find("input[name='cwId']").val();
			$.ajax({
				type: "GET",
				url: "${ctx}/order/withdraw/showDepositOrderPanel",
				data: {"id" : id, "status" : "1", "userType" : "4"},
				async: false,
			    success: function(data) {
			    	BUI.Mask.maskElement('body');
	    		    $("#show").html(data);
			    }
	    	});
		});
	    
	    $(".cw-no-but").click(function(){
	    	var id = $(this).parent().find("input[name='cwId']").val();
	    	$.ajax({
				type: "GET",
				url: "${ctx}/order/withdraw/showDepositOrderPanel",
				data: {"id" : id, "status" : "0", "userType" : "4"},
				async: false,
			    success: function(data) {
			    	BUI.Mask.maskElement('body');
	    		    $("#show").html(data);
			    }
	    	});
	    });
	    
	    function showCallback(){
	    	window.location.href = "${ctx}/order/withdraw/list";
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>