package com.xjw.tag;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.utility.SpringContextHolder;

public class SelectTagByDB extends AbstractTag
{
  private static final Logger logger = LoggerFactory.getLogger(SelectTagByDB.class.getName());
  private static final long serialVersionUID = 1L;
  private static final String NBSP = "&nbsp;";
  private static final String SPLIT = ",";
  private static final String DEFAULT_SELECT = "--请选择--";
  private String type;
  private String code;
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
      FinalResourcesIndexService finalResourcesIndexService = SpringContextHolder.getBean(FinalResourcesIndexService.class);
      List<FinalResourcesValues> list = finalResourcesIndexService.getFinalResourcesValuesByCode(code);
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
          ret.append("<option value='' ").append(StringUtils.isNotBlank(this.value)?"":"selected='selected'").append(">").append(DEFAULT_SELECT).append("</option>");
        }
        
        if(list != null && list.size() > 0)
          buildSelect4List(ret, excludeArray, list);
        
        ret.append("</select>");
      }
      else if ("checkbox".equals(this.type))
      {
        if(list != null && list.size() > 0)
          buildCheckBox4List(ret, list);
      }
      else if ("radio".equals(this.type))
      {
        String[] excludeArray = null;
        if ((this.exclude != null) && (this.exclude.length() > 0))
        {
          excludeArray = this.exclude.split(SPLIT);
        }
//        if (Class.forName(this.clazz).isEnum())
//        {
//          if ((excludeArray != null) && (excludeArray.length > 0))
//            buildRadio4Enum(ret, excludeArray);
//          else {
//            buildRadio4Enum(ret);
//          }
//
//        }
//        else if ((excludeArray != null) && (excludeArray.length > 0))
//          buildRadio4EnumBean(ret, excludeArray);
//        else {
//          buildRadio4EnumBean(ret);
//        }
      }
      logger.debug(ret.toString());
      this.pageContext.getOut().print(ret.toString());
    }
    catch (Exception e)
    {
      logger.error(e.getMessage(), e);
      e.printStackTrace();
    }

    return 0;
  }

  public void buildSelect4List(StringBuffer ret, String[] excludeArray, List<FinalResourcesValues> list){
    for (FinalResourcesValues entity : list) {
      if (excludeArray != null)
      {
        boolean flag = false;
        for (String word : excludeArray)
        {
          if (!entity.getVal().equals(word))
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
        selected = entity.getVal().equals(this.value) ? " selected='selected' " : "";
      }
      ret.append("<option value='").append(entity.getVal()).append("' ").append(selected).append(">").append(entity.getName()).append("</option>");
    }
  }
  
  private void buildCheckBox4List(StringBuffer ret, List<FinalResourcesValues> list) throws IllegalAccessException, ClassNotFoundException
  {
    for (FinalResourcesValues entity : list) {
      String checked = "";
      if ((this.value != null) && (this.value.length() > 0))
      {
        if (this.value.indexOf(SPLIT) != -1)
        {
          if ((this.value + SPLIT).indexOf(entity.getVal() + SPLIT) != -1)
          {
            checked = "checked";
          }
  
        }
        else if (entity.getVal().equals(this.value))
        {
          checked = "checked";
        }
      }
  
      ret.append("<input type='checkbox' name='").append(this.name).append("' ");
      ret.append(" value='").append(entity.getVal()).append("' ");
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
      ret.append(checked).append("/>").append(NBSP).append(entity.getName()).append(NBSP);
    }
  }
  
  public String getName()
  {
    return this.name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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