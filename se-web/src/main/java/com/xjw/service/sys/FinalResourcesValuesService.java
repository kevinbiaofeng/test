package com.xjw.service.sys;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.FinalResourcesValues;

@Service
public interface FinalResourcesValuesService extends BaseServcie<FinalResourcesValues>{
  
	public Map<String, Object> getMapForList(String code);
}
