package com.xjw.entity.po.notice;

import java.util.Date;

import com.xjw.base.entity.BasePo;

public class NoticeUserRel extends BasePo {
  private static final long serialVersionUID = 1L;

  private Long noticeId;

  private Long userId;

  private Integer isRead;
  
  private Integer status;
  
  private Date readTime;
  
  private String functionCode;
  
  public Long getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Long noticeId) {
    this.noticeId = noticeId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getIsRead() {
    return isRead;
  }

  public void setIsRead(Integer isRead) {
    this.isRead = isRead;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getReadTime() {
    return readTime;
  }

  public void setReadTime(Date readTime) {
    this.readTime = readTime;
  }

  public String getFunctionCode() {
    return functionCode;
  }

  public void setFunctionCode(String functionCode) {
    this.functionCode = functionCode;
  }
  
}
