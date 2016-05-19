package com.xl.file;

import java.io.File;

public class 找到所有的压缩文件 {
    public static void main(String args[]) {
        File f = new File("d:" + File.separator); // 操作路径
        find(f);
    }

    public static void find(File file) { // 递归调用
        if (file != null) { // 判断对象是否为空
            if (file.isDirectory()) { // 如果是目录
                File f[] = file.listFiles(); // 列出全部的文件
                if (f != null) { // 判断此目录能否列出
                    for (int i = 0; i < f.length; i++) {
                        find(f[i]); // 因为给的路径有可能是目录，所以，继续判断
                    }
                }
            } else {
                // System.out.println(file); // 输出路径
                String name = file.getName();
                if (name.endsWith(".jar") || name.endsWith(".rar") || name.endsWith(".zip")) {
                    System.out.println(file);
                }
            }
        }
    }
}
