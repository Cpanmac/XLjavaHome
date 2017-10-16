package com.xuan.xutils.concurrent.forkjoin.listtask.core;

/**
 * ִ��ListTask�쳣
 * <p>
 * Created by xuan on 17/8/29.
 */
public class ListTaskException extends Throwable {
    private static final long serialVersionUID = 1;
    /**
     * ��ʵ�׳����쳣�������û��Բ����쳣���д���
     */
    private Throwable realException;

    public ListTaskException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.realException = cause;
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

    public Throwable getRealException() {
        return realException;
    }

    public void setRealException(Throwable realException) {
        this.realException = realException;
    }
}
