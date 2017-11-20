package com.xl.base;

import com.xl.util.Print;
import org.junit.Test;

import java.util.UUID;

public class UUIDTest {
    @Test
    public void demoTest() {
        UUID u = UUID.randomUUID();
        Print.println(u.toString().length());
        Print.println(u);
    }
}
