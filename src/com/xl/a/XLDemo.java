package com.xl.a;

import com.xl.entity.Student;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017/10/13
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 */
public class XLDemo {
    @Test
    public void demoTest() {
        System.out.println(new Student("1", 2));
        System.out.println(new Student("1", "1", 1, "2"));
    }
}
