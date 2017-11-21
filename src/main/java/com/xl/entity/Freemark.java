package com.xl.entity;

import com.xl.encode.Encode;
import freemarker.template.Configuration;
import lombok.Data;

import java.io.File;
import java.util.Map;

@Data
public class Freemark {
    /**
     * freemark模板配置
     */
    private Configuration configuration;
    /**
     * 输出文件
     */
    private File outFile;
    /**
     * 要解析的模板名称
     */
    private String templetName;
    /**
     * 解析的参数，如果文档有参数没给值会报错
     */
    private Map param;

    /**
     * freemark初始化
     *
     * @param templatePath 模板文件位置
     */
    public Freemark(String templatePath) {
        configuration = new Configuration(Configuration.VERSION_2_3_22);
        configuration.setDefaultEncoding(Encode.UTF);
        configuration.setClassForTemplateLoading(this.getClass(), templatePath);
    }
}
