package com.xjw.tag;

import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjw.entity.po.sys.Areas;
import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.service.sys.AreasService;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.utility.SpringContextHolder;

public class NameByValTag extends AbstractTag {
  private static final Logger logger = LoggerFactory.getLogger(NameByValTag.class.getName());
  private static final long serialVersionUID = 1L;
  private String type;
  private String code;
  private String value;

  public int doStartTag() throws JspException {
    try {
      String name = "";
      if ("AREA".equals(this.type)) {
        AreasService areasService = SpringContextHolder.getBean(AreasService.class);
        Areas areas = areasService.getAreasListByCode(value);
        if(areas != null)
          name = areas.getName();
      } else if ("FINAL".equals(this.type)) {
    	  if(!"".equals(value)){
    		  FinalResourcesIndexService finalResourcesIndexService = SpringContextHolder.getBean(FinalResourcesIndexService.class);
    	        FinalResourcesValues finalResourcesValues = finalResourcesIndexService.getByCodeAndVal(code, value);
    	        if(finalResourcesValues != null)
    	          name = finalResourcesValues.getName();
    	  }
      }
      
      this.pageContext.getOut().print(name);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      e.printStackTrace();
    }

    return 0;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}