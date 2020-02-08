package com.xjw.controller.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjw.controller.BaseController;
import com.xjw.entity.form.user.SameIpForm;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserLoginLog;
import com.xjw.entity.po.user.Member;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.sys.UserLoginLogService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.MemberService;
import com.xjw.utility.BizException;

/**
 * 马甲账号查询
 */
@Controller
@RequestMapping("/member/sameip/")
public class SameIpController extends BaseController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginLogService userLoginLogService;
	
	@RequestMapping("list")
	public String list(SameIpForm form, Model model) throws BizException {
		if(null != form && StringUtils.isNotBlank(form.getLoginName())){
			Member member = memberService.findMemberByLoginName(form.getLoginName());
			List<String> ip3List = this.getIp3List(member);

			if(null != ip3List && !ip3List.isEmpty()){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("ip3List", ip3List);
				
				List<UserLoginLog> logList = userLoginLogService.getByIp3(params);
				
				Map<String, List<UserLoginLog>> ip2UserLogMap = new HashMap<String, List<UserLoginLog>>();
				Map<String, List<UserLoginLog>> user2IpLogMap = new HashMap<String, List<UserLoginLog>>();
				for(UserLoginLog log : logList){
					User user = userService.selectById(log.getUserId());
					//仅需要统计前台用户
					if(UserTypeAllEnum.KH.getCode().equals(user.getType().toString())){
						log.setStatus(user.getStatus());
						
						//IP -> 账号映射
						String ipKey = log.getIpAddress().substring(0, log.getIpAddress().lastIndexOf("."));
						if(ip2UserLogMap.containsKey(ipKey)){
							List<UserLoginLog> ipLogList = ip2UserLogMap.get(ipKey);
							ipLogList.add(log);
						}else{
							List<UserLoginLog> ipLogList = new ArrayList<UserLoginLog>();
							ipLogList.add(log);
							ip2UserLogMap.put(ipKey, ipLogList);
						}
						
						//账号 -> IP映射
						String userKey = user.getLoginName() + "|" + user.getStatus();
						if(user2IpLogMap.containsKey(userKey)){
							List<UserLoginLog> iplogList = user2IpLogMap.get(userKey);
							iplogList.add(log);
						}else{
							List<UserLoginLog> ipLogList = new ArrayList<UserLoginLog>();
							ipLogList.add(log);
							user2IpLogMap.put(userKey, ipLogList);
						}
					}
				}
				
				model.addAttribute("ip2UserLogMap", ip2UserLogMap);
				model.addAttribute("user2IpLogMap", user2IpLogMap);
			}
		}
		
		model.addAttribute("form", form);
		return "xjw/member/sameip/sameip-list";
	}
	
	/**
	 * 获取IP前三段网段地址（格式：192.168.1）
	 */
	private List<String> getIp3List(Member member){
		if(null!= member){
			Calendar nowTime = Calendar.getInstance();
			Date beginTime = new GregorianCalendar(nowTime.get(Calendar.YEAR), nowTime.get(Calendar.MONTH)-3, nowTime.get(Calendar.DATE)).getTime();
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("loginName", member.getLoginName());
			params.put("beginTime", beginTime);
			
			List<String> ipList = userLoginLogService.getIpList(params);
			if(!ipList.contains(member.getRegisterIp())){
				ipList.add(member.getRegisterIp());
			}
			
			List<String> ip3List = new ArrayList<String>();  
			for(String ip : ipList){
				ip3List.add(ip.substring(0, ip.lastIndexOf(".")));
			}
			
			return ip3List;
		}
		
		return null;
	}
}
