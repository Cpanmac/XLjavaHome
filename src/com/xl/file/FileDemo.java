package com.xl.file;

// 1.创建。
// boolean createNewFile();在指定位置创建文件，如果该文件已经在指定位置已经存在，反回false
// 于输出流的区别：输出流，一创建就会覆盖。
// 2.删除。
// bealean delete();
// void deteOnExit(): 在退出虚拟机的时候删除
// canExcute: 是否可执行
// compareTo: 比较
//
// 3.判断：
// boolean exists() 文件是否存在，一般都开始要判断一下
// isFile()
// isDirectory()
// isHiddent()
// isAbsolute()
//
// 4.获取信息
// getName();
// getPath()
// File getAbsoluteFile()
// 返回此抽象路径名的绝对路径名形式。
// String getAbsolutePath()
// 返回此抽象路径名的绝对路径名字符串。
//
// 覆盖的原理：先删除再创建跟原文件一样名字的文件
//
// boolean renameTo(File dest) 比较特殊
// 重新命名此抽象路径名表示的文件。

import com.xl.util.FileTool;
import org.junit.Before;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Scanner;

public class FileDemo {
    private File file;
    private File[] fileList;

    @Before
    public void init() throws UnsupportedEncodingException {
        file = new File(FileTool.getCurrentPath(this), "123.txt");
    }

    @Test
    public void test1() throws IOException {
        File file = new File(FileTool.getCurrentPath(this), "123.txt");
        String s = "冯帅你好";
        FileTool.write(file, s);
    }

    public static void method_1() throws IOException {
        File f = new File("file.txt");
        // 防止异常无法关掉，尤其是线程正在操作的时候
        f.deleteOnExit();
        // System.out.println(f.canExecute());
        // System.out.println(f.exists());
        // 创建文件夹
        File dir = new File("xl");
        System.out.println("mkdir:" + dir.mkdir()); // true
        System.out.println("mkdir:" + dir.mkdir()); // false
        // 创建多级文件夹。
        File dirs = new File("xl\\xl");
        System.out.println(dirs.mkdirs());
    }

    public static void method_3() throws IOException {
        File f = new File("file.txt");
        // 记住在判断文件对象是否是文件或者目的时，必须先判断文件是否存在
        System.out.println(f.exists());// false
        System.out.println("dir:" + f.isDirectory());// false
        System.out.println("File:" + f.isFile());// false
        // 创建文件
        // f.createNewFile();
        // 创建目录，目录后面也可以带txt
        // f.mkdir();
        // f.mkdirs();
        // 尽量不访问硬盘中被隐藏的文件。容易失败
        // 判断是否是绝对路径，带着盘符就是绝对路径，即使不存在也返回true
        // System.out.println(f.isAbsolute());
    }

    public static void method_4() {
        // 这样结果是一样的，因为路径本身就是绝对的,可以不抛异常
        File f = new File("c:/a.txt");
        System.out.println("path:" + f.getPath());
        System.out.println("abspath:" + f.getAbsolutePath());
        // 文件不存在，路径也能得到
        // File f = new File("file.txt");
        System.out.println("path:" + f.getPath()); // 返回file.txt,相对路径
        System.out.println("abspath:" + f.getAbsolutePath()); // 绝对路径
        // 返回绝对路径的父目录
        // System.out.println("parent:"+f.getParent());//此时null，如果有上一层目录就返回结果
        // 返回最后修改的时间long类型
        // System.out.println(f.lastModified());//1357820463062/
    }

    public void method_5() throws IOException {
        // 重命名文件，就是剪切
        File f1 = new File("D:\\text.java");
        File f2 = new File("c:\\haha.java");
        System.out.println("rename:" + f2.renameTo(f1));
    }

    @Test
    public void 测试编码() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("1.txt");
        BufferedInputStream bis = new BufferedInputStream(is);
        while (true) {
            int ch = bis.read();
            System.out.println(ch + "  " + (char) ch);
            if (ch < 0) {
                break;
            }
        }
    }

    @Test
    public void 查询指定目录下所有文件() {
        FileService service = new FileService();
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入目录：");
        String path = sr.nextLine().trim();
        File file = new File(path);
        service.queryAll(file);
    }

    @Test
    public void 得到桌面的路径() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File file = fsv.getHomeDirectory();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }

    @Test
    public void 如果目录不存在() throws IOException {
        File file = new File(FileSystemView.getFileSystemView().getHomeDirectory(), "5/" + "a.txt");
        FileTool.write(file, "张三");
    }

    @Test
    public void 文件大小() throws FileNotFoundException, IOException {
        file = new File(FileTool.getCurrentPath(this), this.getClass().getSimpleName() + ".java");
        System.out.println(FileTool.getSize(file.length()));
        System.out.println(file.length() + "bytes");
        System.out.println(FileTool.getSize(file));
    }

    @Test
    public void 查看文件是否可读() {
        file = new File("I:/我的快盘/mywork");
        System.out.println(file.canRead() + ":" + file.canWrite() + ":" + file.isDirectory());
        file.setReadOnly();
        System.out.println(file.canRead() + ":" + file.canWrite());
        file.setWritable(true);
        System.out.println(file.canRead() + ":" + file.canWrite());
    }

    @Test
    public void 读取文件() throws FileNotFoundException, UnsupportedEncodingException {
        String content = FileTool.read(file).toString();
        // System.out.println(content);
    }
}
