package com.xjw.entity.po.sys;

import com.xjw.base.entity.BasePo;

public class UserFunctionRel extends BasePo {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Long userId;
  private Long functionId;
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getFunctionId() {
    return functionId;
  }

  public void setFunctionId(Long functionId) {
    this.functionId = functionId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
