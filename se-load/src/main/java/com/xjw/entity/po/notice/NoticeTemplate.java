package com.xjw.entity.po.notice;

import com.xjw.base.entity.BasePo;

public class NoticeTemplate extends BasePo {

  private static final long serialVersionUID = 1L;

  private String title;

  private String context;

  private String code;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
