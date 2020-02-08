package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.FinalResourcesIndex;
import com.xjw.entity.po.sys.FinalResourcesValues;

@Service
public interface FinalResourcesIndexService extends BaseServcie<FinalResourcesIndex> {
  public FinalResourcesIndex getByCode(String code);

  public List<FinalResourcesValues> getFinalResourcesValuesByCode(String code);

  public Map<String, Object> getValuesMapByCode(String code);
  
  public FinalResourcesValues getByCodeAndVal(String code, String val);
}
