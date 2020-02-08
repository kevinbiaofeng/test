<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户列表</title>
	<%@ include file="/WEB-INF/jsps/layout/base-js.jsp"%>
</head>


<body>
	<div class="pageContent">
  		<div class="doc-content">
  			<div class="well">
				<button type="button" class="btn btn-info" id="add"><i class="icon-white icon-plus"></i>新增功能</button>
			</div>
	    	<div class="panel">
		      <div class="panel-header">
		        	<strong>功能列表</strong>
		      </div>
		        	
        	  <table class="table table-bordered definewidth">
				    <thead>
					    <tr>
					        <th>标题</th>
					        <th>级别</th>
					        <th>编号（唯一）</th>
					        <th>主菜单排序级别</th>
					        <th>排序级别</th>
					        <th>状态</th>
					        <th width="300px">操作</th>
					    </tr>
				    </thead>
			    	<c:choose>
			    		<c:when test="${not empty list }">
			    			<tbody>
				    			<c:forEach var="menu" items="${list }">
				    				<c:if test="${menu.parentId eq 0}">
				    					 <tr><td colspan="7" style="background-color: gray;"></td></tr>
				    					<tr style="<c:if test="${menuD.showFlag == 2}"> background: #ffccff</c:if>">
								            <td class="first">${menu.name }</td>
								            <td class="first">主菜单</td>
								            <td class="first">${menu.code }</td>
								            <td class="first">${menu.level }</td>
								            <td class="first"></td>
								            <td class="first" style="color: ${menu.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${menu.status }" /></td>
								            <td>
								            	<input type="hidden" name="id" value="${menu.id }" />
												<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
												<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
												<button type="button" class="btn btn-info add-but"><i class="icon-white icon-plus"></i>新增子菜单</button>
								            </td>
								        </tr>
								        <c:forEach var="menuF" items="${list }">
								        	<c:if test="${menuF.parentId eq menu.id}">
									        	<tr style="<c:if test="${menuF.showFlag == 2}"> background: #ffccff</c:if>">
										            <td style="font-size: 14px;">&nbsp;&nbsp;&nbsp;${menuF.name }</td>
										            <td style="font-size: 14px;">一级菜单</td>
										            <td style="font-size: 14px;">${menuF.code }</td>
										            <td style="font-size: 14px;">${menuF.level }</td>
										            <td style="font-size: 14px;">${menuF.sort }</td>
										            <td style="color: ${menuF.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${menuF.status }" /></td>
										            <td>
										            	<input type="hidden" name="id" value="${menuF.id }" />
										            	<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
														<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
														<button type="button" class="btn btn-info add-but"><i class="icon-white icon-plus"></i>新增子菜单</button>
										            </td>
										        </tr>
										        
										        <c:forEach var="menuC" items="${list }">
										        	<c:if test="${menuC.parentId eq menuF.id}">
											        	<tr style="color: gray; <c:if test="${menuC.showFlag == 2}"> background: #ffccff</c:if>">
												            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${menuC.name }</td>
												            <td>二级菜单</td>
												            <td>${menuC.code }</td>
												            <td>${menuC.level }</td>
												            <td>${menuC.sort }</td>
												            <td style="color: ${menuC.status eq '1' ? 'green' : 'red'}"><xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${menuC.status }" /></td>
												            <td>
												            	<input type="hidden" name="id" value="${menuC.id }" />
												            	<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
												            	<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
																<button class="button button-info add-but" type="button"><i class="icon-white icon-plus-sign"></i>新增按钮</button>
												            </td>
												        </tr>
												        
												        <c:forEach var="menuD" items="${list }">
												        	<c:if test="${menuD.parentId eq menuC.id}">
													        	<tr style="color: #984B4B; <c:if test="${menuD.showFlag == 2}"> background: #ffccff</c:if>">
														            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${menuD.name }</td>
														            <td>按钮</td>
														            <td>${menuD.code }</td>
														            <td>${menuD.level }</td>
														            <td>${menuD.sort }</td>
														            <td style="color: ${menuD.status eq '1' ? 'green' : 'red'}">
														              <xjw:enumBar clazz="com.xjw.kzenum.sys.StatusEnum" code="${menuD.status }" />
														            </td>
														            <td>
														            	<input type="hidden" name="id" value="${menuD.id }" />
														            	<button type="button" class="btn btn-edit modify-but"><i class="icon-white icon-edit"></i>编辑</button>
																		<button type="button" class="btn btn-danger del-but"><i class="icon-white icon-remove-sign"></i>删除</button>
														            </td>
														        </tr>
														     </c:if>
												        </c:forEach>
												     </c:if>
										        </c:forEach>
										     </c:if>
								        </c:forEach>
								       
				    				</c:if>
						    	</c:forEach>
					    	</tbody>
			    		</c:when>
			    		<c:otherwise>
			    			<tr><td colspan="9" class="notdata"><spring:message code="page.text.notData" /></td></tr>
			    		</c:otherwise>
			    	</c:choose>
			      </table>
			      
		      	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
	 		</div>
	 	</div>	
  	</div>
	
      
      <script>
	    $(function () {
			bindSkipClick("add", "${ctx}/sysmenu/skipAdd");
			BUI.use('bui/overlay');
	    });
	    $(".add-but").click(function(){
			window.location.href="${ctx}/sysmenu/skipAdd?id=" + $(this).parent().find("input[name='id']").val();
		});
		$(".del-but").click(function() {
			var id = $(this).parent().find("input[name='id']").val();
			delRow(id, "${ctx}/sysmenu/del");
		});
		$(".modify-but").click(function() {
			window.location.href = "${ctx}/sysmenu/skipModify?id=" + $(this).parent().find("input[name='id']").val();
		});
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-list-js.jsp"%>
</body>
</html>