package com.xjw.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.user.UserForm;
import com.xjw.entity.po.media.Video;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.po.user.Agent;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.user.UserVo;
import com.xjw.kzenum.log.LoginLogNetworkTypeEnum;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.sys.UserBankInfoStatusEnum;
import com.xjw.kzenum.sys.UserBankInfoTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.kzenum.user.UserTypeAllEnum;
import com.xjw.service.log.UserLoginLogService;
import com.xjw.service.media.VideoService;
import com.xjw.service.message.MessageService;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.service.user.AgentService;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.service.user.UserService;
import com.xjw.util.CookieManager;
import com.xjw.util.PwdRandom;
import com.xjw.util.SessionManager;
import com.xjw.utility.DateUtil;
import com.xjw.utility.EncryptUtil;
import com.xjw.utility.IpUtil;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/user/")
public class UserController extends BaseController{
  private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());
  @Resource
  private UserService userService;
  @Resource
  private MemberService memberService;
  @Resource
  private UserAccountIntegralService userAccountIntegralService;
  @Autowired
  private UserBankInfoService userBankInfoService;
  @Resource
  private UserLoginLogService userLoginLogService;
  @Autowired
  private MessageService messageService;
  @Autowired
  private AgentService agentService;
  @Autowired
  private VideoService videoService;
  
