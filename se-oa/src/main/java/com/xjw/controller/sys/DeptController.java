package com.xjw.controller.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.sys.DeptForm;
import com.xjw.entity.po.sys.Dept;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.DeptService;
import com.xjw.util.TreeUtil;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/sysdept/")
public class DeptController extends BaseController{
  private static final Logger logger = LoggerFactory.getLogger(DeptController.class.getName());
  
  private static final String addPage = "/sysdept/skipAdd";
  private static final String editPage = "/sysdept/skipModify";
  private static final String listPage = "/sysmenu/list";
  
  @Resource
  private DeptService deptService;
  
  
  @RequestMapping("/validateCode")
  public void validateCode(HttpServletResponse response, DeptForm deptForm) throws IOException{
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("code", deptForm.getCode());
    params.put("statusList", StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode().toString()));
    List<Dept> list = deptService.selectAll(params);
    if(list != null && list.size() > 0){
      if(StringUtils.isNotBlank(deptForm.getId())){
        if(list.get(0).getId().toString().equals(deptForm.getId())){
          response.getWriter().print(true);
        }else{
          response.getWriter().print(false);
        }
      }else{
        response.getWriter().print(false);
      }
    }else{
      response.getWriter().print(true);
    }
  }
  
  @RequestMapping("/index")
  public String index(Model model){
    return "public/dept/index";
  }
  
  @RequestMapping("/tree")
  public String tree(Model model){
    try{
      List<Dept> list = deptService.getNormalList();
      model.addAttribute("list", list);
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "public/dept/tree";
  }
  
  @RequestMapping("/skipModify")
  public String skipModify(DeptForm deptForm, Model model){
	String id = deptForm.getId();
    try{
      if(StringUtil.isNotBlank(id)){
        if(!"0".equals(id)){
          Dept dept = deptService.selectById(Long.valueOf(deptForm.getId()));
          model.addAttribute("dept", dept);
        }
        model.addAttribute("id", deptForm.getId());
      }
      model.addAttribute("deptCodes", deptService.getDeptCodesAll());
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "public/dept/modify";
  }
  
  
  @RequestMapping("/skipAdd")
  public String skipAdd(DeptForm deptForm, Model model, HttpServletRequest request){
    try{
      model.addAttribute("parentId", deptForm.getId());
      model.addAttribute("name", deptForm.getName());
      model.addAttribute("deptCodes", deptService.getDeptCodesAll());
    }catch(Exception e){
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "public/dept/add";
  }
  
  @RequestMapping("/save")
  public void save(Dept dept, Model model, HttpServletResponse response){
      try {
        deptService.save(dept);
        Map <String, Object> param = new HashMap<String, Object>();
        param.put("id", dept.getParentId());
        this.writerSuccessJSONDataById("新增成功", addPage, null, null, null);
      } catch (Exception e) {
        writerJSONData("failure", "新增失败", null, null);
        logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
      }
  }
  
  @RequestMapping("/modify")
  public void modify(Dept dept, Model model, HttpServletResponse response){
    try {
      deptService.update(dept);
      Map <String, Object> param = new HashMap<String, Object>();
      param.put("id", dept.getId());
      this.writerSuccessJSONDataById("编辑成功", null, editPage, null, param);
    } catch (Exception e) {
      writerJSONData("failure", "编辑失败", null, null);
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }
  
  @SuppressWarnings("unchecked")
  @RequestMapping("/del")
  public String del(DeptForm deptForm){
    try {
      List<Map<String, Object>> list = deptService.getMapNormalList();
      String ids =  TreeUtil.getIdsByListAndId(Long.valueOf(deptForm.getId()), list);
      deptService.delete(StringUtil.getListFromStr(ids));
      this.writerSuccessJSONDataById("删除成功", null, null, null, null);
    } catch (Exception e){
      writerJSONData("failure", "删除失败", null, null);
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
    return "redirect:" + listPage;
  }
  
  
  @ResponseBody
  @RequestMapping(value = "/getTree", method = RequestMethod.GET)
  public JSONArray getTree(Model model){
    List<Map<String, Object>> list = deptService.getMapNormalList();
    Map<String, Object> firstNode = new HashMap<String, Object>();
    firstNode.put("id", "0");
    firstNode.put("name", "现金网");
    firstNode.put("parentId", "");
    list.add(firstNode);
    
    return JSONArray.parseArray(TreeUtil.getTreeJsonByListAndId(list));
  }
}
