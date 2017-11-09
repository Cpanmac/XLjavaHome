package com.xl.util;

import com.xl.entity.Freemark;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.log4j.Log4j;
import sun.misc.BASE64Encoder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.freemark工具类
 * User: 徐立
 * Date: 2017-11-09
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class FreemarkUtil {
    public static String getImage(File imgFile) throws IOException {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("关闭流错误", e);
                }
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 解析
     *
     * @param freemark
     * @throws IOException
     * @throws TemplateException
     */
    public static void createWord(Freemark freemark) throws IOException, TemplateException {
        Template t = freemark.getConfiguration().getTemplate(freemark.getTempletName());
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(freemark.getOutFile()), "UTF-8"));
            t.process(freemark.getParam(), out);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}