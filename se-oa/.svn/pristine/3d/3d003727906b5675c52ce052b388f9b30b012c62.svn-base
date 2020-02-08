<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>相同IP账号查询</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<style>
		div.panel-header strong{cursor: pointer; margin-right: 10px;}
	</style>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/member/sameip/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">用户账号：</td>
					<td><input type="text" name="loginName" value="${form.loginName}"/></td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>
		
	  	<div class="doc-content">
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong data-for="ipTable">按IP显示</strong>
		        	<strong data-for="userTable">按账号显示</strong>
		      </div>
		        	
	          <table id="ipTable" class="table list table-bordered table-hover definewidth">
				    <thead>
					    <tr>
					    	<th width="150px;">IP网段</th>
					    	<th>账号</th>
					    </tr>
				    </thead>
	    			<tbody>
	    				<c:choose>
	    					<c:when test="${not empty ip2UserLogMap}">
			    				<c:forEach var="entry" items="${ip2UserLogMap}">
									<tr>
								    	<td>${entry.key}</td>
								    	<td>
								    		<ul style="overflow:hidden;width:100%;">
									    		<c:forEach var="log" items="${entry.value}">
									    			<li style="width:25%;float:left;">
									    				<font color="#6A5ACD">${log.ipAddress}</font>
									    				 - 
									    				<c:choose>
									    					<c:when test="${log.status == 1}">
									    						<font color="#007799">${log.loginName}</font>
									    					</c:when>
									    					<c:when test="${log.status == 2}">
									    						<font color="#CC0000">${log.loginName}(冻结)</font>
									    					</c:when>
									    					<c:when test="${log.status == 3}">
									    						<font color="#CC0000">${log.loginName}(关闭)</font>
									    					</c:when>
									    					<c:otherwise>${log.loginName}</c:otherwise>
									    				</c:choose>
									    			</li>
									    		</c:forEach>
								    		</ul>
								    	</td>
								    </tr>
						    	</c:forEach>
						    </c:when>
						    <c:otherwise>
						    	<tr><td colspan="12" class="notdata"><spring:message code="page.text.notData" /></td></tr>
						    </c:otherwise>
				    	</c:choose>
			    	</tbody>
			  </table>
			  
			  <!-- 按账号显示 -->
			  <table id="userTable" class="table list table-bordered table-hover definewidth" style="display:none;">
				    <thead>
					    <tr>
					    	<th width="150px;">账号</th>
					    	<th>IP</th>
					    </tr>
				    </thead>
	    			<tbody>
	    				<c:choose>
	    					<c:when test="${not empty user2IpLogMap}">
			    				<c:forEach var="entry" items="${user2IpLogMap}">
			    					<c:set var="loginName" value="${fn:split(entry.key, '|')[0]}"/>
			    					<c:set var="status" value="${fn:split(entry.key, '|')[1]}"/>
			    				
									<tr>
								    	<td>
								    		<c:choose>
						    					<c:when test="${status == 1}">
						    						<font color="#007799">${loginName}</font>
						    					</c:when>
						    					<c:when test="${status == 2}">
						    						<font color="#CC0000">${loginName}(冻结)</font>
						    					</c:when>
						    					<c:when test="${status == 3}">
						    						<font color="#CC0000">${loginName}(关闭)</font>
						    					</c:when>
						    					<c:otherwise>${loginName}</c:otherwise>
						    				</c:choose>
								    	</td>
								    	<td>
								    		<ul style="overflow:hidden;width:100%;">
									    		<c:forEach var="log" items="${entry.value}">
									    			<li style="width:25%;float:left;">
									    				${log.ipAddress}
									    			</li>
									    		</c:forEach>
								    		</ul>
								    	</td>
								    </tr>
						    	</c:forEach>
						    </c:when>
						    <c:otherwise>
						    	<tr><td colspan="12" class="notdata"><spring:message code="page.text.notData" /></td></tr>
						    </c:otherwise>
				    	</c:choose>
			    	</tbody>
			  </table>
		 	</div>
		 </div>
	  </div>
      
      <script>
	    $(function () {
			$("div.panel-header strong").click(function(){
				var tableId = $(this).data("for");
				
				$("div.doc-content table").hide();
				$("#" + tableId).show();
			});
	    });
	 
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>