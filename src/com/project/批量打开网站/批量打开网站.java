package com.project.��������վ;

import com.xl.util.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author ����
 * @Decription ���ļ����ڱ�Ŀ¼�¼���
 * @date 2014-5-3
 */
public class ��������վ {
    /**
     * �洢��վ�ļ���
     */
    String[] strs = null;
    private StringBuffer content = new StringBuffer();
    /**
     * ɨ����ļ�
     */
    private File[] files;
    /**
     * ��վ������
     */
    private String reg = "http.+";

    @Before
    public void init() {
        files = new File(FileTool.getCurrentPath(this)).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if ((��������վ.class.getSimpleName() + ".java").equals(pathname.getName())) {
                    return false;
                }
                return true;
            }
        });
    }

    @Test
    public void before() throws IOException {
        if (files.length == 0) {
            System.out.println("û��Ҫ�򿪵���վ��");
            return;
        }
        for (int i = 0; i < files.length; i++) {
        }
        // strs = RegTool.getContent(content.toString(), reg);
        // System.out.println("�����"+strs.length+"����վ");
        // for (String _s : strs) {
        // Desktop.getDesktop().browse(URI.create(_s));
        // }
    }

    /**
     * ����һ��
     *
     * @param file
     */
    private void handle(File file) {
    }
}
