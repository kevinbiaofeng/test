package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserDao;
import com.xjw.entity.po.sys.Dept;
import com.xjw.entity.po.sys.Role;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserDeptRel;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.kzenum.AbstractEnum.EnumBean;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.kzenum.sys.UserTypeEnum;
import com.xjw.service.sys.DeptService;
import com.xjw.service.sys.RoleService;
import com.xjw.service.sys.UserDeptRelService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.service.sys.UserService;
import com.xjw.utility.BizException;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.MD5Util;
import com.xjw.utility.StringUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private UserDeptRelService userDeptRelService;
	@Resource
	private DeptService deptService;
	@Resource
	private RoleService roleService;
	@Resource
	private UserRoleRelService userRoleRelService;

	// @Override
	// public int deleteByIds(List<Long> ids){
	// Map <String, Object> param = new HashMap<String, Object>();
	// param.put("ids", ids);
	// return this.deleteOne(param);
	// }

	public List<User> getNormalList() {
		Map<String, Object> m = new HashMap<String, Object>();
		return this.getNormalList(m);
	}

	public List<User> getByUserIds(List<Long> ids) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ids", ids);
		return this.selectAll(param);
	}

	public List<User> getNormalList(Map<String, Object> params) {
		List<Integer> status = new ArrayList<Integer>();
		status.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
		status.add(Integer.valueOf(StatusEnum.LOCK.getCode()));
		params.put("statusList", status);
		return this.selectAll(params);
	}

	public User selectByLoginNameAndPwd(User u) throws BizException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
		statusList.add(Integer.valueOf(StatusEnum.LOCK.getCode()));
		map.put("statusList", statusList);
		map.put("loginName", u.getLoginName());
		try {
			map.put("pwd", MD5Util.getMessageDigest(u.getPwd()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.selectOne(map);
	}

	@SuppressWarnings("unchecked")
	public void deleteUserAndDeptRel(String ids) throws BizException {
		this.delete(StringUtil.getListFromStr(ids));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userIds", StringUtil.getListFromStr(ids));
		userDeptRelService.deleteOne(params);
	}

	public void saveUserAndDeptRel(User user, Long deptId) throws BizException {
		Dept dept = deptService.selectById(deptId);
		
		List<EnumBean> list = UserTypeAllEnum.getEnumBeans(UserTypeAllEnum.class);
        for (EnumBean enumBean : list) {
            if (enumBean.getName().equals(dept.getCode())) {
                user.setType(Integer.valueOf(enumBean.getCode()));
                break;
            }
        }
		
		user.setPwd(MD5Util.getMessageDigest(user.getPwd()));
		user.setParentId(getDLParentId(CurrentUserHolder.getCurrentUserId()));
		User u = this.save(user);
		
		UserDeptRel userDeptRel = new UserDeptRel();
		userDeptRel.setDeptId(deptId);
		userDeptRel.setUserId(u.getId());
		userDeptRelService.save(userDeptRel);

		Role role = roleService.selectByCode(dept.getCode());
		if (role != null && UserTypeEnum.USER.getCode().equals(String.valueOf(user.getType()))) {
			UserRoleRel userRoleRel = new UserRoleRel();
			userRoleRel.setUserId(u.getId());
			userRoleRel.setRoleId(role.getId());
			userRoleRelService.save(userRoleRel);
		}
	}

	public Long getDLParentId(Long userId) {
		User user = this.selectById(userId);
		if (UserTypeAllEnum.GLY.getCode().equals(String.valueOf(user.getType()))
				|| UserTypeAllEnum.DL.getCode().equals(String.valueOf(user.getType()))) {
			return user.getId();
		} else {
			return getDLParentId(user.getParentId());
		}
	}

	public Long getUserParentId(User user) {
		Long parentId = null;
		if (user != null) {
			if (UserTypeAllEnum.DL.getCode().equals(String.valueOf(user.getType()))
					|| UserTypeAllEnum.GLY.getCode().equals(String.valueOf(user.getType()))) {
				parentId = user.getId();
			} else {
				parentId = user.getParentId();
			}
		}
		return parentId;
	}

	public void updateUserAndDeptRel(User user, Long deptId, Long oldDeptId) throws BizException {
		Dept dept = deptService.selectById(deptId);
		Integer type = user.getType();
		if (type != null && UserTypeEnum.USER.getCode().equals(String.valueOf(type))) {
			List<EnumBean> list = UserTypeAllEnum.getEnumBeans(UserTypeAllEnum.class);

			for (EnumBean enumBean : list) {
				if (enumBean.getName().equals(dept.getCode())) {
					user.setType(Integer.valueOf(enumBean.getCode()));
					break;
				}
			}
		}
		try {
			User oldUser = this.selectById(user.getId());
			if(!oldUser.getPwd().equals(user.getPwd())){
				user.setPwd(MD5Util.getMessageDigest(user.getPwd()));
			}else{
				user.setPwd("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.update(user);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptId", oldDeptId);
		condition.put("userId", user.getId());
		List<UserDeptRel> list = userDeptRelService.selectAll(condition);
		if (list != null && list.size() > 0) {
			UserDeptRel userDeptRel = list.get(0);
			userDeptRel.setDeptId(deptId);
			userDeptRelService.update(userDeptRel);
		}
	}

	public List<User> getUserListByDeptIdAndLoginUserId(Long deptId, Long userId) {
		Long parentId = this.getDLParentId(userId);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptId", deptId);
		params.put("parentId", parentId);
		return this.selectAll(params);
	}

	public User checkUserName(String loginName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("loginName", loginName);
		param.put("statusList",
				StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode() + "," + StatusEnum.LOCK.getCode()));
		return this.selectOne(param);
	}

	/**
	 * 验证账户名称获取用户列表
	 * 
	 * @return
	 */
	public List<User> selectUserListByLoginName(String loginName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("keywords", loginName);
		param.put("type", UserTypeAllEnum.KH.getCode());
		param.put("statusList",
				StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode() + "," + StatusEnum.LOCK.getCode()));
		return this.selectAll(param);
	}

	public List<User> getUserListByUserType(String type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("status", StatusEnum.DEFAULT.getCode());
		return this.selectAll(param);
	}

	public List<User> getUserListByUserType(List<Integer> typeList) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeList", typeList);
		param.put("status", StatusEnum.DEFAULT.getCode());
		return this.selectAll(param);
	}

	public void modifyPwd(User user, String oldPwd, String newPwd) throws BizException {
		oldPwd = StringUtils.trim(oldPwd);
		newPwd = StringUtils.trim(newPwd);

		if (StringUtils.isBlank(oldPwd)) {
			throw new BizException("原始密码不能为空");
		} else if (StringUtils.isBlank(newPwd) || newPwd.length() < 6) {
			throw new BizException("新密码不能为空且长度不能小于6位数");
		}

		String md5OldPwd = MD5Util.getMessageDigest(oldPwd);
		String md5NewPwd = MD5Util.getMessageDigest(newPwd);

		if (!user.getPwd().equals(md5OldPwd)) {
			throw new BizException("原始密码错误，请重新输入 ");
		}

		User _user = new User();
		_user.setId(user.getId());
		_user.setPwd(md5NewPwd);
		this.update(_user);
		
	}

	@Override
	public Class<User> getClazz() {
		return User.class;
	}

	@Override
	public BaseDaoImpl<User> baseDao() {
		return userDao;
	}

	public List<User> getUserListByUserId(Map<String, Object> params) {
		return userDao.getUserListByUserId(params);
	}

	public User getUserByLoginName(String loginName) {
		return userDao.selectByLoginName(loginName);
	}

}
