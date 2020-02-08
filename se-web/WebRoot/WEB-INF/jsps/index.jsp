<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
		<title>老司机510-首页</title>
    	<meta name="keywords" content="老司机510,老司机我要你,老司机2018,老司机小电影,老司机精品,老司机网,老司机福利,老司机福利你懂的" />
    	<meta name="description" content="老司机510是汇集全球视频，及时收录各国视频内容的一家永久免费在线看片平台。看片，从老司机510平台开始。" />
		<link rel="shortcut icon" href="${statics }/images/favicon.ico" type="image/x-icon" />
		<link href="${statics }/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${statics }/css/common.css" rel="stylesheet" />
    	<link href="${statics }/css/main.css" rel="stylesheet" />
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
			
		<style>
			.media-buttom {
				height: 25px;
				line-height: 20px;
				text-align: right;
				padding-top: 3px;
				font-size: 12px;
				background-color: #f6f6f6;
			}
			
			.media-buttom a {
				color: #8B8B8C;
				margin-right: 10px;
			}
			
			.media-buttom a span{
				margin: 0 5px;
			}
		</style>

	</head>
	<body>
    	<%@ include file="/WEB-INF/jsps/commons/header.jsp"%>
    	<div class="f-panel">
	    	<div class="container">
	    	
	    	
	    	
	    	<div class="main-module">
	    	   <div class="main-title">
   	   			<c:set var="tagNew">
				    <spring:message code="tag.new"/>
				 </c:set>
	    	   	 <div class="title"><i class="fa fa-podcast" style="position: "></i> &nbsp;${tagNew }</div>
	    		<div class="more"><a href="${ctx }/media/list/${tagNew }/newVideo/1/">更多 <i class="fa fa-angle-double-right"></i></a></div>
	    	   </div>
	    		
	    	   <div class="content">
	    		    <div class="media-grid">
	    			  	<ul>
	    			  		<c:forEach var="media" items="${newList}">
		    			  		<li>
									<div class="media-box">
										<a href="${ctx }/media/play/${media.code}" class="media">
											<div class="media-icon">
												<img class="lazy" src="${statics}/images/default-video.jpg" data-original="<spring:message code="video.image.url" />${media.imagePath}" width="167" height="138" style="border-radius: 5px;" alt="${media.title}"/>
											</div>
											<div class="media-name" title="${media.title}">
												<se:subStringTag input="${media.title}" replace="***" size="10" />
											</div>
										</a>
										<div class="media-buttom">
											<c:if test="${media.vipFlag eq '1'}">
												<div class="media-vip">
													VIP
												</div>
											</c:if>
											<a href="javascript:;">
												<i class="fa fa-eye"></i>
												<span>${media.clickCount}</span> 
											</a>
											<a href="javascript:;">
												<i class="fa fa-heart"></i>
												<span>${media.favoriteCount}</span> 
											</a>
										</div>
									</div>
								</li>
		    			   </c:forEach>
						</ul>
					</div>
	    		</div>
	    	</div>
	    	
	    	
	    	 
	    	 <div class="main-module" style="margin-top: 30px;margin-bottom: 30px;">
	    	   <div class="main-title">
	    	   	 <c:set var="hot">
				    <spring:message code="tag.hot"/>
				 </c:set>
	    	   	 <div class="title"><i class="fa fa-fire"></i> &nbsp;${hot }</div>
	    		<div class="more"><a href="${ctx }/media/list/${hot }/hotVideo/1/">更多 <i class="fa fa-angle-double-right"></i></a></div>
	    	   </div>
	    		
	    	   <div class="content">
	    		    <div class="media-grid">
	    			  <ul>
		    			  <c:forEach var="media" items="${hotList}">
	    			  		<li>
								<div class="media-box">
									<a href="${ctx }/media/play/${media.code}" class="media">
										<div class="media-icon" style="position: relative;">
											<img class="lazy" src="${statics}/images/default-video.jpg" data-original="<spring:message code="video.image.url" />${media.imagePath}" width="167" height="138" style="border-radius: 5px;" alt="${media.title}"/>
										</div>
										
										<div class="media-name" title="${media.title}">
											<se:subStringTag input="${media.title}" replace="***" size="10" />
										</div>
									</a>
									<div class="media-buttom">
										<c:if test="${media.vipFlag eq '1'}">
											<div class="media-vip">
												VIP
											</div>
										</c:if>
										<a href="javascript:;">
											<i class="fa fa-eye"></i>
											<span>${media.clickCount}</span> 
										</a>
										<a href="javascript:;">
											<i class="fa fa-heart"></i>
											<span>${media.favoriteCount}</span> 
										</a>
									</div>
								</div>
							</li>
		    			  </c:forEach>
						</ul>
					</div>
	    		</div>
	    	</div>
	    	
	    	
	    		
	    		
	    		<div class="container web-tag">
					<div style="float: left;height: 60px; font-size: 16px;width: 10%;">
					 	<img src="${statics }/images/tag.png" width="30" height="30" alt="视频标签"/>
						<b><strong>视频标签</strong></b>
					</div>
					<div style="float: left;width: 90%;">
						<ul style="float: left;">
							<li>
								美女套图
							</li>
							<li>
								H动漫
							</li>
							<li>
								宅男福利
							</li>
							<li>
								美女合集
							</li>
							<li>
								女主女奴
							</li>
							<li>
								门事件
							</li>
							<li>
								VIP私拍
							</li>
							<li>
								人气女优
							</li>
							<li>
								捆绑绳技
							</li>
							<li>
								电击
							</li>
							<li>
								三级电影
							</li>
							<li>
								白嫩主播
							</li>
							<li>
								大尺度
							</li>
							<li>
								激情热舞
							</li>
							<li>
								破解流出
							</li>
							<li>
								气质女神
							</li>
							<li>
								美女直播
							</li>
							<li>
								真人直播
							</li>
						</ul>
					</div>
				</div>
	    		
	    		
	    		
	    		<div id="jx_div" align="center">
					<table width="990" height="120" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td class="tdtitle" style="color:#fd3a99; border-left:#fd3a99 solid 4px; ">电影专区</td>
								<td>亚洲电影</td>
								<td>欧美电影</td>
								<td>日韩爽片</td>
								<td>偷拍流出</td>
								<td>制服丝袜</td>
								<td>岛国伦理</td>
								<td>经典港片</td>
								<td>女神合集</td>
							</tr>
							<tr>
								<td class="tdtitle" style="color:#e69a17; border-left:#e69a17 solid 4px;">激情图库</td>
								<td>唯美清纯</td>
								<td>靓模私拍</td>
								<td>自拍偷拍</td>
								<td>私房写真</td>
								<td>性感诱惑</td>
								<td>美腿丝袜</td>
								<td>美女套图</td>
								<td>另类图片</td>
							</tr>
							<tr>
								<td class="tdtitle" style="color:#79d222; border-left:#79d222 solid 4px;">在线视频</td>
								<td>美女视频</td>
								<td>在线直播</td>
								<td>制服陪聊</td>
								<td>同城约会</td>
								<td>主播聊天</td>
								<td>湿身热舞</td>
								<td>寂寞少女</td>
								<td>妖艳熟女</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				
	    	</div>
	    </div>
 		  	
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