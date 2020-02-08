package com.xjw.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.User;

@Service
public interface UserService extends BaseServcie<User> {
	
	/**
	 * 根据登陆用户名查询 
	 */
	public User getUserByLoginName(String loginName) throws Exception;
	
	/**
	 * 根据用户名和用户类别查询用户 
	 */
	public User getUserByLoginName(String loginName, Integer type) throws Exception;
	
	/**
	 * 根据用户名、sessionSid查询用户信息
	 * @return
	 */
	public User getUserByNameAndSessionSid(String loginName, String sessionSid) throws Exception;
	
	/**
	 * 验证用户名是否存在
	 * @return
	 */
	public long checkLoginName(String loginName) throws Exception;
	
	/**
	 * 验证用户邮箱是否存在
	 * @return
	 */
	public long checkEmail(String email) throws Exception;
	
	/**
	 * 验证用户手机号码是否存在
	 * @return
	 */
	public long checkPhone(String phone) throws Exception;
	
	/**
	 * 锁定用户账号
	 * @param id	用户ID
	 */
	public Integer lockUser(Long id) throws Exception;
	
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePwd(User user, String oldPwd, String newPwd) throws Exception;
	
	/**
	 * 异步修改ipaddress
	 */
	public void excuUpdateUserLoginIpAddress(final Long userId, final String ipAddress);
	
	/**
	 * 查询用户列表
	 * @param type
	 * @return
	 */
	public List<User> getUserListByUserType(String type);
	
	/**
	 * 查询用户列表
	 * @param typeList
	 * @return
	 */
	public List<User> getUserListByUserType(List<Integer> typeList);
	
	/**
	 * 用户登录后设置需要字段
	 */
	public void setLoginUserParam(User user, HttpServletRequest request, HttpServletResponse response, String sessionSid);
}
