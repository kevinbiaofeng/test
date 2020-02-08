package com.xjw.base.service;

import java.util.List;
import java.util.Map;

import com.xjw.entity.Page;
import com.xjw.utility.BizException;

public interface BaseServcie <T> {
  public T save(T t) throws BizException;
  public int saveRecordBatch(List<T> list) throws BizException;
  public int deleteOne(Map<String, Object> params) throws BizException;
  public int delete(List<Long> ids) throws BizException;
  public int update(T t) throws BizException;
  public int update(Map<String, Object> params) throws BizException;
  public T selectById(Long id);
  public List<T> selectAll(Map<String, Object> params);
  public T selectOne(Map<String, Object> params);
  public long selectAllCount(Map<String, Object> params);
  public Class<T> getClazz();
  public Page<T> getPage(Map<String, Object> params, Integer pageNo, Integer pageSize) throws BizException;
}
