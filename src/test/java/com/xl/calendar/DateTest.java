package com.xl.calendar;

import com.xl.util.Print;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class DateTest {
    @Test
    public void test() {
        Date d = new Date();
        Date d2 = d;
        Print.println(d.getMonth());
        Print.println(d.getDay());
        Print.println(d2.compareTo(d));//相等就输出
    }
}
