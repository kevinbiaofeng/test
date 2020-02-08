package com.xjw.controller.user;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.user.ActiveMembersForm;
import com.xjw.entity.po.user.OfficialMember;
import com.xjw.service.user.OfficialMemberService;

/**
 * 统计官网会员(pub_user.parent_id 为 null 的用户)的数据
 * 
 * @author qing
 *
 */
@Controller
@RequestMapping("/officialmember/count/")
public class OfficialMemberCountController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(OfficialMemberCountController.class);
	@Resource
	private OfficialMemberService officialMemberService;

	// 查询统计
	@RequestMapping("/query")
	public String querystat(@RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "loginName", required = false) String loginName, Model model,
			HttpServletRequest request) {
		try {
			if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
				Calendar nowTime = Calendar.getInstance();
				beginTime = DateFormatUtils.format(nowTime, "yyyy-MM");
				endTime = DateFormatUtils.format(nowTime, "yyyy-MM-dd");
				beginTime += "-01 00:00:00";
				endTime += " 23:59:59";
			} else {
				beginTime += " 00:00:00";
				endTime += " 23:59:59";
			}

			// 时间段注册用户数量
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			int registerCount = officialMemberService.selectCountByOfficialMember(params); 

			// 总注册用户数量
			int allRegisterCount = officialMemberService.selectCountByOfficialMember(new HashMap<String, Object>());
			
			// 时间段投注总额
			params = new HashMap<String, Object>();
			params.put("beginLocalTime", beginTime);
			params.put("endLocalTime", endTime);
			BigDecimal betAmount = officialMemberService.selectSumBetAmount(params);
			
			// 时间段存款总额
			params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			BigDecimal depositAmount = officialMemberService.selectAmountByOfficialMember(params);
			
			// 总存款总额
			BigDecimal allDepositAmount = officialMemberService.selectAmountByOfficialMember(new HashMap<String, Object>());
		
			// 时间段提款总额
			params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			BigDecimal withdrawAmount = officialMemberService.selectWithdrawalAmountByOfficialMember(params);
			
			// 总提款总额
			BigDecimal allWithdrawAmount = officialMemberService.selectWithdrawalAmountByOfficialMember(new HashMap<String, Object>());

			// 时间段红利总额
			params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			BigDecimal memberMoneyAmount = officialMemberService.selectMMCAmountByOfficialMember(params);

			// 总红利总额
			BigDecimal allMemberMoneyAmount = officialMemberService.selectMMCAmountByOfficialMember(new HashMap<String, Object>());

			// 时间段活跃会员人数
			params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			// params.put("tradeAmount", "0");//存款大于0
			// 活跃会员人数是当月有存款的玩家
			long tradeCount = officialMemberService.selectAllCountByOfficialUser(params);

			// 总活跃会员人数
			params = new HashMap<String, Object>();
			// params.put("tradeAmount", "0");//存款大于0
			// 活跃会员人数是当月有存款的玩家
			long allTradeCount = officialMemberService.selectAllCountByOfficialUser(params);

			model.addAttribute("beginTime", beginTime.substring(0, 10));
			model.addAttribute("endTime", endTime.substring(0, 10));
			model.addAttribute("loginName", loginName);
			model.addAttribute("registerCount", registerCount);
			model.addAttribute("allRegisterCount", allRegisterCount);
			model.addAttribute("betAmount", betAmount);
			model.addAttribute("depositAmount", depositAmount);
			model.addAttribute("allDepositAmount", allDepositAmount);
			model.addAttribute("withdrawAmount", withdrawAmount);
			model.addAttribute("allWithdrawAmount", allWithdrawAmount);
			model.addAttribute("memberMoneyAmount", memberMoneyAmount);
			model.addAttribute("allMemberMoneyAmount", allMemberMoneyAmount);
			model.addAttribute("tradeCount", tradeCount);
			model.addAttribute("allTradeCount", allTradeCount);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}

		return "xjw/member/count/query";
	}

	// 活跃会员
	@RequestMapping("/activemembers")
	public String activemembers(Model model, ActiveMembersForm form, HttpServletRequest request) {
		if (StringUtils.isBlank(form.getBeginTime()) && StringUtils.isBlank(form.getEndTime())) {
			Calendar beginTime = Calendar.getInstance();
			form.setBeginTime(DateFormatUtils.format(beginTime, "yyyy-MM-01"));
			form.setEndTime(DateFormatUtils.format(beginTime, "yyyy-MM-dd"));
		}

		try {
			Map<String, Object> conditionParam = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(form.getLoginName())) {
				conditionParam.put("loginName", form.getLoginName());
			}
			if (StringUtils.isNotBlank(form.getBeginTime())) {
				conditionParam.put("beginTime", form.getBeginTime() + " 00:00:00");
			}
			if (StringUtils.isNotBlank(form.getEndTime())) {
				conditionParam.put("endTime", form.getEndTime() + " 23:59:59");
			}
			Page<OfficialMember> page = officialMemberService.getPage(conditionParam, form.getPageNo(),form.getPageSize());

			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		model.addAttribute("form", form);

		return "xjw/member/count/activemembers";
	}

}
