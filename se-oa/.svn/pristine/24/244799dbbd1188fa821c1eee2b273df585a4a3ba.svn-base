package com.xjw.service.notice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.notice.NoticeDao;
import com.xjw.entity.po.notice.Notice;
import com.xjw.entity.po.notice.NoticeTemplate;
import com.xjw.entity.po.notice.NoticeUserRel;
import com.xjw.entity.po.sys.User;
import com.xjw.kzenum.notice.NoticeStatusEnum;
import com.xjw.kzenum.notice.NoticeTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.notice.NoticeTemplateService;
import com.xjw.service.notice.NoticeUserRelService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {
  @Resource
  private NoticeDao noticeDao;
  @Resource
  private NoticeTemplateService noticeTemplateService;
  @Resource
  private NoticeUserRelService noticeUserRelService;
  
  public void saveSendNotice(Map<String, Object> param, List<User> userList, String code) throws BizException{
    Map <String, Object> params = new HashMap<String, Object>();
    params.put("code", code);
    NoticeTemplate noticeTemplate = noticeTemplateService.selectOne(params);
    if(noticeTemplate != null){
      Notice notice = new Notice();
      notice.setTitle(noticeTemplate.getTitle());
      notice.setContext(StringUtil.replaceContextByMap(noticeTemplate.getContext(), param));
      notice.setType(Integer.valueOf(NoticeTypeEnum.SYS.getCode()));
      notice = this.save(notice);
      
      if(userList != null && userList.size() > 0 && notice != null){
        List<NoticeUserRel> noticeUserRellist = new ArrayList<NoticeUserRel>();
        NoticeUserRel noticeUserRel = null;
        for (User user : userList) {
          noticeUserRel = new NoticeUserRel();
          noticeUserRel.setUserId(user.getId());
          noticeUserRel.setIsRead(Integer.valueOf(YesORNoEnum.NO.getCode()));
          noticeUserRel.setNoticeId(notice.getId());
          noticeUserRel.setStatus(Integer.valueOf(NoticeStatusEnum.DEFAULT.getCode()));
          noticeUserRel.setFunctionCode(code);
          noticeUserRellist.add(noticeUserRel);
        }
        noticeUserRelService.saveRecordBatch(noticeUserRellist);
      }
    }
  }
  
  public Long selectUserNoticeCount(Long userId){
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("isRead", YesORNoEnum.NO.getCode());
    param.put("statusList", StringUtil.getListFromStr(NoticeStatusEnum.DEFAULT.getCode()));
    param.put("userId", userId);
    return noticeUserRelService.selectAllCount(param);
  }
  
  public void delete(String ids) throws BizException{
    noticeUserRelService.delete(StringUtil.getListFromStr(ids));
  }
  
  @Override
  public Class<Notice> getClazz() {
    return Notice.class;
  }

  @Override
  public BaseDaoImpl<Notice> baseDao() {
    return noticeDao;
  }
}
