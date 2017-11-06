package com.xl.a;

import com.xl.annotation.Igore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/13
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 */
@Igore
public class XLDemo {
    public void say() {
        System.out.println("说话");
    }
    @Test
    public void demoTest() {
        XLDemo xlDemo = new XLDemo();
        xlDemo.say();
    }
}
