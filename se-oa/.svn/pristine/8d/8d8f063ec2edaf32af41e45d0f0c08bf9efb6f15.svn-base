package com.xjw.base.dao;

import java.util.List;
import java.util.Map;

import com.xjw.base.entity.BasePo;
import com.xjw.utility.BizException;

public interface BaseDao<T extends BasePo>{
  
  public T save(String mapId, T t) throws BizException;
  
  public int saveRecordBatch(String mapId, List<T> list) throws BizException;
  
  public int deleteOne(String mapId, Object params) throws BizException;
  
  public List<T> selectAll(String mapId, Object params);
  
  public long selectAllCount(String mapId, Object params);
  
  public int update(String mapId, T t) throws BizException;
  
  public int update(String mapId, Map<String, Object> params) throws BizException;
  
  public int delete(String mapId, Object params) throws BizException;
  
  public T selectById(String mapId, Long id);
}
