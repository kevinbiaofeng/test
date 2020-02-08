package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.Function;
import com.xjw.utility.BizException;

@Service
public interface FunctionService extends BaseServcie<Function>{
  
  /**
   * 获取正常的主菜单 非禁用、删除状态
   * @return
   */
  public List<Function> getNormalMainList();
  
  /**
   * 获取正常的功能 非禁用、删除状态
   * @return
   */
  public List<Function> getNormalFunctionList(Map<String, Object> param);
  
  public void updateFunctionAndLevel(Function function) throws BizException;
  
  /**
   * 根据用户ID获取用户角色功能权限列表
   * @param userId
   * @return
   */
  public List<Function> getFunctionListByUserId(Long userId);
  
  /**
   * 根据用户ID获取用户角色功能权限列表   MAP形式
   */
  public Map<String, Object> getFunctionMapByUserId(Long userId);
}
