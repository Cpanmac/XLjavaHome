package com.xl.util;

import com.xl.encode.Encode;
import com.xl.entity.Freemark;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
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
import java.util.Map;

/**
 * Created with IntelliJ IDEA.freemark工具类
 * User: 徐立
 * Date: 2017-11-09
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class FreemarkerUtil {
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
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(freemark.getOutFile()), Encode.UTF));
            t.process(freemark.getParam(), out);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * @param templatePath 资源下的文件，不用"/"开头
     * @param filePath
     * @param param
     * @throws TemplateException
     * @throws IOException
     */
    public static void analysisTemplate(String templatePath, String filePath, Map param) throws TemplateException, IOException {
        File e = new File(filePath);
        if (!e.getParentFile().exists()) {
            e.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(fos, Encode.UTF);
            Template template = configFreemarker(templatePath);
            template.process(param, out);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static Template configFreemarker(String templatePath) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_22);
        config.setObjectWrapper(new DefaultObjectWrapper(Configuration.getVersion()));
        int slashIndex = templatePath.lastIndexOf("/");
        String tplPath = templatePath.substring(0, slashIndex);
        config.setClassForTemplateLoading(FreemarkerUtil.class, "/" + tplPath);
        String tplName = templatePath.substring(slashIndex + 1);
        Template template = config.getTemplate(tplName, Encode.UTF);
        return template;
    }
}
