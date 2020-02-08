<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>

<form id="payConfigForm">
  	<div class="doc-content">
    	<div class="panel">
			<table class="table table-bordered definewidth">
			    <tr>
			        <td>* <b>支付类别：</b></td>
			        <td><xjw:selectBar name="tradeMode"  clazz="com.xjw.kzenum.order.TradeModeEnum" type="select" myClass="" value=""/></td>
			    </tr>
			    <tr>
			        <td>* <b>启用状态：</b></td>
			        <td>
			        	<xjw:selectBar name="status"  clazz="com.xjw.kzenum.sys.YesORNoEnum" type="select" myClass="" value=""/>
			        </td>
			    </tr>
			</table>
	 	</div>
	 </div>
</form>