package com.xuan.xutils.concurrent.forkjoin.listtask;

import com.xuan.xutils.concurrent.forkjoin.listtask.executor.CyclicBarrierExecutorImpl;
import com.xuan.xutils.concurrent.forkjoin.listtask.executor.ListTaskExecutor;
import com.xuan.xutils.concurrent.forkjoin.listtask.executor.ListTaskExecutorImpl;

/**
 * ����ִ����������,��ÿ���ʹ��Spring��ʽ����Bean������ֻ���ṩ��API��ʽ
 * <p>
 * Created by xuan on 17/8/23.
 */
public abstract class ListTaskExecutorFactory {
    /**
     * ��ȡListTaskִ����
     *
     * @return
     */
    public static <T, R> ListTaskExecutor<T, R> getExecutor() {
        return new ListTaskExecutorImpl<>(10);
    }

    /**
     * ��ȡListTaskִ����
     *
     * @return
     */
    public static <T, R> ListTaskExecutor<T, R> getCyclicBarrierExecutor() {
        return new CyclicBarrierExecutorImpl<>();
    }
}
