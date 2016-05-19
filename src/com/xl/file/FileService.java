package com.xl.file;

import com.xl.util.FileTool;

import java.io.File;
import java.util.ArrayList;

public class FileService {
    /**
     * ��ѯ��Ŀ¼�µ������ļ�����ӡ
     *
     * @param file
     */
    public void queryAll(File file) throws RuntimeException {
        if (!file.isDirectory()) {
            throw new RuntimeException("�ⲻ��Ŀ¼");
        }
        ArrayList<File> list = new ArrayList<File>();
        FileTool.queryAll(list, file);
        // System.out.println(list);
        for (File _file : list) {
            System.out.println(_file.getName());
        }
    }

    /**
     * �ݹ��ȡ�ļ��д�С
     *
     * @param file
     * @return
     * @throws Exception
     */
    public long getFileSize(File file) {
        long size = 0;
        File flist[] = file.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }
}
