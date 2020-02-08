package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.DeptDao;
import com.xjw.entity.po.sys.Dept;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.DeptService;
import com.xjw.utility.BeanToMapUtil;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {
  @Resource
  private DeptDao deptDao;

  public List<Dept> getNormalList() {
    Map <String, Object> param = new HashMap<String, Object>();
    List<Integer> statusList = new ArrayList<Integer>();
    statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    param.put("statusList", statusList);
    return this.selectAll(param);
  }
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> getMapNormalList() {
    List <Dept> list = this.getNormalList();
    List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
    for (Dept dept : list) {
      mapList.add(BeanToMapUtil.convertBean(dept));
    }
    return mapList;
  }
  
  public String getDeptCodesAll(){
    List<Dept> list = this.getNormalList();
    if(list != null && list.size() > 0){
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i < list.size(); i++) {
        buf.append(i > 0? ",": "").append(list.get(i).getCode());
      }
      return buf.toString();
    }else{
      return null;
    }
  }
  
  @Override
  public Class<Dept> getClazz() {
    return Dept.class;
  }

  @Override
  public BaseDaoImpl<Dept> baseDao() {
    return deptDao;
  }
}
