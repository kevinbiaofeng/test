<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>备注列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/member/remark/list" method="post">
			<input type="hidden" id="userId" name="userId" value="${form.userId }"/>
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						类别：
					</td>
					<td>
						<xjw:selectBar name="titleType" clazz="com.xjw.kzenum.user.RemarkTitleTypeEnum" myClass="" type="select" value="${form.titleType }" id="titleType"/>
					</td>
					<td class="tableleft">
						内容：
					</td>
					<td><input type="text" name="remark" value="${form.remark }" maxlength="15"/></td>
					<td class="tableleft">时间：</td>
					<td>
						<input type="text" name="beginTime" id="beginTime" class="datepicker" value="${form.beginTime }" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
						一
						<input type="text" name="endTime" id="endTime" class="datepicker" value="${form.endTime }" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-inverse" id="backId"><i class="icon-white icon-home"></i>返回用户详情</button>
			</div>
		</form>
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>备注列表</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>类别</th>
					        <th>内容</th>
					        <th>时间</th>
					        <th>操作</th>
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty page.dataList }">
			    			<tbody>
			    				<c:forEach var="dto" items="${page.dataList }">
								    	<tr>
								    		<td>
								    			<xjw:enumBar clazz="com.xjw.kzenum.user.RemarkTitleTypeEnum" code="${dto.titleType }"/>
								    		</td>
								            <td title="${dto.remark }"><xjw:subStringTag input="${dto.remark}" replace="......" size="20"></xjw:subStringTag></td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<input type="hidden" name="ck" value="${dto.id }"/>
								            	<c:choose>
								            		<c:when test="${dto.status eq '1'}">
								            			<button type="button" class="btn btn-success up-but"><i class="icon-white icon-arrow-up"></i>置顶</button>
								            		</c:when>
								            		<c:otherwise>
								            			<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove"></i>取消置顶</button>
								            		</c:otherwise>
								            	</c:choose>
								            </td>
								        </tr>
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
		 
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("backId", "${ctx}/member/info/detail?id=${form.userId }");
	    });
		
		$(".up-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认该条置顶？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/member/remark/up?id=" + id + "&userId=" + $("#userId").val();
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
		
		$(".down-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认该条取消置顶？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/member/remark/dowm?id=" + id + "&userId=" + $("#userId").val();
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>