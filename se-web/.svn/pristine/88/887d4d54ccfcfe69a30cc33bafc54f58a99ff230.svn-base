package com.xjw.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.order.BankInfoForm;
import com.xjw.entity.form.order.WithdrawalOrderForm;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.sys.UserBankInfoStatusEnum;
import com.xjw.kzenum.sys.UserBankInfoTypeEnum;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.service.user.MemberService;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;
import com.xjw.utility.EncryptUtil;

/**
 * 提款
 */
@Controller
@RequestMapping("/withdraw")
public class WithdrawController extends BaseController{
	  private static Logger logger = LoggerFactory.getLogger(WithdrawController.class);
	  
	  @Autowired
	  private MemberService memberService;
	  @Autowired
	  private UserBankInfoService userBankInfoService;
	  @Autowired
	  private WithdrawalOrderService withdrawalOrderService;
	  
	  /** 首页 */ 
	  @RequestMapping("index")
	  public String index(Model model, HttpServletRequest request){
		  model.addAttribute("ORDER_TAB", "提款");
		  return "/xjw/order/order-index";
	  }
	  
	  /** 首页 */ 
	  @RequestMapping("load")
	  public String load(Model model, HttpServletRequest request){
		  User user = SessionManager.getUserSession(request);
		  try{
			  List<UserBankInfo> userBankList = userBankInfoService.queryList(user.getId(), Integer.valueOf(UserBankInfoTypeEnum.OUTSIDE.getCode()), Integer.valueOf(UserBankInfoStatusEnum.START.getCode()));
			  Member member = memberService.getMemberByUserId(user.getId());
			  member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
			  
			  model.addAttribute("userBankList", userBankList);
			  model.addAttribute("member", member);
		  }catch(Exception e){
			  logger.error(e.getMessage(), e);
			  return this.toJsonResult("-1", "提交失败，请与管理员联系", null).toString();
		  }

		  setToken(request);
		  return "/xjw/order/withdraw";
	  }
	  
	  /**
	   * 保存提款申请记录
	   */
	  @RequestMapping("save")
	  @ResponseBody
	  public String save(WithdrawalOrderForm withdrawalOrderForm, HttpServletRequest request){
		  try{
			  boolean isToken = isTokenTrue(request, request.getParameter("tk"));
			  if(!isToken){
				  return this.toJsonResult("100", "您的请求过于频繁，请稍后再试", null).toString();
			  }
			  User user = SessionManager.getUserSession(request);
			  withdrawalOrderService.createOrder(user, withdrawalOrderForm.getUserBankId(), withdrawalOrderForm.getAmount(), withdrawalOrderForm.getRemark());
		  }catch(BizException e){
				  return this.toJsonResult("200", e.getMessage(), null).toString();
		  }catch(Exception e){
			  logger.error(e.getMessage(), e);
			  return this.toJsonResult("-1", "提交失败，请与管理员联系", null).toString();
		  }
		  
		  return this.toJsonResult("1", "提交申请成功", null).toString();
	  }
	  
	  /**
	   * 绑定用户银行卡
	   * @param bankType		银行类别
	   * @param bankCardNo		银行卡号
	   * @param bankAddress		开户行地址
	   */
	  @RequestMapping("saveBank")
	  @ResponseBody
	  public String saveBank(BankInfoForm bankInfoForm, HttpServletRequest request){
		  	Integer bankType = bankInfoForm.getBankType();
		  	String bankCardNo = bankInfoForm.getBankCardNo();
		  	String bankAddress = bankInfoForm.getBankAddress();
		  try {
			  User user = SessionManager.getUserSession(request);
			  Member member = memberService.getMemberByUserId(user.getId());
			  
			  UserBankInfo userBank = new UserBankInfo();
			  userBank.setAccountName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
			  userBank.setType(Integer.valueOf(UserBankInfoTypeEnum.OUTSIDE.getCode()));
			  userBank.setIsDefault(0);
			  userBank.setBankType(bankType);
			  userBank.setBankCardNo(bankCardNo);
			  userBank.setBankAddress(bankAddress);
			  userBank.setUserId(user.getId());
			  
			  UserBankInfo ub = userBankInfoService.save(userBank);
			  return this.toJsonResult("1", null, ub).toString();
		  }catch(Exception e){
			  logger.error(e.getMessage(), e);
			  return this.toJsonResult("-1", "添加失败，请与管理员联系", null).toString();
		  }
	  }
	  
	  public JSONObject toJsonResult(String code, String msg, Object model){
		  JSONObject jsonObject = new JSONObject();
		  jsonObject.put("code", code);
		  jsonObject.put("msg", msg);
		  jsonObject.put("model", model);
		  return jsonObject;
	  }
}