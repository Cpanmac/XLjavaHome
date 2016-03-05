package com.xl.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class FileTool {
    /**
     * 获取当前类的路径<br/>
     * 思路：工程路径+src+类名
     *
     * @param clazz 得到类的全名
     * @return
     * @throws UnsupportedEncodingException
     */
    public static <T> String getCurrentPath(Class<T> clazz) {
        String projectPath = getProjectPath() + File.separator + "src";
        String name = clazz.getName();
        name = name.substring(0, name.lastIndexOf(".")).replace(".", File.separator);
        return projectPath + File.separator + name;
    }

    @Test
    public void testGetCurrentPath() {
        String path = getCurrentPath(this);
        System.out.println(path);
    }

    public static <T> String getCurrentPath(T obj) {
        return getCurrentPath(obj.getClass());
    }

    /**
     * 复制文件
     *
     * @param src
     * @param target void
     * @throws IOException
     */
    public static void copyFile(File src, File target) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    /**
     * 删除指定目录下重复的文件（带（1）这样的）
     *
     * @param file
     */
    public static void deleteRepeatiFile(File file) {
        if (file.isDirectory()) {
            List<File> fileList = new ArrayList<File>();
            fileList = queryAll(fileList, file);
            for (File f : fileList) {
                // if (RegTool.isMatch(f.getName(), "\\(\\d+?\\)")) {
                // f.deleteOnExit();
                // System.out.println(f.getName() + "删除");
                // }
            }
        } else {
            throw new RuntimeException("这不是目录");
        }
    }

    /**
     * 对文件大小进行格式化
     *
     * @param fileS
     * @return String
     */
    public static String FormetFileSize(long fileS) {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 得到当前工程的绝对路径
     *
     * @return String
     */
    public static String getProjectPath() {
        return new File("").getAbsolutePath();
    }

    /**
     * 返回该文件大小,leng就可以获得大小了
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException           int
     */
    @Deprecated
    public static int getSize(File file) throws FileNotFoundException, IOException {
        return new FileInputStream(file).available();
    }

    /**
     * 打印集合
     *
     * @param con void
     */
    public static <T> void print(Collection<T> con) {
        Iterator<T> i = con.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    /**
     * 遍历该目录下所有文件
     *
     * @param file
     * @return List<File>
     */
    public static List<File> queryAll(List<File> list, File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i] != null) {
                        queryAll(list, files[i]);
                    }
                }
            } else if (file.isFile()) {
                list.add(file);
            }
        }
        return list;
    }

    public static List<File> queryAll(List<File> list, File file, String end) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i] != null) {
                        queryAll(list, files[i], end);
                    }
                }
            } else if (file.isFile()) {
                if (file.getName().endsWith(end)) {
                    list.add(file);
                }
            }
        }
        return list;
    }

    /**
     * 往目标写入
     *
     * @param file
     * @param is   void
     * @throws IOException
     */
    public static void write(File file, InputStream is) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = StreamTool.getBytes(is);
        bos.write(buf);
        bos.flush();
        bos.close();
        is.close();
    }

    /**
     * 向指定文件输入内容
     *
     * @param file
     * @param content
     * @throws IOException
     */
    public static void write(File file, String content) throws IOException {
        if (content == null) {
            return;
        }
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(content);
        bw.flush();
        bw.close();
    }

    public static CharSequence read(File file) throws FileNotFoundException,
            UnsupportedEncodingException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                "utf-8"));
        StringBuffer sb;
        try {
            sb = new StringBuffer();
            String content = null;
            while ((content = br.readLine()) != null) {
                if (RegTool.isHttpUrl(content)) {
                    sb.append(content + "\r\n");
                    System.out.println(content);
                }
            }
            return sb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                br = null;
            }
        }
    }

    public static String getSize(Long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    @Test
    public void testTraverser() {
        File file = new File(getProjectPath());
        List<File> fileList = new ArrayList<File>();
        queryAll(fileList, file);
        System.out.println(fileList.size());
        for (File f : fileList) {
            System.out.println(f.getName());
        }
    }
}
