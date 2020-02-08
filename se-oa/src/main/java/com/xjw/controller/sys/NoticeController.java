package com.xjw.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.notice.NoticeForm;
import com.xjw.entity.po.notice.Notice;
import com.xjw.kzenum.notice.NoticeStatusEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.notice.NoticeUserRelService;
import com.xjw.utility.BizException;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/sysmsg/")
public class NoticeController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(NoticeController.class.getName());
  @Resource
  private NoticeService noticeService;
  @Resource
  private NoticeUserRelService noticeUserRelService;
  
  @RequestMapping("/load")
  public String index(Model model, HttpServletResponse response) {
    return "public/msg/load";
  }
  
  @RequestMapping("/getNotice")
  public void getNotice(Model model, HttpServletResponse response) {
    try {
      Long count = noticeService.selectUserNoticeCount(CurrentUserHolder.getCurrentUserId());
      this.write(String.valueOf(count), response);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }
  
  @RequestMapping("/list")
  public String list(Model model, NoticeForm noticeForm) {
    try {
      Map<String, Object> conditionParam = new HashMap<String, Object>();
      conditionParam.put("status", NoticeStatusEnum.DEFAULT.getCode());
      conditionParam.put("userId", CurrentUserHolder.getCurrentUserId());
      if(StringUtil.isNotBlank(noticeForm.getIsRead())){
        conditionParam.put("isRead", noticeForm.getIsRead());
      }
      if(StringUtil.isNotBlank(noticeForm.getFunctionCode())){
        conditionParam.put("functionCode", noticeForm.getFunctionCode());
      }
      Page<Notice> page = noticeService.getPage(conditionParam, noticeForm.getPageNo(), noticeForm.getPageSize());
      model.addAttribute("page", page);
    } catch (BizException e) {
    	logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("form", noticeForm);
    return "public/msg/list";
  }
  
  @RequestMapping("/del")
  public String del(NoticeForm noticeForm){
      try {
        noticeService.delete(noticeForm.getIds());
      } catch (Exception e){
        e.printStackTrace();
        logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
      }
      return "redirect:/sysmsg/list";
  }
  
  @RequestMapping("/detail")
  public String detail(Model model, NoticeForm noticeForm) {
    try {
      Map<String, Object> conditionParam = new HashMap<String, Object>();
      conditionParam.put("id", noticeForm.getId());
      Notice notice = noticeService.selectOne(conditionParam);
      conditionParam.clear();
      if(notice.getIsRead() == Integer.valueOf(YesORNoEnum.NO.getCode())){
        conditionParam.put("id", noticeForm.getId());
        conditionParam.put("readTime", new Date());
        conditionParam.put("isRead", YesORNoEnum.YES.getCode());
        noticeUserRelService.update(conditionParam);
      }
      model.addAttribute("notice", notice);
    } catch (BizException e) {
    	logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
    }
    return "public/msg/detail";
  }
}
