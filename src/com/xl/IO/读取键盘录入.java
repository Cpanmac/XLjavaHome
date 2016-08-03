package com.xl.IO;

/*
 读取键盘录入。
 System.out:对应的标准输出设备，控制台。
 System,in：对应标准的输入设备,键盘。
 */

import java.io.IOException;
import java.io.InputStream;

public class 读取键盘录入 // ReadIn
{
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        // int by = in.read(); //read方法是阻塞方法，等待键盘录入
        // int by1=in.read();
        // int by2=in.read();
        // System.out.println(by); //一次只读一个字节
        // System.out.println(by1);
        // System.out.println(by2);
        // System.out.println('\r'+0); //13
        // System.out.println('\n'+0); //10
        // 要想一直读取，一个一个字符的读取
        /*
         * int ch = 0; while ((ch = in.read()) != -1) { //
		 * 是不可能输入-1，-1,是两个字符，要想终止就用Ctrl+C结束 System.out.println(ch); }
		 * in.close();// 可以不用关。。
		 */
        // 想要over的时候停下来，把输入的数据一次性打印出来
        int ch;
        StringBuilder sb = new StringBuilder(); // 建立缓冲区
        /*
         * //没有使用readLine读取一行 while (true) { ch = in.read(); if (ch == '\r')
		 * continue; // 终止当前循环，进行下次循环 if (ch == '\n') // 当输入回车的时候 { String s =
		 * sb.toString(); // 降缓冲区的字符串转化为String // if (s.endsWith("over")) //
		 * 输入over结束我的代码 if ("over".equals(s)) break;
		 * System.out.println(s.toUpperCase()); // 如果不是就打印字符串，大写的 sb.delete(0,
		 * sb.length()); // 清空缓冲区,没有这个字符串会累加 } else sb.append((char) ch); //
		 * 将传进来的字符串存到缓冲区 }
		 */
        // 利用readLine方法读取一行,而键盘录入的read方法是字节流，readLine方法是字符流BufferedReader的方法
        // 怎么将字节流转化成字符流
        //		参照转化
    }
}
