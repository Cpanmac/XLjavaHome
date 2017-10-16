package com.xl.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// ������Ŀ�ӿ�
interface Subject {
    String say(String name, int age);
}

/**
 * @author ����
 * @Decription �����Ҫ��ɶ�̬����������Ҫ����һ��InvocationHandler�ӿڵ����࣬����ɴ���ľ��������
 * @date 2014-1-19
 */
public class ProxyDemo {
    /**
     * ��ʵ��java������������������� 1��Bootstrap ClassLoader �˼���������c++��д��һ�㿪���к��ټ���
     * 2��Extension ClassLoader ����������չ��ļ��أ�һ���Ӧ����jre\lib\extĿ¼�е���
     * 3��AppClassLoader ����classpathָ�����࣬����õļ�������ͬʱҲ��java��Ĭ�ϵļ�������
     */
    @Test
    public void classLoad() {
        Person p = new Person();
        System.out.println("classLoad  " + p.getClass().getClassLoader().getClass().getName());
    }

    @Test
    public void test() {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
        System.out.println(info);
    }
}

// ������ʵ��Ŀ
class RealSubject implements Subject {
    @Override
    public String say(String name, int age) {
        return name + "  " + age;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj = null;

    public Object bind(Object obj) {
        this.obj = obj;
        System.out.println("bind");
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke");
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
// �����������
// ��һ����������֮����һ������Ҫ��ʼʹ���࣬���Ҫʹ��һ���࣬�϶��벻��JVM���ڳ���ִ����JVMͨ��װ�أ����ӣ���ʼ����3��������ɡ�
// ���װ����ͨ�����������ɵģ���������.class�ļ��Ķ������ļ�װ��JVM�ķ������������ڶ�����������������java.lang.Class����������װ���ݡ�
// ����ͬһ����ֻ�ᱻ��װ����װ����ǰ
// ���Ӿ��ǰѶ�����������װΪ�������е�״̬��
//
// ���ӷ�ΪУ�飬׼����������3���׶�
// У��һ������ȷ�ϴ˶������ļ��Ƿ��ʺϵ�ǰ��JVM���汾����
// ׼������Ϊ��̬��Ա�����ڴ�ռ䣬��������Ĭ��ֵ
// ����ָ����ת���������еĴ�����Ϊֱ�����õĹ��̣�ֱ�����еķ������ö����Ա����г���ʹ�ã����������Ķ�Ӧ��ϵ��
// ���֮������Ҳ������˳�ʼ������ʼ��֮����Ķ���Ϳ�������ʹ���ˣ�ֱ��һ��������ʹ��֮�󣬽����������ա��ͷſռ䡣
// ��û���κ�����ָ��Class����ʱ�ͻᱻж�أ����������������
