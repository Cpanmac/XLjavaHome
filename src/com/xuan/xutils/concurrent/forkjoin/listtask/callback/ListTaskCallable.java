package com.xuan.xutils.concurrent.forkjoin.listtask.callback;

import java.util.List;

/**
 * ������߼��ص������ܿ�ܻ��Զ������ֳɺܶ������񣬵��Ǿ�����Ҫִ�е��߼��������û��Լ�ʵ�֡�
 * <p>
 * Created by xuan on 17/8/23.
 */
public interface ListTaskCallable<T, R> {
    /**
     * �ص����������Ҫ��������ݣ������Ǵ���������
     *
     * @param tList
     * @return
     */
    List<R> call(List<T> tList);
}
