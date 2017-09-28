package com.xl.Regex;

import com.xl.util.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
    static long normalLines = 0; // 正常行数
    static long commentLines = 0; // 有内容的行数
    static long whiteLines = 0; // 空白行数

    public static void main(String[] args) {
        String path = StringUtil.getClassPath() + "\\src"; // 获取当前工程的的目录
        System.out.println("path========" + path);
        File f = new File(path);
        File[] codeFiles = f.listFiles(); // 获取该目录下的所有文件
        for (File child : codeFiles) {
            // System.out.println("child.getName()========"+child.getName());
            if (child.getName().matches(".+java")) { // 匹配以java结尾的文件
                // System.out.println("child========"+child);
                parse(child);
            }
        }
        System.out.println("normalLines:" + normalLines);
        System.out.println("commentLines:" + commentLines);
        System.out.println("whiteLines:" + whiteLines);
    }

    private static void parse(File f) {
        BufferedReader br = null;
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim(); // 去掉两端的空格
                if (line.matches("^[\\s&&[^\\n]]*$")) { // 如果以空格开头
                    whiteLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    commentLines++;
                    comment = true;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentLines++;
                    System.out.println(line);
                } else if (true == comment) {
                    commentLines++;
                    if (line.endsWith("*/")) {
                        comment = false;
                    }
                } else if (line.startsWith("//")) {
                    commentLines++;
                } else {
                    normalLines++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
