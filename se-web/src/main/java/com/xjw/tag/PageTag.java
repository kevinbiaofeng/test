package com.xjw.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import com.xjw.entity.Page;

@SuppressWarnings("serial")
public class PageTag<T> extends AbstractTag {
	private Page<T> page;
	private String formId;
	private String isAjax;
	private String url;

	public int doStartTag() throws JspException {
		String hrefafter = "/\"";
		StringBuffer buf = new StringBuffer();
		
		//location.href='http://www.example.com'
		String hrefbefor = "location.href=\""+url;

		if ("1".equals(this.isAjax)) {
			hrefbefor = "javascript:ajaxCommonPageFormSubmit(\"";
		}
		
		StringBuilder ulDom = new StringBuilder();
		for (int i = 1; i <= getPage().getTotalPages(); i++) {
			if(getPage().getPageNo() == i){
				ulDom.append("<li").append(" class='set-page'").append("'>").append(i).append("</li>");
			}else{
				ulDom.append("<li").append(" onclick='").append(hrefbefor).append("/").append(i).append(hrefafter).append("'>").append(i).append("</li>");
			}
		}
		
		
		buf.append("<div class='paging'>").append("<ul>");
		buf.append("<li class='set-btn'")
				.append(getPage().isHasPre() ? "" : " disabled='disabled'");
		if (getPage().isHasPre()) {
			buf.append(" onclick='").append(hrefbefor).append("/1").append(hrefafter)
					.append("'>首頁</li> ");
		} else {
			buf.append(">首頁</li> ");
		}

		buf.append("<li class='set-btn'").append(getPage().isHasPre() ? "" : " disabled='disabled'");
		if (getPage().isHasPre()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getPrePage())
					.append(hrefafter).append("'>上一頁</li>");
		} else {
			buf.append(">上一頁</li>");
		}

//		buf.append(ulDom);
		
		buf.append("<li class='set-btn'")
				.append(getPage().isHasNext() ? "" : " disabled='disabled'");
		if (getPage().isHasNext()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getNextPage())
					.append(hrefafter).append("'>下一頁</li>");
		} else {
			buf.append(">下一頁</li>");
		}

		buf.append("<li class='set-btn'")
				.append(getPage().isHasNext() ? "" : " disabled='disabled'");
		if (getPage().isHasNext()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getTotalPages())
					.append(hrefafter).append("'>尾頁</li>");
		} else {
			buf.append(">尾頁</li>");
		}

//		buf.append("<p class='total-count'>").append(getPage().getTotalCount()).append("個視頻</p>");
//		buf.append("<li class='text'>").append("共 ").append(getPage().getTotalPages()).append(" 頁</li>");
		buf.append("</ul>");
		
		
		
		buf.append("</div>");
		try {
			pageContext.getOut().write(buf.toString());
		} catch (IOException e) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
