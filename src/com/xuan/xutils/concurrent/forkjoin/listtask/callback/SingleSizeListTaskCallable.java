package com.xuan.xutils.concurrent.forkjoin.listtask.callback;

import java.util.ArrayList;
import java.util.List;

/**
 * ����û�������㣬ֻ��Ҫ��ԭʼ���ݵ��������������Լ̳����ȥʵ�֡�
 * ���������ӵ�ж��ԭʼ������Ҫ���������forѭ�����д��д���
 * <p>
 * Created by xuan on 17/8/26.
 */
public abstract class SingleSizeListTaskCallable<T, R> extends AbstractListTaskCallable<T, R> {
    @Override
    public List<R> call(List<T> list) {
        List<R> rList = new ArrayList<>();
        for (T t : list) {
            rList.add(call(t));
        }
        return rList;
    }

    /**
     * ����ʵ�֣�������ԭʼ����
     *
     * @param t
     * @return
     */
    protected abstract R call(T t);
}
