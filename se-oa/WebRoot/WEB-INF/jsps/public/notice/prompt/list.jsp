<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>中奖弹窗消息列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/notice/prompt/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">用户名：</td>
					<td>
						<input type="text" name="name" value="${form.name}"/>
					</td>
					<td class="tableleft">平台类别：</td>
					<td>
						<xjw:selectBar id="platformType" name="platformType" clazz="com.xjw.kzenum.platform.PlatformTypeEnum" 
					           myClass="" type="select" value="${form.platformType}" />
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" id="btnAdd" class="btn btn-info" ><i class="icon-white icon-plus"></i>新增</button>
			</div>
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>弹窗消息列表</strong>
		      </div>
		        	
	        	<table class="table table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="20px"><input type="checkbox" id="allck"/></th>
					    	<th width="150px">用户名</th>
					        <th>中奖金额</th>
					        <th>游戏名称</th>
					        <th>平台类型</th>
					        <th width="150px">中奖时间</th>
					        <th width="150px">创建时间</th>
					        <th width="150px">操作</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty page.dataList }">
			    			<tbody>
				    			<c:forEach var="prompt" items="${page.dataList}">
								    	<tr class="tr" id="${prompt.id}" title="双击查看详情">
								    		<td><input type="checkbox" value="${prompt.id}" name="ck"/></td>
								            <td>${prompt.name}</td>
								            <td>${prompt.amount}</td>
								            <td>${prompt.content}</td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.platform.PlatformTypeEnum" code="${prompt.platformType}"/></td>
								            <td><fmt:formatDate value="${prompt.winTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${prompt.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>
								            	<button id="btnEdit" class="btn btn-info" type="button"><i class="icon-white icon-plus"></i>编辑</button>
												<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
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
		 </form>
	  </div>
      
      <script>
      	$(function () {
			BUI.use('bui/overlay');
	    });
      
      	$("#btnAdd").click(function(){
      		window.location.href = "${ctx}/notice/prompt/new";
      	});
      	
      	$("button[id=btnEdit]").click(function(){
      		var id = $(this).parent().parent().find("input[name='ck']").val();
      		window.location.href = "${ctx}/notice/prompt/edit?id=" + id;
      	});
		
		$(".del-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认删除这条弹窗消息？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/notice/prompt/delete?id=" + id;
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