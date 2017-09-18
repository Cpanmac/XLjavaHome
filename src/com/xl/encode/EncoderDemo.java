package com.xl.encode;

import com.xl.util.FileTool;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017-08-14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class EncoderDemo {
    private String gbkPath = FileTool.getCurrentPath(getClass()) + "\\gbk";
    private File gbkFile = new File(gbkPath);
    private String utfPath = FileTool.getCurrentPath(getClass()) + "\\utf-8";
    private File utfFile = new File(utfPath);

    /**
     * 将指定目录下的GBK文件转为UTF-8文件
     *
     * @throws IOException
     */
    @Test
    public void getFileTest() throws IOException {
        System.out.println(FileTool.getCurrentPath(getClass()));
        System.out.println(FileTool.getFileEncode(gbkPath));
        System.out.println(FileTool.getFileEncode(utfPath));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            System.out.println(file.getName() + ":" + FileTool.getFileEncode(file));
        }
    }

    /**
     * 转变文件   TODO
     */
    @Test
    public void fileTest() throws IOException {
        System.out.println(FileTool.read(gbkFile));
        FileTool.write(gbkFile, FileTool.read(gbkFile) + "1111");
        System.out.println(FileTool.read(utfFile));
    }
}
