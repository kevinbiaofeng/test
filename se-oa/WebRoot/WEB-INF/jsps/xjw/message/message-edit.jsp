<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="editForm">
	<input type="hidden" name="id" value="${message.id}"/>

  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
			    <tr>
			        <td>* <b>标题：</b></td>
			        <td>
			        	<input type="text" name="title" style="width:300px;" value="${message.title}" maxlength="20"/>
			        </td>
			    </tr>
			    <tr>
			        <td>* <b>内容：</b></td>
			        <td>
			        	<textarea name="content" style="margin:0px; height:150px; width:300px;">${message.content}</textarea>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
</form>