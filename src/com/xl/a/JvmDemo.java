package com.xl.a;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.�鿴JVM
 * User: ����
 * Date: 2017-10-09
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class JvmDemo {
    private final static Logger LOGGER = Logger.getLogger(JvmDemo.class);

    @Test
    public void jvmTest() {
        LOGGER.info(Runtime.getRuntime().maxMemory()); //�������ڴ棬��Ӧ-Xmx
        LOGGER.info(Runtime.getRuntime().freeMemory());//��ǰJVM�����ڴ�
        LOGGER.info(Runtime.getRuntime().totalMemory());  //��ǰJVMռ�õ��ڴ���������ֵ�൱�ڵ�ǰJVM��ʹ�õ��ڴ漰freeMemory()���ܺ�
    }
}

