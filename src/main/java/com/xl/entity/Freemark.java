package com.xl.entity;

import freemarker.template.Configuration;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.util.Map;

@Log4j
@Data
public class Freemark {
    /**
     * freemark初始化
     *
     * @param templatePath 模板文件位置
     */
    public Freemark(String templatePath) {
        configuration = new Configuration(Configuration.VERSION_2_3_22);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), templatePath);
    }

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
}
