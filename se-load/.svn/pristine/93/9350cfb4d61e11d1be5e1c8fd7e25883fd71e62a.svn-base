package com.xjw.tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.xjw.kzenum.AbstractEnum;
import com.xjw.utility.EnumUtil;

public class SelectTag extends AbstractTag
{
  private static final long serialVersionUID = 1L;
  private static final String NBSP = "&nbsp;";
  private static final String SPLIT = ",";
  private static final String DEFAULT_SELECT = "--请选择--";
  private String type;
  private String clazz;
  private String name;
  private String value;
  private String myClass;
  private String onChange;
  private String onClick;
  private String id;
  private String isDefaultSelect = "true";
  private String valitext;
  private String exclude;

  public String getOnChange()
  {
    return this.onChange;
  }

  public void setOnChange(String onChange)
  {
    this.onChange = onChange;
  }

  public int doStartTag() throws JspException
  {
    try
    {
      StringBuffer ret = new StringBuffer();
      if ("select".equals(this.type))
      {
        ret.append("<select type='select' name='").append(this.name).append("' ");
        if (StringUtils.isNotBlank(this.valitext))
        {
          ret.append(" valitext='").append(this.valitext).append("' ");
        }
        if (StringUtils.isNotBlank(this.id))
        {
          ret.append(" id='").append(this.id).append("' ");
        }
        if ((this.myClass != null) && (this.myClass.length() > 0))
        {
          ret.append(" class='").append(this.myClass).append("'");
        }
        if ((this.onChange != null) && (this.onChange.length() > 0))
        {
          ret.append(" onchange='").append(this.onChange).append("'");
        }
        if ((this.onClick != null) && (this.onClick.length() > 0))
        {
          ret.append(" onclick='").append(this.onClick).append("'");
        }
        String[] excludeArray = null;
        if ((this.exclude != null) && (this.exclude.length() > 0))
        {
          excludeArray = this.exclude.split(SPLIT);
        }
        ret.append(" >");
        if ("true".equals(this.isDefaultSelect))
        {
          ret.append("<option value=''>").append(DEFAULT_SELECT).append("</option>");
        }

        if (Class.forName(this.clazz).isEnum())
        {
          buildSelect4Enum(ret, excludeArray);
        }
        else
        {
          buildSelect4EnumBean(ret, excludeArray);
        }
        ret.append("</select>");
      }
      else if ("checkbox".equals(this.type))
      {
        if (Class.forName(this.clazz).isEnum())
        {
          buildCheckBox4Enum(ret);
        }
        else
        {
          buildCheckBox4EnumBean(ret);
        }
      }
      else if ("radio".equals(this.type))
      {
        String[] excludeArray = null;
        if ((this.exclude != null) && (this.exclude.length() > 0))
        {
          excludeArray = this.exclude.split(SPLIT);
        }
        if (Class.forName(this.clazz).isEnum())
        {
          if ((excludeArray != null) && (excludeArray.length > 0))
            buildRadio4Enum(ret, excludeArray);
          else {
            buildRadio4Enum(ret);
          }

        }
        else if ((excludeArray != null) && (excludeArray.length > 0))
          buildRadio4EnumBean(ret, excludeArray);
        else {
          buildRadio4EnumBean(ret);
        }

      }

      this.pageContext.getOut().print(ret.toString());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IllegalArgumentException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }

    return 0;
  }

  private void buildRadio4EnumBean(StringBuffer ret) throws ClassNotFoundException, IllegalAccessException
  {
    Field[] fs = Class.forName(this.clazz).getDeclaredFields();
    for (Field f : fs)
    {
      if (!f.getType().equals(AbstractEnum.EnumBean.class))
        continue;
      AbstractEnum.EnumBean obj = (AbstractEnum.EnumBean)f.get(f.getName());
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        checked = obj.getCode().equals(this.value) ? "checked" : "";
      }
      ret.append("<input type='radio' name='").append(this.name).append("' ");
      ret.append(" value='").append(obj.getCode()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append(obj.getName()).append("</lable>").append(NBSP);
    }
  }

