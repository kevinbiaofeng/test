package com.xjw.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.utility.SpringContextHolder;
import com.xjw.utility.StringUtil;

public class DbTag extends AbstractTag {
  private static final long serialVersionUID = 1L;
  private String code;
  private String value;

  public int doStartTag() throws JspException {
    
    try {
      StringBuffer ret = new StringBuffer();
      if(StringUtil.isNotBlank(code)){
        FinalResourcesIndexService finalResourcesIndexService = SpringContextHolder.getBean(FinalResourcesIndexService.class);
        List<FinalResourcesValues> list = finalResourcesIndexService.getFinalResourcesValuesByCode(code);
        for (FinalResourcesValues obj : list) {
          if (StringUtils.isNotEmpty(value)) {
            if(obj.getVal().equals(this.value)){
              ret.append(obj.getName());
              break;
            }
          }
        }
      }
      pageContext.getOut().print(ret.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return SKIP_BODY;
  }

  public int doEndTag() throws JspException {
    return EVAL_PAGE;
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
