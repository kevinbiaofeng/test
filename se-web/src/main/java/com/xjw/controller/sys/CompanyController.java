package com.xjw.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;

/**
 * 公司相关
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController{

	/**
	 * 常见问题
	 */
	@RequestMapping("guide")
	public String guide(){
		return "xjw/static/company-guide";
	}
	
	/**
	 * 联系我们
	 */
	@RequestMapping("cs")
	public String consult(){
		return "xjw/static/company-cs";
	}
	
	/**
	 * 发展历程
	 */
	@RequestMapping("history")
	public String history(){
		return "xjw/static/company-history";
	}
	
	/**
	 * 公司优势
	 */
	@RequestMapping("advantage")
	public String advantage(){
		return "xjw/static/company-advantage";
	}
	
	/**
	 * 平台产品
	 */
	@RequestMapping("product")
	public String product(){
		return "xjw/static/company-product";
	}
	
	/**
	 * 用户条款
	 */
	@RequestMapping("agreement")
	public String agreement(){
		return "xjw/static/company-agreement";
	}
	
	/**
	 * 账户安全
	 */
	@RequestMapping("accountsafe")
	public String accountsafe(){
		return "xjw/static/company-accountsafe";
	}
	
	/**
	 * 信息安全
	 */
	@RequestMapping("infosafe")
	public String infosafe(){
		return "xjw/static/company-infosafe";
	}
}
