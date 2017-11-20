package com.xl.calendar;

import com.xl.util.DateUtil;
import com.xl.util.Print;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/9/19
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class CalendarTest {
    /**
     * month是-1的
     */
    @Test
    public void calendarTest() {
        Calendar c = Calendar.getInstance();
        Print.println("YEAR:" + c.get(Calendar.YEAR));
        Print.println("MONTH:" + c.get(Calendar.MONTH));
        Print.println("DAY_OF_YEAR:" + c.get(Calendar.DAY_OF_YEAR));
        Print.println("DAY_OF_MONTH:" + c.get(Calendar.DAY_OF_MONTH));
        Print.println("HOUR_OF_DAY:" + c.get(Calendar.HOUR_OF_DAY));
        Print.println("MINUTE:" + c.get(Calendar.MINUTE));
        Print.println("MILLISECOND:" + c.get(Calendar.MILLISECOND));
        c.set(Calendar.DATE, 1);
        Print.println(DateUtil.formatDate(c.getTime()));
        c.set(Calendar.MONTH, 0);
        Print.println(DateUtil.formatDate(c.getTime()));
    }

    @Test
    public void compareTest() {
        Calendar tomorrow = Calendar.getInstance();//明天
        tomorrow.add(Calendar.DATE, 1);
        Calendar now = Calendar.getInstance();
        Print.println(tomorrow.compareTo(now));   //1
        Print.println(now.compareTo(now));   //0
    }

    @Test
    public void todateTest() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Print.println(DateUtil.formatTime(c.getTime()));
        Print.println(DateUtil.formatTime(c.getTime()));
    }
}
