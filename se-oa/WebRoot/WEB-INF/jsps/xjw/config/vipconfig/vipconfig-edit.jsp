<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="editSlotForm">
	<input type="hidden" name="id" value="${vipconfig.id}"/>

  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
			    <tr>
			        <td style="height: 15px;"><b>会员等级：</b></td>
			        <td>
			        	${vipconfig.level }
			        </td>
			    </tr>
			    <tr style="height: 15px;">
			        <td><b>月累计存款：</b></td>
			        <td>
			        	<input type="text" name="monthDepositAmount" value="${vipconfig.monthDepositAmount}" maxlength="10"/>
			        </td>
			    </tr>
			    <tr style="height: 15px;">
			        <td><b>周有效投注：</b></td>
			        <td>
			        	<input type="text" name="weekBetAmount" value="${vipconfig.weekBetAmount}" maxlength="10"/>
			        </td>
			    </tr>
			    <tr style="height: 15px;">
			        <td><b>每月免费筹码：</b></td>
			        <td style="height: 15px;">
			        	<input type="text" name="monthChipAmount" value="${vipconfig.monthChipAmount}" maxlength="10"/>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
</form>