package com.xjw.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.sys.FunctionDao;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.RoleFunctionRel;
import com.xjw.entity.po.sys.UserRoleRel;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.user.UserTypeAllEnum;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.RoleFunctionRelService;
import com.xjw.service.sys.UserRoleRelService;
import com.xjw.service.user.UserService;
import com.xjw.util.TreeUtil;
import com.xjw.utility.BeanToMapUtil;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService, BaseServcie<Function> {
   @Resource
   private FunctionDao functionDao;
   @Resource
   private RoleFunctionRelService roleFunctionRelService;
   @Resource
   private UserService userService;
   @Resource
   private UserRoleRelService userRoleRelService;

  public List<Function> getNormalMainList(){
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("parentId", Constant.CommonManage.NO);
    return this.getNormalFunctionList(param);
  }
  
  public List<Function> getNormalFunctionList(Map<String, Object> param){
    List<Integer> statusList = new ArrayList<Integer>();
    statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    param.put("statusList", statusList);
    return this.selectAll(param);
  }
  
  @SuppressWarnings("unchecked")
  public void updateFunctionAndLevel(Function function) throws BizException{
    this.update(function);
    if(function.getParentId() == 0){
      Map <String, Object> param = new HashMap<String, Object>();
      List<Function> list = this.getNormalFunctionList(param);
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
	  Map<String, Object> param = new HashMap<String, Object>();
	  if(user.getType().byteValue() == Integer.valueOf(UserTypeAllEnum.GLY.getCode()).byteValue()){
		  return this.getNormalFunctionList(param);
	  }else{
		  List<UserRoleRel> userRoleRelList = userRoleRelService.getRoleIdsByUserId(userId);
		  if(userRoleRelList != null && userRoleRelList.size() > 0){
			  List<RoleFunctionRel> roleFunctionRelList = roleFunctionRelService.getRoleFunctionRelByRoleId(userRoleRelList.get(0).getRoleId());
			  if(roleFunctionRelList != null && roleFunctionRelList.size() > 0){
				  List <Long> ids = new ArrayList<Long>();
				  for (RoleFunctionRel roleFunctionRel : roleFunctionRelList) {
					  ids.add(roleFunctionRel.getFunctionId());
				  }
				  param.put("ids", ids);
				  return this.getNormalFunctionList(param);
			  }
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
