<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员IP筛选查询</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/member/ip/groupData" method="post">
			<input type="hidden" name="userId" value="${form.userId }"/>
			<input type="hidden" name="ipAddress" value="${form.ipAddress }"/>
			<table class="searchTable">
				<tr>
					<td class="tableleft">
						会员账号：
					</td>
					<td>
						<input type="text" name="keywords" value="${form.keywords }" maxlength="15"/>
					</td>
					<td class="tableleft">
						IP地址：
					</td>
					<td>
						<input type="text" name="searchIp" value="${form.searchIp }" maxlength="15"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		
	
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>会员IP查询</strong>
		      </div>
		        	
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					        <th>会员账号</th>
					        <th>登录IP</th>
<!-- 					        <th>IP地址</th> -->
					    </tr>
				    </thead>
				    <c:choose>
					    <c:when test="${not empty list }">
			    			<tbody>
			    				<c:forEach var="dto" items="${list }">
								    	<tr>
								    		<td>
								    			<c:choose>
								    				<c:when test="${empty form.ipAddress}">
								    					<a href="${ctx}/member/ip/groupData?userId=${dto.userId}">${dto.loginName }</a>
								    				</c:when>
								    				<c:otherwise>
								    					${dto.loginName }
								    				</c:otherwise>
								    			</c:choose>
								    			
								    		</td>
								            <td>
								    			<c:choose>
								    				<c:when test="${empty form.userId}">
								    					<a href="${ctx}/member/ip/groupData?ipAddress=${dto.ipAddress}">${dto.ipAddress }</a>
								    				</c:when>
								    				<c:otherwise>
								    					${dto.ipAddress }
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
		 </form>
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>