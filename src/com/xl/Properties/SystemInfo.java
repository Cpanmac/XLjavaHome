package com.xl.Properties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {
    public static void main(String[] args) throws FileNotFoundException {
        Properties pro = System.getProperties(); // ϵͳ��Ϣ
        System.out.println(pro); // ��ӡ������һ��
        // ���д�ӡ
        test1(pro);
        // ��������
        test2(pro);
    }

    private static void test2(Properties pro) throws FileNotFoundException {
        pro.list(new PrintStream("sysinfo.txt"));
    }

    private static void test1(Properties pro) {
        pro.list(System.out);
    }
}
