package com.xl.Properties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class ϵͳ��Ϣ {
    public static void main(String[] args) throws FileNotFoundException {
        // ����ϵͳ��Ϣ
        Properties prop = System.getProperties();
        prop.list(new PrintStream("sysinfo.txt"));
    }
}
