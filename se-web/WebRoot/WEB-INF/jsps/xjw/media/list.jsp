<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
		<title>老司机510-${HEADER_MENU }</title>
    	<meta name="keywords" content="${HEADER_MENU },老司机510,老司机我要你,老司机2018,老司机小电影,老司机精品,老司机网,老司机福利,老司机福利你懂的" />
    	<meta name="description" content="老司机510是汇集全球视频，及时收录各国视频内容的一家永久免费在线看片平台。看片，从老司机510平台开始。" />
    	<link href="${statics }/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${statics }/css/common.css" rel="stylesheet" />
    	<link href="${statics }/css/main.css" rel="stylesheet" />
    	<link href="${statics }/css/paging/paging.css" rel="stylesheet" />
    	<link rel="shortcut icon" href="${statics }/images/favicon.ico" type="image/x-icon" />
    	<script src="${statics }/plugins/jquery/1.11.1/jquery.min.js"></script>
    	
    	<!--[if lte IE 9]>
		<script src="${statics}/js/respond.min.js"></script>
		<script src="${statics}/js/html5shiv.min.js"></script>
		<![endif]-->
		<script>
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "https://hm.baidu.com/hm.js?716d9b6e1d9c47db3a6f81d1d50f89d8";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
		</script>
	</head>
	<body>
    	<%@ include file="/WEB-INF/jsps/commons/header.jsp"%>
    	
    	<div class="list-panel">
    		<div class="container">
    			<div class="list-header">
    				<div class="header-left"><i class="glyphicon glyphicon-list-alt"></i><span class="list-icon-title">${HEADER_MENU }</span></div>
    				<div class="header-right">
    					<ul>
    						<li>
    							<a href="${ctx }/media/list/${HEADER_MENU }/newVideo/1/">
    								<i class="fa fa-podcast"></i><span class="list-icon-title">最新發布</span>
    							</a>
    						</li>
    						<li>
    							<a href="${ctx }/media/list/${HEADER_MENU }/hotVideo/1/">
    								<i class="fa fa-eye"></i><span class="list-icon-title">最多播放</span>
    							</a>
    						</li>
    						<li>
    							<a href="${ctx }/media/list/${HEADER_MENU }/goodVideo/1/">
    								<i class="fa fa-heart"></i><span class="list-icon-title">最多收藏</span>
    							</a>
    						</li>
    					</ul>
    				</div>
    			</div>
    			
    		</div>
    		
    	</div>
    	
    	<div class="container">
    			<form id="listform">
    			<div class="list-content">
    				<ul>
    					<c:forEach var="media" items="${page.dataList}">
	    					<li>
		    					<div class="list-media-box">
		    						<a href="${ctx }/media/play/${media.code}">
				                    	<img class="lazy" src="${statics}/images/default-video.jpg" data-original="<spring:message code="video.image.url" />${media.imagePath}" width="270" height="202" alt="${media.title}"/>
				                    </a>
				                    <div class="cover-info">
				                        <a href="${ctx }/media/play/${media.code }/">
				                        	<h4>
				                        		<se:subStringTag input="${media.title}" replace="***" size="25" />
				                        	</h4>
				                        </a>
				                    </div>
				                    <c:if test="${media.vipFlag eq '1'}">
										<div class="media-vip">
											VIP
										</div>
									</c:if>
				                    <div class="cover-fields">
				                        <i class="fa fa-list-ul"></i> &nbsp;
 				                        <c:if test="${not empty media.keyword}">
 					                        <c:set value="${fn:split(media.keyword, ',')}" var="kws" />
					                        <c:forEach items="${kws}" var="kw">
 					                        	${kw}&nbsp;&nbsp; 
 					                        </c:forEach> 
 				                        </c:if> 
				                    </div>
				                    <div class="cover-stat">
				                        <i class="fa fa-eye"></i><span class="f10"> &nbsp;${media.clickCount}</span>
				                        <i class="fa fa-heart"></i><span class="f10"> &nbsp;${media.favoriteCount}</span>
	<!-- 			                        <div class="cover-yh"> -->
	<!-- 			                            <a href="mem4779" data-container="body" data-toggle="popover" data-placement="top" data-content="丶 " data-original-title="" title=""> -->
	<!-- 			                                <i class="fa fa-user-secret"></i> -->
	<!-- 			                            </a> -->
	<!-- 			                        </div> -->
				                    </div>        
				                </div>
	    					</li>
    					</c:forEach>
    				</ul>
    			</div>
    			</form>
    		</div>
    		<se:pageTag page="${page}" formId="listform" url="${ctx}/media/list/${HEADER_MENU }/${ORDER_BY}"></se:pageTag>
    	
		<%@ include file="/WEB-INF/jsps/commons/footer.jsp"%>
		<script src="${statics }/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script src="${statics }/plugins/jquery.lazyload/1.9.7/jquery.lazyload.min.js"></script>
    	<script type="text/javascript">
	    	$(function() {
	    	    $("img.lazy").lazyload();
	    	});
    	</script>
	</body>
</html>