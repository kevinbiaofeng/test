package com.xjw.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.FinalResourcesValuesDao;
import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.service.sys.FinalResourcesValuesService;

@Service
public class FinalResourcesValuesServiceImpl extends BaseServiceImpl<FinalResourcesValues> implements FinalResourcesValuesService {
  @Resource
  private FinalResourcesValuesDao finalResourcesValuesDao;

  @Override
  public Class<FinalResourcesValues> getClazz() {
    return FinalResourcesValues.class;
  }

  @Override
  public BaseDaoImpl<FinalResourcesValues> baseDao() {
    return finalResourcesValuesDao;
  }

public Map<String, Object> getMapForList(String code) {
	// TODO Auto-generated method stub
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("code", code);
	List<FinalResourcesValues> list = this.selectAll(params);
	params.clear();
	if(list!=null&list.size()>0){
		
		for (FinalResourcesValues finalResourcesValues : list) {
			params.put(finalResourcesValues.getVal(), finalResourcesValues.getName());
		}
	}
	return params;
}

}
