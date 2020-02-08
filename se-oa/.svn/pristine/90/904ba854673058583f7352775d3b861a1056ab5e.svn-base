package com.xjw.controller.user;

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
import com.xjw.entity.form.user.MemberRemarkForm;
import com.xjw.entity.po.user.MemberRemark;
import com.xjw.kzenum.user.MemberRemarkStatusEnum;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * 会员备注
 * @author KevinZ
 */
@Controller
@RequestMapping("/member/remark/")
public class MemberRemarkController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(MemberRemarkController.class.getName());
  @Resource
  private MemberRemarkService memberRemarkService;
  
//  private static final String addPage = "/sysuser/skipAdd";
//  private static final String editPage = "/sysuser/skipModify";
  private static final String listPage = "/member/remark/list";
  
  
  @RequestMapping("/detail")
  public String detail(Model model, MemberRemarkForm memberRemarkForm){
    return "xjw/member/remark/detail";
  }
  
  @RequestMapping("/skipAddRemark")
  public String skipAddRemark(Model model, MemberRemarkForm memberRemarkForm){
	  model.addAttribute("userId", memberRemarkForm.getUserId());
	  return "xjw/member/remark/addPanel";
  }
  
  @RequestMapping("/list")
  public String list(Model model, MemberRemarkForm memberRemarkForm, HttpServletRequest request){
	  try {
	      Map<String, Object> conditionParam = new HashMap<String, Object>();
	      conditionParam.put("userId", memberRemarkForm.getUserId());
	      String remark = memberRemarkForm.getRemark();
	      if(remark != null && StringUtil.isNotBlank(remark)){
	    	  conditionParam.put("remark", remark);
	      }
	      String titleType = memberRemarkForm.getTitleType();
	      if(titleType != null  && StringUtil.isNotBlank(titleType)){
	    	  conditionParam.put("titleType", titleType);
	      }
	      String beginTime = memberRemarkForm.getBeginTime();
	      if(beginTime != null && StringUtil.isNotBlank(beginTime)){
	    	  conditionParam.put("beginTime", beginTime);
	      }
	      String endTime = memberRemarkForm.getEndTime();
	      if(endTime != null && StringUtil.isNotBlank(endTime)){
	    	  conditionParam.put("endTime", endTime);
	      }
	      conditionParam.put("statusList", StringUtil.getListFromStr("1,2"));
	      Page<MemberRemark> page = memberRemarkService.getPage(conditionParam, memberRemarkForm.getPageNo(), memberRemarkForm.getPageSize());
	      model.addAttribute("page", page);
	  } catch (BizException e) {
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	  }
	  model.addAttribute("form", memberRemarkForm);
	  return "xjw/member/remark/list";
  }
  
  @RequestMapping("/save")
  public void save(MemberRemark memberRemark, Model model, HttpServletResponse response) {
    try {
    	memberRemarkService.save(memberRemark);
    } catch (Exception e) {
    	logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
    }
  }
  
  @RequestMapping("/up")
  public String up(Model model, MemberRemarkForm memberRemarkForm) throws BizException {
	Map <String, Object> params = new HashMap<String, Object>();
	params.put("id", memberRemarkForm.getId());
	params.put("status", MemberRemarkStatusEnum.UP.getCode());
	memberRemarkService.update(params);
	//保存到下个会话
	model.addAttribute("userId", memberRemarkForm.getUserId());
	return "redirect:" + listPage;
  }
  
  @RequestMapping("/dowm")
  public String dowm(Model model, MemberRemarkForm memberRemarkForm) throws BizException {
	Map <String, Object> params = new HashMap<String, Object>();
	params.put("id", memberRemarkForm.getId());
	params.put("status", MemberRemarkStatusEnum.DEFAULT.getCode());
	memberRemarkService.update(params);
	//保存到下个会话
	model.addAttribute("userId", memberRemarkForm.getUserId());
	return "redirect:" + listPage;
  }
}
