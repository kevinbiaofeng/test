<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>详情</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
		      <div class="panel-header">
	        	<strong>消息详情</strong>
		      </div>
	
			  <form id="objForm">
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">标题：</td>
					        <td>${notice.title }</td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">内容：</td>
					        <td>${notice.context }</td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button type="button" class="button" id="backId">返回列表</button>
					        </td>
					    </tr>
					</table>
			    </form>
		  
		  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
	 	</div>
	 </div>	
		  
	  </div>
      
      <script>
	    $(function () {
	    	bindSkipClick("backId", "${ctx}/sysmsg/list");
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
