package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.User;
import com.xjw.utility.BizException;

@Service
public interface UserService extends BaseServcie<User>{
//  public int deleteByIds(List<Long> ids);
  
  public User selectByLoginNameAndPwd(User u) throws BizException;
  
  public List<User> getNormalList();
  
  public List<User> getByUserIds(List<Long> ids);
  
  public List<User> getNormalList(Map<String, Object> params);
  
  public void deleteUserAndDeptRel(String ids) throws BizException;
  
  public void saveUserAndDeptRel(User user, Long deptId) throws BizException;
  
  public void updateUserAndDeptRel(User user, Long deptId, Long oldDeptId) throws BizException;
  
  public Long getUserParentId(User user);
  
  public Long getDLParentId(Long userId);
  
  /**
   * 查询该代理部门下所有用户列表，根据部门ID 登录用户ID
   * @param deptId
   * @param userId
   * @return
   */
  public List<User> getUserListByDeptIdAndLoginUserId(Long deptId, Long userId);
  
  /**
   * 验证登录名是否存在
   * @return
   */
  public User checkUserName(String loginName);
  
  /**
   * 验证账户名称获取用户列表
   * @return
   */
  public List<User> selectUserListByLoginName(String loginName);
  
  /**
   * 根据用户类型查询用户
   * @param deptId
   * @param userId
   * @return
   */
  public List<User> getUserListByUserType(String type);
  
  /**
   * 根据多个用户类型 查询用户
   * @param deptId
   * @param userId
   * @return
   */
  public List<User> getUserListByUserType(List<Integer> typeList);
  
  /**
   * 修改密码
   * @param user	登录用户
   * @param oldPwd	旧密码
   * @param newPwd	新密码
   * @throws BizException
   */
  public void modifyPwd(User user, String oldPwd, String newPwd) throws BizException;
  
  /**
   * 根据userid集合查询用户
   * @param userIdList
   * @return List<User>
   */
  public List<User> getUserListByUserId(Map<String, Object> params);
  
  /** 根据loginName查询User对象  */
  public User getUserByLoginName(String loginName);
}
