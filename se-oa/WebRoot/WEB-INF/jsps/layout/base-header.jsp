<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tag/XjwTag.tld" prefix="xjw"%>
<c:set var="ctx" value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<c:set var="statics" value="${ctx}/static"></c:set>
<c:set var="videoStatics" value="http://192.168.1.103"/>
<%-- <c:set var="videoStatics" value="http://img.lsj510.com"/> --%>
