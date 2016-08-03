package com.project.批量打开网站;

import com.xl.util.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author 徐立
 * @Decription 把文件放在本目录下即可
 * @date 2014-5-3
 */
public class 批量打开网站 {
    /**
     * 存储网站的集合
     */
    String[] strs = null;
    private StringBuffer content = new StringBuffer();
    /**
     * 扫描的文件
     */
    private File[] files;
    /**
     * 网站的正则
     */
    private String reg = "http.+";

    @Before
    public void init() {
        files = new File(FileTool.getCurrentPath(this)).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if ((批量打开网站.class.getSimpleName() + ".java").equals(pathname.getName())) {
                    return false;
                }
                return true;
            }
        });
    }

    @Test
    public void before() throws IOException {
        if (files.length == 0) {
            System.out.println("没有要打开的网站。");
            return;
        }
        for (int i = 0; i < files.length; i++) {
        }
        // strs = RegTool.getContent(content.toString(), reg);
        // System.out.println("你打开了"+strs.length+"个网站");
        // for (String _s : strs) {
        // Desktop.getDesktop().browse(URI.create(_s));
        // }
    }

    /**
     * 处理一个
     *
     * @param file
     */
    private void handle(File file) {
    }
}
