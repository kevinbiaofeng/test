package com.xjw.dao.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.sys.User;

@Repository
public class UserDao extends BaseDaoImpl<User> {
	
	/** 根据userid集合查询用户 */
	public List<User> getUserListByUserId(Map<String, Object> params) {
		return super.getSqlSession().selectList("User.getUserListByUserId", params);
	}
	
	/** 根据loginName查询User对象  */
	public User selectByLoginName(String loginName){
		return super.getSqlSession().selectOne("User.selectByLoginName", loginName);
	}
}
