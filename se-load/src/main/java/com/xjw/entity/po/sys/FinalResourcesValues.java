package com.xjw.entity.po.sys;

import com.xjw.base.entity.BasePo;

public class FinalResourcesValues extends BasePo {
  private static final long serialVersionUID = 1L;
  private String name;
  private String code;
  private String val;
  private Long finalResourcesIndexId;
  private Integer sort;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  public Long getFinalResourcesIndexId() {
    return finalResourcesIndexId;
  }

  public void setFinalResourcesIndexId(Long finalResourcesIndexId) {
    this.finalResourcesIndexId = finalResourcesIndexId;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }
}
