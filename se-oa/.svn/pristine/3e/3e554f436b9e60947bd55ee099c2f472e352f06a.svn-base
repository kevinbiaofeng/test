package com.xjw.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.PayConfigForm;
import com.xjw.entity.po.sys.PayConfig;
import com.xjw.kzenum.AbstractEnum.EnumBean;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.service.sys.PayConfigService;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/payconfig/")
public class PayConfigController extends BaseController{
	 private static Logger logger = LoggerFactory.getLogger(PayConfigController.class);
	
	@Autowired
	private PayConfigService payConfigService;
	
	@RequestMapping("/list")
	public String list(PayConfigForm form, Model model) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		try {
			Page<PayConfig> page =  payConfigService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "xjw/config/payconfig/list";
	}
	
	@RequestMapping("new")
	public String editNew(Model model){

		List<EnumBean> tradeModeList = TradeModeEnum.getEnumBeans(TradeModeEnum.class);
		
		model.addAttribute("tradeModeList", tradeModeList);
		return "xjw/config/payconfig/new";
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(PayConfig payConfig) {
		try {
			if(null == payConfig.getId()){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("tradeMode", payConfig.getTradeMode());
				long count = payConfigService.selectAllCount(params);
				if(count > 0){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isSuccess", false);
					jsonObject.put("code", 100);
					jsonObject.put("msg", "支付类别已存在，请重新选择");
					
					return jsonObject.toString();
				}
				
				payConfigService.save(payConfig);
			}else {
				payConfigService.update(payConfig);
			}
		} catch (Exception e) {
		    logger.error(e.getMessage(), e);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isSuccess", false);
			jsonObject.put("code", -1);
			jsonObject.put("msg", "操作异常");
			
			return jsonObject.toString();
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", true);
		jsonObject.put("msg", "操作成功");
		return  jsonObject.toString();
	}
}
