package com.xjw.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserService;
import com.xjw.utility.EncryptUtil;

/**
 * 重置密码 
 */
@Controller
@RequestMapping("/resetpwd")
public class ResetPwdController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(ResetPwdController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String index(){
		return "/xjw/user/resetpwd";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save(@RequestParam("loginName") String loginName, @RequestParam("email") String email){
		if(StringUtils.isBlank(loginName)){
			return this.toJsonResult("102", "请输入账号").toString();
		}else if(StringUtils.isBlank(email)){
			return this.toJsonResult("104", "请输入邮箱").toString();
		}

		try {
			User user = userService.getUserByLoginName(loginName);
			if(null == user){
				return this.toJsonResult("110", "您的登录账号或邮箱错误，请重新输入").toString();
			}
			
			Member member = memberService.getMemberByUserId(user.getId());
			if(!EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, member.getEmail()).equals(email)){
				return this.toJsonResult("112", "您的登录账号或邮箱错误，请重新输入").toString();
			}
		
			memberService.updateMemberPwd(user.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
			return this.toJsonResult("-1", "密码重置失败，请稍后再试").toString();
		}
		
		return this.toJsonResult("1", "密码已重置，请登录您的邮箱查看最新密码").toString();
	}
	
	private JSONObject toJsonResult(String code, String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("msg", msg);
		return jsonObject;
	}
	
	public static void main(String[] args) {
		String pwd = "123123";
		System.out.println(EncryptUtil.encode(Constant.DateEncryptManage.PWD_PWD, pwd));
		
		
//		String email = "FC8958F7036841C0AB3C5128E848D1B24BEE529B380AF919";
//		System.out.println(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, email));
		
//		String email = "lyd8935@126.com";
//		System.out.println(EncryptUtil.encode(Constant.DateEncryptManage.EMAIL_PWD, email));
	}
}
