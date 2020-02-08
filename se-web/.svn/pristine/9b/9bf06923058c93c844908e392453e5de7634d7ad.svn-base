package com.xjw.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.user.UserDao;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserService;
import com.xjw.util.CookieManager;
import com.xjw.util.GetAddressByIp;
import com.xjw.utility.BizException;
import com.xjw.utility.EncryptUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class.getName());
	@Resource
	private UserDao userDao;
	@Resource
	private MemberService memberService;
	
	public User getUserByLoginName(String loginName) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return this.selectOne(params);
	}
	
	public User getUserByLoginName(String loginName, Integer type) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("type", type);
		return this.selectOne(params);
	}
	
	/**
	 * 根据用户名、sessionSid查询用户信息
	 * @return
	 */
	public User getUserByNameAndSessionSid(String loginName, String sessionSid) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("sessionSid", sessionSid);
		params.put("sessionSidTime", new Date());
		return this.selectOne(params);
	}
	
	/**
	 * 验证用户名是否存在
	 * @return
	 */
	public long checkLoginName(String loginName) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return this.selectAllCount(params);
	}
	
	public long checkEmail(String email) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		return memberService.selectAllCount(params);
	}
	
	public long checkPhone(String phone) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		return memberService.selectAllCount(params);
	}
	
	public Integer lockUser(Long id) throws Exception{
		if(null == id || id <= 0){
			return 0;
		}
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", id);
		condition.put("status", StatusEnum.LOCK.getCode());
		this.update(condition);
		return 1;
	}
	
	public String updatePwd(User user, String oldPwd, String newPwd) throws Exception{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", user.getId());
		condition.put("pwd", EncryptUtil.encode(Constant.DateEncryptManage.PWD_PWD, oldPwd));
		long count = this.selectAllCount(condition);
		if(count > 0){
			condition.clear();
			condition.put("id", user.getId());
			condition.put("pwd", EncryptUtil.encode(Constant.DateEncryptManage.PWD_PWD, newPwd));
			this.update(condition);
			return "1";
		}else{
			return "0";
		}
	}
	
//	public void setIpAddressInfo(Long userId, String ipAddress) throws MessagingException, IOException {
//		aa(userId, ipAddress);
//	}
	
	public void excuUpdateUserLoginIpAddress(final Long userId, final String ipAddress) {
	    new Thread(new Runnable() {
            public void run() {
                try {
                    updateUserLoginIpAddress(userId, ipAddress);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage(), e);
                }
            }
        }).start();
	}
	
	public void updateUserLoginIpAddress(Long userId, String ipAddress) throws BizException {
		Map<String, Object> modifyParams = new HashMap<String, Object>();
		modifyParams.put("id", userId);
		modifyParams.put("loginIpCityInfo", GetAddressByIp.GetAddressByIp01(ipAddress));
		this.update(modifyParams);
	}
	
	public List<User> getUserListByUserType(String type){
		  Map<String, Object> param = new HashMap<String, Object>();
		  param.put("type", type);
		  param.put("status", StatusEnum.DEFAULT.getCode());
		  return this.selectAll(param);
	}
	
	public List<User> getUserListByUserType(List<Integer> typeList){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeList", typeList);
		param.put("status", StatusEnum.DEFAULT.getCode());
		return this.selectAll(param);
	}
	
	public void setLoginUserParam(User user, HttpServletRequest request, HttpServletResponse response, String sessionSid){
		/**登录的用户保存用户信息到session、cookie*/
		CookieManager.addCookie(request, response, "un", CookieManager.cookieEncryptEncode(Constant.CookieDateEncryptManage.NAME, user.getLoginName()), 60 * 60 * 24 * 1); // 用户名   保存两周
		CookieManager.addCookie(request, response, "ui", CookieManager.cookieEncryptEncode(Constant.CookieDateEncryptManage.INTEGRAL, String.valueOf(new Date())), 60 * 60 * 24 * 1);
		CookieManager.addCookie(request, response, "s", sessionSid, 60 * 60 * 24 * 1); // sessionSid 保存1天
		/**添加登录后需要字段，member表中*/
		try {
			Member member = memberService.getMemberByUserId(user.getId());
			user.setName(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
			user.setSex(member.getSex());
			user.setLevel(member.getVipType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession(true).setAttribute(Constant.USER_SESSION, user);
	}
	
	
	@Override
	public Class<User> getClazz() {
		return User.class;
	}

	@Override
	public BaseDaoImpl<User> baseDao() {
		return userDao;
	}

}
