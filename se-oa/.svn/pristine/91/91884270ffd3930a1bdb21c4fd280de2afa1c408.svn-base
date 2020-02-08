package com.xjw.service.sys;

import java.util.List;
import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserLoginLog;
import com.xjw.utility.BizException;

public interface UserLoginLogService extends BaseServcie<UserLoginLog> {

	public void saveUserLoginLog(User user, String ip, Integer netWorkType) throws BizException;

	public List<UserLoginLog> getGroupData(Map<String, Object> params) throws BizException;

	public List<UserLoginLog> getByIp3(Map<String, Object> params);

	public List<String> getIpList(Map<String, Object> params);
}
