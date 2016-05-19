package com.xl.Properties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class 系统信息 {
    public static void main(String[] args) throws FileNotFoundException {
        // 保存系统信息
        Properties prop = System.getProperties();
        prop.list(new PrintStream("sysinfo.txt"));
    }
}
