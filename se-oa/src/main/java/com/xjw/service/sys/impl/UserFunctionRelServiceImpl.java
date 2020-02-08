package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserFunctionRelDao;
import com.xjw.entity.po.sys.UserFunctionRel;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.UserFunctionRelService;

@Service
public class UserFunctionRelServiceImpl extends BaseServiceImpl<UserFunctionRel> implements UserFunctionRelService {
   @Resource
   private UserFunctionRelDao userFunctionrelDao;

  public List<UserFunctionRel> getNormalList(Map<String, Object> param){
    List<Integer> statusList = new ArrayList<Integer>();
    statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    param.put("statusList", statusList);
    return this.selectAll(param);
  }
  
  @Override
  public Class<UserFunctionRel> getClazz() {
    return UserFunctionRel.class;
  }

  @Override
  public BaseDaoImpl<UserFunctionRel> baseDao() {
    return userFunctionrelDao;
  }


}
