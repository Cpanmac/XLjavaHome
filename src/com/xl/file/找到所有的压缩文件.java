package com.xl.file;

import java.io.File;

public class �ҵ����е�ѹ���ļ� {
    public static void main(String args[]) {
        File f = new File("d:" + File.separator); // ����·��
        find(f);
    }

    public static void find(File file) { // �ݹ����
        if (file != null) { // �ж϶����Ƿ�Ϊ��
            if (file.isDirectory()) { // �����Ŀ¼
                File f[] = file.listFiles(); // �г�ȫ�����ļ�
                if (f != null) { // �жϴ�Ŀ¼�ܷ��г�
                    for (int i = 0; i < f.length; i++) {
                        find(f[i]); // ��Ϊ����·���п�����Ŀ¼�����ԣ������ж�
                    }
                }
            } else {
                // System.out.println(file); // ���·��
                String name = file.getName();
                if (name.endsWith(".jar") || name.endsWith(".rar") || name.endsWith(".zip")) {
                    System.out.println(file);
                }
            }
        }
    }
}
