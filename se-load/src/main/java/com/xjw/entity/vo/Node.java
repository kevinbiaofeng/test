package com.xjw.entity.vo;

public class Node {
  public Long id;
  public String text;
  public Long parentId;
  private Children children = new Children();

  public String toString() {
    String result = "{" + "id : " + id + "" + ", text : '" + text + "'";

    if (children != null && children.getSize() != 0) {
      result += ", children : " + children.toString();
    } 
//    else {
//      result += ", leaf : true";
//    }

    return result + "}";
  }

  public void sortChildren() {
    if (children != null && children.getSize() != 0) {
      children.sortChildren();
    }
  }

  public void addChild(Node node) {
    this.children.addChild(node);
  }
}
