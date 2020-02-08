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
		Integer liWidth = 60;
		Long wrapLength = 0L;
		wrapLength = getPage().getTotalPages() > 5 ? 5 * liWidth : getPage().getTotalPages() * liWidth;
		String leftSize = null;
		if (getPage().getTotalPages() >= 5) {
			leftSize = "35%";
		} else {
			leftSize = "38%";
		}
		
		//location.href='http://www.example.com'
		String hrefbefor = "location.href=\""+url;

		if ("1".equals(this.isAjax)) {
			hrefbefor = "javascript:ajaxCommonPageFormSubmit(\"";
		}
		
		StringBuilder ulDom = new StringBuilder();
		for (int i = 1; i <= getPage().getTotalPages(); i++) {
			if(getPage().getPageNo() == i){
				ulDom.append("<li").append(" class='sel-page'").append(" onclick='").append(hrefbefor).append("/").append(i).append(hrefafter).append("'>").append(i).append("</li>");
			}else{
				ulDom.append("<li").append(" onclick='").append(hrefbefor).append("/").append(i).append(hrefafter).append("'>").append(i).append("</li>");
			}
		}
		

		buf.append("<div style='padding-top:70px;padding-left: ").append(leftSize).append(";text-align: center;'>")
				.append("<div class='box' id='box'>");

		buf.append("<button type='button'")
				.append(getPage().isHasPre() ? "" : " disabled='disabled' class='turnPage first-page'");
		if (getPage().isHasPre()) {
			buf.append(" onclick='").append(hrefbefor).append("/1").append(hrefafter)
					.append("'>首頁</button> ");
		} else {
			buf.append(">首頁</button> ");
		}

		buf.append("<button type='button'").append(getPage().isHasPre() ? "" : " disabled='disabled' class='turnPage'");
		if (getPage().isHasPre()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getPrePage())
					.append(hrefafter).append("'>上一頁</button>");
		} else {
			buf.append(">上一頁</button>");
		}

		buf.append("<div class='pageWrap' style='width:").append(wrapLength).append("px'>")
				.append("<ul id='pageSelect' style='transition:all 600ms'> ").append(ulDom).append("</ul></div>");

		buf.append("<button type='button'")
				.append(getPage().isHasNext() ? "" : " disabled='disabled' class='turnPage'");
		if (getPage().isHasNext()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getNextPage())
					.append(hrefafter).append("'>下一頁</button>");
		} else {
			buf.append(">下一頁</button>");
		}

		buf.append("  <li class='bui-bar-item-button bui-bar-item bui-pb-last bui-inline-block'>")
				.append("<button type='button'")
				.append(getPage().isHasNext() ? "" : " disabled='disabled' class='bui-button-disabled'");
		if (getPage().isHasNext()) {
			buf.append(" onclick='").append(hrefbefor).append("/").append(getPage().getTotalPages())
					.append(hrefafter).append("'>尾頁</button>");
		} else {
			buf.append(">尾頁</button>");
		}

		buf.append("<p class='total-pages'>").append("共").append(getPage().getTotalPages()).append("頁</p>");

//		buf.append("<p class='total-count'>").append(getPage().getTotalCount()).append("個視頻</p>");

		buf.append("</ul>").append("</div></div>");
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
