package com.xl.encode;

import com.xl.util.FileTool;
import com.xl.util.StringUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017-08-14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class EncoderDemo {
    private File gbkFile = FileTool.getResourceFile("/gbk.txt");
    private File utfFile = FileTool.getResourceFile("/utf-8.txt");

    /**
     * ��ָ��Ŀ¼��������ʽ�ļ�ΪUTF-8�ļ�
     *
     * @throws IOException
     */
    @Test
    public void encodeTest() throws IOException, InterruptedException {
        System.out.println(FileTool.getCurrentPath(getClass()));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            String encode = FileTool.getFileEncode(file);
            if (encode != null && !encode.equals("UTF-8")) {
                OutputStreamWriter w1 = null;
                try {
                    String content = FileTool.getContent(file);
                    if (StringUtil.isEmpty(content)) {
                        System.out.println(file.getAbsolutePath() + "Ϊ��");
                    } else {
                        w1 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                        w1.write(content);
                        w1.flush();
                        System.out.println(file.getAbsolutePath() + "ת�����:" + content);
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
     * ��ָ��Ŀ¼��������ʽ�ļ�ΪGBK�ļ�
     *
     * @throws IOException
     */
    @Test
    public void encodeGBKTest() throws IOException, InterruptedException {
        System.out.println(FileTool.getCurrentPath(getClass()));
        List<File> fileList = FileTool.queryAll(FileTool.getProjectPath(), "java");
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            String encode = FileTool.getFileEncode(file);
            if (encode != null && !encode.contains("GB")) {
                OutputStreamWriter w1 = null;
                try {
                    String content = FileTool.getContent(file);
                    if (StringUtil.isEmpty(content)) {
                        System.out.println(file.getAbsolutePath() + "Ϊ��");
                    } else {
                        w1 = new OutputStreamWriter(new FileOutputStream(file), "GBK");
                        w1.write(content);
                        w1.flush();
                        System.out.println(file.getAbsolutePath() + "ת�����:" + content);
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
