package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.Function;
import com.xjw.utility.BizException;

@Service
public interface FunctionService extends BaseServcie<Function>{
  
	/** 获取正常状态的功能菜单  */
	public List<Function> getNormalFunctionList(Long userId);
	
	/** 根据code查询菜单 */
	public Function getFunctionByCode(String code);
  
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
