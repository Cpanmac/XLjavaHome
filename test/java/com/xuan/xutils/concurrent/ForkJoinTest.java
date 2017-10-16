package com.xuan.xutils.concurrent;

import com.xuan.xutils.concurrent.forkjoin.listtask.ListTaskExecutorFactory;
import com.xuan.xutils.concurrent.forkjoin.listtask.callback.SingleSizeListTaskCallable;
import com.xuan.xutils.concurrent.forkjoin.listtask.core.ListTaskException;
import com.xuan.xutils.concurrent.forkjoin.listtask.executor.ListTaskExecutor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������������һ���������ַ����б�����Ҫ����Щ�ַ�������"_deal".
 * <p>
 * Created by xuan on 17/8/24.
 */
public class ForkJoinTest {
    ListTaskExecutor executor = ListTaskExecutorFactory.getExecutor();

    @Test
    public void testListTask() throws Throwable {
        run1();
        run2();
        run3();
    }

    /**
     * ����
     *
     * @return
     */
    private void run1() {
        List<String> list = initList();
        //
        long start = System.currentTimeMillis();
        List<String> resultList = new ArrayList<String>();
        for (String str : list) {
            resultList.add(doThing(str));
        }
        //
        System.out.println("++++++++++run1-time:" + (System.currentTimeMillis() - start));
        System.out.println("++++++++++run1-result:" + resultList);
    }

    /**
     * ����
     *
     * @return
     */
    private void run2() throws ListTaskException {
        List<String> list = initList();
        //
        long start = System.currentTimeMillis();
        List<String> resultList = executor.execute(list, new SingleSizeListTaskCallable<String, String>() {
            @Override
            protected String call(String s) {
                return doThing(s);
            }
        });
        //
        System.out.println("++++++++++run2-time:" + (System.currentTimeMillis() - start));
        System.out.println("++++++++++run2-result:" + resultList);
    }

    /**
     * �̳߳�
     */
    private void run3() throws ListTaskException {
        List<String> list = initList();
        //
        long start = System.currentTimeMillis();
        ListTaskExecutor<String, String> executor = ListTaskExecutorFactory.getCyclicBarrierExecutor();
        List<String> resultList = executor.execute(list, new SingleSizeListTaskCallable<String, String>() {
            @Override
            protected String call(String s) {
                return doThing(s);
            }
        });
        //
        System.out.println("++++++++++run3-time:" + (System.currentTimeMillis() - start));
        System.out.println("++++++++++run3-result:" + resultList);
    }

    /**
     * ��ʼ��ԭʼ����
     *
     * @return
     */
    private List<String> initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    /**
     * ʵ��һ��С����Ҫ��������
     *
     * @param str
     * @return
     */
    private String doThing(String str) {
        sleep();
        return str + "_deal";
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
