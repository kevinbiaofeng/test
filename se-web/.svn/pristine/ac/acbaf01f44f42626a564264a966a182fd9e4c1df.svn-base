package com.xjw.service.log;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.log.UserLoginLog;
import com.xjw.entity.po.user.User;
import com.xjw.utility.BizException;

@Service
public interface UserLoginLogService extends BaseServcie<UserLoginLog>{
  public void saveUserLoginLog(User user, String ip, Integer netWorkType) throws BizException;
  
  public List<UserLoginLog> getGroupData(Map<String, Object> params) throws BizException;
}
