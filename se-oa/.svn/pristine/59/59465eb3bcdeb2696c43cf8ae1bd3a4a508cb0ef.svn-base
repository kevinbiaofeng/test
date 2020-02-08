package com.xjw.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.user.MemberForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Agent;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.MemberCallcsDetail;
import com.xjw.entity.po.user.MemberCheck;
import com.xjw.entity.po.user.MemberRemark;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.AgentService;
import com.xjw.service.user.MemberCallcsDetailService;
import com.xjw.service.user.MemberCheckService;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.service.user.MemberService;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.EncryptUtil;
import com.xjw.utility.StringUtil;

/**
 * 会员管理
 */
@Controller
@RequestMapping("/member/info/")
public class MemberController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(MemberController.class.getName());
  @Resource
  private UserService userService;
  @Resource
  private MemberService memberService;
  @Resource
  private AgentService agentService;
  @Resource
  private MemberRemarkService memberRemarkService;
  @Autowired
  private MemberCheckService memberCheckService;
  @Autowired
  private MemberCallcsDetailService memberCallcsDetailService;
  @Autowired
  private DepositOrderService depositOrderService;
  
  /**
   * 会员列表展开详情
   * @param model
   * @param memberForm
   * @return
   * @throws BizException
   */
  @RequestMapping("/detail")
  public String detail(Model model, MemberForm memberForm) throws BizException{
	  model.addAttribute("apisURL", ContextPropsLoad.getValByKey("APIS.BASE.URL"));
	  model.addAttribute("op", "modify");
	  //获取用户余额、积分
	  Map <String, Object> condition = new HashMap<String, Object>();
	  condition.put("getBalance", "1");
	  condition.put("id", memberForm.getId());
	  Member member = memberService.selectOne(condition);
	  member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
	  member.setPhone(EncryptUtil.decode(Constant.DateEncryptManage.PHONE_PWD, member.getPhone()));
	  member.setEmail(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, member.getEmail()));
	  member.setQq(EncryptUtil.decode(Constant.DateEncryptManage.QQ_PWD, member.getQq()));
	  
	  model.addAttribute("dto", member);
	  Map<String, Object> conditionParam = new HashMap<String, Object>();
      conditionParam.put("userId", memberForm.getId());
      conditionParam.put("begin", 0);
      conditionParam.put("pageSize", 5);
      List<MemberRemark> memberRemarkList = memberRemarkService.selectAll(conditionParam);
      model.addAttribute("memberRemarkList", memberRemarkList);
      
      MemberCheck memberCheck = memberCheckService.createAndReturn(member.getId());
      model.addAttribute("memberCheck", memberCheck);
      
      //查询用户最近的存款记录
      Map<String, Object> depositParam = new HashMap<String, Object>();
      depositParam.put("userId", memberForm.getId());
      depositParam.put("statusList", StringUtil.getListFromStr("2,3"));
      Page<DepositOrder> depositPage = depositOrderService.getPage(depositParam, 1, 1);
      if(depositPage.getDataList().size() > 0){
    	  model.addAttribute("depositOrder", depositPage.getDataList().get(0));
      }
      
      //查询用户最近的回访记录
      Map<String, Object> callCsParam = new HashMap<String, Object>();
      callCsParam.put("userId", memberForm.getId());
      MemberCallcsDetail callcsPage = memberCallcsDetailService.selectOne(callCsParam);
      if(callcsPage != null){
    	  model.addAttribute("callcsDetail", callcsPage);
      }
      
      if(member != null && member.getParentId() != null){
    	  Agent agent = agentService.selectById(Long.valueOf(member.getParentId()));
    	  model.addAttribute("agent", agent);
      }
	  return "xjw/member/detail";
  }
  
  /**
   * 会员列表查询
   * @param model
   * @param memberForm
   * @return
   */
  @RequestMapping("/list")
  public String list(Model model, MemberForm memberForm){
	  
	  try {
	      Map<String, Object> conditionParam = new HashMap<String, Object>();
	      String keywords = memberForm.getKeywords();
	      if(keywords != null && StringUtil.isNotBlank(keywords)){
	    	  conditionParam.put("keywords", keywords.trim());
	    	  conditionParam.put("keywordsName", EncryptUtil.encode(Constant.DateEncryptManage.NAME_PWD, keywords.trim()));
//	    	  conditionParam.put("keywordsPhone", EncryptUtil.encode(Constant.DateEncryptManage.PHONE_PWD, keywords));
//	    	  conditionParam.put("keywordsEmail", EncryptUtil.encode(Constant.DateEncryptManage.EMAIL_PWD, keywords));
//	    	  conditionParam.put("keywordsQQ", EncryptUtil.encode(Constant.DateEncryptManage.QQ_PWD, keywords));
	      }
	      String beginTime = memberForm.getBeginTime();
	      if(beginTime != null && StringUtil.isNotBlank(beginTime)){
	    	  conditionParam.put("beginTime", beginTime);
	      }
	      String endTime = memberForm.getEndTime();
	      if(endTime != null && StringUtil.isNotBlank(endTime)){
	    	  conditionParam.put("endTime", endTime);
	      }
	      String status = memberForm.getStatus();
	      if(status != null && StringUtil.isNotBlank(status)){
	    	  conditionParam.put("status", status);
	      }
	      Integer callcsType = memberForm.getCallcsType();
	      if(callcsType != null){
	    	  conditionParam.put("callcsType", callcsType);
	      }
	      if(StringUtils.isNotBlank(memberForm.getBeginCallcsTime())){
	    	  conditionParam.put("beginCallcsTime", memberForm.getBeginCallcsTime());
	      }
	      if(StringUtils.isNotBlank(memberForm.getEndCallcsTime())){
	    	  conditionParam.put("endCallcsTime", memberForm.getEndCallcsTime());
	      }
	      //获取用户余额、积分
	      conditionParam.put("getBalance", "1");
	      //获取存、提款记录
	      conditionParam.put("getOrderAmount", "1");
	      
		  Page<Member> page = memberService.getPage(conditionParam, memberForm.getPageNo(), memberForm.getPageSize());
		  List<Member> list = page.getDataList();
	      for (Member member : list) {
	    	  member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
	      }
	      
	      model.addAttribute("page", page);
	  } catch (BizException e) {
		  logger.error(e.getMessage(), e);
	  }
	  model.addAttribute("form", memberForm);
	  return "xjw/member/list";
  }
  
  /**
   * 根据账户名称模糊搜索注册用户
   * @param model
   * @param memberForm
   * @param request
   */
  @RequestMapping("/memberComplete")
  public void memberComplete(Model model, MemberForm memberForm, HttpServletResponse response){
	  List<User> list = userService.selectUserListByLoginName(memberForm.getKeywords());
	  JSONArray arr = new JSONArray();
      if (!list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
          User info = list.get(i);
          if (i == 0) {
            arr.add("<B><font color=red>已存在的客户名称如下：</font></B>");
          }
          arr.add(info.getLoginName());
        }
      }
	  
	 /* JSONObject jsonObj = new JSONObject();
	  JSONArray json = JSONArray.fromObject(list);
	  jsonObj.put("list", json);*/
	  try {
	      this.write(String.valueOf(arr.toString()), response);
	  } catch (IOException e) {
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	      e.printStackTrace();
	  }
  }
  
  /**
   * 发送找回密码Email
   * @param model
   * @param memberForm
   * @param request
   * 有空加个日志
   */
  @RequestMapping("/sendEmailFindPwd")
  @ResponseBody
  public String sendEmailFindPwd(Model model, MemberForm memberForm, HttpServletResponse response){
	  try{
		  memberService.updateMemberPwd(memberForm.getId());
		  return "1";
	  }catch(Exception e){
		  e.printStackTrace();
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
		  return "0";
	  }
  }
  
  /**
   * 修改会员资料取值
   * @param model
   * @param memberForm
   * @param response
   * @return String
   */
  @RequestMapping("/showUserEditPanel")
  public String showUserEditPanel(Model model, MemberForm memberForm, HttpServletResponse response){
	  try {
		  Member member = memberService.selectById(Long.valueOf(memberForm.getId()));
		  member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
		  member.setPhone(EncryptUtil.decode(Constant.DateEncryptManage.PHONE_PWD, member.getPhone()));
		  member.setEmail(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, member.getEmail()));
		  member.setQq(EncryptUtil.decode(Constant.DateEncryptManage.QQ_PWD, member.getQq()));
		  model.addAttribute("dto", member);
	  } catch (Exception e) {
		  logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
	  }
    return "xjw/member/userEditPanel";
  }
  
  /**
   * 修改会员资料保存
   * @param memberForm
   * @param model
   * @param response
   * @param request
   * @return String
   */
  @RequestMapping("/save")
  @ResponseBody
  public String updateMemberInfo(MemberForm memberForm, Model model, HttpServletResponse response, HttpServletRequest request) {
    try {
        memberService.updateMember(memberForm.getUser(), memberForm.getMember());
        return "1";
    } catch (Exception e) {
    	e.printStackTrace();
    	logger.error(e.getMessage(), e);
  	  logger.error("---fill---:" + e.fillInStackTrace());
  	  logger.error("---msg---:"+ e.getMessage());
  	  logger.error("---e---:" + e.toString());
    	return "0";
    }
  }
  
  @RequestMapping("/updatePrivacyFlag")
  @ResponseBody
  public String updatePrivacyFlag(@RequestParam("memberId") Long memberId, @RequestParam("privacyFlag") Integer privacyFlag) {
    try {
    	if(memberId < 0){
    		return "0";
    	}
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("memberId", memberId);
    	params.put("privacyFlag", privacyFlag);
    	memberService.update(params);
        return "1";
    } catch (Exception e) {
    	logger.error(e.getMessage(), e);
    	return "-1";
    }
  }
  
  @RequestMapping("/close")
  @ResponseBody
  public String close(@RequestParam("id") Long id) {
    try {
    	if(id < 0){
    		return "0";
    	}
    	
    	List<Long> ids = new ArrayList<Long>();
    	ids.add(id);
    	
    	userService.delete(ids);
        return "1";
    } catch (Exception e) {
    	logger.error(e.getMessage(), e);
    	return "-1";
    }
  }
  
  @RequestMapping("/unlock")
  @ResponseBody
  public String unlock(@RequestParam("id") Long id){
	  try {
		  if(id < 0){
			  return "0";
		  }
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("id", id);
		  params.put("status", StatusEnum.DEFAULT.getCode());
	  
		  userService.update(params);
	  } catch (Exception e) {
		  logger.error(e.getMessage(), e);
		  return "-1";
	  }
	  
	  return "1";
  }
  
  /** 更换代理 */
  @RequestMapping("/updateAgent")
  @ResponseBody
  public String updateAgent(@RequestParam("id") Long id, @RequestParam("parentId") Long parentId){
	  try{
		  if(id < 0 || parentId < 0){
			  return "0";
		  }
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("id", id);
		  params.put("parentId", parentId);
		  userService.update(params);
		  
		  return "1";
	  }catch(Exception e){
		  logger.error(e.getMessage(), e);
		  return "0";
	  }
  }
  
  @RequestMapping("showInfo")
  public String showInfo(@RequestParam("userId") Long userId, Model model){
		Member member = memberService.selectById(userId);
		member.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
		member.setPhone(EncryptUtil.decode(Constant.DateEncryptManage.PHONE_PWD, member.getPhone()));
		member.setEmail(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, member.getEmail()));
		member.setQq(EncryptUtil.decode(Constant.DateEncryptManage.QQ_PWD, member.getQq()));
		model.addAttribute("member", member);
		return "xjw/member/showInfo";
  }
  
  @RequestMapping("showCallcsDetail")
  public String showCallcsDetail(@RequestParam("userId") Long userId, Model model){
	  	Map<String, Object> condition = new HashMap<String, Object>();
	  	condition.put("userId", userId);
	  	
		MemberCallcsDetail memberCallcsDetail = memberCallcsDetailService.selectOne(condition);
		
		if(null != memberCallcsDetail){
			User user = userService.selectById(memberCallcsDetail.getUpdateUser());
			memberCallcsDetail.setUpdateUserName(user.getLoginName());
		}
		
		model.addAttribute("memberCallcsDetail", memberCallcsDetail);
		model.addAttribute("userId", userId);
		
		return "xjw/member/show_callcs_detail";
  }
}
