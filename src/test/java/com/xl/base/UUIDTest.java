package com.xl.base;

import com.xl.util.Print;
import org.junit.Test;

import java.util.UUID;

public class UUIDTest {
    @Test
    public void demoTest() {
        for (int i = 0; i < 1000; i++) {
            UUID u = UUID.randomUUID();
            //Print.info(u.toString().length());
            Print.info(u);
        }

    }
}
