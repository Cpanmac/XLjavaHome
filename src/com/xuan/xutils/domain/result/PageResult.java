package com.xuan.xutils.domain.result;

/**
 * ���з�ҳ����ķ��ؽ������
 * <p>
 * Created by xuan on 17/8/2.
 */
public class PageResult extends Result {
    private static final long serialVersionUID = 1L;
    /**
     * ��ҳ����
     */
    private Page page;

    /**
     * ���ط�ҳ����
     *
     * @param result
     * @param page
     * @return
     */
    public static PageResult obtainPage(Object result, Page page) {
        PageResult pageResult = new PageResult();
        pageResult.setCode(CodeEnum.SUCCESS.getCode());
        pageResult.setMessage("�ɹ�");
        pageResult.setResult(result);
        pageResult.setPage(page);
        return pageResult;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