//  @RequestMapping("/skipLogin")
//  public String skipLogin(){
//	  return "/login";
//  }
  
  @RequestMapping(value = "/login")
  @ResponseBody
  public String login(UserForm userForm, Model model, HttpServletRequest request, HttpServletResponse response){
	  	JSONObject json = new JSONObject();
		try {
			User user = userService.getUserByLoginName(userForm.getLoginName(), Integer.valueOf(UserTypeAllEnum.HY.getCode()));
			if(user == null) {			//账号不存在
				json.put("code", "102");
				json.put("msg", this.getMsg(request, "login.error.input"));
				return json.toString();
			}
			
			String cookieName = "login_error_count_" + user.getLoginName();
			if(user.getPwd().equals(EncryptUtil.encode(Constant.DateEncryptManage.PWD_PWD, userForm.getLoginPwd()))){	//账号密码匹配成功
				CookieManager.delCookie(request, response, cookieName);	//解除登录错误计数
			}else{	//密码输入错误
				if(Integer.valueOf(StatusEnum.DEFAULT.getCode()).equals(user.getStatus())){	//正常状态的用户
				  	//账号连续登录错误累计5次，锁定账号
					Cookie cookie = CookieManager.getCookie(request, cookieName);
					if(null == cookie){
						CookieManager.addCookie(request, response, cookieName, "1", 0);
					}else if(Integer.valueOf(cookie.getValue()) < 4){
						CookieManager.addCookie(request, response, cookieName, String.valueOf(1+Integer.valueOf(cookie.getValue())), 0);
					}else{	//连续输入超过5次，锁定账号
						userService.lockUser(user.getId());
						CookieManager.delCookie(request, response, cookieName);	//解除登录错误计数
						user.setStatus(Integer.valueOf(StatusEnum.LOCK.getCode()));
					}
				}
				
				if(Integer.valueOf(StatusEnum.DEFAULT.getCode()).equals(user.getStatus())){
					json.put("code", "104");
					json.put("msg", this.getMsg(request, "login.error.input"));	
					return json.toString();
				}
			}
			  
			if(user.getStatus().equals(Integer.valueOf(StatusEnum.LOCK.getCode()))){	//锁定
				json.put("code", "106");
				json.put("msg", this.getMsg(request, "login.error.lock"));	
				return json.toString();
			}else if(user.getStatus().equals(Integer.valueOf(StatusEnum.DEL.getCode()))){	//注销
				json.put("code", "108");
				json.put("msg", this.getMsg(request, "login.error.del"));
				return json.toString();				
			}else{
				String ip = IpUtil.getIpAddr(request);
				//返回正确代码
				json.put("code", "1");
				//添加用户登录日志
				userLoginLogService.saveUserLoginLog(user, ip, Integer.valueOf(LoginLogNetworkTypeEnum.WW.getCode()));
				String sessionSid = PwdRandom.getSessionId(user.getLoginName());
				//修改用户sessionSid为生成的ID
				Map<String, Object> modifyParams = new HashMap<String, Object>();
				if(user != null && user.getId() != null) {
					modifyParams.put("id", user.getId());
					modifyParams.put("loginTime", new Date());
					modifyParams.put("loginIp", ip);
					modifyParams.put("sessionSid", sessionSid);
					modifyParams.put("sessionSidTime", DateUtil.addDays(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss", 7));
					userService.update(modifyParams);
					userService.excuUpdateUserLoginIpAddress(user.getId(), ip);
				}
				userService.setLoginUserParam(user, request, response, sessionSid); //登录的用户保存用户信息到session、cookie
				
				return json.toString();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("msg", this.getMsg(request, "login.error.input"));
			return json.toString();
		}
  }
  
  
  /** 获取用户中心的用户信息*/
  @RequestMapping("/centerUserInfo")
  @ResponseBody
  public String centerUserInfo(HttpServletRequest request){
	  try{
		  User user = SessionManager.getUserSession(request);
		  Member member = memberService.getMemberByUserId(user.getId());
		  member = memberService.decodeMember(member);
		  
		  AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(user.getId());
		  List<UserBankInfo> userBankList = userBankInfoService.queryList(user.getId(), Integer.valueOf(UserBankInfoTypeEnum.OUTSIDE.getCode()), Integer.valueOf(UserBankInfoStatusEnum.START.getCode()));
		  
		  String nickName = StringUtils.substring(member.getName(), 0, 1) + (member.getSex() == 1 ? "先生" : "女士");
		  String level = member.getVipType() == 0 ? "普通会员" : ("VIP" + member.getVipType());
		  String phone = StringUtils.length(member.getPhone()) > 7 ? (StringUtils.substring(member.getPhone(), 0, 4) + "****") : member.getPhone();
		  
		  com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
		  jsonObject.put("nickName", nickName);		//用户昵称
		  jsonObject.put("loginName", user.getLoginName());	//登陆账号
		  jsonObject.put("level", level);	//会员等级
		  jsonObject.put("phone", phone);	//电话号码
		  jsonObject.put("registerTime", DateFormatUtils.format(user.getCreateTime(), "yyyy-MM-dd"));	//注册时间
		  jsonObject.put("balance", StringUtil.replaceContextByMap(accountIntegral.getTotalMoney()));	//账户余额
		  jsonObject.put("bankCount", userBankList.size());
		  return jsonObject.toString();
	  }catch(Exception e){
		 logger.error(e.getMessage(), e); 
	  }
	  
	  return null;
  }
  
  
  
  /**
   * 获取toolbar用户信息
   * @param userVo
   * @param response
   * @param request
   */
  @RequestMapping("/toolbarUserInfo")
  @ResponseBody
  public String toolbarUserInfo(HttpServletRequest request, HttpServletResponse response){
	  JSONObject jsonObj = new JSONObject();
	  try {
		  Map<String, Cookie> map = CookieManager.readCookieMap(request);
		  if(map != null){
			  Cookie nu = map.get("un");	// 用户名称
			  Cookie ui = map.get("ui");	//账户余额
			  if(nu != null && ui != null) {
				  String name = CookieManager.cookieEncryptDecode(Constant.CookieDateEncryptManage.NAME, nu.getValue());
				  jsonObj.put("name", name);
				  
//				  String balance = CookieManager.cookieEncryptDecode(Constant.CookieDateEncryptManage.BALANCE, ui.getValue());
//				  jsonObj.put("balance", balance);
				  User sessUser = SessionManager.getUserSession(request);
				  
				  if(sessUser != null){
					  if(sessUser.getSessionSidTime() == null || sessUser.getSessionSidTime().before(new Date())){
						  //用户登录时间过期，需要重新登录
						  jsonObj.put("code", "0");
					  }else{
						  AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(sessUser.getId());
						  jsonObj.put("balance", StringUtil.replaceContextByMap(accountIntegral.getTotalMoney()));
						  jsonObj.put("code", "1");
						  
						  Map<String, Object> params = new HashMap<String, Object>();
						  params.put("receiveUser", sessUser.getId());
						  params.put("readStatus", YesORNoEnum.NO.getCode());
						  long unReadCount = messageService.selectAllCount(params);
						  jsonObj.put("unReadCount", unReadCount);
						  
					  }
				  }
			  }else{
				  jsonObj.put("code", "0");
			  }
		  }else{
			  jsonObj.put("code", "0");
		  }
	  } catch (Exception e) {
	  		logger.error(e.getMessage(), e);
	  		jsonObj.put("code", "0");
	  }
	  return String.valueOf(jsonObj);
  }
  
  
  
  /**
   * 检查用户名是否存在
   * @return
   */
  @RequestMapping("/checkLoginName")
  @ResponseBody
  public String checkLoginName(UserVo userVo){
	  JSONObject jsonObj = new JSONObject();
	  try {
		  Long count = userService.checkLoginName(userVo.getRegName());
		  if(count > 0){
			  jsonObj.put("code", "0");
		  }else{
			  jsonObj.put("code", "1");
		  }
	  } catch (Exception e) {
	  		logger.error(e.getMessage(), e);
	  		jsonObj.put("code", "0");
	  }
	  return String.valueOf(jsonObj);
  }
  
  /**
   * 检查邮箱是否存在
   * @return
   */
  @RequestMapping("/checkEmail")
  @ResponseBody
  public String checkEmail(UserVo userVo){
	  JSONObject jsonObj = new JSONObject();
	  try {
		  Long count = userService.checkEmail(EncryptUtil.encode(Constant.DateEncryptManage.EMAIL_PWD, userVo.getEmail()));
		  if(count > 0){
			  jsonObj.put("code", "0");
		  }else{
			  jsonObj.put("code", "1");
		  }
	  } catch (Exception e) {
	  		logger.error(e.getMessage(), e);
	  		jsonObj.put("code", "0");
	  }
	  return String.valueOf(jsonObj);
  }
  
  /**
   * 检查用户手机号码是否存在
   * @return
   */
  @RequestMapping("/checkPhone")
  @ResponseBody
  public String checkPhone(UserVo userVo){
	  JSONObject jsonObj = new JSONObject();
	  try {
		  Long count = userService.checkPhone(EncryptUtil.encode(Constant.DateEncryptManage.PHONE_PWD, userVo.getPhone()));
		  if(count > 0){
			  jsonObj.put("code", "0");
		  }else{
			  jsonObj.put("code", "1");
		  }
	  } catch (Exception e) {
	  		logger.error(e.getMessage(), e);
	  		jsonObj.put("code", "0");
	  }
	  return String.valueOf(jsonObj);
  }
  
  /**
   * 用户注册页面
   */
  @RequestMapping("/skipRegister")
  public String skipRegister(Model model, HttpServletRequest request){
	  Cookie cookie = CookieManager.getCookie(request, "agentCode");
	  if(null != cookie){
		  model.addAttribute("agentCode", cookie.getValue());
	  }else{
		  String domainUrl = request.getServerName();
		  Agent agent = agentService.queryByPromotionUrl(domainUrl);
		  if(null != agent){
			  model.addAttribute("agentCode", agent.getPromotionCode());
		  }
	  }
	  
	  return "/register";
  }
  
  /**
   * 代理推广注册页面
   * @param agentCode 	代理推广代码
   */
  @RequestMapping("/skipRegister/{agentCode}")
  public String skipRegister(@PathVariable("agentCode") String agentCode, Model model, HttpServletRequest request, HttpServletResponse response){
	  CookieManager.addCookie(request, response, "agentCode", agentCode, -1);
	  model.addAttribute("agentCode", agentCode);
	  return "/register";
  }
  
  /**
   * 用户推广注册页面
   * @param promoCode 	用户推广代码
   */
  @RequestMapping("/skipRegister/promo/{promoCode}")
  public String promoRegister(@PathVariable String promoCode, Model model){
	  model.addAttribute("promoCode", promoCode);
	  return "/register";
  }
  
  /**
   * 用户注册
   */
  @RequestMapping("/register")
  @ResponseBody
  public String register(UserVo userVo, HttpServletResponse response, HttpServletRequest request){
	  JSONObject json = new JSONObject();
	  
	  try {
		  //判断用户是否存在
		  Long count = userService.checkLoginName(userVo.getRegName());
		  if(count > 0){
			  json.put("code", "0");
			  json.put("msg", this.getMsg(request, "reg.error.regName"));
			  return json.toString();
		  }
		  
		  
		  User user = memberService.createMember(userVo, IpUtil.getIpAddr(request));
		  String sessionSid = PwdRandom.getSessionId(user.getLoginName());
		  userService.setLoginUserParam(user, request, response, sessionSid); //登录的用户保存用户信息到session、cookie
		  json.put("code", "1");
		  return json.toString();
	  } catch (Exception e) {
		  json.put("code", "0");
		  logger.error(e.getMessage(), e);
		  return json.toString();
	  }
  }
  
  @RequestMapping("/index")
  public String index(Model model, HttpServletRequest request, HttpServletResponse response){
	  request.setAttribute("sn", "tool-id");
	  /*热门*/
	  Map<String, Object> params = new HashMap<String, Object>();
	  params.put("hotVideo", "1");
	  params.put("begin", "1");
	  params.put("pageSize", "12");
	  List<Video> hotList = videoService.selectAll(params);
	  model.addAttribute("hotList", hotList);
	  
	  /*最新上传*/
	  params.clear();
	  params.put("newVideo", "1");
	  params.put("begin", "1");
	  params.put("pageSize", "18");
	  List<Video> newList = videoService.selectAll(params);
	  model.addAttribute("newList", newList);
	  
	  return "/index";
  }
}
