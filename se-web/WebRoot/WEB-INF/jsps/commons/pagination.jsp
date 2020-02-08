<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty page.dataList && page.totalPages > 1}">
	<c:choose>
		<c:when test="${page.totalPages < 5}">
			<c:set var="start" value="1"/>
			<c:set var="end" value="${page.totalPages}"/>	
		</c:when>
		<c:when test="${page.pageNo < 3}">
			<c:set var="start" value="1"/>
			<c:set var="end" value="5"/>	
		</c:when>
		<c:when test="${page.totalPages - page.pageNo <= 2}">
			<c:set var="start" value="${page.totalPages - 4}"/>
			<c:set var="end" value="${page.totalPages}"/>	
		</c:when>
		<c:otherwise>
			<c:set var="start" value="${page.pageNo - 2}"/>
			<c:set var="end" value="${page.pageNo + 2}"/>	
		</c:otherwise>
	</c:choose>

	<ul class="pagination">
		<c:if test="${page.pageNo > 1}">
			<li><a href="javascript:;" data-num="${page.pageNo-1}" aria-label="Previous"><span aria-hidden="true">上一页</span></a></li>
		</c:if>
		<c:forEach begin="${start}" end="${end}" var="i">
			<c:choose>
				<c:when test="${i == page.pageNo}">
					<li class="active"><a href="javascript:;">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript:;" data-num="${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${page.pageNo < page.totalPages}">
			<li><a href="javascript:;" data-num="${page.pageNo+1}" aria-label="Next"><span aria-hidden="true">下一页</span></a></li>
		</c:if>
	</ul>
</c:if>