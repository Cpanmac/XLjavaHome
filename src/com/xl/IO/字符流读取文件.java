package com.xl.IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class 字符流读取文件 {
    public static void main(String[] args) {
        File f = null;
        FileReader fr = null;
        try {
            f = new File("D:\\电话.txt");
            fr = new FileReader(f);
            char[] ch = new char[1024];
            int len = fr.read(ch, 0, ch.length);
            String s = new String(ch, 0, len);
            System.out.println(s);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
