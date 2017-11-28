package com.xl.a;

import com.xl.util.Print;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * @Date: 2017-11-28
 * @Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
public class TimeTest {
    @Test
    public void timeTest() throws InterruptedException {
        long a = System.currentTimeMillis();
        Print.info(a);
        Thread.sleep(100);
        long b=  System.currentTimeMillis();
        Print.info(b);
    }
}
