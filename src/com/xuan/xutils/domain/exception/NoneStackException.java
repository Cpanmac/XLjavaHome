package com.xuan.xutils.domain.exception;

/**
 * �ܶ�ʱ��������ҵ����ʹ���Զ����쳣��������������,����û�б�Ҫ�����ջ��Ϣ(���ջ��Ϣ�ǱȽ��������ܵ�)
 * ���ǿ��Ը�дfillInStackTrace������
 * <p>
 * Created by xuan on 17/8/7.
 */
public class NoneStackException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoneStackException() {
        super();
    }

    public NoneStackException(String message) {
        super(message);
    }

    public NoneStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneStackException(Throwable cause) {
        super(cause);
    }

    protected NoneStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * ��д����������Է�ֹ�����ջ��Ϣ
     *
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
