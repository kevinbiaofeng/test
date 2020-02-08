package com.xjw.controller.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.sys.MenuForm;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.User;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.sys.FunctionService;
import com.xjw.utility.StringUtil;

@Controller
@RequestMapping("/sysmenu/")
public class MenuController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(MenuController.class.getName());
  
  private static final String addPage = "/sysmenu/skipAdd";
  private static final String editPage = "/sysmenu/skipModify";
  private static final String listPage = "/sysmenu/list";
  
  @Resource
  private FunctionService functionService;
  
  @RequestMapping("/validateCode")
  @ResponseBody
  public String validateCode(HttpServletResponse response, MenuForm menuForm) throws IOException{
	  if(StringUtils.isBlank(menuForm.getCode())){
		  return Boolean.FALSE.toString();
	  }
	  
	  Function function = functionService.getFunctionByCode(menuForm.getCode());
	  if(function != null){
		  //新增菜单code重复   或 修改菜单code
		  if(StringUtils.isBlank(menuForm.getId()) || !function.getId().toString().equals(menuForm.getId()))
			  return Boolean.FALSE.toString();
	  }
	  
	  return Boolean.TRUE.toString();
  }
  
  @RequestMapping("/skipAdd")
  public String skipAdd(MenuForm menuForm, Model model){
    if(StringUtil.isNotBlank(menuForm.getId())){
      Function menu = functionService.selectById(Long.valueOf(menuForm.getId()));
      model.addAttribute("menu", menu);
    }
    return "menu/add";
  }
  
  @RequestMapping("/skipModify")
  public String skipModify(MenuForm menuForm, Model model){
    Function menu = functionService.selectById(Long.valueOf(menuForm.getId()));
    model.addAttribute("menu", menu);
    return "menu/modify";
  }
  
  @RequestMapping("/save")
  public void save(Function menu, Model model, HttpServletResponse response){
      try {
        menu.setStatus(Integer.valueOf(StatusEnum.DEFAULT.getCode()));
    	  
        functionService.save(menu);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", menu.getParentId());
        this.writerSuccessJSONDataById("新增成功", addPage, null, listPage, params);
      } catch (Exception e) {
        writerJSONData("failure", "新增失败", null, listPage);
        logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
      }
  }
  
  @SuppressWarnings("unchecked")
  @RequestMapping("/del")
  public String del(MenuForm menuForm){
    try {
      functionService.delete(StringUtil.getListFromStr(menuForm.getIds()));
    } catch (Exception e){
      logger.error(e.getMessage(), e);
    }
    return "redirect:/sysmenu/list";
  }
  
  @RequestMapping("/modify")
  public void modify(Function function, Model model, HttpServletResponse response){
      Map <String, Object> param = new HashMap<String, Object>();
      param.put("id", function.getId());
      try {
        functionService.updateFunctionAndLevel(function);
        this.writerSuccessJSONDataById("编辑成功", null, editPage, listPage, param);
      } catch (Exception e) {
        writerJSONData("failure", "编辑失败", null, listPage, param);
        logger.error(e.getMessage(), e);
		  logger.error("---fill---:" + e.fillInStackTrace());
		  logger.error("---msg---:"+ e.getMessage());
		  logger.error("---e---:" + e.toString());
      }
  }
  
  @RequestMapping("/list")
  public String list(Model model){
	User user = super.getCurrentUser();
	List<Function> list = functionService.getNormalFunctionList(user.getId());
    model.addAttribute("list", list);
    return "menu/list";
  }
  
  @RequestMapping("/getFunctionByCode")
  public void getFunctionByCode(MenuForm menuForm, HttpServletResponse response){
    Map <String, Object> param = new HashMap<String, Object>();
    param.put("code", menuForm.getCode());
    Function function = functionService.selectOne(param);
    try {
      if(function != null){
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(function);
        this.printWriter(jsonObj.toString());
      }else{
        this.printWriter("{id:0}");
      }
    } catch (IOException e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
	  logger.error("---fill---:" + e.fillInStackTrace());
	  logger.error("---msg---:"+ e.getMessage());
	  logger.error("---e---:" + e.toString());
    }
  }
}
