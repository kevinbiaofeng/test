package com.xjw.tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.xjw.kzenum.AbstractEnum.EnumBean;
import com.xjw.utility.BaseEnumUtil;

public class EnumTag extends AbstractTag {
  private static final long serialVersionUID = 1L;

  private static final String SPLIT = ",";
  private static final String BLANK = " ";

  private String clazz;
  private String code;

  public int doStartTag() throws JspException {
    
    try {
      StringBuffer ret = new StringBuffer();
      if (Class.forName(clazz).isEnum()) {
        LinkedHashMap<String, String> map = BaseEnumUtil.enumToMap(Class.forName(clazz));
        for (Map.Entry<String, String> obj : map.entrySet()) {
          if (StringUtils.isNotEmpty(code)) {
            if (code.indexOf(SPLIT) != -1) {
              if ((code + SPLIT).indexOf(obj.getKey() + SPLIT) != -1) {
                ret.append(obj.getValue()).append(BLANK);
              }
            } else {
              if (obj.getKey().equals(code)) {
                ret.append(obj.getValue());
                break;
              }
            }
          }
        }
      } else {
        Field[] fs = Class.forName(clazz).getDeclaredFields();
        for (Field f : fs) {
          if (f.getType().equals(EnumBean.class)) {
            EnumBean obj = (EnumBean) f.get(f.getName());

            if (StringUtils.isNotEmpty(code)) {
              if (code.indexOf(SPLIT) != -1) {
                if ((code + SPLIT).indexOf(obj.getCode() + SPLIT) != -1) {
                  ret.append(obj.getName()).append(BLANK);
                }
              } else {
                if (obj.getCode().equals(code)) {
                  ret.append(obj.getName());
                  break;
                }
              }
            }

          }
        }

      }
      if (code.indexOf(SPLIT) != -1 && ret.indexOf(BLANK) != -1) {
        ret.deleteCharAt(ret.length() - 1);
      }
      pageContext.getOut().print(ret.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return SKIP_BODY;
  }

  public int doEndTag() throws JspException {
    return EVAL_PAGE;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
