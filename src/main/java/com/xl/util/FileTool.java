package com.xl.util;

import com.xl.encode.Encode;
import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FileTool {
    /**
     * 利用第三方开源包cpdetector获取文件编码格式
     *
     * @param path 要判断文件编码格式的源文件的路径
     * @author huanglei
     * @version 2012-7-12 14:05
     */
    public static String getFileEncode(String path) {
    /*
     * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
     * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、
     * JChardetFacade、ASCIIDetector、UnicodeDetector。
     * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
     * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar
     * cpDetector是基于统计学原理的，不保证完全正确。
     */
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
    /*
     * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
     * 指示是否显示探测过程的详细信息，为false不显示。
     */
        detector.add(new ParsingDetector(false));
    /*
     * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
     * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
     * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
     */
        detector.add(JChardetFacade.getInstance());// 用到antlr.jar、chardet.jar
        // ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance());
        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance());
        java.nio.charset.Charset charset = null;
        File f = new File(path);
        try {
            charset = detector.detectCodepage(f.toURI().toURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (charset != null) {
            return charset.name();
        } else {
            return null;
        }
    }

    /**
     * 获取资源目录下的文件
     *
     * @param path
     * @return
     */
    public static File getResourceFile(String path) throws UnsupportedEncodingException {
        return new File(URLDecoder.decode(FileTool.class.getClassLoader().getResource(path).getFile(), Encode.UTF));
    }

    /**
     * 获取资源目录下的输入流
     *
     * @param path
     * @return
     */
    public static InputStream getResourceInputStream(String path) {
        return FileTool.class.getClassLoader().getResourceAsStream(path);
    }

    /**
     * 利用第三方开源包cpdetector获取文件编码格式
     *
     * @param file
     * @return
     */
    public static String getFileEncode(File file) {
        return getFileEncode(file.getAbsolutePath());
    }

    public static void openNodepad() {
        SystemUtil.exec("notepad");
    }

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
    public static int getSize(File file) throws IOException {
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
            Print.info(i.next());
        }
    }

    /**
     * 遍历该目录下所有文件
     *
     * @param file
     * @return List<File>
     */
    public static List<File> queryAll(File file, List<File> list) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i] != null) {
                        queryAll(files[i], list);
                    }
                }
            } else if (file.isFile()) {
                list.add(file);
            }
        }
        return list;
    }

    /**
     * 遍历该目录下所有文件
     *
     * @param file
     * @return List<File>
     */
    public static List<File> queryAll(File file) {
        return queryAll(file.getAbsolutePath());
    }

    /**
     * 遍历该目录下所有文件
     *
     * @param filePath
     * @return List<File>
     */
    public static List<File> queryAll(String filePath) {
        File file = new File(filePath);
        List<File> list = new ArrayList<File>();
        return queryAll(file, list);
    }

    /**
     * 遍历该目录下所有文件
     *
     * @param filePath
     * @return List<File>
     */
    public static List<File> queryAll(String filePath, String endWith) {
        File file = new File(filePath);
        List<File> list = new ArrayList<File>();
        return queryAll(file, list, endWith);
    }

    public static List<File> queryAll(File file, List<File> list, String end) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i] != null) {
                        queryAll(files[i], list, end);
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
        BufferedOutputStream bos = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            bos = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buf = StreamTool.getBytes(is);
            bos.write(buf);
            bos.flush();
        } finally {
            bos.close();
            is.close();
        }
    }

    /**
     * 向指定文件输入内容
     *
     * @param file
     * @param content
     * @throws IOException
     */
    public static void write(File file, String content) throws IOException {
        BufferedWriter bw = null;
        try {
            if (content == null) {
                return;
            }
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.flush();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static String getContent(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer sb = null;
        try {
            sb = new StringBuffer();
            String content = null;
            while ((content = br.readLine()) != null) {
                sb.append(content).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                br.close();
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

    public static File getDesktopPath() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        return fsv.getHomeDirectory();
    }

    public static void open(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }

    public static File createResourceFile(String path) throws IOException {
        File f = new File(getResourceFile(""), path);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        return f;
    }

    @Test
    public void testGetCurrentPath() {
        String path = getCurrentPath(this);
        Print.info(path);
    }

    @Test
    public void testTraverser() {
        File file = new File(getProjectPath());
        List<File> fileList = new ArrayList<File>();
        queryAll(file, fileList);
        Print.info(fileList.size());
        for (File f : fileList) {
            Print.info(f.getName());
        }
    }

    @Test
    public void createTest() throws IOException {
        createResourceFile("1");
    }
}
