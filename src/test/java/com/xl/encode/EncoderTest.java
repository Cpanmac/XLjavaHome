package com.xl.encode;

import com.xl.util.FileTool;
import com.xl.util.Print;
import com.xl.util.StringUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017-08-14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class EncoderTest {
    private File gbkFile = FileTool.getResourceFile("gbk.txt");
    private File utfFile = FileTool.getResourceFile("utf-8.txt");

    public EncoderTest() throws UnsupportedEncodingException {
    }

    @Test
    public void pathTest() {
        Print.info(gbkFile.getAbsolutePath());
        Print.info(utfFile.getAbsolutePath());
    }

    /**
     * 将指定目录下其他格式文件为UTF-8文件
     *
     * @throws IOException
     */
    @Test
    public void encodeTest() throws IOException, InterruptedException {
        Print.info(FileTool.getCurrentPath(getClass()));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            String encode = FileTool.getFileEncode(file);
            if (encode != null && !com.xl.encode.Encode.UTF.equals(encode)) {
                OutputStreamWriter w1 = null;
                try {
                    String content = FileTool.getContent(file);
                    if (StringUtil.isEmpty(content)) {
                        Print.info(file.getAbsolutePath() + "为空");
                    } else {
                        w1 = new OutputStreamWriter(new FileOutputStream(file), com.xl.encode.Encode.UTF);
                        w1.write(content);
                        w1.flush();
                        Print.info(file.getAbsolutePath() + "转换完成:" + content);
                    }
                } finally {
                    if (w1 != null) {
                        w1.close();
                    }
                }
            }
        }
    }

    /**
     * 将指定目录下其他格式文件为GBK文件
     *
     * @throws IOException
     */
    @Test
    public void encodeGBKTest() throws IOException, InterruptedException {
        Print.info(FileTool.getCurrentPath(getClass()));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            String encode = FileTool.getFileEncode(file);
            if (encode != null && !encode.contains("GB")) {
                OutputStreamWriter w1 = null;
                try {
                    String content = FileTool.getContent(file);
                    if (StringUtil.isEmpty(content)) {
                        Print.info(file.getAbsolutePath() + "为空");
                    } else {
                        w1 = new OutputStreamWriter(new FileOutputStream(file), "GBK");
                        w1.write(content);
                        w1.flush();
                        Print.info(file.getAbsolutePath() + "转换完成:" + content);
                    }
                } finally {
                    if (w1 != null) {
                        w1.close();
                    }
                }
            }
        }
    }
}
