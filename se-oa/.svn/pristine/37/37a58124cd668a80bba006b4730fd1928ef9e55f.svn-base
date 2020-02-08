package com.xjw.controller.user;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.user.MemberAmountForm;
import com.xjw.entity.vo.user.MemberAmountVo;
import com.xjw.service.user.MemberService;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/memberamount")
public class MemberAmountController extends BaseController{

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("list")
	public String list(MemberAmountForm form, Model model){
		if(null == form.getDayType()){
			form.setDayType(2);
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(form.getKeywords())){
			params.put("keywords", form.getKeywords());
		}
		
		if(StringUtils.isNotBlank(form.getBeginTime()) || StringUtils.isNotBlank(form.getEndTime())){
			form.setDayType(null);
			
			if(StringUtils.isNotBlank(form.getBeginTime())){
				params.put("beginTime", form.getBeginTime());
			}
			
			if(StringUtils.isNotBlank(form.getEndTime())){
				params.put("endTime", form.getEndTime());
			}
		}else{
			String[] rangeTimes = this.getRangeTimes(form.getDayType());
			params.put("beginTime", rangeTimes[0]);
			params.put("endTime", rangeTimes[1]);
		}
		if(StringUtils.isNotBlank(form.getVipType())){//VIP会员等级 0,1,2,3,4,5
			if("9".equals(form.getVipType())){//所有
				params.put("viptypes", StringUtil.getListFromStr("0,1,2,3,4,5"));
			}else if("8".equals(form.getVipType())){//所有VIP
				params.put("viptypes", StringUtil.getListFromStr("1,2,3,4,5"));
			}else{
				params.put("viptype", form.getVipType());
			}
		}
		
		Page<MemberAmountVo> page = memberService.queryMemberAmountVoPage(params, form.getPageNo(), form.getPageSize());
	    
		model.addAttribute("page", page);
		model.addAttribute("form", form);
		return "xjw/member/memberamount-list";
	}
	
	//获取日期段
	private String[] getRangeTimes(Integer dayType){
		Calendar nowTime = Calendar.getInstance();
		
		Calendar beginTime = null;
		Calendar endTime = null;
		
		if(dayType == 1){ //今天
			beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE));
		}else if(dayType == 2){	//昨天
			beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE)-1);
			endTime = new GregorianCalendar(beginTime.get(Calendar.YEAR), beginTime.get(Calendar.MONTH), beginTime.get(Calendar.DATE), 23, 59, 59);
		}else if(dayType == 3){	//最近一周
			beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE)-7);
		}else if(dayType == 4){ // 最近两周
			beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE)-14);
		}else if(dayType == 5){ // 最近一月
			beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH) - 1, nowTime.get(Calendar.DATE));
		}
		
		return new String[]{
			(null == beginTime ? null : DateFormatUtils.format(beginTime, "yyyy-MM-dd HH:mm:ss")),
			(null == endTime ? null : DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm:ss")),
		};
	}
}
