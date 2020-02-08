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
import com.xjw.dao.sys.FunctionDao;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.RoleFunctionRelService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.service.sys.UserService;
import com.xjw.util.TreeUtil;
import com.xjw.utility.BeanToMapUtil;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService{
   @Resource
   private FunctionDao functionDao;
   @Resource
   private RoleFunctionRelService roleFunctionRelService;
   @Resource
   private UserService userService;
   @Resource
   private UserRoleRelService userRoleRelService;

   public List<Function> getNormalFunctionList(Long userId){
	   Map<String, Object> params = new HashMap<String, Object>();
	   params.put("status", StatusEnum.DEFAULT.getCode());
	   params.put("showFlag", "1");
	   
	   User user = userService.selectById(userId);
	   if(user.getType().intValue() == Integer.valueOf(UserTypeAllEnum.GLY.getCode())){
		   params.remove("showFlag");
	   }
	   
	   return this.selectAll(params);
   }
   
   public Function getFunctionByCode(String code){
	   if(StringUtils.isNotBlank(code)){
		   Map<String, Object> params = new HashMap<String, Object>();
		   params.put("code", code);
		   
		   List<Function> list = this.selectAll(params);
		   if(list.size() > 0){
			   return list.get(0);
		   }
	   }
	   
	   return null;
   }
  
  @SuppressWarnings("unchecked")
  public void updateFunctionAndLevel(Function function) throws BizException{
    this.update(function);
    if(function.getParentId() == 0){
      List<Function> list = this.getNormalFunctionList(null);
      if(list != null && list.size() > 0){
          List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
          for (Function role : list) {
            mapList.add(BeanToMapUtil.convertBean(role));
          }
          String ids = TreeUtil.getIdsByListAndId(function.getId(), mapList);
          if(StringUtils.isNotBlank(ids)){
            Map<String, Object> conditionParam = new HashMap<String, Object>();
            conditionParam.put("level", function.getLevel());
            conditionParam.put("ids", StringUtil.getListFromStr(ids));
            this.update(conditionParam);
          }
      }
    }
  }
  
  
  public Map<String, Object> getFunctionMapByUserId(Long userId){
	  List<Function> functionList = this.getFunctionListByUserId(userId);
	  if(functionList != null && functionList.size() > 0){
		  Map<String, Object> objList = new HashMap<String, Object>();
		  for (Function function : functionList) {
			  objList.put(function.getCode(), function.getUrl());
		  }
		  return objList;
	  }
	  return null;
  }
  
  public List<Function> getFunctionListByUserId(Long userId){
	  User user = userService.selectById(userId);
	  if(user.getType().intValue() == Integer.valueOf(UserTypeAllEnum.GLY.getCode())){
		  return this.getNormalFunctionList(userId);
	  }else{
		  List<UserRoleRel> userRoleRelList = userRoleRelService.getRoleIdsByUserId(userId);
		  if(userRoleRelList != null && userRoleRelList.size() > 0){
			  Map<String, Object> funParams = new HashMap<String, Object>();
			  funParams.put("roleId", userRoleRelList.get(0).getRoleId());
			  funParams.put("status", StatusEnum.DEFAULT.getCode());
			  funParams.put("showFlag", 1);
			  return functionDao.selectAllByRole(funParams);
		  }
	  }
	  
	  return null;
  }
  
  @Override
  public Class<Function> getClazz() {
    return Function.class;
  }

  @Override
  public BaseDaoImpl<Function> baseDao() {
    return functionDao;
  }
}
