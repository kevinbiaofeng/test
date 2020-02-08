package com.xjw.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.xjw.utility.StringUtil;

public class SubStringTag extends AbstractTag {
	private static final long serialVersionUID = 7149484249634262850L;

	private String input;

	private Integer size;

	private String replace;

	private String type;

	public int doStartTag() throws JspException {
		try {
			if(StringUtil.isNotBlank(type) && StringUtil.isNotBlank(input)){
				if ("phone".equals(type) && input.length() > 7){
					pageContext.getOut().write(input.substring(0, 7) + replace);
				}else if("qq".equals(type) && input.length() > 4){
					pageContext.getOut().write(input.substring(0, 4) + replace);
				}else if("email".equals(type) && input.length() > 4){
					if(input.indexOf("@") > 4){
						input = input.substring(0, 4) + replace+ input.substring(input.indexOf("@"), input.length());
			        }if(input.indexOf("@") == -1){
			        	
			        }else{
			        	input = input.substring(0, input.indexOf("@")) + replace + input.substring(input.indexOf("@"), input.length());
			        }
					pageContext.getOut().write(input);
				}else{
					
				}
			}else if(StringUtil.isNotBlank(input)){
				if (input.length() <= size) {
					pageContext.getOut().write(input);
				} else {
					pageContext.getOut().write(input.substring(0, size) + replace);
				}
			}else{
				pageContext.getOut().write(input);
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
		return super.doStartTag();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getReplace() {
		return replace;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
