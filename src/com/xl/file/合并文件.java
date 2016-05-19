package com.xl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

//合并文件
public class 合并文件 {
    public static void main(String[] args) throws IOException {
        // 只有Vector里面有Enumeration
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入要合并.java文件的当前路径:");
        String url = sr.next();
        File file = new File(url);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            try {
                merge(files);
                System.out.println("合成成功");
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("合并失败");
            }
        }
    }

    // 合并文件
    public static void merge(File[] files) throws IOException {
        ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>(); // 因为Vector效率低
        String FuName = files[0].getParent();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();   //这个就包括了后缀名
            a1.add(new FileInputStream(FuName + "\\" + name)); // 关联，并添加到文件当中
        }
        final Iterator<FileInputStream> it = a1.iterator(); // 因为下面是匿名内部类，所以要用final修饰
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() { // 匿名内部类，Enumeration是接口
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public FileInputStream nextElement() {
                return it.next();
            }
        };
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream(FuName + "\\合并后.java"); //写入到哪个文件
        byte[] buf = new byte[1024 * 5];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        sis.close();
        fos.close();
    }
}
