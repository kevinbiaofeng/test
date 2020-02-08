package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserRoleRelDao;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Service
public class UserRoleRelServiceImpl extends BaseServiceImpl<UserRoleRel> implements UserRoleRelService {
   @Resource
   private UserRoleRelDao userRoleRelDao;
   
   @SuppressWarnings("unchecked")
   public void saveNewRecordBatch(String userIds, Long roleId) throws BizException{
     if(StringUtils.isNotBlank(userIds)){
      List<String> ids = StringUtil.getListFromStr(userIds);
       Map<String, Object> conditionParam = new HashMap<String, Object>();
       conditionParam.put("userIds", ids);
       this.deleteOne(conditionParam);
       
       List<UserRoleRel> list = new ArrayList<UserRoleRel>();
       for (String userId : ids) {
         UserRoleRel userRoleRel = new UserRoleRel();
         userRoleRel.setRoleId(roleId);
         userRoleRel.setUserId(Long.valueOf(userId));
         list.add(userRoleRel);
       }
       this.saveRecordBatch(list);
     }
   }
   
   public List<UserRoleRel> getRoleIdsByUserId(Long userId){
     Map<String, Object> conditionParam = new HashMap<String, Object>();
     conditionParam.put("userId", userId);
     return this.selectAll(conditionParam);
   }
   
   @Override
   public Class<UserRoleRel> getClazz() {
     return UserRoleRel.class;
   }

   @Override
   public BaseDaoImpl<UserRoleRel> baseDao() {
     return userRoleRelDao;
   }
}
