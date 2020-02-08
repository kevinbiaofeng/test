package com.xjw.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.po.media.Favorite;
import com.xjw.entity.po.media.Video;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.user.UserVo;
import com.xjw.service.media.FavoriteService;
import com.xjw.service.media.VideoService;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.service.user.UserService;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;
/**
 * 会员中心
 */
@Controller
@RequestMapping("/member/")
public class MemberController extends BaseController{
  private static Logger logger = LoggerFactory.getLogger(MemberController.class);
  
  @Autowired
  private UserService userService;
  @Autowired
  private MemberService memberService;
  @Autowired
  private FavoriteService favoriteService;
  @Autowired
  private VideoService videoService;
  @Autowired
  private UserAccountIntegralService userAccountIntegralService;
  /**
   * 获取用户信息
   */
  @RequestMapping("/skipUserCenterAccount")
  public String skipAccountInfo(Model model){
	  User user = SessionManager.getUserSession(super.getRequest());
	  model.addAttribute("sn", "left-user");
	  try {
		  if(user != null){
			  model.addAttribute("user", user);
			  
			  Map<String, Object> condition = new HashMap<String, Object>();
			  condition.put("userId", user.getId());
			  Member member = memberService.selectOne(condition);
			  member = memberService.decodeMember(member);
			  model.addAttribute("member", member);
			  
			  setPageParams(model);
		  }
	  } catch (Exception e) {
		  logger.error(e.getMessage(), e);
	  }
	  return "/xjw/user/account";
  }
  
  /**
   * 查询用户收藏电影、积分
   * @param model
   */
  private void setPageParams(Model model){
	  User user = SessionManager.getUserSession(super.getRequest());
	  Map<String, Object> condition = new HashMap<String, Object>();
	  condition.put("userId", user.getId());
	  //查询收藏电影count
	  Long favoriteCount = favoriteService.selectAllCount(condition);
	  model.addAttribute("favoriteCount", favoriteCount);
	  //查询积分
	  AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(user.getId());
	  model.addAttribute("integral", accountIntegral.getIntegral());
  }
  
  /**
   * 跳转到修改密码页面
   * @param request
   * @return
   */
  @RequestMapping("/skipUpdatePwd")
  public String skipUpdatePwd(HttpServletRequest request, Model model){
	  request.setAttribute("safe", "left-up");
	  setPageParams(model);
	  return "/xjw/user/update-pwd";
  }
  
  /**
   * 修改密码
   */
  @RequestMapping("/updatePwd")
  @ResponseBody
  public String updatePwd(UserVo userVo, HttpServletRequest request, HttpServletResponse response){
	  User user = SessionManager.getUserSession(request);
	  try {
		  String code = userService.updatePwd(user, StringUtils.trim(userVo.getOldPwd()), StringUtils.trim(userVo.getNewPwd()));
		  if(code.equals("1")){
			  this.exit(request, response);
			  return "1";	//修改成功， 不需要明确的错误
		  }else{
			  return "0";	//修改失败， 不需要明确的错误
		  }
		  
	  } catch (Exception e) {
		  logger.error(e.getMessage(), e);
		  return "0";
	  }
  }
  
  /**
   * vip
   */
  @RequestMapping("/vip")
  public String vip(UserVo userVo, HttpServletRequest request, HttpServletResponse response){
	  return "/xjw/user/vip";
  }
  
  /**
   * 跳转到我的收藏
   * @param request
   * @return
   */
  @RequestMapping(value = "/skipMyFavorite/{pageNo}/", method = RequestMethod.GET)
  public String skipMyFavorite(HttpServletRequest request, Model model, @PathVariable Integer pageNo, @RequestParam(defaultValue = "6") Integer pageSize){
	  request.setAttribute("favorite", "left-up");
	  User user = SessionManager.getUserSession(super.getRequest());
	  Map<String, Object> condition = new HashMap<String, Object>();
	  condition.put("userId", user.getId());
	  //查询收藏电影
	  try {
		  Page<Favorite> page = favoriteService.getPage(condition, pageNo, pageSize);
		  model.addAttribute("page", page);
		  List<String> videoCodes = new ArrayList<String>();
		  for (Favorite favorite : page.getDataList()) {
			  videoCodes.add(favorite.getVideoCode());
		  }
		  
		  if(page.getDataList() != null && page.getDataList().size() > 0){
			  condition.clear();
			  condition.put("videoCodes", videoCodes);
			  List<Video> list = videoService.selectAll(condition);
			  model.addAttribute("list", list);
		  }
	  } catch (BizException e) {
		  e.printStackTrace();
	  }
	  setPageParams(model);
	  return "/xjw/user/my-favorite";
  }
  
  /**
   * 跳转到会员签到页面
   * @param request
   * @return
   */
  @RequestMapping("/skipSign")
  public String skipSign(HttpServletRequest request, Model model){
	  request.setAttribute("sign", "left-up");
	  setPageParams(model);
	  return "/xjw/user/sign";
  }
}
