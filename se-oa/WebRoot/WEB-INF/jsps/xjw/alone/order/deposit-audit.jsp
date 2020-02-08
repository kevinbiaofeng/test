<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="depositForm">
	<input type="hidden" name="id" value="${dto.id}"/>

  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
				 <tr>
			        <td><b>会员账号：</b></td>
			        <td>
			        	${dto.loginName }
			        </td>
			    </tr>
			    <tr>
			        <td width="130px"><b>存款编号：</b></td>
			        <td>
			        	${dto.orderNo }
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款人姓名：</b></td>
			        <td>
			        	${dto.fromBankAccount }
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款金额：</b></td>
			        <td>
			        	<fmt:formatNumber type="currency" pattern="#.##" value="${dto.tradeAmount }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款时间：</b></td>
			        <td>
			        	<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${dto.createTime }"/>
			        </td>
			    </tr>
			    <tr>
			        <td><b>存款方式：</b></td>
			        <td>
			        	<xjw:enumBar clazz="com.xjw.kzenum.order.TradeModeEnum" code="${dto.tradeMode}" />
			        </td>
			    </tr>
			    <tr>
			        <td><b>账户姓名：</b></td>
			        <td>
			        	${dto.toBankAccount}
			        </td>
			    </tr>
			    <tr>
			        <td><b>存入的银行账号：</b></td>
			        <td>
			        	${dto.toBankCard}
			        </td>
			    </tr>
			    <tr>
			        <td><b>备注：</b></td>
			        <td>
			        	<textarea name="remark" style="width:250px; height:80px;"></textarea>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
</form>