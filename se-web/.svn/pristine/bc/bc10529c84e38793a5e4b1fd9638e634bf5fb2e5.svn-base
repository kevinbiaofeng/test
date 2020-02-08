package com.xjw.controller.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.po.notice.NoticePrompt;
import com.xjw.kzenum.platform.PlatformTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.notice.NoticePromptService;
import com.xjw.utility.BizException;

/**
 * 弹窗相关
 */
@Controller
@RequestMapping("/prompt")
public class PromptController extends BaseController{
	 private static Logger logger = LoggerFactory.getLogger(PromptController.class);
	
	@Autowired
	private NoticePromptService noticePromptService;
	
	/**
	 * 弹窗列表
	 */
	@RequestMapping("top5")
	@ResponseBody
	public String top5(){
		List<NoticePrompt> promptList = null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", YesORNoEnum.YES.getCode());
			
			Page<NoticePrompt> page = noticePromptService.getPage(params, 1, 5);
			promptList = page.getDataList();
			
			for(NoticePrompt promot : promptList){
				String name = StringUtils.substring(promot.getName(), 0, 2) + "****" + StringUtils.substring(promot.getName(), promot.getName().length()-2, promot.getName().length());
				promot.setName(name);
			}
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			promptList = new ArrayList<NoticePrompt>();
		}
		
		return JSONArray.toJSONString(promptList);
	}
	
	/**
	 * 弹窗内游戏重定向
	 */
	@RequestMapping("redirect")
	public String redirect(@RequestParam(required=false) String platformType){
		if(null != platformType){
			if(PlatformTypeEnum.AG_GJ.getCode().equals(platformType) || PlatformTypeEnum.AG_JS.getCode().equals(platformType)){
				return "redirect:/games/live";
			}else if(PlatformTypeEnum.PT.getCode().equals(platformType) || PlatformTypeEnum.MG.getCode().equals(platformType)){
				return "redirect:/games/egame";
			}else if(PlatformTypeEnum.SB.getCode().equals(platformType) ){
				return "redirect:/games/sports";
			}
		}
		return "redirect:/";
	}
}