  private void buildRadio4EnumBean(StringBuffer ret, String[] excludeArray)
    throws ClassNotFoundException, IllegalAccessException
  {
    Field[] fs = Class.forName(this.clazz).getDeclaredFields();
    for (Field f : fs)
    {
      if (!f.getType().equals(AbstractEnum.EnumBean.class))
        continue;
      AbstractEnum.EnumBean obj = (AbstractEnum.EnumBean)f.get(f.getName());

      boolean excludeFlag = false;
      for (String excludeCode : excludeArray) {
        if (excludeCode.equals(String.valueOf(obj.getCode()))) {
          excludeFlag = true;
          break;
        }
      }
      if (excludeFlag)
      {
        continue;
      }
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        checked = obj.getCode().equals(this.value) ? "checked" : "";
      }
      ret.append("<input type='radio' name='").append(this.name).append("' ");
      ret.append(" value='").append(obj.getCode()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append(obj.getName()).append("</lable>").append(NBSP);
    }
  }

  private void buildRadio4Enum(StringBuffer ret)
    throws IllegalAccessException, ClassNotFoundException
  {
    LinkedHashMap map = EnumUtil.enumToMap(Class.forName(this.clazz));
    Iterator iterator=map.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, String> entity= (Entry<String, String>) iterator.next();
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        checked = ((String)entity.getKey()).equals(this.value) ? "checked" : "";
      }
      ret.append("<input type='radio' name='").append(this.name).append("' ");
      ret.append(" value='").append((String)entity.getValue()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append((String)entity.getValue()).append("</lable>").append(NBSP);
    }
  }

  private void buildRadio4Enum(StringBuffer ret, String[] excludeArray) throws IllegalAccessException, ClassNotFoundException
  {
    LinkedHashMap map = EnumUtil.enumToMap(Class.forName(this.clazz));
    Iterator iterator=map.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, String> entity= (Entry<String, String>) iterator.next();
      boolean excludeFlag = false;
      for (String excludeCode : excludeArray) {
        if (excludeCode.equals(String.valueOf(entity.getKey()))) {
          excludeFlag = true;
          break;
        }
      }
      if (excludeFlag)
      {
        continue;
      }
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        checked = ((String)entity.getKey()).equals(this.value) ? "checked" : "";
      }
      ret.append("<input type='radio' name='").append(this.name).append("' ");
      ret.append(" value='").append((String)entity.getValue()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append((String)entity.getValue()).append("</lable>").append(NBSP);
    }
  }

  private void buildCheckBox4EnumBean(StringBuffer ret) throws ClassNotFoundException, IllegalAccessException
  {
    Field[] fs = Class.forName(this.clazz).getDeclaredFields();
    for (Field f : fs)
    {
      if (!f.getType().equals(AbstractEnum.EnumBean.class))
        continue;
      AbstractEnum.EnumBean obj = (AbstractEnum.EnumBean)f.get(f.getName());
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        if (this.value.indexOf(SPLIT) != -1)
        {
          if ((this.value + SPLIT).indexOf(obj.getCode() + SPLIT) != -1)
          {
            checked = "checked";
          }

        }
        else if (obj.getCode().equals(this.value))
        {
          checked = "checked";
        }
      }

      ret.append("<input type='checkbox' name='").append(this.name).append("' ");
      ret.append(" value='").append(obj.getCode()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append(obj.getName()).append("</lable>").append("&nbsp;");
    }
  }

  private void buildCheckBox4Enum(StringBuffer ret)
    throws IllegalAccessException, ClassNotFoundException
  {
    LinkedHashMap map = EnumUtil.enumToMap(Class.forName(this.clazz));
    Iterator iterator=map.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, String> entity= (Entry<String, String>) iterator.next();
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        if (this.value.indexOf(SPLIT) != -1)
        {
          if ((this.value + SPLIT).indexOf((String)entity.getKey() + SPLIT) != -1)
          {
            checked = "checked";
          }

        }
        else if (((String)entity.getKey()).equals(this.value))
        {
          checked = "checked";
        }
      }

      ret.append("<input type='checkbox' name='").append(this.name).append("' ");
      ret.append(" value='").append((String)entity.getKey()).append("' ");
      if ((this.myClass != null) && (this.myClass.length() > 0))
      {
        ret.append(" class='").append(this.myClass).append("'");
      }
      if (StringUtils.isNotBlank(this.id))
      {
        ret.append(" id='").append(this.id).append("' ");
      }
      if ((this.onChange != null) && (this.onChange.length() > 0))
      {
        ret.append(" onchange='").append(this.onChange).append("'");
      }
      if ((this.onClick != null) && (this.onClick.length() > 0))
      {
        ret.append(" onclick='").append(this.onClick).append("'");
      }
      ret.append(checked).append("/>").append(NBSP).append("<lable>").append((String)entity.getValue()).append("</lable>").append(NBSP);
    }
  }

  private void buildSelect4EnumBean(StringBuffer ret, String[] excludeArray) throws ClassNotFoundException, IllegalAccessException
  {
    Field[] fs = Class.forName(this.clazz).getDeclaredFields();
    for (Field f : fs)
    {
      if (!f.getType().equals(AbstractEnum.EnumBean.class))
        continue;
      AbstractEnum.EnumBean obj = (AbstractEnum.EnumBean)f.get(f.getName());
      if (excludeArray != null)
      {
        boolean flag = false;
        for (String word : excludeArray)
        {
          if (!obj.getCode().equals(word))
            continue;
          flag = true;
          break;
        }

        if (flag)
        {
          continue;
        }
      }

      String selected = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        selected = obj.getCode().equals(this.value) ? " selected='selected' " : "";
      }
      ret.append("<option value='").append(obj.getCode()).append("' ").append(selected).append(">").append(obj.getName()).append("</option>");
    }
  }

  private void buildSelect4Enum(StringBuffer ret, String[] excludeArray)
    throws IllegalAccessException, ClassNotFoundException
  {
    LinkedHashMap map = EnumUtil.enumToMap(Class.forName(this.clazz));
    Iterator iterator=map.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, String> entity= (Entry<String, String>) iterator.next();
      if (excludeArray != null)
      {
        boolean flag = false;
        for (String word : excludeArray)
        {
          if (!((String)entity.getKey()).equals(word))
            continue;
          flag = true;
          break;
        }

        if (flag)
        {
          continue;
        }
      }

      String selected = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        selected = ((String)entity.getKey()).equals(this.value) ? " selected='selected' " : "";
      }
      ret.append("<option value='").append((String)entity.getKey()).append("' ").append(selected).append(">").append((String)entity.getValue()).append("</option>");
    }
  }

  public int doEndTag()
    throws JspException
  {
    return 6;
  }

  public String getClazz()
  {
    return this.clazz;
  }

  public void setClazz(String clazz)
  {
    this.clazz = clazz;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getType()
  {
    return this.type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getMyClass()
  {
    return this.myClass;
  }

  public void setMyClass(String myClass)
  {
    this.myClass = myClass;
  }

  public String getOnClick()
  {
    return this.onClick;
  }

  public void setOnClick(String onClick)
  {
    this.onClick = onClick;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getIsDefaultSelect()
  {
    return this.isDefaultSelect;
  }

  public void setIsDefaultSelect(String isDefaultSelect)
  {
    this.isDefaultSelect = isDefaultSelect;
  }

  public String getValitext()
  {
    return this.valitext;
  }

  public void setValitext(String valitext)
  {
    this.valitext = valitext;
  }

  public String getExclude()
  {
    return this.exclude;
  }

  public void setExclude(String exclude)
  {
    this.exclude = exclude;
  }
}