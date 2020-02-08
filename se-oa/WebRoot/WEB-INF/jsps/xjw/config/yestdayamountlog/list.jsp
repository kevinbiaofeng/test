<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>中奖弹窗消息列表</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/yestdayamountlog/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">派彩时间：</td>
					<td>
						<input type="text" id="beginStatTime" name="beginStatTime" class="datepicker" value='<fmt:formatDate value="${form.beginStatTime}" type="both" pattern="yyyy-MM-dd"/>' 
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'#F{$dp.$D(\'endStatTime\')}'})" readonly/>
						-
						<input type="text" id="endStatTime" name="endStatTime" class="datepicker" value='<fmt:formatDate value="${form.endStatTime}" type="both" pattern="yyyy-MM-dd"/>' 
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'beginStatTime\')}'})" readonly/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" id="btnAdd" class="btn btn-info" ><i class="icon-white icon-plus"></i>新增</button>
			</div>
		</form>			
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>派彩记录</strong>
		      </div>
		        	
	        	<table class="table table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="20px"><input type="checkbox" id="allck"/></th>
					    	<th width="150px">派彩时间</th>
					        <th>派彩金额</th>
					        <th>次日金额范围</th>
					        <th width="150px">创建时间</th>
					        <th width="150px">操作</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty page.dataList}">
			    			<tbody>
				    			<c:forEach items="${page.dataList}" var="log" >
								    	<tr class="tr" id="${log.id}" title="双击查看详情">
								    		<td><input type="checkbox" value="${log.id}" name="ck"/></td>
								    		<td><fmt:formatDate value="${log.statTime}" type="both" pattern="yyyy-MM-dd"/></td>
								            <td>${log.dayAmount}</td>
								            <td>${log.minAmount} - ${log.maxAmount}</td>
								            <td><fmt:formatDate value="${log.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<button id="btnEdit" class="btn btn-info" type="button"><i class="icon-white icon-plus"></i>编辑</button>
								            	<button id="btnDelete" class="btn btn-danger remove-but" type="button"><i class="icon-white icon-remove-sign"></i>删除</button>
								            </td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
			    		</c:when>
			    		<c:otherwise>
			    			<tr><td colspan="7" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			      </table>
			      
			      <div class='bui-grid'><div class='bui-grid-bbar'>
		    		  <c:if test="${not empty page.dataList }">
		   				<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
					  </c:if>
				  </div></div>
		 	</div>
		 </div>
	  </div>
      
      <script>
      	$(function () {
			BUI.use('bui/overlay');
	    });
      
      	$("#btnAdd").click(function(){
      		window.location.href = "${ctx}/yestdayamountlog/new";
      	});
      	
      	$("button[id=btnEdit]").click(function(){
      		var id = $(this).parent().parent().find("input[name='ck']").val();
      		window.location.href = "${ctx}/yestdayamountlog/edit?id=" + id;
      	});
      	
      	$("button[id=btnDelete]").click(function(){
      		var id = $(this).parent().parent().find("input[name='ck']").val();

      		BUI.Message.Show({
				 msg : '是否确定删除该记录？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/yestdayamountlog/delete?id=" + id;
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