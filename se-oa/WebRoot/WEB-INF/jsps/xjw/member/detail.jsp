<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员详情信息</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
		      <div class="panel-header">
	        	<strong>会员详细信息</strong>
	        	<div style="float: right;margin-top:-9px;">
					<button type="button" class="btn btn-inverse" id="backId"><i class="icon-white icon-home"></i>返回列表</button>
				</div>
		      </div>
	
			  <form id="objForm">
			  		<input type="hidden" id="userId" value="${dto.id }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td class="tableleft" style="width: 10%">会员账号</td>
					        <td class="tableleft" style="width: 10%">真实姓名</td>
					        <td class="tableleft" style="width: 10%">性别</td>
					        <td class="tableleft" style="width: 13%">联系电话</td>
					        <td class="tableleft" style="width: 10%">QQ</td>
					        <td class="tableleft" style="width: 13%">邮箱</td>
					        <td class="tableleft" style="width: 15%">&nbsp;</td>
					        <td class="tableleft" colspan="2">
					        	<xjw:auth code="YWGL-HYGL-LIST-XGHYZL">
					        		<button type="button" class="btn btn-edit" id="editUserBut"><i class="icon-white icon-edit"></i>修改会员资料</button>
					        	</xjw:auth>
							</td>
					    </tr>
					    <tr>
					        <td>${dto.loginName }</td>
					        <td>${dto.name }</td>
					        <td>
					        	<xjw:enumBar clazz="com.xjw.kzenum.user.SexTypeEnum" code="${dto.sex }"/></td>
					        <td>
					        	<xjw:subStringTag input="${dto.phone}" replace="****" type="phone" />
					        
					        	<c:choose>
					        		<c:when test="${memberCheck.phoneFlag == 1}"><font color="green">(已验证)</font></c:when>
					        		<c:when test="${memberCheck.phoneFlag == 2}"><font color="red">(未验证)</font></c:when>
					        	</c:choose>
					        </td>
					        <td><xjw:subStringTag input="${dto.qq}" replace="****" type="qq" /></td>
					        <td>
					        	<xjw:subStringTag input="${dto.email}" replace="****" type="email" />
					        
					        	<c:choose>
					        		<c:when test="${memberCheck.emailFlag == 1}"><font color="green">(已验证)</font></c:when>
					        		<c:when test="${memberCheck.emailFlag == 2}"><font color="red">(未验证)</font></c:when>
					        	</c:choose>
					        </td>
					        <td>&nbsp;</td>
					        <td colspan="2">
					        	<xjw:auth code="YWGL-HYGL-LIST-CZMM">
					        		<button type="button" class="btn btn-edit" id="findPwd"><i class="icon-white icon-edit"></i>重置密码</button>
					        	</xjw:auth>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">会员状态</td>
					        <td class="tableleft">会员类别</td>
					        <td class="tableleft">生日</td>
					        <td class="tableleft">注册时间</td>
					        <td class="tableleft">最后登录IP</td>
					        <td class="tableleft">主平台余额</td>
					        <td class="tableleft">提款积分</td>
					        <td class="tableleft" colspan="2">
					        </td>
					    </tr>
					    <tr>
					        <td><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${dto.status }"/></td>
					        <td><xjw:enumBar clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" code="${dto.vipType }"/></td>
					        <td><fmt:formatDate value="${dto.birthday }" type="both" pattern="yyyy-MM-dd"/></td>
					        <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					        <td>${dto.loginIp }</td>
					        <td><fmt:formatNumber value="${dto.totalMoney }" type="currency" pattern="#.##"/></td>
					        <td><fmt:formatNumber value="${dto.integral }" type="currency" pattern="#.##"/></td>
					        <td>&nbsp;</td>
					        <td>&nbsp;</td>
					    </tr>
					    
					    <tr>
					        <td class="tableleft" colspan="2">最近登录时间</td>
					        <td class="tableleft" colspan="2">最近存款时间</td>
					        <td class="tableleft" colspan="2">最近回访时间</td>
					        <td class="tableleft" colspan="3"><button class="btn btn-info" type="button" id="addRemark"><i class="icon-white icon-plus"></i>添加备注</button></td>
					    </tr>
					    <tr>
					    	<td colspan="2"><fmt:formatDate value="${dto.loginTime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
					    	<td colspan="2">
					    		<c:choose>
					    			<c:when test="${not empty depositOrder}">
					    				<fmt:formatDate value="${depositOrder.createTime}" type="both" pattern="yyyy-MM-dd HH:mm"/>
					    			</c:when>
					    			<c:otherwise>------</c:otherwise>
					    		</c:choose>
					    	</td>
					    	<td colspan="2">
					    		<c:choose>
					    			<c:when test="${not empty callcsDetail}">
					    				<fmt:formatDate value="${callcsDetail.updateTime}" type="both" pattern="yyyy-MM-dd HH:mm"/>
					    			</c:when>
					    			<c:otherwise>------</c:otherwise>
					    		</c:choose>
					    	</td>
					    	<td colspan="3">&nbsp;</td>
					    </tr>
					    
					    <c:choose>
						    <c:when test="${not empty memberRemarkList }">
				    			<tbody>
				    				<c:forEach var="dto" items="${memberRemarkList }" varStatus="status">
								    	<tr>
								    		<c:if test="${status.index eq 0}">
								    			<td class="tableleft" rowspan="${fn:length(memberRemarkList)}" style="color: black;"><a href="######" id="goRemark">备注：</a></td>
								    		</c:if>
								    		<td>
							    				<xjw:enumBar clazz="com.xjw.kzenum.user.RemarkTitleTypeEnum" code="${dto.titleType }"/>
								    		</td>
								            <td title="${dto.remark }" colspan="3"><xjw:subStringTag input="${dto.remark}" replace="......" size="20"></xjw:subStringTag></td>
								            <td><fmt:formatDate value="${dto.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								            <td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
								        </tr>
							    	</c:forEach>
						    	</tbody>
					    	</c:when>
					    	<c:otherwise>
				    			<tr>
				    				<td class="tableleft" rowspan="10" style="color: black;"><a href="######" id="goRemark">备注：</a></td>
				    				<td colspan="10" class="notdata"><spring:message code="page.text.notData" /></td>
				    			</tr>
				    		</c:otherwise>
				    	</c:choose>
					</table>
			    </form>
			   <div class="bui-grid"><div class="bui-grid-bbar"></div></div>
	 	</div>
	 	<br />
	 	
	 	<!-- 会员详细信息             end -->
	 	
	    <div class="panel" style="width: 60%">
		      <div class="panel-header">
	        	<strong>其他信息</strong>
		      </div>
			    <table class="table">
				    <tr>
				        <td class="tableleft">代理归属</td>
				        <td class="tableleft" width="30%">注册IP</td>
				        <td class="tableleft" width="30%">注册地址</td>
				    </tr>
				    <tr>
				        <td>${agent.loginName}
				        	<xjw:auth code="YWGL-HYGL-LIST-GHDL">
				        		<button id="btnChangeAgent">更换代理</button>
				        	</xjw:auth>
				        </td>
				        <td>${dto.registerIp }</td>
				        <td>${dto.registerIpCityInfo }</td>
				    </tr>
				</table>
		  <div class="bui-grid"><div class="bui-grid-bbar"></div></div>
 	  </div>
	 	  
		<!-- 其他信息             end --> 
		<br />

	 	  
	 	  <div class="panel">
                  <div class="panel-header">
                    <strong>游戏平台信息</strong>
                  </div>
                    <table class="table">
                        <tr>
                            <td class="tableleft">主平台</td>
                            <td class="tableleft">GM_MG</td>
                            <td class="tableleft">GM_PT</td>
                            <td class="tableleft">GM_AG</td>
                            <td class="tableleft">GM_PNG</td>
                            <td class="tableleft">GM_GG</td>
                        </tr>
                         <tr>
                            <td>余额：<span class="jq_balance"><fmt:formatNumber value="${dto.totalMoney }" type="currency" pattern="#.##"/></span></td>
                            <td>余额：<span class="jq_balance"><button data-type="8">查询</button></span></td>
                            <td>余额：<span class="jq_balance"><button data-type="9">查询</button></span></td>
                            <td>余额：<span class="jq_balance"><button data-type="10">查询</button></span></td>
                            <td>余额：<span class="jq_balance"><button data-type="11">查询</button></span></td>
                            <td>余额：<span class="jq_balance"><button data-type="12">查询</button></span></td>
                        </tr>
                    </table>
              <div class="bui-grid"><div class="bui-grid-bbar"></div></div>
          </div>
		</div>
	  </div>
      
      <div id="panel"></div>
       <div id="showDialog"></div>
      
      <script>
	    $(function () {
	    	bindSkipClick("backId", "${ctx}/member/info/list");
	    	BUI.use('bui/overlay');
	    });
	   
	    // 查询游戏平台余额
	    $("span.jq_balance button").click(function() {
	    	var $this = $(this);
            var platformType = $this.data("type");
            var url = "${ctx}/platform/" + platformType + "/balance";
            var data = {"userId" : "${dto.id}"};
            $.getJSON(url, data, function(json) {
            	if(json.success) {
            		$this.parent().text(json.model);
            	} else {
            		BUI.Message.Alert(json.msg, 'error');
            	}
            });
        });
	    
	    $("#goRemark").click(function (){
	    	window.location.href = "${ctx}/member/remark/list?userId=" + $("#userId").val();
	    })
	    
	    $("#addRemark").click(function(){
	    	$.ajax({
				type: "GET",
				url: "${ctx}/member/remark/skipAddRemark",
				data: {"userId" : $("#userId").val()},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#panel").html(data);
			    	});
			    }
	    	});
	    })
	    
	    $("#findPwd").click(function(){
	    	$.ajax({
				type: "GET",
				url: "${ctx}/member/info/sendEmailFindPwd",
				data: {"id" : $("#userId").val()},
				async: false,
				dataType: "text",
			    success: function(data) {
			    	if(data == "1"){
			    		BUI.Message.Alert('发送成功！','success');
			    	}else{
			    		BUI.Message.Alert('发送失败，请联系管理员！','error');
			    	}
			    }
	    	});
	    })


