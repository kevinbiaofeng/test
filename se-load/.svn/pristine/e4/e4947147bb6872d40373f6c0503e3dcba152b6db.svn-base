package com.xjw.service.notice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.notice.NoticeUserRelDao;
import com.xjw.entity.po.notice.NoticeUserRel;
import com.xjw.service.notice.NoticeUserRelService;

@Service
public class NoticeUserRelServiceImpl extends BaseServiceImpl<NoticeUserRel> implements NoticeUserRelService, BaseServcie<NoticeUserRel> {
  @Resource
  private NoticeUserRelDao noticeUserRelDao;

  @Override
  public Class<NoticeUserRel> getClazz() {
    return NoticeUserRel.class;
  }

  @Override
  public BaseDaoImpl<NoticeUserRel> baseDao() {
    return noticeUserRelDao;
  }
}
