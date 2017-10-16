package com.xl.encode;

import com.xl.util.FileTool;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017-08-14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class EncoderDemo {
    private File gbkFile = FileTool.getResourceFile("/gbk.txt");
    private File utfFile = FileTool.getResourceFile("/utf-8.txt");

    /**
     * 将指定目录下的GBK文件转为UTF-8文件
     *
     * @throws IOException
     */
    @Test
    public void getFileTest() throws IOException, InterruptedException {
        System.out.println(FileTool.getCurrentPath(getClass()));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            System.out.println(file.getName() + ":" + FileTool.getFileEncode(file));
        }
    }

    @Test
    public void aTest() throws IOException {
        File file = new File("D:\\code\\javaSE\\src\\com\\xl\\util\\FileTool.java");
        String content = FileTool.getContent(file);
        OutputStreamWriter w1 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        w1.write(content);
        w1.flush();
        w1.close();
    }
}
