package com.xjw.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjw.entity.po.sys.Function;
import com.xjw.entity.vo.Node;

public class TreeUtil {
  private static final Logger logger = LoggerFactory.getLogger(TreeUtil.class.getName());
  public static List<Function> getMainMenu(List<Function> menuList){
    List <Function> firstMenu = null;
    if(menuList != null && menuList.size() > 0){
      firstMenu = new ArrayList<Function>();
      for (Function menu : menuList) {
        if(menu.getParentId() == 0L){
          firstMenu.add(menu);
          menuList.remove(menu);
        }
      }
    }
    return firstMenu;
  }
  
  public static String treeList2Json(String basePath, List<Function> menuList){
    StringBuffer buf = new StringBuffer();
    buf.append("[");
    for (Function main : menuList) {
      if(main.getParentId() == 0L){
        buf.append("{")
        .append("'id': '" + main.getId() + "',");
//        for (Function firstMenu : menuList) {
//          if(main.getId() == firstMenu.getParentId()){
//            for (Function secondMenu : menuList) {
//              if(secondMenu.getParentId() == firstMenu.getId()){
//                buf.append("'homePage': '"+secondMenu.getId()+"',");
//                break;
//              }
//            }
//            break;
//          }
//        }
        buf.append("'homePage': '',");
        buf.append("'menu': [");
        for (Function firstMenu : menuList) {
          if(main.getId().longValue() == firstMenu.getParentId().longValue()){
            buf.append("{")
            .append("'text': '" + firstMenu.getName() + "','items':[");
            for (Function secondMenu : menuList) {
              if(secondMenu.getParentId().longValue() == firstMenu.getId().longValue()){
                buf.append("{")
                .append("'id': '" + secondMenu.getId() + "',")
                .append("'text': '" + secondMenu.getName() + "',")
                .append("'href': '" + basePath + secondMenu.getUrl())
                .append("'},");
              }
            }
            buf.append("]},");
          }
        }
        buf.append("]},");
      }
    }
    buf.append("]");
    return buf.toString();
  }
  
  public static String getIdsByListAndId(Long id, List<Map<String, Object>> list){
    List<Map<String, Object>> tempList = getTreeListById(id, list);
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < tempList.size(); i++) {
      buf.append(i > 0 ? ",": "").append(tempList.get(i).get("id"));
    }
    return buf.toString();
  }
  
  /**
   * 获取删除id集合
   * @param id
   * @param list
   * @return
   */
  public static List<Map<String, Object>> getTreeListById(Long id, List<Map<String, Object>> list){
    List <Map<String, Object>> newList = null;
    if(list != null && list.size() > 0){
      newList = new ArrayList<Map<String, Object>>();
      for (int i = 0; i < list.size(); i++) {
          if(id.longValue() == Long.valueOf(String.valueOf(list.get(i).get("id"))).longValue()){
            newList.add(list.get(i));
            break;
          }
      }
    }
    if(newList != null && newList.size() > 0){
      newList = TreeUtil.connectList(list, newList, new ArrayList<Map<String, Object>>());
    }
    return newList;
  }
  
  public static List<Map<String, Object>> connectList(List<Map<String, Object>> list, List<Map<String, Object>> newList, List<Map<String, Object>> tempList){
    if(newList != null && newList.size() == 1){
        for (Map<String, Object> lObj : list) {
           for (Map<String, Object> newObj : newList) {
              if(String.valueOf(lObj.get("parentId")).equals(String.valueOf(newObj.get("id")))){
                newList.add(lObj);
                tempList.add(lObj);
                break;
              }
           }
        }
        if(tempList != null && tempList.size() > 0){
          connectList(list, newList, tempList);
        }
        
    }else{
         List<Map<String, Object>> t = new ArrayList<Map<String,Object>>();;
         t.addAll(tempList);
         tempList.clear();
         for (Map<String, Object> tempObj : t) {
            for (Map<String, Object> lObj : list) {
               if(String.valueOf(lObj.get("parentId")).equals(String.valueOf(tempObj.get("id")))){
                 newList.add(lObj);
                 tempList.add(lObj);
                 break;
               }
            }
         }
         if(tempList!= null && tempList.size() > 0){
           connectList(list, newList, tempList);
         }else{
           return newList;
         }
    }
    return newList;
  }
  
  
  
  /**
   * 获取treeJson
   * @param id
   * @param list
   * @return
   */
  @SuppressWarnings("all")
  public static String getTreeJsonByListAndId(List<Map<String, Object>> dataList){
    HashMap nodeList = new HashMap();  
    Node root = null;  
    for (Iterator it = dataList.iterator(); it.hasNext();) {  
     Map dataRecord = (Map) it.next();  
     Node node = new Node();  
     node.id = Long.valueOf(dataRecord.get("id").toString()) ;  
     node.text = (String) dataRecord.get("name");  
     node.parentId = dataRecord.get("parentId") != ""? Long.valueOf(dataRecord.get("parentId").toString()): null;  
     nodeList.put(node.id, node);  
    }  
    Set entrySet = nodeList.entrySet();  
    for (Iterator it = entrySet.iterator(); it.hasNext();) {  
     Node node = (Node) ((Map.Entry) it.next()).getValue();  
     if (node.parentId == null || node.parentId.equals("")) {  
      root = node;  
     } else {  
      ((Node) nodeList.get(node.parentId)).addChild(node);  
     }  
    }
    root.sortChildren();
    return "[" + root.toString() + "]";
  }
  
}
