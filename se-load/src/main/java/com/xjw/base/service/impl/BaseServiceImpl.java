package com.xjw.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.entity.BasePo;
import com.xjw.base.service.BaseServcie;
import com.xjw.entity.Page;
import com.xjw.utility.BizException;
import com.xjw.utility.ClassUtil;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.StringUtil;


@Component
public abstract class BaseServiceImpl<T extends BasePo> implements BaseServcie<T> {
  @Resource
  public abstract BaseDaoImpl<T> baseDao();

  public abstract Class<T> getClazz();
  
  public List<T> selectAll(Map <String, Object> param) {
    return baseDao().selectAll(ClassUtil.getMapId(getClazz(), new Throwable()), param);
  }
  
  public T selectOne(Map<String, Object> params) {
    List<T> list = this.selectAll(params);
    if(list != null && list.size() > 0)
      return list.get(0);
    else
      return null;
  }
  
  public T selectById(Long id){
    return baseDao().selectById(ClassUtil.getMapId(getClazz(), new Throwable()), id);
  }

  public T save(T t) throws BizException{
    return baseDao().save(ClassUtil.getMapId(getClazz(), new Throwable()), t);
  }
  
  public int update(T t) throws BizException{
    return baseDao().update(ClassUtil.getMapId(getClazz(), new Throwable()), t);
  }
  
  public int update(Map<String, Object> params) throws BizException{
    params.put("updateTime", new Date());
    params.put("updateUser", CurrentUserHolder.getCurrentUserId());
    return baseDao().update(ClassUtil.getMapId(getClazz(), new Throwable()), params);
  }
  
  public Page<T> getPage(Map<String, Object> params, Integer pageNo, Integer pageSize) throws BizException{
//	  if(params.get("statusList") == null){
//		  params.put("statusList", StringUtil.getListFromStr("1"));
//	  }
	  long totalCount = this.selectAllCount(params);
	  Page<T> page = new Page<T>();
	  page.setTotalCount(totalCount);
	  if(pageNo != null){
		  page.setPageNo(pageNo);
	  }
	  if(pageSize != null){
		  page.setPageSize(pageSize);
	  }
	  params.put("begin", page.getBegin());
      params.put("pageSize", page.getPageSize());
      page.setDataList(this.selectAll(params));
      return page;
  }
  
  public long selectAllCount(Map<String, Object> params){
    return baseDao().selectAllCount(ClassUtil.getMapId(getClazz(), new Throwable()), params);
  }
  
  public int saveRecordBatch(List<T> list) throws BizException{
    return baseDao().saveRecordBatch(ClassUtil.getMapId(getClazz(), new Throwable()), list);
  }
  
  public int delete(List<Long> ids) throws BizException{
    Map <String, Object> params = new HashMap<String, Object>();
    params.put("ids", ids);
    params.put("status", 3);
    params.put("updateTime", new Date());
    params.put("updateUser", CurrentUserHolder.getCurrentUserId());
    return baseDao().delete(ClassUtil.getMapId(getClazz(), new Throwable()), params);
  }
  
  public int deleteOne(Map<String, Object> params) throws BizException{
    return baseDao().deleteOne(ClassUtil.getMapId(getClazz(), new Throwable()), params);
  }
  
}
