package com.xl.base;

import org.junit.Test;

import java.util.UUID;

public class UUIDDemo {
    @Test
    public void test1() {
        UUID u = UUID.randomUUID();
        System.out.println(u.toString().length());
        System.out.println(u);
    }
}
