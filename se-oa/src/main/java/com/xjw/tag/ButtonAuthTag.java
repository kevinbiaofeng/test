package com.xjw.tag;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.xjw.util.SessionManager;

public class ButtonAuthTag extends AbstractTag {
  private static final long serialVersionUID = 1L;
  private String code;
  private boolean isHave = true;	//是否具备权限

  public int doStartTag() throws JspException {
	  try{
		  Map<String, Object> map = SessionManager.getAuthSession(((HttpServletRequest)pageContext.getRequest()));
		  if(map != null){
			  Object obj = map.get(code);
			  if((obj != null && isHave == true) || (obj == null && isHave == false)){
				  return EVAL_BODY_INCLUDE;
			  }else{
				  return SKIP_BODY;
			  }
		  }else{
			  return SKIP_BODY;
		  }
		  
	  }catch (Exception e) {
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

  public boolean getIsHave() {
	return isHave;
  }

  public void setIsHave(boolean isHave) {
	this.isHave = isHave;
  }
}
