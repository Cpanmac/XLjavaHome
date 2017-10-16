package com.xuan.xutils.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * �Զ���һ���̳߳�
 * <p>
 * Created by xuan on 17/8/14.
 */
public interface XThreadPool extends Executor {
    /**
     * �ύ����
     *
     * @param task
     * @return
     */
    Future<?> submit(Runnable task);

    /**
     * �ύ����
     *
     * @param task
     * @param <T>
     * @return
     */
    <T> Future<T> submit(Callable<T> task);
}
