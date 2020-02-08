<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增</title>
	<%@ include file="/WEB-INF/jsps/layout/base-validate-js.jsp"%>
	
	<link rel="stylesheet" type="text/css" href="${statics }/css/kindeditor/prettify.css" />
	<script type="text/javascript" src="${statics }/js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${statics }/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="${statics }/js/kindeditor/prettify.js"></script>
	<script type="text/javascript" src="${statics }/js/kindeditor/zh_CN.js"></script>
</head>

<body>
	<div class="pageContent">
		<div class="doc-content m10">
	    	<div class="panel">
			      <div class="panel-header">
			        	<strong>
			        		<c:choose>
			        			<c:when test="${op eq 'add' }">
			        				新增活动
			        			</c:when>
			        			<c:when test="${op eq 'edit' }">
			        				编辑
			        			</c:when>
			        		</c:choose>
			        	</strong>
			      </div>
		
				  <form id="objForm" method="post" enctype="application/x-www-form-urlencoded">
				  	<input name="id" type="hidden" value="${dto.id }"/>
					<table class="table table-bordered definewidth">
					    <tr>
					        <td width="10%" class="tableleft">活动名称：</td>
					        <td>
					        	<input type="text" name="name" maxlength="15" value="${dto.name }" style="width:400px;"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td width="10%" class="tableleft">副标题：</td>
					        <td>
					        	<input type="text" name="title" maxlength="60" value="${dto.title }" style="width:400px;"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">活动代码：</td>
					        <td>
					        	<input type="text" name="discountCode" value="${dto.discountCode }"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">存款金额上下限设定：</td>
					        <td>
					        	<input type="text" name="moneyUp" value="${dto.moneyUp }" maxlength="15"/>
					        	一
					        	<input type="text" name="moneyDown" value="${dto.moneyDown }" maxlength="15"/>
					        	<span class="error"></span></td>
					    </tr>
					    <tr>
					        <td class="tableleft">红利百分比：</td>
					        <td>
					        	<input type="text" name="dividendPercent" value="<fmt:formatNumber value="${dto.dividendPercent }" type="currency" pattern="##.##"/>" maxlength="5"/> <font color="blue">%</font>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">红利上限：</td>
					        <td>
					        	<input type="text" name="dividendUp" value="${dto.dividendUp }" maxlength="5"/>
					        	<span class="error">
					        </span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">参加次数：</td>
					        <td>
					        	<input type="text" name="count" value="${dto.count }" maxlength="3"/>
					        	<span class="error">
					        </span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">流水倍数：</td>
					        <td>
					        	<input type="text" name="multiple" value="${dto.multiple }" maxlength="3"/>
					        	<span class="error">
					        </span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">会员类别：</td>
					        <td>
					        	<xjw:selectBar name="memberStart" clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" myClass="" type="select" value="${dto.memberStart }"/>
					         	  一
					         	<xjw:selectBar name="memberEnd" clazz="com.xjw.kzenum.user.MemberVIPTypeEnum" myClass="" type="select" value="${dto.memberEnd }"/>
					           <span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">活动时间段：</td>
					        <td>
		    					<input type="text" name="startTime" value="<fmt:formatDate value="${dto.startTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" id="startTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'})"/>
								一
								<input type="text" name="endTime" value="<fmt:formatDate value="${dto.endTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" id="endTime" class="datepicker" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:'2020-10-01'})"/>
								<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">图片地址：</td>
					        <td>
					        	<input type="text" id="pictureUrl" name="pictureUrl" value="${dto.pictureUrl }" style="width:400px;"/>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">文字说明：</td>
					        <td>
					        	<textarea id="explains" name="explains" class="uneditable-textarea" cols="47" rows="5" style="width: 500px">${dto.explains }</textarea>
					        	<span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">备注：</td>
					        <td>
					        	<textarea name="remark" class="uneditable-textarea" cols="45" rows="5">${dto.remark}</textarea>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">类别：</td>
					        <td>
					        	<xjw:selectBar name="type" value="${dto.type}" clazz="com.xjw.kzenum.activity.ActivityTypeEnum" type="select"  myClass=""/>
					           <span class="error"></span>
					        </td>
					    </tr>
					     <tr>
					        <td class="tableleft">返水：</td>
					        <td>
					        	<div style="color:red">
					        		注意： </br>
					        			1.若电子游戏勾选否，用户参与此活动期间， 统计日的所有投注总额和提款积分总额进行比较换算后计入奖金会员的返水 </br>
					        			2.若真人、体育勾选否，用户参与此活动期间的投注总额不计入返水</br>
					        			3.其它类别的活动全部勾选是
					        	</div>
					        	<xjw:selectBar name="rakeStatus" clazz="com.xjw.kzenum.sys.YesORNoEnum"  myClass="" type="radio" value="${dto.rakeStatus}" exclude="4,5"/>
					           <span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">状态：</td>
					        <td>
					        	<xjw:selectBar name="status" clazz="com.xjw.kzenum.activity.ActivityStatusEnum" 
					           myClass="" type="radio" value="${dto.status}" exclude="4,5"/>
					           <span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft">活动类型：</td>
					        <td>
					        	<xjw:selectBar name="comeFrom" clazz="com.xjw.kzenum.activity.ActivityComeFromEnum" 
					           myClass="" type="radio" value="${dto.comeFrom}"/>
					           <span class="error"></span>
					        </td>
					    </tr>
					    <tr>
					        <td class="tableleft"></td>
					        <td>
					            <button class="button button-primary" type="button" id="save">保存</button> 
					            &nbsp;&nbsp;
					            <button type="button" class="button" id="backId">返回列表</button>
					        </td>
					    </tr>
					</table>
			    </form>
			  
			  	<div class="bui-grid"><div class="bui-grid-bbar"></div></div>
		 	</div>
		 </div>	
	  </div>
      
      <script>
	    $(function () {
	    	BUI.use('bui/overlay');
	    	BUI.use(['bui/mask']);
	    	bindSkipClick("backId", "${ctx}/activity/info/list");
	    	bindClick("save", "${ctx}/activity/info/save");
	    	
	    	$("#objForm").validate({
	    		rules: {
	    			name: {
	    				required:true,maxlength:15
	    			},
	    			title: {
	    				required:true
	    			},
	    			discountCode: {
	    				required:true,
	    				remote: {
	    					async:false,
							url: "/activity/info/checkDiscountCode",
							dataType:"html",  
							data: {
								id: function(){return $("input:hidden[name=id]").val();},
								discountCode: function(){return $("input:text[name=discountCode]").val();}
	    					},
							dataFilter: function(data, type){
								var json = JSON.parse(data)
								return (json.code == 1);
							}
						}
	    			},
	    			moneyUp: {
	    				required:true,maxlength:10, number:true
	    			},
	    			moneyDown: {
	    				required:true,maxlength:10, number:true
	    			},
	    			dividendPercent: {
	    				required:true,maxlength:3, number:true
	    			},
	    			dividendUp: {
	    				required:true,maxlength:5, number:true
	    			},
	    			count: {
	    				required:true,maxlength:5, number:true, digits : true
	    			},
	    			multiple: {
	    				required:true,maxlength:3, number:true, digits : true
	    			},
	    			memberStart: {
	    				required:true
	    			},
	    			memberEnd: {
	    				required:true
	    			},
	    			startTime: {
	    				required:true
	    			},
	    			endTime: {
	    				required:true
	    			},
	    			type:{
	    				required:true
	    			},
	    			rakeStatus:{
	    				required:true
	    			},
	    			status: {
	    				required:true
	    			},
	    			
	    			explains: {maxlength:8000},
	    			remark: {maxlength:250}
	    		},messages:{
	    			name: {
	    				required:"活动名称为必填项",maxlength:"活动名称不能超过15个字符"
	    			},
	    			title: {
	    				required:"副标题为必填项"
	    			},
	    			discountCode: {
	    				required:"活动代码为必填项",
	    				remote:"活动代码不能重复"
	    			},
	    			moneyUp: {
	    				required:"存款金额上限设定为必填项",maxlength:"存款金额上限设定不能超过10个字符",number:"存款金额上限设定必须为数字"
	    			},
	    			moneyDown: {
	    				required:"存款金额下限设定为必填项",maxlength:"存款金额下限设定不能超过10个字符",number:"存款金额下限设定必须为数字"
	    			},
	    			dividendPercent: {
	    				required:"红利百分比为必填项",maxlength:"红利百分比不能超过3个字符",number:"红利百分比必须为数字"
	    			},
	    			dividendUp: {
	    				required:"红利上限为必填项",maxlength:"红利上限不能超过5个字符",number:"红利上限必须为数字"
	    			},
	    			count: {
	    				required:"参加次数为必填项",maxlength:"参加次数不能超过5个字符",number:"参加次数必须为数字", digits: "参加次数必须为整数"
	    			},
	    			multiple: {
	    				required:"流水倍数为必填项",maxlength:"流水倍数不能超过3个字符",number:"流水倍数必须为数字", digits: "流水倍数必须为整数"
	    			},
	    			memberStart: {
	    				required:"会员类别为必填项"
	    			},
	    			memberEnd: {
	    				required:"会员类别为必填项"
	    			},
	    			startTime: {
	    				required:"活动开始时间为必填项"
	    			},
	    			endTime: {
	    				required:"活动结束时间为必填项"
	    			},
	    			type: {
	    				required:"活动类别为必填项"
	    			},
	    			rakeStatus:{
	    				required:"返水为必选项"
	    			},
	    			status: {
	    				required:"状态为必填项"
	    			},
	    		
	    			explains: {maxlength:"文字说明不能超过2500个字符"},
	    			remark: {maxlength:"备注不能超过250个字符"}
	    		},
	    		errorPlacement : function(error, element) {
	    			error.appendTo(element.siblings("span"));
	    		}
	    	});
	    });
	    /**
	     * kindEditor的与服务器交互配置
	     */
	    KindEditor.ready(function(K) {
	    	K.create('#explains', {
	    		width:"100%",
	    		height:"500px",
	    		allowFileManager : true,
	    		afterBlur: function(){this.sync();},
	    		items: [
						'source', '|', 'undo', 'redo', '|', 'preview', 'cut', 'copy', 'paste',
						'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
						'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
						'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
						'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
						'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',
						'table', 'hr', 'pagebreak',
						'anchor', 'link', 'unlink'
	    		        ]
	    	});
	    });
   
	  </script>
	  <%@ include file="/WEB-INF/jsps/layout/pub-click-js.jsp"%>
</body>
</html>
