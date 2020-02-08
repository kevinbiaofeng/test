package com.xjw.controller.activity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.activity.AdvertWebsiteForm;
import com.xjw.entity.po.activity.AdvertWebsite;
import com.xjw.kzenum.activity.ActivityStatusEnum;
import com.xjw.service.activity.AdvertWebsiteService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * 网页公告列表
 */
@Controller
@RequestMapping("/site/notice/")
public class SiteNoticeController extends BaseController{
	private static Logger logger= LoggerFactory.getLogger(SiteNoticeController.class.getName());
	  @Resource
	  private AdvertWebsiteService advertWebsiteService;
	  
	  private static final String addPage = "/site/notice/skipAdd";
	  private static final String editPage = "/site/notice/skipEdit";
	  private static final String listPage = "/site/notice/list";
	  
	  @RequestMapping("/skipAdd")
	  public String skipAdd(Model model, AdvertWebsiteForm AdvertWebsiteForm, HttpServletRequest request){
		  model.addAttribute("op", "add");
		  return "xjw/activity/siteNoticeDetail";
	  }
	  
	  @RequestMapping("/skipEdit")
	  public String skipEdit(Model model, AdvertWebsiteForm AdvertWebsiteForm, HttpServletRequest request){
		  model.addAttribute("op", "edit");
		  model.addAttribute("dto", advertWebsiteService.selectById(Long.valueOf(AdvertWebsiteForm.getId())));
		  return "xjw/activity/siteNoticeDetail";
	  }
	  
	  @RequestMapping("/save")
	  public void save(AdvertWebsite AdvertWebsite, Model model, HttpServletResponse response) {
	    try {
	    	if(AdvertWebsite.getId() == null){
	    		advertWebsiteService.save(AdvertWebsite);
	    		this.writerSuccessJSONDataById("新增成功", addPage, null, listPage, null);
	    	}else{
	    		advertWebsiteService.update(AdvertWebsite);
	    		Map <String, Object> param = new HashMap<String, Object>();
		        param.put("id", AdvertWebsite.getId());
	    		this.writerSuccessJSONDataById("编辑成功", null, editPage, listPage, param);
	    	}
	    		
	    } catch (Exception e) {
	    	writerJSONData("failure", "操作失败", null, listPage);
	    	logger.error(e.getMessage(), e);
			  logger.error("---fill---:" + e.fillInStackTrace());
			  logger.error("---msg---:"+ e.getMessage());
			  logger.error("---e---:" + e.toString());
	    }
	  }
	  
	  @RequestMapping("/list")
	  public String list(Model model, AdvertWebsiteForm AdvertWebsiteForm, HttpServletRequest request){
		  try {
		      Map<String, Object> conditionParam = new HashMap<String, Object>();
		      conditionParam.put("statusList", StringUtil.getListFromStr("1,2,3,4"));
		      Page<AdvertWebsite> page = advertWebsiteService.getPage(conditionParam, AdvertWebsiteForm.getPageNo(), AdvertWebsiteForm.getPageSize());
		      model.addAttribute("page", page);
		  } catch (BizException e) {
			  logger.error(e.getMessage(), e);
			  logger.error("---fill---:" + e.fillInStackTrace());
			  logger.error("---msg---:"+ e.getMessage());
			  logger.error("---e---:" + e.toString());
		  }
		  model.addAttribute("form", AdvertWebsiteForm);
		  return "xjw/activity/siteNoticeList";
	  }
	  
	  @RequestMapping("/start")
	  public String start(AdvertWebsiteForm AdvertWebsiteForm, Model model, HttpServletResponse response) throws BizException {
		Map <String, Object> params = new HashMap<String, Object>();
		params.put("id", AdvertWebsiteForm.getId());
		params.put("status", ActivityStatusEnum.START.getCode());
		advertWebsiteService.update(params);
		return "redirect:" + listPage;
	  }
	  
	  @RequestMapping("/stop")
	  public String stop(AdvertWebsiteForm AdvertWebsiteForm, Model model, HttpServletResponse response) throws BizException {
		Map <String, Object> params = new HashMap<String, Object>();
		params.put("id", AdvertWebsiteForm.getId());
		params.put("status", ActivityStatusEnum.STOP.getCode());
		advertWebsiteService.update(params);
		return "redirect:" + listPage;
	  }
	  
	  @RequestMapping("/down")
	  public String down(AdvertWebsiteForm AdvertWebsiteForm, Model model, HttpServletResponse response) throws BizException {
		Map <String, Object> params = new HashMap<String, Object>();
		params.put("id", AdvertWebsiteForm.getId());
		params.put("status", ActivityStatusEnum.DOWN.getCode());
		advertWebsiteService.update(params);
		return "redirect:" + listPage;
	  }
}
