package com.xjw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.VipConfigForm;
import com.xjw.entity.po.sys.VipConfig;
import com.xjw.service.sys.VipConfigService;
import com.xjw.utility.BizException;

@Controller
@RequestMapping("/vipconfig/")
public class VipConfigController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(VipConfigController.class);
	@Autowired
	private VipConfigService vipConfigService;
	
	@RequestMapping("/list")
	public String list(VipConfigForm form, Model model) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			Page<VipConfig> page =  vipConfigService.getPage(params, form.getPageNo(), form.getPageSize());
			model.addAttribute("page", page);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		
		model.addAttribute("form", form);
		return "xjw/config/vipconfig/list";
	}
	
	/**
	 * 编辑页面 
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam("id") Long id, Model model){
		VipConfig vipconfig = vipConfigService.selectById(id);
		model.addAttribute("vipconfig", vipconfig);
		return "xjw/config/vipconfig/vipconfig-edit";
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(VipConfig vipConfig) {
		try {
			if(null == vipConfig.getId()){
				/*Map<String, Object> params = new HashMap<String, Object>();
				params.put("level", vipConfig.getLevel());
				long count = vipConfigService.selectAllCount(params);
				if(count > 0){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isSuccess", false);
					jsonObject.put("code", 100);
					jsonObject.put("msg", "会员等级已存在，请重新录入.");
					
					return jsonObject.toString();
				}*/
				
				vipConfigService.save(vipConfig);
			}else {
				vipConfigService.update(vipConfig);
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
