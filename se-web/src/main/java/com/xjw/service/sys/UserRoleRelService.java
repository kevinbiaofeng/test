package com.xjw.service.sys;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.utility.BizException;

@Service
public interface UserRoleRelService extends BaseServcie<UserRoleRel>{
  public void saveNewRecordBatch(String userIds, Long roleId) throws BizException;
  
  public List<UserRoleRel> getRoleIdsByUserId(Long userId);
}
