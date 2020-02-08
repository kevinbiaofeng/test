<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<script language="javascript">
		function rp(id){
			right.window.location="${ctx}/sysuser/list?deptId=" + id;
		}
		function flushTree(){
			left.window.location.reload();
		}
	</script>
</head>

<body>
	<div style="height: 100%; width: 100%;">
		<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
			<tr>
				<td width="228px" valign="top">
					<iframe name="left" src="${ctx}/sysdept/tree " width="228px" height="100%" scrolling="auto" frameborder="0" border="0"></iframe>
				</td>
				
				<td valign="top">
					<iframe name="right" src="" width="100%" height="100%" scrolling="auto" frameborder="0" border="0"></iframe>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
