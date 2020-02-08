package com.xjw.controller.sys;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.sys.Areas;
import com.xjw.service.sys.AreasService;

@Controller
@RequestMapping("/areas/")
public class AreasController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(AreasController.class.getName());

  @Resource
  private AreasService areasService;
  
  @RequestMapping(value = "/getAreasByCode", method = RequestMethod.GET)
  public void getAreasByCode(String parentCode, HttpServletResponse response){
    List<Areas> list = areasService.getAreasListByParentCode(parentCode);
    JSONArray jsonArray = new JSONArray();
    for(Areas area : list) {
    	jsonArray.add(JSONObject.toJSON(area));
    }
    
    try {
      this.write(String.valueOf(jsonArray), response);
    } catch (IOException e) {
    	logger.error(e.getMessage(), e);
    }
  }
}
