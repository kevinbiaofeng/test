package com.xjw.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.sys.ShowPanelForm;
import com.xjw.entity.po.activity.Activity;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.sys.Dept;
import com.xjw.entity.po.user.Agent;
import com.xjw.entity.po.user.Member;
import com.xjw.kzenum.activity.ActivityStatusEnum;
import com.xjw.service.activity.ActivityService;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.sys.DeptService;
import com.xjw.service.user.AgentService;
import com.xjw.service.user.MemberService;
import com.xjw.utility.BizException;
import com.xjw.utility.EncryptUtil;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/showPanel/")
public class ShowPanelController extends BaseController{
  private static final Logger logger = LoggerFactory.getLogger(ShowPanelController.class.getName());
  @Resource
  private MemberService memberService;
  @Resource
  private DeptService deptService;
  @Autowired
  private ActivityService activityService;
  @Resource
  private DepositOrderService depositOrderService;
  @Resource
  private WithdrawalOrderService withdrawalOrderService;
  @Autowired
  private AgentService agentService;
  
  @RequestMapping("/openDialog")
  public String openDialog(ShowPanelForm showPanelForm, Model model){
    model.addAttribute("showPanelForm", showPanelForm);
    return "public/show/openDialog";
  }
  
  @RequestMapping("/findSkipPage")
  public String findSkipPage(ShowPanelForm showPanelForm){
    if(showPanelForm.getOp() != null){
      if("customerList".equals(showPanelForm.getOp())){
        return "redirect:/showPanel/customerList?k=" + showPanelForm.getK();
      }else if("deptList".equals(showPanelForm.getOp())){
        return "redirect:/showPanel/deptList?k=" + showPanelForm.getK();
      }else if("actList".equals(showPanelForm.getOp())){
    	  return "redirect:/showPanel/actList?k=" + showPanelForm.getK();  
      }else if("agentList".equals(showPanelForm.getOp())){
    	  return "redirect:/showPanel/agentList?k=" + showPanelForm.getK();  
      }else if("depositList".equals(showPanelForm.getOp())){
    	  return "redirect:/showPanel/depositList?k=" + showPanelForm.getK() + "&otherInput=" + showPanelForm.getOtherInput();  
      }else if("withdrawalList".equals(showPanelForm.getOp())){
    	  return "redirect:/showPanel/withdrawalList?k=" + showPanelForm.getK() + "&otherInput=" + showPanelForm.getOtherInput();  
      }else if("depositUserName".equals(showPanelForm.getOp())){
    	  return "redirect:/showPanel/depositUserName?k=" + showPanelForm.getK() + "&otherInput=" + showPanelForm.getOtherInput();
      }
    }
    return null;
  }
  
