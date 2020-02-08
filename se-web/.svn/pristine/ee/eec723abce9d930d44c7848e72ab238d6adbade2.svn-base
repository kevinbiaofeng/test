<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>
<div class="center-left">
	<div class="left-user-top">
		<div class="photo" align="center">
			<img src="${statics }/images/user-center-photo.jpg"></img>
		</div>
		<div class="account" align="center">
			${sessionScope.memberUser.loginName}
			<img src="${statics }/images/vip.gif" alt="VIP"/>
		</div>
		<div class="info-list">
			<ul>
				<li>
					<div>
						<span>積分</span>
						<span>${integral }</span>
					</div>
				</li>
				<div class="vertical-line pull-left"></div>
				<li>
					<div>
						<span>收藏視頻</span>
						<span>${favoriteCount }</span>
					</div>
				</li>
				<div class="vertical-line pull-left"></div>
				<li>
					<div>
						<span>會員</span>
						<span style="font-size: 12px;">
							<font color="red">
								<se:enumBar clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" code="${memberUser.level}"></se:enumBar>
							</font>
						</span>
					</div>
				</li>
			</ul>
		</div>
	</div>
	
	<div class="left-user-bottom">
		<ul>
			<li>
				<a href="${ctx }/member/skipUserCenterAccount"><i class="fa fa-address-card-o"></i>我的資料</a>
			</li>
			<li>
				<a href="${ctx }/member/skipUpdatePwd"><i class="fa fa-lock"></i>修改密碼</a>
			</li>
			<li>
				<a href="${ctx }/member/skipMyFavorite/1/"><i class="fa fa-heart-o"></i>我的收藏</a>
			</li>
			<li>
				<a href="${ctx }/member/skipSign"><i class="fa fa-calendar"></i>會員簽到</a>
			</li>
			<li>
				<a href="${ctx }/member/vip" class="re"><i class="fa fa-thumbs-o-up"></i>VIP 介紹</a>
			</li>
		</ul>
	</div>
</div>