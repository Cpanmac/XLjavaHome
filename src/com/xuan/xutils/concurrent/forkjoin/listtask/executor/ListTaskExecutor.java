package com.xuan.xutils.concurrent.forkjoin.listtask.executor;

import com.xuan.xutils.concurrent.forkjoin.listtask.callback.ListTaskCallable;
import com.xuan.xutils.concurrent.forkjoin.listtask.config.ListTaskConfig;
import com.xuan.xutils.concurrent.forkjoin.listtask.core.ListTaskException;
import com.xuan.xutils.concurrent.forkjoin.listtask.core.ListTaskResult;

import java.util.List;

/**
 * ���������л�ִ����
 * �û����һ��list��Ϊԭʼ���ݣ�������ԭʼ���ݵĴ����߼��ص�����ܻ�������ã���������ֽ⣬Ȼ����ִ�У����պϲ�������ظ��û�
 * <p>
 * Created by xuan on 17/8/23.
 */
public interface ListTaskExecutor<T, R> {
    /**
     * �߼���ҿ�ʹ�ø�API������һЩ�߼����ã�Ҳ�᷵��һЩ�������Ϣ
     *
     * @param orignList ��Ҫ���д����ԭʼ����List
     * @param callable  ���崦��ԭʼ���ݵĻص�
     * @param config    һЩ�������ò������߼��û�ʹ�ã�С���û�����ʹ�������ṩ�ı�ݷ���
     * @return
     * @throws ListTaskException �û���Ҫ�Լ������쳣
     */
    ListTaskResult<R> execute(List<T> orignList, ListTaskCallable<T, R> callable, ListTaskConfig config) throws ListTaskException;

    /**
     * С����ҿ�ʹ�ø�API��ֻ��Ҫԭʼ����List�ʹ���ص��Ϳ���
     *
     * @param orignList ��Ҫ���д����ԭʼ����List
     * @param callable  ���崦��ԭʼ���ݵĻص�
     * @return
     * @throws ListTaskException �û���Ҫ�Լ������쳣
     */
    List<R> execute(List<T> orignList, ListTaskCallable<T, R> callable) throws ListTaskException;

    /**
     * С����ҿ�ʹ�ø�API��ֻ��Ҫԭʼ����List�ʹ���ص��Ϳ��ԣ������Լ򵥵��趨���С��������ȣ�
     *
     * @param orignList         ��Ҫ���д����ԭʼ����List������ִ��
     * @param callable          ���崦��ԭʼ���ݵĻص�
     * @param subOriginListSize �趨���ٸ�ԭʼ����Ϊһ��������
     * @return
     * @throws ListTaskException �û���Ҫ�Լ������쳣
     */
    List<R> execute(List<T> orignList, ListTaskCallable<T, R> callable, int subOriginListSize) throws ListTaskException;
}
