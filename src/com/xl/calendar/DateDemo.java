package com.xl.calendar;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    @Test
    public void test() {
        Date d = new Date();
        Date d2=d;
        System.out.println(d.getMonth());
        System.out.println(d.getDay());
        System.out.println(d2.compareTo(d));//相等就输出
        // 0
    }
}
