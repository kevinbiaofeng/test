package com.xjw.controller.order;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.order.WithdrawalOrderForm;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.order.WithdrawalTimeCount;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.utility.StringUtil;

/**
 * 提款时间统计
 * @author qing
 *
 */

@Controller
@RequestMapping("/order/timecount/")
public class WithdrawalTimeCountController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(WithdrawalTimeCountController.class);
	
	@Resource
	private WithdrawalOrderService withdrawalOrderService;
	
	@RequestMapping("/list")
	public String list(Model model, WithdrawalOrderForm form, HttpServletRequest request) {
		try {
			String nowDate = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd");
			if(StringUtils.isBlank(form.getBeginTime()) && StringUtils.isBlank(form.getEndTime())){
				form.setBeginTime(nowDate + " 00:00:00");
				form.setEndTime(nowDate + " 23:59:59");
			}
			
			Map<String, Object> params = new HashMap<String, Object>();
			String beginTime = form.getBeginTime();
			if (StringUtil.isNotBlank(beginTime)) {
				params.put("beginTime", beginTime);
			}
			String endTime = form.getEndTime();
			if (StringUtil.isNotBlank(endTime)) {
				params.put("endTime", endTime);
			}
			
			List<WithdrawalTimeCount> page = withdrawalOrderService.getWithdrawalOrderListByTime(params);
			model.addAttribute("page", page);
			model.addAttribute("form", form);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/timecount/list";
	}
	
	/** 详情  **/
	@RequestMapping("/details")
	public String details(Model model, WithdrawalOrderForm form, HttpServletRequest request) {
		try {
			String nowDate = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd");

			if(StringUtils.isBlank(form.getBeginTime()) && StringUtils.isBlank(form.getEndTime())){
				form.setBeginTime(nowDate + " 00:00:00");
				form.setEndTime(nowDate + " 23:59:59");
			}
			
			Map<String, Object> params = new HashMap<String, Object>();
			String beginTime = form.getBeginTime();
			if (StringUtil.isNotBlank(beginTime)) {
				params.put("beginTime", beginTime);
			}
			String endTime = form.getEndTime();
			if (StringUtil.isNotBlank(endTime)) {
				params.put("endTime", endTime);
			}
			String type = form.getType();
			if (StringUtil.isNotBlank(type)) {//财务：finance  风控：risk
				String userId = form.getUserId();
				if(type.equals("finance")){
					params.put("financeUser", userId);
				}
				if(type.equals("risk")){
					params.put("riskUser", userId);
				}
				form.setType(type);
				form.setUserId(userId);
			}
			params.put("statusList", StringUtil.getListFromStr("2"));
			
			Page<WithdrawalOrder> page = withdrawalOrderService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
			model.addAttribute("form", form);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/timecount/details";
	}
	
}
