package com.xjw.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.FinalResourcesIndexDao;
import com.xjw.entity.po.sys.FinalResourcesIndex;
import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.service.sys.FinalResourcesValuesService;

@Service
public class FinalResourcesIndexServiceImpl extends BaseServiceImpl<FinalResourcesIndex> implements FinalResourcesIndexService {
  @Resource
  private FinalResourcesIndexDao finalResourcesIndexDao;
  @Resource
  private FinalResourcesValuesService finalResourcesValuesService;

  public FinalResourcesIndex getByCode(String code) {
    Map <String, Object> param = new HashMap<String, Object>();
    param.put("code", code);
    List<FinalResourcesIndex> list = this.selectAll(param);
    if(list != null && list.size() > 0){
      return list.get(0);
    }else{
      return null;
    }
  }
  
  public List<FinalResourcesValues> getFinalResourcesValuesByCode(String code){
    Map <String, Object> param = null;
    
    if(StringUtils.isNotBlank(code)){
      param = new HashMap<String, Object>();
      param.put("code", code);
      return finalResourcesValuesService.selectAll(param);
    }else{
      return null;
    }
    
  }
  
  public FinalResourcesValues getByCodeAndVal(String code, String val){
    Map <String, Object> param = new HashMap<String, Object>();
    param.put("code", code);
    param.put("val", val);
    return finalResourcesValuesService.selectOne(param);
  }
  
  public Map<String, Object> getValuesMapByCode(String code){
      Map <String, Object> param = new HashMap<String, Object>();
      param.put("code", code);
      List<FinalResourcesValues> list = finalResourcesValuesService.selectAll(param);
      
      param.clear();
      if(list != null && list.size() > 0){
        for (FinalResourcesValues finalResourcesValues : list) {
          param.put("code", finalResourcesValues.getVal());
        }
        return param;
      }else{
        return null;
      }
    
  }


  @Override
  public Class<FinalResourcesIndex> getClazz() {
    return FinalResourcesIndex.class;
  }

  @Override
  public BaseDaoImpl<FinalResourcesIndex> baseDao() {
    return finalResourcesIndexDao;
  }

}
