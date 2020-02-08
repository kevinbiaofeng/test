package com.xjw.common.result;

import com.xjw.entity.Page;

public class PageResult<T> extends BaseResult {
    private static final long serialVersionUID = 5285947700781530990L;

    private Page<T> page;

    public PageResult() {
        this(null);
    }

    public PageResult(Page<T> page) {
        super();
        this.page = page;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
