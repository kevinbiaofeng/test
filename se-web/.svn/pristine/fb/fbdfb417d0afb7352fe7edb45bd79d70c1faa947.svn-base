<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />	
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1" />
		<title>老司机510-我的资料</title>
    	<meta name="keywords" content="老司机,老司机510,老司机2018,老司机小电影,老司机精品,老司机网,老司机福利,老司机电影网,老司机什么意思" />
    	<meta name="description" content="老司机510是汇集全球视频，及时收录各国视频内容的一家永久免费在线看片平台。看片，从老司机510平台开始。" />
    	<link href="${statics }/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${statics }/css/common.css" rel="stylesheet" />
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
	    				 我的資料
	    			</div>
	    			<div class="center-content">
	    				<div class="detail-title">
	    					帳號信息
	    				</div>
	    				<div class="detail-info">
    						<div class="form-group col-sm-12">
	    						<label class="col-sm-2 control-label">
	    							<b>帳&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;號：</b>
	    						</label>
								<div class="col-sm-10">
									${user.loginName}
								</div>
							</div>
							<div class="form-group col-sm-12">
	    						<label class="col-sm-2 control-label">
	    							<b>注册郵箱：</b>
	    						</label>
								<div class="col-sm-10">
									${member.email}
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-2 control-label">
									<b>收藏視頻：</b>
								</label>
					   			<div class="col-sm-10">
					   				 ${favoriteCount } 部
					   			</div>
					   		</div>
					   		<div class="form-group col-sm-12">
								<label class="col-sm-2 control-label">
									<b>当前積分：</b>
								</label>
					   			<div class="col-sm-10"> ${integral } 積分 </div>
					   		</div>
    					</div>
	    			</div>
	    		</div>
    		</div>
    	</div>
		
		<%@ include file="/WEB-INF/jsps/commons/footer.jsp"%>
	</body>
</html>