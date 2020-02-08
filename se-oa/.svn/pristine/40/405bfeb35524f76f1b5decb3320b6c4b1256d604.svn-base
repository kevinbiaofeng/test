<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
	<link rel="stylesheet" type="text/css" href="${statics }/css/dtree.css?number=Math.random()" />
	<script type="text/javascript" src="${statics }/js/common/dtree.js?number=Math.random()"></script>
	<script type="text/javascript">
	var selectId = "";
    function pageLoad(){
        try {
            if (d.getSelected() != null){
                rp(d.getSelected());
            } else {
                rp("");
            }
        } catch (e) {
        }
    }
    
	function rp(id){
		window.parent.rp(id);
    }
	
	setStatics("${statics}");
	</script>
</head>


<body onload="pageLoad();">
	<div class="dtree">
	
	<p>
		<a href="javascript: d.openAll();">
			<img src="${statics }/img/dtree/open_all.gif" border="0" alt="打开所有结点" />
		</a> 
		| 
		<a href="javascript: d.closeAll();">
			<img src="${statics }/img/dtree/close_all.gif" border="0" alt="关闭所有结点" />
		</a>
	</p>
	
	
	<script type="text/javascript">
		d = new dTree("d");
		d.add(0, -1, "现金网", "javascript:rp('0')");
	</script>
	
	<c:forEach var="dept" items="${list }">
		<script type="text/javascript">
			d.add("${dept.id}", "${dept.parentId}", "${dept.name}", "javascript:rp('${dept.id}')");
		</script>
	</c:forEach>
	
	
	<script type="text/javascript">
		document.write(d);
	</script>

</div>
</body>
</html>