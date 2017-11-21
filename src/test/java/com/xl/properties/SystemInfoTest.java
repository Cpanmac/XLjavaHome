package com.xl.properties;

import com.xl.util.Print;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfoTest {
    private Properties pro = System.getProperties(); // 系

    @Test
    public void demoTest() throws FileNotFoundException {
        Print.info(pro);
        //在项目目录下生成
        pro.list(new PrintStream("生成一个txt.txt"));
    }
}
