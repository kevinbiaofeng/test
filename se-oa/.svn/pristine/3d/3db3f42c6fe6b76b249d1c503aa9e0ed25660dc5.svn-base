package com.xjw.entity.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xjw.kzenum.sys.StatusEnum;


public class BaseForm implements Serializable{
  private static final long serialVersionUID = 1L;
  private String keywords;
  private Integer pageNo;
  private Integer pageSize = 15;
  private List<Integer> statusList;

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public List<Integer> getStatusList() {
    statusList = new ArrayList<Integer>();
    statusList.add(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    return statusList;
  }

  public void setStatusList(List<Integer> statusList) {
    this.statusList = statusList;
  }

  
  
  
}