/*
	    $("#btnConcatShow, #btnConcatHide").click(function(){
	    	var url = "${ctx}/member/info/updatePrivacyFlag";
	    	var data = {memberId : '${dto.memberId}', privacyFlag : $(this).data("value")};
	    	$.get(url, data, function(data){
	    		if(data == "1"){
		    		BUI.Message.Alert('设置成功！','success');
		    		window.location.reload();
		    	}else{
		    		BUI.Message.Alert('设置失败，请联系管理员！','error');
		    	}
	    	});
	    });
*/


		//更换代理
		$("#btnChangeAgent").click(function(){
			$.ajax({
				type: "POST",
				url: "${ctx}/showPanel/openDialog",
				data: {"op" : "agentList", "k" : "r", "inputId" : "userId", "inputName" : "name"},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#showDialog").html(data);
			    	});
			    }
			});
		});

		function showCallback(userId){
			$.get("${ctx}/member/info/updateAgent", {"id" : "${dto.id}", "parentId" : userId}, function(data){
				if(data == "1"){
		    		BUI.Message.Alert('更换代理成功！','success');
		    	}else{
		    		BUI.Message.Alert('更换代理失败，请联系管理员！','error');
		    	}
				
				window.location.href = "${ctx}/member/info/detail?id=" + ${dto.id};
			});
		}
	
		//修改会员资料
	    $("#editUserBut").click(function(){
	    	$.ajax({
				type: "GET",
				url: "${ctx}/member/info/showUserEditPanel",
				data: {"id" : $("#userId").val()},
				async: false,
			    success: function(data) {
			    	BUI.use(['bui/mask'],function(Mask){
			    		 Mask.maskElement('body');
			    		 $("#panel").html(data);
			    	});
			    }
	    	});
	    });
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
