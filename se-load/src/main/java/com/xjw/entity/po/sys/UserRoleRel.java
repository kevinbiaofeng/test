package com.xjw.entity.po.sys;

import com.xjw.base.entity.BasePo;

public class UserRoleRel extends BasePo {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Long userId;
  private Long roleId;
  private String name;

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

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
