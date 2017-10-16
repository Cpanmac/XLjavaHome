package com.xuan.xutils.concurrent.forkjoin.listtask.core;

import com.xuan.xutils.concurrent.forkjoin.listtask.callback.ListTaskCallable;
import com.xuan.xutils.concurrent.forkjoin.listtask.config.ListTaskConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * ������Ĵ��룬���������Ҫ��������
 * ��һ�����ԭ�����㹻�࣬�ͻ���������֣���ֵ�ԭ�����㹻С��������
 * �ڶ������ԭ�����㹻�٣������û�������߼��ص��õ��������
 * <p>
 * Created by xuan on 17/8/23.
 */
public class ListTask<T, R> extends RecursiveTask<ListTaskResult<R>> {
    private static final long serialVersionUID = 1;
    /**
     * ���ò���
     */
    private ListTaskConfig config;
    /**
     * ������Ҫ�����ԭʼ����
     */
    private List<T> originList;
    /**
     * �û��߼��ص�
     */
    private ListTaskCallable<T, R> callable;

    /**
     * ���캯��
     *
     * @param originList ԭ����
     * @param callable   �߼�����ص�
     * @param config     ���ò���
     */
    public ListTask(List<T> originList, ListTaskCallable<T, R> callable, ListTaskConfig config) {
        if (null == originList || originList.size() == 0) {
            throw new RuntimeException("[ListTask-ListTask] originList is empty.");
        }
        if (null == callable) {
            throw new RuntimeException("[ListTask-ListTask] callable is null.");
        }
        if (null == config) {
            throw new RuntimeException("[ListTask-ListTask] config is null.");
        }
        this.originList = originList;
        this.callable = callable;
        this.config = config;
    }

    @Override
    protected ListTaskResult<R> compute() {
        if (originList.size() <= config.getSubOriginListSize()) {
            //���ԭ�����㹻�٣���С�����ò���ָ���ĵ��������ԭ��������ʱ�������û���ҵ���߼��ص�ִ�У��õ����
            List<R> resultList = callable.call(originList);
            ListTaskResult<R> result = new ListTaskResult<R>();
            result.setList(resultList);
            return result;
        } else {
            //���ԭ�����㹻�࣬��ô��Ҫ���������֣��������ã���ֳɶ��������
            //���磺ԭ����=20�����û������������ԭ��������subOriginListSize=3
            //��ô����������3��3��3��3��3��3��2һ��7��������
            List<ListTask<T, R>> taskList = new ArrayList<>();
            int subTaskSize = originList.size() / config.getSubOriginListSize();
            if (originList.size() % config.getSubOriginListSize() > 0) {
                //δ��������������Ҫ�����ټ�һ��
                subTaskSize += 1;
            }
            for (int i = 0; i < subTaskSize; i++) {
                int start = i * config.getSubOriginListSize();
                int end = i * config.getSubOriginListSize() + config.getSubOriginListSize();
                if (end > originList.size()) {
                    //���һ������δ�ظպ���subOriginListSize������������endֵ���е���
                    end = originList.size();
                }
                List<T> subList = originList.subList(start, end);
                ListTask<T, R> subTask = new ListTask<>(subList, callable, config);
                subTask.fork();
                taskList.add(subTask);
            }
            //�ϲ�����ִ�н��
            ListTaskResult<R> result = new ListTaskResult<>();
            for (ListTask<T, R> task : taskList) {
                result.mergeFrom(task.join());
            }
            return result;
        }
    }
}
