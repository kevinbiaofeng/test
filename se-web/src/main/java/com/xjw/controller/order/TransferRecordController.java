package com.xjw.controller.order;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.order.RecordForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.order.MemberMoneyChange;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.platform.PlatformTransfer;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.platform.FromFunctionEnum;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.order.MemberMoneyChangeService;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.platform.PlatformTransferService;
import com.xjw.util.SessionManager;
import com.xjw.utility.StringUtil;


@Controller
@RequestMapping("/trsfRecord/")
public class TransferRecordController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(TransferRecordController.class.getName());
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private DepositOrderService depositOrderService;
	@Autowired
	private WithdrawalOrderService withdrawalOrderService;
	@Autowired
	private PlatformTransferService platformTransferService;
	@Autowired
	private MemberMoneyChangeService memberMoneyChangeService;
	
	@RequestMapping("/index")
	public String index(Model model){
		 model.addAttribute("ORDER_TAB", "记录");
		 return "/xjw/order/order-index";
	}

	
	@RequestMapping("load")
	public String load(Model model){
		return "/xjw/order/transferRecord";
	}
	
	/**
	 * 存款分页
	 */
	@RequestMapping("/page/deposit")
	public String pageDeposit(RecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model){
		User user = SessionManager.getUserSession(request);
		pageNo = (null == pageNo ? 1 : pageNo);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", form.getStatus());
		params.put("userId", user.getId());
		if(null != form.getBeforeDay()){
			Calendar nowTime = Calendar.getInstance();
			Calendar beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE) - form.getBeforeDay());
			params.put("beginTime", DateFormatUtils.format(beginTime, "yyyy-MM-dd"));
		}
		
		try{
			Page<DepositOrder> page = depositOrderService.getPage(params, pageNo, pageSize);
			model.addAttribute("page", page);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "/xjw/order/transferRecord-deposit";
	}
	
	/**
	 * 取款分页
	 */
	@RequestMapping("/page/withdraw")
	public String pageWithdraw(RecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model){
		User user = SessionManager.getUserSession(request);
		pageNo = (null == pageNo ? 1 : pageNo);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", form.getStatus());
		params.put("userId", user.getId());
		if(null != form.getBeforeDay()){
			Calendar nowTime = Calendar.getInstance();
			Calendar beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE) - form.getBeforeDay());
			params.put("beginTime", DateFormatUtils.format(beginTime, "yyyy-MM-dd"));
		}
		
		try{
			Page<WithdrawalOrder> page = withdrawalOrderService.getPage(params, pageNo, pageSize);
			model.addAttribute("page", page);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "/xjw/order/transferRecord-withdraw";
	}
	
	/**
	 * 户内转账分页
	 */
	@RequestMapping("/page/transfer")
	public String pageTransfer(RecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model){
		User user = SessionManager.getUserSession(request);
		pageNo = (null == pageNo ? 1 : pageNo);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", form.getStatus());
		params.put("transferType", form.getTransferType());
		params.put("userId", user.getId());
		params.put("fromFunctionList", StringUtil.getListFromStr(FromFunctionEnum.WEBSITE.getCode() +"," + FromFunctionEnum.HT.getCode()));
		if(null != form.getBeforeDay()){
			Calendar nowTime = Calendar.getInstance();
			Calendar beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE) - form.getBeforeDay());
			params.put("beginTime", DateFormatUtils.format(beginTime, "yyyy-MM-dd"));
		}
		
		try{
			Page<PlatformTransfer> page = platformTransferService.getPage(params, pageNo, pageSize);
			model.addAttribute("page", page);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "/xjw/order/transferRecord-transfer";
	}
	
	/**
	 * 奖金分页
	 */
	@RequestMapping("/page/award")
	public String pageAaward(RecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model){
		User user = SessionManager.getUserSession(request);
		pageNo = (null == pageNo ? 1 : pageNo);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		params.put("minMoney", 0);
		
		if(null != form.getBeforeDay()){
			Calendar nowTime = Calendar.getInstance();
			Calendar beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH), nowTime.get(Calendar.DATE) - form.getBeforeDay());
			params.put("beginCreateTime", DateFormatUtils.format(beginTime, "yyyy-MM-dd"));
		}
		
		try{
			Page<MemberMoneyChange> page = memberMoneyChangeService.getPage(params, pageNo, pageSize);
			model.addAttribute("page", page);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "/xjw/order/transferRecord-award"; 
	}
}
