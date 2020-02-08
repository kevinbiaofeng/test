<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="withdrawalForm">
	<input type="hidden" name="id" value="${dto.id}" />

	<div class="doc-content">
		<div class="panel">
			<table class="table table-bordered definewidth">
				<tr>
					<td><b>会员账号：</b></td>
					<td>${dto.loginName }</td>
				</tr>
				<tr>
					<td width="180px"><b>提款编号：</b></td>
					<td>${dto.orderNo }</td>
				</tr>
				<tr>
					<td><b>提款银行：</b></td>
					<td><xjw:nameByValTagByDB type="FINAL" code="USER_BANK_TYPE"
							value="${dto.toBankType }" /></td>
				</tr>
				<tr>
					<td><b>提款人姓名：</b></td>
					<td>${dto.toBankAccount }</td>
				</tr>
				<tr>
					<td><b>提款账号：</b></td>
					<td>${dto.toBankCard }</td>
				</tr>
				<tr>
					<td><b>提款金额：</b></td>
					<td><fmt:formatNumber value="${dto.tradeAmount }"
							type="currency" pattern="#.##" /></td>
				</tr>
				<tr>
					<td><b>提款时间：</b></td>
					<td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>

				<c:if test="${flag == 2}">
					<tr>
						<td><b><font color="red">*</font>备注：</b></td>
						<td><textarea name="remark" style="width: 300px; height: 55px;" id="remark"></textarea></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</form>