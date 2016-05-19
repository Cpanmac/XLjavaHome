package com.xl.IO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class 打印流PrinterWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(System.out); //可以写入到控制台
        // PrintWriter out = new PrintWriter(System.out,true);
        // //如果写true,下面就可以不写flush, 有ln标记就自动刷新
        // PrintWriter out = new PrintWriter(new FileWriter("a.txt")); //刷新针对流的
        PrintWriter out = new PrintWriter(new FileWriter("a.txt"), true); // 不写刷新ln就是刷新
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line))
                break;
            out.write(line.toUpperCase());
            out.println();
            // out.flush();
        }
        out.close();
        bufr.close();
    }
}
