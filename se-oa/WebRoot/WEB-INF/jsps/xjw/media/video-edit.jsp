<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑-视频管理</title>
<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
			<div class="panel">
				<div class="panel-header">
					<strong>编辑视频 - ${video.code}</strong>
				</div>
				<form id="objForm">
					<input type="hidden" name="id" value="${video.id}" />
					
					<table class="table table-bordered definewidth">
						<tr>
							<td colspan="4">
								<div style="float: left;">
									<video width="400px" height="300px" controls="controls" x5-playsinline="" playsinline="" webkit-playsinline="">
									    <source src="${videoStatics }/video/${video.path}" type="video/mp4"></source>
									    請下載谷歌或火狐瀏覽器
									</video>
									<img src="${videoStatics }/image/${video.imagePath}" width="400px" height="300px"></img>
								</div>
								
							</td>
						</tr>
						<tr>
							<td class="tableleft">原名</td>
							<td>${video.originalName}</td>
							<td class="tableleft">视频大小</td>
							<td>${video.size}K</td>
						</tr>
						<tr>
							<td class="tableleft">视频路径</td>
							<td>${video.path}</td>
							<td class="tableleft">视频时长</td>
							<td>${video.length}秒</td>
						</tr>
						<tr>
							<td class="tableleft">图片路径</td>
							<td colspan="3">
								${video.imagePath} 
								<button type="button" id="btnImage" class="btn btn-primary">换一张</button>
							</td>
						</tr>

						<tr>
							<td class="tableleft">标题：</td>
							<td><input type="text" name="title" style="width:300px;" value="${video.title}" /></td>
							<td class="tableleft">类型：</td>
							<td><xjw:selectBar name="type" myClass="" clazz="com.xjw.kzenum.media.VideoTypeEnum" type="select" value="${video.type}"/></td>
						</tr>
						<tr>
							<td class="tableleft">主角：</td>
							<td><input type="text" name="star" style="width:300px;" value="${video.star}" /></td>
							<td class="tableleft">VIP视频：</td>
							<td><xjw:selectBar name="vipFlag" myClass="" clazz="com.xjw.kzenum.sys.YesORNoEnum" type="radio" value="${video.vipFlag}" exclude="3"/></td>
						</tr>
						<tr>
							<td class="tableleft">关键字：</td>
							<td><input type="text" name="keyword" style="width:300px;" value="${video.keyword}" /></td>
							<td class="tableleft">显示状态：</td>
							<td><xjw:selectBar name="status" myClass="" clazz="com.xjw.kzenum.sys.YesORNoEnum" type="radio" value="${video.status}" exclude="3"/></td>						
						</tr>
						
						<tr>
							<td class="tableleft">点击次数：</td>
							<td><input type="text" name="clickCount" value="${video.clickCount}" /></td>
							<td class="tableleft">收藏人数：</td>
							<td><input type="text" name="favoriteCount" value="${video.favoriteCount}" /></td>
						</tr>
						<tr>	
							<td class="tableleft"></td>
							<td colspan="3">
								<button type="button" class="button button-primary" id="save">保存</button>
								&nbsp;&nbsp;
								<button type="button" class="button" id="backId">返回列表</button>
							</td>
						</tr>
					</table>
				</form>

				<div class="bui-grid">
					<div class="bui-grid-bbar"></div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			BUI.use(['bui/overlay', 'bui/mask']);
			
			$("#btnImage").click(function(){
				var second = prompt("截取第几秒的视频图片", 1);
				if(second) {
					var data = {"id" : ${video.id}, "second" : second};
					$.getJSON("${ctx}/video/screen", data, function(json){
						alert(JSON.stringify(json));
					});
				}
			});
			
			$("#objForm").validate({
				rules : {
					title : {required : true},
					type : {required : true},
					vipFlag : {required : true},
					status : {required : true}
				},
				messages : {
					title : {required : "视频标题不能为空"},
					type : {required : "视频类型不能为空"},
					vipFlag : {required : "会员视频不能为空"},
					status : {required : "显示状态不能为空"}
				}
			});

			bindSkipClick("backId", "${ctx}/video/list");
			bindClick("save", "${ctx}/video/update");
		});
	</script>
	<%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>