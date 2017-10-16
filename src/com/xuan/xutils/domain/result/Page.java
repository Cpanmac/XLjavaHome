package com.xuan.xutils.domain.result;

import com.xuan.xutils.domain.BaseDO;

/**
 * ��ҳ����
 * <p>
 * Created by xuan on 17/8/2.
 */
public class Page extends BaseDO {
    private static final long serialVersionUID = 1L;
    /**
     * ��ǰҳ
     */
    private int page;
    /**
     * ��һҳ
     */
    private int nextPage;
    /**
     * ÿҳ����
     */
    private int pageSize;
    /**
     * �ܼ�¼��
     */
    private int totalCount;
    /**
     * ��ҳ��
     */
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
