<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />	
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1" />
		<title>老司机510-我的收藏</title>
    	<meta name="keywords" content="老司机,老司机510,老司机2018,老司机小电影,老司机精品,老司机网,老司机福利,老司机电影网,老司机什么意思" />
    	<meta name="description" content="老司机510是汇集全球视频，及时收录各国视频内容的一家永久免费在线看片平台。看片，从老司机510平台开始。" />
    	<link href="${statics }/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${statics }/css/common.css" rel="stylesheet" />
    	<link href="${statics }/css/paging/paging.css" rel="stylesheet" />
    	<link href="${statics }/css/user-center.css" rel="stylesheet" />
    	<link rel="shortcut icon" href="${statics }/images/favicon.ico" type="image/x-icon" />
    	<script src="${statics }/plugins/jquery/1.11.1/jquery.min.js"></script>

    	<!--[if lte IE 9]>
		<script src="${statics}/js/respond.min.js"></script>
		<script src="${statics}/js/html5shiv.min.js"></script>
		<![endif]-->
	</head>
	<body>
    	<%@ include file="/WEB-INF/jsps/commons/header.jsp"%>
    	
    	<div class="user-center">
    		<div class="container">
    			<%@ include file="/WEB-INF/jsps/commons/user-center-left.jsp"%>
	    		
	    		<div class="center-right">
	    			<div class="center-title">
	    				 我的收藏
	    			</div>
	    				
	    				<div class="box-content">
	    					<form id="listform">
		    				<ul>
		    					<c:forEach var="media" items="${list}">
			    					<li>
				    					<div class="list-media-box">
						                    <a href="${ctx }/media/${media.code }/play.html">
						                    	<img class="lazy" src="${statics}/images/default-video.jpg" data-original="<spring:message code="video.image.url" />${media.imagePath}" width="204px" height="153px" alt="${media.title}"/>
						                    </a>
						                    
						                    <div class="cover-info" style="padding: 1px 5px 11px;">
						                        <a href="${ctx }/media/${media.code }/play.html"><h4><se:subStringTag input="${media.title}" replace="***" size="25" /></h4></a>
						                    </div>
							                    <div class="cover-stat">
							                    	<c:forEach var="favorite" items="${page.dataList}">
							                    	<c:if test="${favorite.videoCode eq media.code}">
							                        	收藏时间：<fmt:formatDate value="${favorite.createTime }" type="both" pattern="yyyy-MM-dd"/>
							                        </c:if>
							                        </c:forEach>
							                    </div>
						                </div>
			    					</li>
		    					</c:forEach>
		    				</ul>
		    				</form>
		    			</div>
		    			
		    			<se:pageTag page="${page}" formId="listform" url="${ctx }/member/skipMyFavorite/"></se:pageTag>
		    			
	    			</div>
	    		</div>
    		</div>
    	</div>
		
		<%@ include file="/WEB-INF/jsps/commons/footer.jsp"%>
		<script src="${statics }/plugins/jquery.lazyload/1.9.7/jquery.lazyload.min.js"></script>
		<script type="text/javascript">
	    	$(function() {
	    	    $("img.lazy").lazyload();
	    	});
    	</script>
	</body>
</html>