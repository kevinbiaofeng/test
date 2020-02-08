<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>存款订单</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/order/deposit/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						会员账号：
					</td>
					<td><input type="text" name="keywords" value="${form.keywords }" maxlength="20"/></td>
					<td class="tableleft">
						存款编号：
					</td>
					<td><input type="text" name="orderNo" value="${form.orderNo }" maxlength="25"/></td>
				</tr>
				<tr>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" value="${form.beginTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" value="${form.endTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">
						存款类型：
					</td>
					<td>
						<xjw:selectBar name="tradeMode" myClass="" clazz="com.xjw.kzenum.order.TradeModeEnum" type="select" value="${form.tradeMode }"></xjw:selectBar>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增</button>
			</div>
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>存款订单列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th>存款编号</th>
					        <th>会员账号</th>
					        <th>存款人姓名</th>
					        <th>存款金额</th>
					        <th>存款时间</th>
					        <th>存款类型</th>
					        <th>存入银行</th>
					        <th>账户姓名</th>
					        <th>存入账号</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td>${dto.orderNo }</td>
								    		<td>${dto.loginName }</td>
								            <td>${dto.fromBankAccount}</td>
								            <td><fmt:formatNumber value="${dto.tradeAmount }" type="currency" pattern="#.##"/></td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}" /></td>
								            <td>
							            		<xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE" value="${dto.toBankType }"/>
								            </td>
								            <td>${dto.toBankAccount }</td>
								            <td>
								            	<c:choose>
								            		<c:when test="${dto.toBankCard eq 'tiantianlee123@gmail.com' }">
								            			6212262008016966740
								            		</c:when>
								            		<c:otherwise>
								            			<xjw:subStringTag input="${dto.toBankCard }" replace="****" type="" size="7"/>
								            		</c:otherwise>
								            	</c:choose>
								            </td>
								            <td>
								            	<input type="hidden" name="ck" value="${dto.id }"/>
								            	<xjw:auth code="YWGL-ZJGL-CKDDTJ-TY">
													<button type="button" class="btn btn-success yes-but"><i class="icon-white icon-ok"></i>同意</button>
												</xjw:auth>
												<%-- <xjw:auth code="YWGL-ZJGL-CKDDTJ-JJ">
													<button type="button" class="btn btn-danger no-but"><i class="icon-white icon-remove"></i>拒绝</button>
												</xjw:auth> --%>
								            </td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="11" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/order/deposit/skipAdd");
	    });
	    
	    $(".yes-but").click(function(){
	    	var id = $(this).parent().find("input[name='ck']").val();
	    	$.ajax({
				type: "GET",
				url: "${ctx}/order/deposit/showDepositOrderPanel",
				data: {"status" : "success", "id" : id},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#show").html(data);
			    	});
			    }
	    	});
	    });
	    
	    $(".no-but").click(function(){
	    	var id = $(this).parent().find("input[name='ck']").val();
	    	$.ajax({
				type: "GET",
				url: "${ctx}/order/deposit/showDepositOrderPanel",
				data: {"status" : "fail", "id" : id},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#show").html(data);
			    	});
			    }
	    	});
	    });
	    
	    function showCallback(){
	    	window.location.href="${ctx}/order/deposit/list";
	    }
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>