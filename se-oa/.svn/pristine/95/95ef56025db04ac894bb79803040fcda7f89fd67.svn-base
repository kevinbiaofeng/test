package com.xjw.controller.data;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.entity.Page;
import com.xjw.entity.form.data.PlayerCountForm;
import com.xjw.entity.po.data.PlayerCount;
import com.xjw.service.data.PlayerCountService;

@Controller
@RequestMapping("/data/player")
public class PlayerCountController {
	private static Logger logger= LoggerFactory.getLogger(PlayerCountController.class.getName());
	@Resource
	private PlayerCountService playerCountService;
	
	@RequestMapping("/list")
	public String index(PlayerCountForm form, Model model){
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(form.getBeginTime()) && StringUtils.isBlank(form.getEndTime())){
			Calendar beginTime = Calendar.getInstance();
			beginTime = new GregorianCalendar(beginTime.get(Calendar.YEAR), beginTime.get(Calendar.MONTH), beginTime.get(Calendar.DATE)-1);
			form.setBeginTime(DateFormatUtils.format(beginTime, "yyyy-MM-dd HH:mm:ss"));
			beginTime = new GregorianCalendar(beginTime.get(Calendar.YEAR), beginTime.get(Calendar.MONTH), beginTime.get(Calendar.DATE), 23, 59, 59);
			form.setEndTime(DateFormatUtils.format(beginTime, "yyyy-MM-dd HH:mm:ss"));
		}else{
			form.setBeginTime(form.getBeginTime());
			form.setEndTime(form.getEndTime());
		}
		if(StringUtils.isNotBlank(form.getBeginTime())){
			params.put("beginTime", form.getBeginTime());
		}
		if(StringUtils.isNotBlank(form.getEndTime())){
			params.put("endTime", form.getEndTime());
		}
		
		try {
			List<Long> userIdList = playerCountService.getUserIdList(params);
			params.put("userIds", userIdList);
			Page<PlayerCount> page = null;
			if(null != userIdList && userIdList.size() > 0){
				page = playerCountService.getPage(params, form.getPageNo(), form.getPageSize());
			}
			model.addAttribute("page", page);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:"+ e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		
		model.addAttribute("form", form);
		return "xjw/data/playercount";
	}
	
}