package com.xjw.controller.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xjw.entity.Page;
import com.xjw.entity.form.data.SummaryDayForm;
import com.xjw.entity.po.data.SummaryDay;
import com.xjw.entity.vo.data.CwSummaryDayVo;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.service.data.SummaryDayService;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/data/cwsummaryday")
public class CwSummaryDayController {
	private static Logger logger = LoggerFactory.getLogger(CwSummaryDayController.class);
	
	@Autowired
	private SummaryDayService summaryDayService;
	
	@RequestMapping("/list")
	public String list(SummaryDayForm form, Model model) {
		Map<String, Object> params = new HashMap<String, Object>();

		if(StringUtils.isNotBlank(form.getBeginTime())){
			params.put("beginTime", form.getBeginTime());
		}
		if(StringUtils.isNotBlank(form.getEndTime())){
			params.put("endTime", form.getEndTime());
		}
		
		try{
			Page<SummaryDay> page = summaryDayService.getPage(params, form.getPageNo(), form.getPageSize());
			
			//存款项的Header
			JSONObject headerJson = new JSONObject();
			for(SummaryDay summaryDay : page.getDataList()){
				if(StringUtils.isNotBlank(summaryDay.getDepositExt())){
					JSONObject jsonObject = JSONObject.parseObject(summaryDay.getDepositExt());
					for(Entry<String, Object> entry : jsonObject.entrySet()){
						if(!headerJson.containsKey(entry.getKey())){
							headerJson.put(entry.getKey(), TradeModeEnum.getEnumByCode(TradeModeEnum.class, entry.getKey()));
						}
					}
				}
			}
			

			List<CwSummaryDayVo> cwDayVoList = new ArrayList<CwSummaryDayVo>();
			for(SummaryDay summaryDay : page.getDataList()){
				JSONObject jsonObject = JSONObject.parseObject(summaryDay.getDepositExt());
				
				JSONObject fieldJson = new JSONObject();
				for(Entry<String, Object> entry : headerJson.entrySet()){
					BigDecimal value = (jsonObject == null ? BigDecimal.ZERO : jsonObject.getBigDecimal(entry.getKey()));
					value = (value == null ? BigDecimal.ZERO : value);
					fieldJson.put(entry.getKey(), value);
				}
				
				CwSummaryDayVo cwDayVo = new CwSummaryDayVo();
				cwDayVo.setDayTime(summaryDay.getDayTime());
				cwDayVo.setDepositAmount(summaryDay.getDepositAmount());
				cwDayVo.setWithdrawalAmount(summaryDay.getWithdrawalAmount());
				cwDayVo.setDepositItems(fieldJson);
				cwDayVoList.add(cwDayVo);
			}
			
			model.addAttribute("page", page);
			model.addAttribute("cwDayVoList", cwDayVoList);
			model.addAttribute("headerJson", headerJson);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}

		model.addAttribute("form", form);
		return "xjw/data/cwsummaryday";
	}
	
	public static void main(String[] args) {
		JSONObject jsonObject = JSONObject.parseObject("");
		System.out.println(jsonObject.getString("1"));
	}
}
