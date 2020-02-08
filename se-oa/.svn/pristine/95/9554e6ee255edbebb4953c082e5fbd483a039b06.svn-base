<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>系统消息列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/sysmsg/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">所属功能：</td>
					<td>
						<xjw:selectBar name="functionCode" clazz="com.xjw.kzenum.notice.NoticeCodeEnum" 
					           myClass="" type="select" value="${form.functionCode }" id="functionCode"></xjw:selectBar>
					</td>
					<td class="tableleft">是否已读：</td>
					<td>
						<xjw:selectBar name="isRead" clazz="com.xjw.kzenum.sys.YesORNoEnum" 
					           myClass="" type="select" value="${form.isRead }" id="isRead"></xjw:selectBar>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
				<button type="button" class="btn btn-danger" id="delAll"><i class="icon-white icon-trash"></i>批量删除</button>
			</div>	
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>消息列表</strong>
		      </div>
		        	
	        	<table class="table table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="20px"><input type="checkbox" id="allck"/></th>
					    	<th width="20px"></th>
					        <th width="100px">标题</th>
					        <th>内容</th>
					        <th width="150px">创建时间</th>
					        <th width="150px">阅读时间</th>
					        <th width="120px">所属功能</th>
					        <th width="150px">操作</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty page.dataList }">
			    			<tbody>
				    			<c:forEach var="notice" items="${page.dataList }">
								    	<tr class="tr" id="${notice.id}" title="双击查看详情">
								    		<td><input type="checkbox" value="${notice.id }" name="ck"/></td>
								    		<td>
								    			<c:choose>
								    				<c:when test="${notice.isRead eq '1' }">
								    					<img src="${statics}/img/read.png"></img>
								    				</c:when>
								    				<c:otherwise>
								    					<img src="${statics}/img/no_read.png"></img>
								    				</c:otherwise>
								    			</c:choose>
								    		</td>
								            <td>${notice.title }</td>
								            <td>${notice.context }</td>
								            <td><fmt:formatDate value="${notice.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><fmt:formatDate value="${notice.readTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td><xjw:enumBar clazz="com.xjw.kzenum.notice.NoticeCodeEnum" code="${notice.functionCode }" /></td>
								            <td>
												<button type="button" class="btn btn-primary search-but"><i class="icon-white icon-book"></i>阅读</button>
												<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
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
			bindDelAllClick("delAll", "${ctx}/sysmsg/del");
	    });
      
		$('.tr').dblclick(function(){
			window.location.href = "${ctx}/sysmsg/detail?id=" + $(this).attr("id");
		});
		
		$(".del-but").click(function() {
			var ckValue = $(this).parent().parent().find("input[name='ck']").val();
			delRow(ckValue, "${ctx}/sysmsg/del");
		});
      
		$(".search-but").click(function() {
			var id = $(this).parent().parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/sysmsg/detail?id=" + id;
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>