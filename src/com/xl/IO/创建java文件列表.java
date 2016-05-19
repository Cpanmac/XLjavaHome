package com.xl.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 将java文件的绝对路径存储到文本文件中。
 建立一个java文件列表的文件
 思路：
 1.对指定的目录进行递归。
 2.获取递归过程所有的java文件的路径
 3.将这些数据存储到集合中。
 4.将集合中的数据写入到一个文件中

 */
public class 创建java文件列表 {
    public static void main(String[] args) {
        File dir = new File("D:/abc");
        List<File> list = new ArrayList<File>();
        fileToList(dir, list); // 这样就可以添加进list集合
        System.out.println(list.size());
        System.out.println(list);
        try {
            // 文件名是
            File file = new File(dir, "javaList.txt");
            writeToFile(list, file.toString()); // 因为存储的字符串。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将文件存储到集合
    public static void fileToList(File dir, List<File> list) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                fileToList(file, list);
            else {
                if (file.getName().endsWith(".java")) // 如果是java就把文件对象存储到集合中去
                    list.add(file);
            }
        }
    }

    public static void writeToFile(List<File> list, String javaListFile) throws IOException { // 存的是文本,因为里面扔了异常，必须标识
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(javaListFile));
            for (File f : list) {
                String path = f.getAbsolutePath(); // 获取每个文件的绝对路径
                bufw.write(path);
                bufw.flush();
            }
        } catch (IOException e) {
            // TODO: handle exception
            throw e; // 处理不了 如果想停的话就抛RuntimeException
        } finally {
            try {
                if (bufw != null)
                    bufw.close();
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