  @RequestMapping("/customerList")
  public String customerList(Model model, ShowPanelForm showPanelForm, HttpServletRequest request){
    Map<String, Object> params = new HashMap<String, Object>();
    if(StringUtils.isNotBlank(showPanelForm.getKeywords())){
      params.put("keywords", showPanelForm.getKeywords().trim());
      params.put("keywordsName", EncryptUtil.encode(Constant.DateEncryptManage.NAME_PWD, showPanelForm.getKeywords().trim()));
//      params.put("keywordsPhone", EncryptUtil.encode(Constant.DateEncryptManage.PHONE_PWD, showPanelForm.getKeywords()));
//      params.put("keywordsEmail", EncryptUtil.encode(Constant.DateEncryptManage.EMAIL_PWD, showPanelForm.getKeywords()));
//      params.put("keywordsQQ", EncryptUtil.encode(Constant.DateEncryptManage.QQ_PWD, showPanelForm.getKeywords()));
    }
    try {
      Page<Member> page = memberService.getPage(params, showPanelForm.getPageNo(), 6);
      
      model.addAttribute("page", page);
    } catch (BizException e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("showPanelForm", showPanelForm);
    
    return "public/show/customerList";
  }
  
  @RequestMapping("/deptList")
  public String deptList(Model model, ShowPanelForm showPanelForm, HttpServletRequest request){
    try{
      List<Dept> list = deptService.getNormalList();
      model.addAttribute("list", list);
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "public/show/deptList";
  }
  
  @RequestMapping("/depositList")
  public String depositList(Model model, ShowPanelForm showPanelForm, HttpServletRequest request){
    try{
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("statusList", StringUtil.getListFromStr("2"));
    	
    	if(StringUtils.isNotBlank(showPanelForm.getKeywords())){
    		params.put("keywords", showPanelForm.getKeywords());
    	}
    	if(StringUtils.isNotBlank(showPanelForm.getOtherInput())){
    		params.put("userId", showPanelForm.getOtherInput());
    	}
    	
    	Page<DepositOrder> page = depositOrderService.getPage(params, showPanelForm.getPageNo(), 6);
    	model.addAttribute("page", page);
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("showPanelForm", showPanelForm);
    return "public/show/depositList";
  }
  
  @RequestMapping("/withdrawalList")
  public String withdrawalList(Model model, ShowPanelForm showPanelForm, HttpServletRequest request){
    try{
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("statusList", StringUtil.getListFromStr("2"));
    	
    	if(StringUtils.isNotBlank(showPanelForm.getKeywords())){
    		params.put("keywords", showPanelForm.getKeywords());
    	}
    	if(StringUtils.isNotBlank(showPanelForm.getOtherInput())){
    		params.put("userId", showPanelForm.getOtherInput());
    	}
    	Page<WithdrawalOrder> page = withdrawalOrderService.getPage(params, showPanelForm.getPageNo(), 6);
    	model.addAttribute("page", page);
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    model.addAttribute("showPanelForm", showPanelForm);
    return "public/show/withdrawalList";
  }
  
  /**
   * 活动列表 
   */
  @RequestMapping("/actList")
  public String actList(ShowPanelForm showPanelForm, Model model){
    try{
    	List<String> statusList = new ArrayList<String>();
    	statusList.add(ActivityStatusEnum.START.getCode());
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("statusList", statusList);
    	
    	if(StringUtils.isNotBlank(showPanelForm.getKeywords())){
    		params.put("id", showPanelForm.getKeywords());
    	}
    	
    	Page<Activity> page = activityService.getPage(params, showPanelForm.getPageNo(), 6);
    	model.addAttribute("page", page);
    }catch(Exception e){
    	e.printStackTrace();
    	logger.error(e.getMessage(), e);
    	logger.error("---fill---:" + e.fillInStackTrace());
    	logger.error("---msg---:"+ e.getMessage());
    	logger.error("---e---:" + e.toString());
    }
    
    model.addAttribute("showPanelForm", showPanelForm);
    return "public/show/actList";
  }
  
  /**
  * 代理列表
  */
 @RequestMapping("/agentList")
 public String agentList(ShowPanelForm showPanelForm, Model model){
   try{

   	Map<String, Object> params = new HashMap<String, Object>();
   	
   	if(StringUtils.isNotBlank(showPanelForm.getKeywords())){
   		params.put("keywords", showPanelForm.getKeywords());
   	}
   	
    Page<Agent> page = agentService.getPage(params, showPanelForm.getPageNo(), 6);
   	
   	model.addAttribute("page", page);
   }catch(Exception e){
   	logger.error(e.getMessage(), e);
   }
   
   model.addAttribute("showPanelForm", showPanelForm);
   return "public/show/agentList";
 }
 
 	/**
 	 * 查询用户的名称
 	 */
 	@RequestMapping("/depositUserName")
 	public String depositUserName(ShowPanelForm showPanelForm, Model model){
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(showPanelForm.getKeywords())) {
				params.put("keywords", showPanelForm.getKeywords().trim());
				params.put("keywordsName",EncryptUtil.encode(Constant.DateEncryptManage.NAME_PWD, showPanelForm.getKeywords().trim()));
			}
			if (StringUtils.isNotBlank(showPanelForm.getOtherInput())) {
				params.put("id", showPanelForm.getOtherInput());
			}
			Page<Member> page = memberService.getPage(params, showPanelForm.getPageNo(), showPanelForm.getPageSize());
			List<Member> list = page.getDataList();
			for (Member member : list) {
				member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
			}
			model.addAttribute("page", page);

		} catch (BizException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		model.addAttribute("showPanelForm", showPanelForm);
		return "public/show/depositUserName";
	}
 
}
