package com.xl.properties;

import com.xl.util.FileTool;
import com.xl.util.Print;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfoTest {
    private Properties pro = System.getProperties(); // 系
    private File file;

    @Test
    public void demoTest() throws IOException {
        Print.info(pro);
        //在项目目录下生成
        file = FileTool.createResourceFile("生成一个txt.txt");
        pro.list(new PrintStream(file));
    }

    @After
    public void after() throws IOException {
        FileTool.open(file);
    }
}
