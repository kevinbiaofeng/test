package com.xjw.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class TextareaFormatTag extends AbstractTag {
    private String textarea;

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public int doStartTag() throws JspException {
        if (StringUtils.isBlank(textarea)) {
            return super.doStartTag();
        } else {
            try {
                pageContext.getOut().write(textarea);
            } catch (IOException e) {
                throw new JspException(e);
            }
        }

        return super.doStartTag();
    }

}
