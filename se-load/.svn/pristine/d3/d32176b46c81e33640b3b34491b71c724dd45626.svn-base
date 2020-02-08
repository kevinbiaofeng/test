package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.RoleFunctionRelDao;
import com.xjw.entity.po.sys.RoleFunctionRel;
import com.xjw.service.sys.RoleFunctionRelService;
import com.xjw.utility.BizException;

@Service
public class RoleFunctionRelServiceImpl extends BaseServiceImpl<RoleFunctionRel> implements RoleFunctionRelService, BaseServcie<RoleFunctionRel> {
   @Resource
   private RoleFunctionRelDao roleFunctionrelDao;
   
   public void saveNewRecordBatch(String[] functionIds, Long roleId, Map<String, Object> dataAuthType) throws BizException {
     Map <String, Object> delParam = new HashMap<String, Object>();
     delParam.put("roleId", roleId);
     this.deleteOne(delParam);
     
     List<RoleFunctionRel> list = new ArrayList<RoleFunctionRel>();
     for (String functionId : functionIds) {
       RoleFunctionRel u = new RoleFunctionRel();
       u.setRoleId(roleId);
       u.setFunctionId(Long.valueOf(functionId));
       if(dataAuthType.get(functionId) != null){
         u.setDataAuthType(Integer.valueOf(dataAuthType.get(functionId).toString()));
       }
       list.add(u);
     }
     this.saveRecordBatch(list);
   }
   
   public List<RoleFunctionRel> getRoleFunctionRelByRoleId(Long roleId){
       Map <String, Object> conditionParam = new HashMap<String, Object>();
       conditionParam.put("roleId", roleId);
       return this.selectAll(conditionParam);
   }
   
   @Override
   public Class<RoleFunctionRel> getClazz() {
    return RoleFunctionRel.class;
   }

   @Override
   public BaseDaoImpl<RoleFunctionRel> baseDao() {
    return roleFunctionrelDao;
   }


}
