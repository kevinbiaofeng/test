<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>活动设置</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="pageContent">
		<form id="objForm" action="${ctx}/activity/info/list" method="post">
			<table class="searchTable">
				<tr>
					<td class="tableleft">活动ID：</td>
					<td><input type="text" name="id" id="id" value="${form.id}"/></td>
					<td class="tableleft">活动类别：</td>
					<td>
						<select name="type">
							<option value="">---所有---</option>
							<c:forEach items="${typeList}" var="t">
								<option value="${t.code}" <c:if test="${t.code==form.type}">selected</c:if>>
									${t.code} - ${t.name}
								</option>
							</c:forEach>
						</select>
					</td>
					<td class="tableleft">显示条数：</td>
					<td><xjw:selectBar name="pageSize" id="pageSize" clazz="com.xjw.kzenum.sys.PageSizeEnum" myClass="" type="select" value="${form.pageSize }"/></td>
				</tr>
				<tr>
					<td class="tableleft">活动类型：</td>
					<td><xjw:selectBar name="comeFrom" id="comeFrom" clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" myClass="" type="select" value="${form.comeFrom }"/></td>
				</tr>
			</table>
			
			<div class="well">
				<xjw:auth code="YWGL-SCTG-HDSZ-XZHD">
					<button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i>搜索</button>
					<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增活动</button>
				</xjw:auth>
			</div>
		
		  	<div class="doc-content">
		    	<div class="panel">
			      <div class="panel-header">
			        	<strong>活动列表</strong>
			      </div>
			        	
		          <table class="table list table-bordered table-hover definewidth">
					    <thead>
						    <tr>
						    	<th>ID</th>
						        <th>活动名称</th>
						        <th>存款金额上下限设定</th>
						        <th>红利百分比</th>
						        <th>红利上限</th>
						        <th>参加次数</th>
						        <th>流水倍数</th>
						        <th>活动开始时间</th>
						        <th>活动结束时间</th>
						        <th>活动代码</th>
						        <th>活动类型</th>
						        <th>备注</th>
						        <th>操作</th>
						    </tr>
					    </thead>
					    <c:choose>
						    <c:when test="${not empty page.dataList }">
				    			<tbody>
				    				<c:forEach var="dto" items="${page.dataList }">
									    	<tr>
									    		<td>${dto.id}</td>
									    		<td>${dto.name }</td>
									            <td>
									            	${dto.moneyUp}
									            	-
									            	${dto.moneyDown}
									            </td>
									            <td><fmt:formatNumber value="${dto.dividendPercent }" type="currency" pattern="##.##"/>%</td>
									            <td>${dto.dividendUp }</td>
									            <td>${dto.count }</td>
									            <td>${dto.multiple }</td>
									            <td><fmt:formatDate value="${dto.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td><fmt:formatDate value="${dto.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									            <td>${dto.discountCode }</td>
									            <td>
									            	<c:choose>
									            		<c:when test="${dto.comeFrom eq '1' }">
									            			<font color="green">
									            			<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${dto.comeFrom}"/>
									            			</font>
									            		</c:when>
									            		<c:when test="${dto.comeFrom eq '2' }">
									            			<font color="red">
									            				<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${dto.comeFrom}"/>
									            			</font>
									            		</c:when>
									            		<c:otherwise>
									            			<xjw:enumBar clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" code="${dto.comeFrom}"/>
									            		</c:otherwise>
									            	</c:choose>
									            </td>
									            <td title="${dto.remark }"><xjw:subStringTag input="${dto.remark }" replace="......" size="10"/></td>
									            <td>
									            	<input type="hidden" name="ck" value="${dto.id }"/>
													<c:choose>
														<c:when test="${dto.status eq '1' }">
															<xjw:auth code="YWGL-SCTG-HDSZ-BJ">
																<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
															</xjw:auth>
															<xjw:auth code="YWGL-SCTG-HDSZ-HDQD">
																<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>活动启动</button>
															</xjw:auth>
														</c:when>
														<c:when test="${dto.status eq '2' }">
															<xjw:auth code="YWGL-SCTG-HDSZ-BJ">
																<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
															</xjw:auth>
															<xjw:auth code="YWGL-SCTG-HDSZ-HDZT">
																<button type="button" class="btn btn-warning stop-but"><i class="icon-white icon-off"></i>活动暂停</button>
															</xjw:auth>
															<xjw:auth code="YWGL-SCTG-HDSZ-HDXX">
																<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>活动下线</button>
															</xjw:auth>
														</c:when>
														<c:when test="${dto.status eq '3' }">
															<xjw:auth code="YWGL-SCTG-HDSZ-BJ">
																<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
															</xjw:auth>
															<xjw:auth code="YWGL-SCTG-HDSZ-HDQD">
																<button type="button" class="btn btn-success start-but"><i class="icon-white icon-play"></i>活动启动</button>
															</xjw:auth>
															<xjw:auth code="YWGL-SCTG-HDSZ-HDXX">
																<button type="button" class="btn btn-danger down-but"><i class="icon-white icon-remove-sign"></i>活动下线</button>
															</xjw:auth>
														</c:when>
														<c:otherwise>
															
														</c:otherwise>
													</c:choose>
									            </td>
									        </tr>
							    	</c:forEach>
						    	</tbody>
					    	</c:when>
					    	<c:otherwise>
				    			<tr><td colspan="12" class="notdata"><spring:message code="page.text.notData" /></td></tr>
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
		 </form>
		 
	  </div>
      
      <script>
	    $(function () {
			BUI.use('bui/overlay');
			bindSkipClick("add", "${ctx}/activity/info/skipAdd");
	    });
	    
	    $(".modify-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			window.location.href = "${ctx}/activity/info/skipEdit?id=" + id;
		});
	    
	    $(".start-but").click(function() {
			var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认活动启动？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/activity/info/start?id=" + id;
					 this.close();
				 }},{
				 text:'否',
				 elCls : 'button',
				 handler : function(){
					 this.close();
				 }} ]
			});
		});
	    
	    $(".stop-but").click(function() {
	    	var id = $(this).parent().find("input[name='ck']").val();
			BUI.Message.Show({
				 msg : '是否确认活动暂停？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/activity/info/stop?id=" + id;
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
				 msg : '是否确认活动下线？',
				 icon : 'question',
				 buttons : [{
				 text:'是',
				 elCls : 'button button-primary',
				 handler : function(){
					 window.location.href = "${ctx}/activity/info/down?id=" + id;
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