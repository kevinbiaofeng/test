<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />	
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1" />
		<title>老司机510-会员签到</title>
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
	    				 會員簽到
	    			</div>
				    <div class="account-box">
				        <h2 class="account-title">
				            <a href="###" class="f-btn-fhby left" title="點擊簽到"><i class="fa fa-hand-o-up"></i>點擊簽到</a>
				            <div class="clearfix right">
				                <div class="f-btn-jian left"></div>
				                <div class="left f-riqi">
				                	<span class="f-year">2017</span>年
				                	<span class="f-month">1</span>月
				                </div>
				                <div class="f-btn-jia left"></div>
				            </div>
				        </h2>
				        <div class="f-rili-table">
				            <div class="f-rili-head celarfix">
				                <div class="f-rili-th">週天</div>
				                <div class="f-rili-th">週一</div>
				                <div class="f-rili-th">週二</div>
				                <div class="f-rili-th">週三</div>
				                <div class="f-rili-th">週四</div>
				                <div class="f-rili-th">週五</div>
				                <div class="f-rili-th">週六</div>
				                <div class="clear"></div>
				            </div>
				            <div class="f-tbody clearfix">
				
				            </div>
				        </div>
				    </div>
				    <div style="padding-left: 30px;font-size: 14px;padding-bottom: 5px;">
					    <div>会员积分<font color="red">1积分</font>意味着，<font color="red">1</font>部VIP视频全天看</div>
						<div style="margin-top: 5px;">本站的所有视频都是免费观看的（观看<font color="red">VIP</font>视频需要扣除<font color="red">1签到积分</font>）</div>
						<div style="margin-top: 5px;">如果你在其他地方遇到老司机平台并且需要收费，那么你肯定是被骗了。</div>
						<div style="margin-top: 5px;">牢记我们的域名：<font color="red">www.lsj510.vip</font>，如果你们觉得平台好，记得帮忙推荐哦。</div>
					</div>
	    		</div>
    		</div>
    	</div>
		<script>
		$(function(){
				var dataList = null;
				$.ajax({
					type:"get",
					url:"${ctx}/sign/getMonthSign",
					data: {},
					dataType: 'json',
					async : false,
					success:function(data){
						dataList = data;
					}
				}); 
				
                var mydate = new Date();
                $(".f-year").html( mydate.getFullYear() );
                $(".f-month").html( mydate.getMonth()+1 );
                var thisMonth = mydate.getMonth() + 1;
                showDate(mydate.getFullYear(),mydate.getMonth()+1);
                
                $(".f-btn-fhby, .f-no").click(function(){
                    $.ajax({
    					type:"get",
    					url:"${ctx}/sign/today",
    					data: {},
    					dataType: 'json',
    					async : false,
    					success:function(data){
    						if(data.code == "306"){
    							layer.alert("今日已簽到，請明天再來。", {icon: 2});
    						}else if(data.code == "783"){
    							layer.alert("新用戶註冊滿3天即可簽到(註冊不滿3天，無法簽到)", {icon: 2});
    						}else if(data.code == "999"){
    							$(".account-box .f-btn-fhby").remove();
    							$(".f-no").attr("class", "f-right fa fa-check");
    							layer.alert("簽到成功！", {icon: 1});
    						}else{
    							layer.alert("系統異常，請稍後重試。", {icon: 2});
    						}
    					}
    				});
                })
                
                function showDate(yyyy, mm){
                    var dd = new Date(parseInt(yyyy),parseInt(mm), 0);
                    var daysCount = dd.getDate();
                    var datePanel ="";
                    var icon = "";
                    var today = new Date().getDate();
                    var monthstart = new Date(parseInt(yyyy)+"/"+parseInt(mm)+"/1").getDay()
                    var lastMonth;
                    var nextMounth;
                    if(  parseInt(mm) ==1 ){
                        lastMonth = new Date(parseInt(yyyy)-1,parseInt(12), 0).getDate();
                    }else{
                        lastMonth = new Date(parseInt(yyyy),parseInt(mm)-1, 0).getDate();
                    }
                    if( parseInt(mm) ==12 ){
                        nextMounth = new Date(parseInt(yyyy)+1,parseInt(1), 0).getDate();
                    }else{
                        nextMounth = new Date(parseInt(yyyy),parseInt(mm)+1, 0).getDate();
                    }
                    
                    for(j = monthstart;j > 0;j--){
                        datePanel += "<div class='f-td f-null f-lastMonth' style='color:#ccc;'>"+(lastMonth-j+1)+"</div>";
                    }
                    
                    var today = mydate.getDate();
                    for(i=0;i < daysCount; i++){
                        datePanel += "<div class='f-td f-number'><span class='f-day'>"+(i+1)+"</span>"
								var bool = false;
								$.each(dataList, function(j, obj){
									if((i+1) == obj.day){
										datePanel += "<div class='f-right fa fa-check'></div>"
										+"<div class='f-table-msg'>積分+<span class='major'>"+obj.integral+"</span> 已簽到：<span class='major'>"+obj.continueCount+"</span>天</div></div>";
										bool = true;
									}
									if((i+1) == today){
										$(".account-box .f-btn-fhby").remove();
									}
								});
                     			if(!bool){
                     				if((i+1) == today){
                     					datePanel += "<div class='f-no fa fa-check-square-o' title='點擊簽到'></div></div>";
                     				}else{
                     					datePanel += "<div class='f-bad fa fa-close'></div></div>";
                     				}
                     			}
                     			
                    }
                    
                    
                    $(".f-rili-table .f-tbody").html(datePanel);
                    if(mydate.getFullYear() == yyyy){
                        if((mydate.getMonth()+1) == mm){
                            var today = mydate.getDate();
                            var lastNum = $(".f-lastMonth").length;
                            $(".f-rili-table .f-td").eq(today+lastNum-1).addClass("f-today");
                        }
                    }
                    
                    $(".f-right").off("mouseover");
                    $(".f-right").on("mouseover",function(){
                        $(this).parent().find(".f-table-msg").show();
                    });
                    $(".f-table-msg").off("mouseover");
                    $(".f-table-msg").on("mouseover",function(){
                        $(this).show();
                    });
                    $(".f-right").off("mouseleave");
                    $(".f-right").on("mouseleave",function(){
                        $(this).parent().find(".f-table-msg").hide();
                    });
                    $(".f-table-msg").off("mouseleave");
                    $(".f-table-msg").on("mouseleave",function(){
                        $(this).hide();
                    });
                }
                
            })
		</script>
		<%@ include file="/WEB-INF/jsps/commons/footer.jsp"%>
	</body>
</html>