<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>代理下属会员输赢统计</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/bunko/sublist" method="post">
			<input type="hidden" name="parentId" value="${form.parentId}"/>
			<table class="searchTable">
				<tr>
					<td class="tableleft">会员账号:</td>
					<td>
						<input type="text" name="loginName" value="${form.loginName }" maxlength="15"/>
					</td>
					<td class="tableleft">北京时间：</td>
					<td>
						<input type="text" id="beginLocalTime" name="beginLocalTime" value="${form.beginLocalTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endLocalTime\')||\'2020-10-01\'}'})" readonly="readonly"/>
						一
						<input type="text" id="endLocalTime" name="endLocalTime" value="${form.endLocalTime }" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'beginLocalTime\')}',maxDate:'2020-10-01'})" readonly="readonly"/>
					</td>
				</tr>
			</table>
			<div class="well">
				<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
			</div>
		 </form>
		 
	  	<div class="doc-content">
	    	<div class="panel">
				<div class="panel-header">
		        	<strong>${agentMember.loginName}-下属会员输赢统计</strong>
		      	</div>
	          <table class="table list table-bordered table-hover definewidth">
				    <thead>
					   <tr>
					   		<th>会员ID</th>
					        <th>会员账号</th>
					        <th>AG国际厅</th>
					        <th>AG急速版</th>
					        <th>PT</th>
					        <th>MG</th>
					        <th>TTG</th>
					        <th>ENDO</th>
					        <th>XIN</th>
					        <th>棋牌游戏</th>
					        <th>沙巴体育</th>
					        <th>捕鱼王</th>
					    </tr>
				    </thead>
	    			<c:choose>
					    <c:when test="${not empty page.dataList}">
					    	<tbody>
			    				<c:forEach var="dto" items="${page.dataList}">
								    	<tr>
								    		<td>${dto.id}</td>
								    		<td>${dto.loginName}</td>
								            <td>
								            	<a href="${ctx}/platform/data/agList?platformType=AGIN&userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
									            	${dto.aggjAmount}
								            	</a>
								            </td>
					    					<td>
					    						<a href="${ctx}/platform/data/agList?platformType=AG&userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
							    					${dto.agjsAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/ptList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.ptAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/mgList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.mgAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/ttgList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.ttgAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/endoList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.endoAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/xinList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.xinAmount}
								            	</a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/qpList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.qpAmount}
									            </a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/sbList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.sbAmount}
								            	</a>
					    					</td>
					    					<td>
					    						<a href="${ctx}/platform/data/fishList?userId=${dto.id}&localBeginTime=${form.beginLocalTime}&localEndTime=${form.endLocalTime}">
						    						${dto.fishAmount}
									            </a>
					    					</td>
								        </tr>
						    	</c:forEach>
					    	</tbody>
				    	</c:when>
				    	<c:otherwise>
			    			<tr><td colspan="14" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
</body>
</html>