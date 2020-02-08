package com.xjw.utility;

import java.util.Comparator;

import com.xjw.entity.vo.Node;
public class NodeIDComparator implements Comparator<Object> {
  // 按照节点编号比较
  public int compare(Object o1, Object o2) {
    long j1 = Long.valueOf(((Node) o1).id);
    long j2 = Long.valueOf(((Node) o2).id);
    return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
  }
}
