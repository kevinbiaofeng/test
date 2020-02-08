<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="callcsDetailForm" method="post">
	<input name="id" type="hidden" value="${memberCallcsDetail.id }">
	<input name="userId" type="hidden" value="${userId }">
	 <div class="doc-content">
	   	<div class="panel">
			<table class="table table-bordered definewidth" style="color:black;">
				<colgroup>
					<col width="130px;">
					<col>
				</colgroup>
				 <tr>
	        		<td><b>通话状态：</b></td>
	        		<td>
	        			<xjw:selectBar name="callcsStatus" myClass="" clazz="com.xjw.kzenum.user.MemberCallcsDetailCallcsStatusEnum" type="select" value="${memberCallcsDetail.callcsStatus}"></xjw:selectBar>
	        		</td>
	        	</tr>
	        	<tr>
	        		<td><b>回访类型：</b></td>
	        		<td>
	        			<xjw:selectBar name="callcsType" myClass="" clazz="com.xjw.kzenum.user.MemberCallcsDetailCallcsTypeEnum" type="select" value="${memberCallcsDetail.callcsType }"></xjw:selectBar>
	        		</td>
	        	</tr>
	        	<tr>
	       			<td><b>最新通话记录：</b></td>
			        <td>
						<textarea id="remark" name="remark" class="uneditable-textarea" cols="25" rows="5">${memberCallcsDetail.remark}</textarea>
					</td>
			    </tr>
	        	<tr>
	        		<td><b>最新操作人：</b></td>
	        		<td>${memberCallcsDetail.updateUserName}</td>
	        	</tr>
	        	<tr>
	        		<td><b>最新操作时间：</b></td>
	        		<td><fmt:formatDate value="${memberCallcsDetail.updateTime }" type="both" pattern="yyyy年MM月dd日 HH:mm"/></td>
	        	</tr>
			</table>
	 	</div>
	 </div>
 </form>
