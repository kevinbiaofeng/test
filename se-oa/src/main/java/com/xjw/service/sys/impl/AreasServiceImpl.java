package com.xjw.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.AreasDao;
import com.xjw.entity.po.sys.Areas;
import com.xjw.service.sys.AreasService;

@Service
public class AreasServiceImpl extends BaseServiceImpl<Areas> implements AreasService {
  @Resource
  private AreasDao areasDao;
  
  public List<Areas> getAreasListByParentCode(String parentCode){
    Map<String, Object> conditionParam = null;
    if(StringUtils.isNotBlank(parentCode)){
      conditionParam = new HashMap<String, Object>();
      conditionParam.put("parentCode", parentCode);
      return this.selectAll(conditionParam);
    }else{
      return null;
    }
  }
  
  public Areas getAreasListByCode(String code){
    Map<String, Object> conditionParam = null;
    if(StringUtils.isNotBlank(code)){
      conditionParam = new HashMap<String, Object>();
      conditionParam.put("areaCode", code);
      return this.selectOne(conditionParam);
    }else{
      return null;
    }
  }
  
  @Override
  public Class<Areas> getClazz() {
    return Areas.class;
  }

  @Override
  public BaseDaoImpl<Areas> baseDao() {
    return areasDao;
  }
}
