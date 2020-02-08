package com.xjw.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import com.xjw.entity.Page;

@SuppressWarnings("serial")
public class PageTag<T> extends AbstractTag
{
  private Page<T> page;
  private String formId;
  private String isAjax;
  
  public int doStartTag() throws JspException
  {
    StringBuffer buf = new StringBuffer();
    
    
    String hrefbefor = "javascript:commonPageFormSubmit(\"";
    
    if("1".equals(this.isAjax)){
      hrefbefor = "javascript:ajaxCommonPageFormSubmit(\"";
    }
    
    String hrefafter = ");";
    String liafter = "</li>";
    
    buf.append("<ul class='bui-pagingbar bui-bar'>");
    buf.append("<li class='bui-bar-item-button bui-bar-item bui-pb-first bui-inline-block'>")
    .append("<button type='button'").append(getPage().isHasPre() ? "" : " disabled='disabled' class='bui-button-disabled'");
    if(getPage().isHasPre()){
      buf.append(" onclick='").append(hrefbefor).append(formId).append("\",").append(1).append(hrefafter).append("'> 首 页 </button> ").append(liafter);
    }else{
      buf.append("> 首 页 </button> ").append(liafter);
    }
   
    
    buf.append("  <li class='bui-bar-item-button bui-bar-item bui-pb-prev bui-inline-block'>")
    .append("<button type='button'").append(getPage().isHasPre() ? "" : " disabled='disabled' class='bui-button-disabled'");
    if(getPage().isHasPre()){
      buf.append(" onclick='").append(hrefbefor).append(formId).append("\",").append(getPage().getPrePage()).append(hrefafter).append("'> 上一页 </button>").append(liafter);
    }else{
      buf.append("> 上一页 </button>").append(liafter);
    }
    
    
    buf.append("  <li class='bui-bar-item-separator bui-bar-item bui-inline-block'></li>");
    
    buf.append("  <li class='bui-bar-item-text bui-bar-item bui-inline-block'>").append(" 共 ").append(getPage().getTotalPages()).append(" 页 ").append(liafter);
    
    buf.append("  <li class='bui-bar-item-text bui-bar-item bui-inline-block'>")
    .append(" 第 <input type='text' name='pageNo' id='pageNo' value='").append(getPage().getPageNo()).append("' size='20' class='bui-pb-page'/> 页").append(liafter);
    
    
    buf.append("  <li class='bui-bar-item-button bui-bar-item bui-pb-skip bui-inline-block'>");
    
    if(getPage().getTotalPages() > 1){
      if("1".equals(this.isAjax)){
        buf.append("<button type='button'")
        .append(" onclick='").append(hrefbefor).append(formId).append("\",").append(0).append(hrefafter)
        .append("'>确定</button>").append(liafter);
      }else{
        buf.append("<button type='submit'>确定</button>").append(liafter);
      }
    }else{
      buf.append("<button class='bui-button-disabled' type='submit' disabled='disabled'>确定</button>").append(liafter);
    }
    
    buf.append("  <li class='bui-bar-item-separator bui-bar-item bui-inline-block'></li>");
    
    buf.append("  <li class='bui-bar-item-button bui-bar-item bui-pb-next bui-inline-block'>")
    .append("<button type='button'").append(getPage().isHasNext() ? "" : " disabled='disabled' class='bui-button-disabled'");
    if(getPage().isHasNext()){
      buf.append(" onclick='").append(hrefbefor).append(formId).append("\",").append(getPage().getNextPage()).append(hrefafter).append("'>下一页</button>").append(liafter);
    }else{
      buf.append(">下一页</button>").append(liafter);
    }
    
    buf.append("  <li class='bui-bar-item-button bui-bar-item bui-pb-last bui-inline-block'>")
    .append("<button type='button'").append(getPage().isHasNext() ? "" : " disabled='disabled' class='bui-button-disabled'");
    if(getPage().isHasNext()){
      buf.append(" onclick='").append(hrefbefor).append(formId).append("\",").append(getPage().getTotalPages()).append(hrefafter).append("'>末  页</button>").append(liafter);
    }else{
      buf.append(">末 页</button>").append(liafter);
    }
    
    buf.append("  <li class='bui-bar-item-separator bui-bar-item bui-inline-block' ></li>");
    
    buf.append("  <li class='bui-bar-item-text bui-bar-item bui-inline-block'>共 ")
    .append(getPage().getTotalCount()).append(" 条记录").append(liafter);
    
    buf.append("</ul>");
    try{
        pageContext.getOut().write(buf.toString());
    }catch(IOException e){
        throw new JspException(e);
    }
    
    return super.doStartTag();
  }

  public Page<T> getPage() {
    return page;
  }

  public void setPage(Page<T> page) {
    this.page = page;
  }

  public String getFormId() {
    return formId;
  }

  public void setFormId(String formId) {
    this.formId = formId;
  }

  public String getIsAjax() {
    return isAjax;
  }

  public void setIsAjax(String isAjax) {
    this.isAjax = isAjax;
  }
  
  
}
