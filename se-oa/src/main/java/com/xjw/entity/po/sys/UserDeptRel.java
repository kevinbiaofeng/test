package com.xjw.entity.po.sys;

import com.xjw.base.entity.BasePo;

public class UserDeptRel extends BasePo {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Long userId;
  private Long deptId;
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

  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
