package com.xjw.controller.order;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.order.BankInfoForm;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.utility.BizException;


@Controller
@RequestMapping("/bank/")
public class BankInfoController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(BankInfoController.class.getName());
	@Resource
	private UserBankInfoService userBankInfoService;
	/**
	 * 根据code获取银行信息
	 */
//	@RequestMapping("/getBankInfoByCode", method＝RequestMethod.GET)
	@RequestMapping(value="/getBankInfoByCode", method = RequestMethod.GET)  
	@ResponseBody
	public String getBankInfoByCode(BankInfoForm bankInfoForm, HttpServletRequest request, HttpServletResponse response){
		JSONObject jsonObj = new JSONObject();
		try {
			UserBankInfo userBankInfo = userBankInfoService.getBankInfoByBankType(bankInfoForm.getDepositBankType());
			if(userBankInfo != null){
				jsonObj.put("accountName", userBankInfo.getAccountName());
				jsonObj.put("bankCardNo", userBankInfo.getBankCardNo());
				jsonObj.put("bankAddress", userBankInfo.getBankAddress());
				return String.valueOf(jsonObj);
			}
			return "";
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}
}
