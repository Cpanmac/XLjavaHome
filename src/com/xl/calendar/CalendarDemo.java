package com.xl.calendar;

import org.junit.Test;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: ÐìÁ¢
 * Date: 2017/9/19
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class CalendarDemo {
    /**
     * monthÊÇ-1µÄ
     */
    @Test
    public void calendarTest() {
        Calendar c = Calendar.getInstance();
        System.out.println("YEAR:"+c.get(Calendar.YEAR));
        System.out.println("MONTH:"+c.get(Calendar.MONTH));
        System.out.println("DAY_OF_YEAR:"+c.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_MONTH:"+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY:"+c.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE:"+c.get(Calendar.MINUTE));
        System.out.println("MILLISECOND:"+c.get(Calendar.MILLISECOND));
    }
}
