<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>账户资金调整</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/bankroll/change/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号：</td>
					<td><input type="text" name="loginName" id="loginName" value="${form.loginName }" maxlength="15"/></td>
					<td class="tableleft">时间段：</td>
					<td>
						<input type="text" name="beginTime" value="${form.beginTime }" id="beginTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" value="${form.endTime }" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
				<tr>
					<td class="tableleft">平台类型：</td>
					<td>
						<xjw:selectBar name="platformType" id="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" myClass="" type="select" value="${form.platformType }" exclude="6,10"/>
					</td>
					<td class="tableleft">调整类型：</td>
					<td>
						<select name="changeType">
							<option value="">---所有---</option>
							<c:forEach items="${changeTypeList}" var="ct">
								<option value="${ct.code}" <c:if test="${ct.code==form.changeType}">selected</c:if>>
									${ct.name}
								</option>
							</c:forEach>
						</select>
					</td>
					<td class="tableleft">优惠活动ID：</td>
					<td><input type="text" name="actId" id="actId" value="${form.actId}"/></td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<xjw:auth code="YWGL-HYGL-ZHZJJJFTZ-XZ">
					<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增</button>
				</xjw:auth>
			</div>
		</form>
		
	
	  	<div class="doc-content">
		 	<div class="panel">
		      <div class="panel-header">
		        	<strong>账户资金调整</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>会员账号</th>
					        <th>调整金额</th>
					        <th>流水倍数</th>
					        <th>提款积分</th>
					        <th>调整类别</th>
					        <th>活动ID</th>
					        <th>活动平台</th>
					        <th>存款编号</th>
					        <th>备注</th>
					        <th>操作人</th>
					        <th>创建时间</th>
					        <th>开始时间</th>
					        <th>结束时间</th>
					        <th>状态</th>
					    </tr>
				    </thead>
				    
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td id="userName">${dto.userName}</td>
								            <td style="color:<c:if test="${dto.money < 0}">red</c:if><c:if test="${dto.money > 0}">green</c:if>">
							            		<fmt:formatNumber value="${dto.money }" type="currency" pattern="#.##"/>
								            </td>
								            <td>${dto.multiple }</td>
								            <td><fmt:formatNumber value="${dto.integral }" type="currency" pattern="#.##"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.user.MemberMoneyChangeTypeEnum" code="${dto.changeType}"/></td>
								            <td>${dto.actId}</td>
								            <td id="platformTypeName"><xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${dto.platformType}"/></td>
								            <td>${dto.depositOrderNo }</td>
								            <td title="${dto.remark }"><xjw:subStringTag input="${dto.remark}" replace="......" size="20"></xjw:subStringTag></td>
								            <td>${dto.createUserName }</td>
								            <td><fmt:formatDate value="${dto.createTime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td><fmt:formatDate value="${dto.startTime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td><fmt:formatDate value="${dto.endTime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
								            <td>
								            	<input type="hidden" name="ck" value="${dto.id }"/>
								            	<input type="hidden" name="platformType" value="${dto.platformType}"/>
								            	<input type="hidden" name="userId" value="${dto.userId }"/>
								            	<c:if test="${empty dto.startTime && not empty dto.actId && dto.actType eq '2'}">
								            		<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>开启转账限制</button>
								            	</c:if>
								            	<c:if test="${empty dto.endTime && not empty dto.actId && not empty dto.startTime && dto.actType eq '2'}">
								            		<button type="button" class="btn btn-danger close-but"><i class="icon-white icon-remove-sign"></i>关闭转账限制</button>
								            	</c:if>
								            </td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="13" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			  </table>
		 	</div>
		 	
		 	<div class='bui-grid'>
			  	<div class='bui-grid-bbar'>
	    		  <c:if test="${not empty page.dataList }">
	   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
				  </c:if>
			  	</div>
			  </div>
		 </div>
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/bankroll/change/skipAdd");
	    });
	    
	    $(".start-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
	    	var userId = $(this).parent().find("input[name='userId']").val();
	    	var userName = $(this).parent().parent().find("#userName").text();
	    	var platformType = $(this).parent().find("input[name='platformType']").val();
	    	var platformTypeName = $(this).parent().parent().find("#platformTypeName").text();
	    	
	    	$.ajax({
				type: "get",
				url: "${ctx}/platform/" + platformType + "/balance",
				data: {"userId" : userId},
				async: false,
				dataType:"json",
			    success: function(data) {
			    	var balance;
			    	if(data.agGJ != null){
			    		balance = data.agGJ;
			    	}else if(data.agJS != null){
			    		balance = data.agJS;
			    	}else if(data.pt != null){
			    		balance = data.pt;
			    	}else if(data.mg != null){
			    		balance = data.mg;
			    	}else if(data.sb != null){
			    		balance = data.sb;
			    	}else if(data.qp != null){
			    		balance = data.qp;
			    	}
			    	BUI.Message.Show({
						 msg : '是否开启活动转账限制，用户:'+userName+'游戏平台：'+platformTypeName+'游戏平台余额：' + balance + '元',
						 icon : 'question',
						 buttons : [{
						 text:'是',
						 elCls : 'button button-primary',
						 handler : function(){
							 window.location.href = "${ctx}/bankroll/change/start?id=" + id;
							 this.close();
						 }},{
						 text:'否',
						 elCls : 'button',
						 handler : function(){
							 this.close();
						 }} ]
					});
			    	
			    }
	    	});
		});
	    
	    
	    $(".close-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
	    	var userId = $(this).parent().find("input[name='userId']").val();
	    	var userName = $(this).parent().parent().find("#userName").text();
	    	var platformType = $(this).parent().find("input[name='platformType']").val();
	    	var platformTypeName = $(this).parent().parent().find("#platformTypeName").text();
	    	$.ajax({
				type: "get",
				url: "${ctx}/platform/" + platformType + "/balance",
                data: {"userId" : userId},
				async: false,
				dataType:"json",
			    success: function(data) {
			    	var balance;
			    	if(data.agGJ != null){
			    		balance = data.agGJ;
			    	}else if(data.agJS != null){
			    		balance = data.agJS;
			    	}else if(data.pt != null){
			    		balance = data.pt;
			    	}else if(data.mg != null){
			    		balance = data.mg;
			    	}else if(data.sb != null){
			    		balance = data.sb;
			    	}else if(data.qp != null){
			    		balance = data.qp;
			    	}
			    	BUI.Message.Show({
						 msg : '活动正在进行中，是否确定关闭用户:' + userName + '的转账限制？'+platformTypeName+'游戏平台账户余额：' + balance + '元',
						 icon : 'question',
						 buttons : [{
						 text:'是',
						 elCls : 'button button-primary',
						 handler : function(){
							 window.location.href = "${ctx}/bankroll/change/close?id=" + id;
							 this.close();
						 }},{
						 text:'否',
						 elCls : 'button',
						 handler : function(){
							 this.close();
						 }} ]
					});
			    	
			    }
	    	});
			
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>