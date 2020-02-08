package com.xjw.service.notice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.notice.NoticeTemplateDao;
import com.xjw.entity.po.notice.NoticeTemplate;
import com.xjw.service.notice.NoticeTemplateService;

@Service
public class NoticeTemplateServiceImpl extends BaseServiceImpl<NoticeTemplate> implements NoticeTemplateService, BaseServcie<NoticeTemplate> {
  @Resource
  private NoticeTemplateDao noticeTemplateDao;

  
  @Override
  public Class<NoticeTemplate> getClazz() {
    return NoticeTemplate.class;
  }

  @Override
  public BaseDaoImpl<NoticeTemplate> baseDao() {
    return noticeTemplateDao;
  }
}
