package com.xjw.entity.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.xjw.utility.NodeIDComparator;

@SuppressWarnings("all")
class Children {
  
  private List list = new ArrayList();

  public int getSize() {
    return list.size();
  }

  public void addChild(Node node) {
    list.add(node);
  }

  public String toString() {
    String result = "[";
    for (Iterator it = list.iterator(); it.hasNext();) {
      result += ((Node) it.next()).toString();
      result += ",";
    }
    result = result.substring(0, result.length() - 1);
    result += "]";
    return result;
  }

  public void sortChildren() {
    Collections.sort(list, new NodeIDComparator());
    for (Iterator it = list.iterator(); it.hasNext();) {
      ((Node) it.next()).sortChildren();
    }
  }
}