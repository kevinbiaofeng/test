package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.Role;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.vo.UserVo;

@Service
public interface RoleService extends BaseServcie<Role> {
  /**
   * 获取状态正常数据
   * 
   * @return
   */
  public List<Role> getNormalList(Map<String, Object> param);

  public List<Map<String, Object>> getMapNormalList();

  public List<Role> selectRoleListByUserId(Long userId);
  
  public List<UserVo> selectRoleNameByUserList(List<User> userList);
  
  public Role selectByCode(String code);
}
