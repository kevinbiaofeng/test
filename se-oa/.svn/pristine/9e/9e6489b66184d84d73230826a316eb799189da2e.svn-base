<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>代理输赢统计</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/alone/bunko/list" method="post">
			<table class="searchTable">
				<tr>
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
		        	<strong>代理输赢统计</strong>
		      	</div>
		      	
	          	<table class="table list table-bordered table-hover definewidth">
				    <thead>
					   <tr>
					   		<th>代理ID</th>
					        <th>代理账号</th>
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
					    <c:when test="${not empty bunkoList}">
					    	<c:set var="totalAggjAmount" value="0"/>
					    	<c:set var="totalAgjsAmount" value="0"/>
					    	<c:set var="totalPtAmount" value="0"/>
					    	<c:set var="totalMgAmount" value="0"/>
					    	<c:set var="totalTtgjAmount" value="0"/>
					    	<c:set var="totalEndoAmount" value="0"/>
					    	<c:set var="totalXinAmount" value="0"/>
					    	<c:set var="totalQpAmount" value="0"/>
					    	<c:set var="totalSbAmount" value="0"/>
					    	<c:set var="totalFishAmount" value="0"/>
					    
					    	<tbody>
			    				<c:forEach var="dto" items="${bunkoList}">
			    					<c:set var="totalAggjAmount" 	value="${totalAggjAmount + dto.aggjAmount}"/>
			    					<c:set var="totalAgjsAmount" 	value="${totalAgjsAmount + dto.agjsAmount}"/>
			    					<c:set var="totalPtAmount" 		value="${totalPtAmount + dto.ptAmount}"/>
			    					<c:set var="totalMgAmount" 		value="${totalMgAmount + dto.mgAmount}"/>
			    					<c:set var="totalTtgjAmount" 	value="${totalTtgjAmount + dto.ttgAmount}"/>
			    					<c:set var="totalEndoAmount" 	value="${totalEndoAmount + dto.endoAmount}"/>
			    					<c:set var="totalXinAmount" 	value="${totalXinAmount + dto.xinAmount}"/>
			    					<c:set var="totalFishAmount" 	value="${totalFishAmount + dto.fishAmount}"/>
			    					<c:set var="totalQpAmount" 		value="${totalQpAmount + dto.qpAmount}"/>
			    					<c:set var="totalSbAmount" 		value="${totalSbAmount + dto.sbAmount}"/>
			    				
							    	<tr>
							    		<td>${dto.id}</td>
							    		<td>
							    			<a href="${ctx}/alone/bunko/sublist?parentId=${dto.id}&beginLocalTime=${form.beginLocalTime}&endLocalTime=${form.endLocalTime}">
							    			${dto.loginName}
							    			</a>
							    		</td>
							            <td>
							            	<c:choose>
								    			<c:when test="${dto.aggjAmount > 0}">
								    				<font color="green">${dto.aggjAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.aggjAmount < 0}">
								    				<font color="red">${dto.aggjAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
							            </td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.agjsAmount > 0}">
								    				<font color="green">${dto.agjsAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.agjsAmount < 0}">
								    				<font color="red">${dto.agjsAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.ptAmount > 0}">
								    				<font color="green">${dto.ptAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.ptAmount < 0}">
								    				<font color="red">${dto.ptAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.mgAmount > 0}">
								    				<font color="green">${dto.mgAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.mgAmount < 0}">
								    				<font color="red">${dto.mgAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.ttgAmount > 0}">
								    				<font color="green">${dto.ttgAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.ttgAmount < 0}">
								    				<font color="red">${dto.ttgAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.endoAmount > 0}">
								    				<font color="green">${dto.endoAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.endoAmount < 0}">
								    				<font color="red">${dto.endoAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.xinAmount > 0}">
								    				<font color="green">${dto.xinAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.xinAmount < 0}">
								    				<font color="red">${dto.xinAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.qpAmount > 0}">
								    				<font color="green">${dto.qpAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.qpAmount < 0}">
								    				<font color="red">${dto.qpAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.sbAmount > 0}">
								    				<font color="green">${dto.sbAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.sbAmount < 0}">
								    				<font color="red">${dto.sbAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
				    					<td>
				    						<c:choose>
								    			<c:when test="${dto.fishAmount > 0}">
								    				<font color="green">${dto.fishAmount}</font>
								    			</c:when>
								    			<c:when test="${dto.fishAmount < 0}">
								    				<font color="red">${dto.fishAmount}</font>
								    			</c:when>
								    			<c:otherwise>-</c:otherwise>
								    		</c:choose>
				    					</td>
							        </tr>
						    	</c:forEach>
					    	</tbody>
					    	<thead>
							   <tr>
							        <th align="center" colspan="2">合计</th>
							        <th>${totalAggjAmount}</th>
							        <th>${totalAgjsAmount}</th>
							        <th>${totalPtAmount}</th>
							        <th>${totalMgAmount}</th>
							        <th>${totalTtgjAmount}</th>
							        <th>${totalEndoAmount}</th>
							        <th>${totalXinAmount}</th>
							        <th>${totalQpAmount}</th>
							        <th>${totalSbAmount}</th>
							        <th>${totalFishAmount}</th>
							    </tr>
						    </thead>
				    	</c:when>
				    	
				    	<c:otherwise>
			    			<tr><td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			    	
				</table>
			      
				<%-- <div class='bui-grid'>
					<div class='bui-grid-bbar'>
		    			<c:if test="${not empty listAG }">
		   					<xjw:pageTag page="${page}" formId="objForm"></xjw:pageTag>
						</c:if>
					</div>
		  		</div> --%>
		 	</div>
		 </div>
	  </div>
</body>
</html>