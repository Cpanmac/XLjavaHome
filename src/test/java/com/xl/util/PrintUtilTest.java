package com.xl.util;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

@Log4j
public class PrintUtilTest {
    @Test
    public void print() throws Exception {
        PrintUtil.print("测试");
    }
}