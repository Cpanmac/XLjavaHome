package com.xl.util;

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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FileTool {
    /**
     * ���õ�������Դ��cpdetector��ȡ�ļ������ʽ
     *
     * @param path Ҫ�ж��ļ������ʽ��Դ�ļ���·��
     * @author huanglei
     * @version 2012-7-12 14:05
     */
    public static String getFileEncode(String path) {
    /*
     * detector��̽����������̽�����񽻸������̽��ʵ�����ʵ����ɡ�
     * cpDetector������һЩ���õ�̽��ʵ���࣬��Щ̽��ʵ�����ʵ������ͨ��add���� �ӽ�������ParsingDetector��
     * JChardetFacade��ASCIIDetector��UnicodeDetector��
     * detector���ա�˭���ȷ��طǿյ�̽���������Ըý��Ϊ׼����ԭ�򷵻�̽�⵽��
     * �ַ������롣ʹ����Ҫ�õ�����������JAR����antlr.jar��chardet.jar��cpdetector.jar
     * cpDetector�ǻ���ͳ��ѧԭ��ģ�����֤��ȫ��ȷ��
     */
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
    /*
     * ParsingDetector�����ڼ��HTML��XML���ļ����ַ����ı���,���췽���еĲ�������
     * ָʾ�Ƿ���ʾ̽����̵���ϸ��Ϣ��Ϊfalse����ʾ��
     */
        detector.add(new ParsingDetector(false));
    /*
     * JChardetFacade��װ����Mozilla��֯�ṩ��JChardet����������ɴ�����ļ��ı���
     * �ⶨ�����ԣ�һ���������̽�����Ϳ�����������Ŀ��Ҫ������㻹�����ģ�����
     * �ٶ�Ӽ���̽���������������ASCIIDetector��UnicodeDetector�ȡ�
     */
        detector.add(JChardetFacade.getInstance());// �õ�antlr.jar��chardet.jar
        // ASCIIDetector����ASCII����ⶨ
        detector.add(ASCIIDetector.getInstance());
        // UnicodeDetector����Unicode�������Ĳⶨ
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
     * ��ȡ��ԴĿ¼�µ��ļ�
     *
     * @param path
     * @return
     */
    public static File getResourceFile(String path) {
        return new File(FileTool.class.getResource(path).getFile());
    }

    /**
     * ��ȡ��ԴĿ¼�µ�������
     *
     * @param path
     * @return
     */
    public static InputStream getResourceInputStream(String path) {
        return FileTool.class.getResourceAsStream("/" + path);
    }

    /**
     * ���õ�������Դ��cpdetector��ȡ�ļ������ʽ
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
     * ��ȡ��ǰ���·��<br/>
     * ˼·������·��+src+����
     *
     * @param clazz �õ����ȫ��
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
     * �����ļ�
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
     * ���ļ���С���и�ʽ��
     *
     * @param fileS
     * @return String
     */
    public static String FormetFileSize(long fileS) {// ת���ļ���С
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
     * �õ���ǰ���̵ľ���·��
     *
     * @return String
     */
    public static String getProjectPath() {
        return new File("").getAbsolutePath();
    }

    /**
     * ���ظ��ļ���С,leng�Ϳ��Ի�ô�С��
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
     * ��ӡ����
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
     * ������Ŀ¼�������ļ�
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
     * ������Ŀ¼�������ļ�
     *
     * @param file
     * @return List<File>
     */
    public static List<File> queryAll(File file) {
        return queryAll(file.getAbsolutePath());
    }

    /**
     * ������Ŀ¼�������ļ�
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
     * ������Ŀ¼�������ļ�
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
     * ��Ŀ��д��
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
     * ��ָ���ļ���������
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

    @Test
    public void testGetCurrentPath() {
        String path = getCurrentPath(this);
        System.out.println(path);
    }

    @Test
    public void testTraverser() {
        File file = new File(getProjectPath());
        List<File> fileList = new ArrayList<File>();
        queryAll(file, fileList);
        System.out.println(fileList.size());
        for (File f : fileList) {
            System.out.println(f.getName());
        }
    }
}
