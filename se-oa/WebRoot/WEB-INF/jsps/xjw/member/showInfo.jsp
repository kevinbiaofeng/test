<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

 <div class="doc-content">
   	<div class="panel">
		<table class="table table-bordered definewidth" style="color:black;">
			<colgroup>
				<col width="100px;">
				<col>
			</colgroup>
			 <tr>
        		<td><b>会员账号：</b></td>
        		<td>${member.loginName}</td>
        	</tr>
		    <tr>
        		<td><b>真实姓名：</b></td>
        		<td>${member.name}</td>
        	</tr>
        	<tr>
       			<td><b>电话号码：</b></td>
		        <td>
		        	<c:choose>
        				<c:when test="${member.privacyFlag == 1}">${member.phone}</c:when>
        				<c:otherwise><xjw:subStringTag input="${member.phone}" replace="****" type="phone" /></c:otherwise>
        			</c:choose>
		        </td>
		    </tr>
		    <tr>
       			<td><b>QQ：</b></td>
		        <td>
		        	<c:choose>
        				<c:when test="${member.privacyFlag == 1}">${member.qq}</c:when>
        				<c:otherwise><xjw:subStringTag input="${member.qq}" replace="****" type="qq" /></c:otherwise>
        			</c:choose>
		        </td>
		    </tr>
		    <tr>
       			<td><b>邮箱：</b></td>
		        <td>
		       	 	<c:choose>
        				<c:when test="${member.privacyFlag == 1}">${member.email}</c:when>
        				<c:otherwise><xjw:subStringTag input="${member.email}" replace="****" type="email" /></c:otherwise>
        			</c:choose>
		        </td>
		    </tr>
		</table>
 	</div>
 </div>
