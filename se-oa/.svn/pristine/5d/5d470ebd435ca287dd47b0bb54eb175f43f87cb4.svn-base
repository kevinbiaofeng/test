package com.xjw.service.notice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.notice.Notice;
import com.xjw.entity.po.sys.User;
import com.xjw.utility.BizException;

@Service
public interface NoticeService extends BaseServcie<Notice>{
  public void saveSendNotice(Map<String, Object> param, List<User> userList, String code) throws BizException;
  
  public Long selectUserNoticeCount(Long userId);
  
  public void delete(String ids) throws BizException;
}
