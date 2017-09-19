package com.xl.a;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    @Test
    public void test() {
        Date d = new Date();
        System.out.println(d.getMonth());
        System.out.println(d.getDay());
    }
}
