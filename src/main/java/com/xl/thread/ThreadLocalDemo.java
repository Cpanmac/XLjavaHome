package com.xl.thread;

import com.xl.util.Print;

import java.util.Random;

/**
 * @author 徐立
 * @Decription 实现线程类共享数据
 * @date 2014年3月7日
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    Print.info(Thread.currentThread().getName() + " has put data :" + data);
                    x.set(data);
                    /*
                     * MyThreadScopeData myData = new MyThreadScopeData();
					 * myData.setName("name" + data); myData.setAge(data);
					 * myThreadScopeData.set(myData);
					 */
                    MyThreadScopeData.getThreadInstance().setName("name" + data);
                    MyThreadScopeData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            int data = x.get();
            Print.info("A from " + Thread.currentThread().getName() + " get data :" + data);
            /*
             * MyThreadScopeData myData = myThreadScopeData.get();;
			 * Print.print("A from " + thread.currentThread().getName() +
			 * " getMyData: " + myData.getName() + "," + myData.getAge());
			 */
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            Print.info("A from " + Thread.currentThread().getName() + " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

    static class B {
        public void get() {
            int data = x.get();
            Print.info("B from " + Thread.currentThread().getName() + " get data :" + data);
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            Print.info("B from " + Thread.currentThread().getName() + " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }
}

class MyThreadScopeData {
    // private static MyThreadScopeData instance = null;//new
    // MyThreadScopeData();
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
    private String name;
    private int age;

    private MyThreadScopeData() {
    }

    public static/* synchronized */MyThreadScopeData getThreadInstance() {
        MyThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
