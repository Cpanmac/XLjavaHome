package com.xl.Properties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {
    public static void main(String[] args) throws FileNotFoundException {
        Properties pro = System.getProperties(); // 系统信息
        System.out.println(pro); // 打印出来在一行
        // 分行打印
        test1(pro);
        // 保存起来
        test2(pro);
    }

    private static void test2(Properties pro) throws FileNotFoundException {
        pro.list(new PrintStream("sysinfo.txt"));
    }

    private static void test1(Properties pro) {
        pro.list(System.out);
    }
}
