<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script language="javascript">
		var selectId="";
		
		function rp(id){
			right.window.location="${ctx}/sysdept/skipModify?id=" + id;
		}
	</script>
</head>

<body>
	<div style="height: 100%; width: 100%;">
		<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
			<tr>
				<td width="228px" valign="top">
					<iframe name="left" src="${ctx}/sysdept/list " width="228px" height="100%" scrolling="auto" frameborder="0" border="0"></iframe>
				</td>
				
				<td valign="top">
					<iframe name="right" src="" width="100%" height="100%" scrolling="auto" frameborder="0" border="0"></iframe>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
