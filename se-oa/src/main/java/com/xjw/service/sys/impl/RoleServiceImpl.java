package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.RoleDao;
import com.xjw.entity.po.sys.Role;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.entity.vo.UserVo;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.RoleService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.utility.BeanToMapUtil;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
  @Resource
  private RoleDao roleDao;
  @Resource
  private UserRoleRelService userRoleRelService;

  public List<Role> getNormalList(Map<String, Object> param) {
    List<Integer> statusList = new ArrayList<Integer>();
    statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    param.put("statusList", statusList);
    return this.selectAll(param);
  }
  
  public Role selectByCode(String code){
    Map<String, Object> condition = new HashMap<String, Object>();
    condition.put("code", code);
    return this.selectOne(condition);
  }
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> getMapNormalList() {
    Map <String, Object> param = new HashMap<String, Object>();
    List <Role> list = this.getNormalList(param);
    List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
    for (Role role : list) {
      mapList.add(BeanToMapUtil.convertBean(role));
    }
    return mapList;
  }
  
  public List<Role> selectRoleListByUserId(Long userId){
    Map<String, Object> conditionParam = new HashMap<String, Object>();
    conditionParam.put("userId", userId);
    List<UserRoleRel> list = userRoleRelService.selectAll(conditionParam);
    if(list != null && list.size() > 0){
        List<Long> ids = new ArrayList<Long>();
        for (UserRoleRel userRoleRel : list) {
          ids.add(userRoleRel.getRoleId());
        }
        conditionParam.clear();
        conditionParam.put("ids", ids);
        return this.selectAll(conditionParam);
    }else{
        return null;
    }
  }
  
  public List<UserVo> selectRoleNameByUserList(List<User> userList){
    List<Long> userIds = null;
    if(userList != null && userList.size() > 0){
      userIds = new ArrayList<Long>();
      for (User user : userList) {
        userIds.add(user.getId());
      }
      Map<String, Object> conditionParam = new HashMap<String, Object>();
      conditionParam.put("userIds", userIds);
      List<UserRoleRel> userRoleRelList = userRoleRelService.selectAll(conditionParam);
      List<UserVo> userVoList = new ArrayList<UserVo>();
      for (User user : userList) {
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        for (UserRoleRel userRoleRel : userRoleRelList) {
          if(user.getId().longValue() == userRoleRel.getUserId().longValue()){
            vo.setRoleNames(StringUtils.isNotBlank(vo.getRoleNames())? vo.getRoleNames() + "," + userRoleRel.getName() : userRoleRel.getName());
          }
        }
        userVoList.add(vo);
      }
      return userVoList;
    }else{
      return null;
    }
  }

  @Override
  public Class<Role> getClazz() {
    return Role.class;
  }

  @Override
  public BaseDaoImpl<Role> baseDao() {
    return roleDao;
  }
}
