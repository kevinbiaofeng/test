<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人信息</title>
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>
				        	个人信息
			        	</strong>
			      </div>
		
				  <form id="objForm" method="post">
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">代理账号：</td>
					        <td>${dto.loginName }</td>
					    </tr>
					    <tr>
					        <td class="tableleft">电子邮箱：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.email}" replace="****" type="email" />
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">真实姓名：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.name}" size="1" replace="**"/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">性别：</td>
					        <td>
					        	<xjw:enumBar clazz="com.xjw.kzenum.user.SexTypeEnum" code="${dto.sex }"/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">出生年月：</td>
					        <td>
					        	<fmt:formatDate value="${dto.birthday }" type="both" pattern="yyyy-MM-dd"/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">联系电话：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.phone}" replace="****" type="phone" />
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">银行：</td>
					        <td>
					        	<xjw:nameByValTagByDB type="FINAL" value="${dto.bankType }" code="USER_BANK_TYPE" />
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">银行卡号：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.bankCard}" size="6" replace="************"/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">分行地址：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.bankAddress}" size="10" replace="......"/>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">QQ：</td>
					        <td>
					        	<xjw:subStringTag input="${dto.qq }" replace="****" type="qq" />
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">推广代码：</td>
					        <td>${dto.promotionCode }</td>
					    </tr>
					    <tr>
					        <td class="tableleft">推广地址：</td>
					         <td>${dto.promotionUrl }</td>
					    </tr>
					</table>
			    </form>
			  
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	  </div>

	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
