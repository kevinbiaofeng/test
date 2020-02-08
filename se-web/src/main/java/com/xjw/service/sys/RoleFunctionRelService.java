package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.RoleFunctionRel;
import com.xjw.utility.BizException;

@Service
public interface RoleFunctionRelService extends BaseServcie<RoleFunctionRel>{
  
  public void saveNewRecordBatch(String[] functionIds, Long roleId, Map<String, Object> dataAuthType) throws BizException;
  
  public List<RoleFunctionRel> getRoleFunctionRelByRoleId(Long userId);
}
