package com.xl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

//�ϲ��ļ�
public class �ϲ��ļ� {
    public static void main(String[] args) throws IOException {
        // ֻ��Vector������Enumeration
        Scanner sr = new Scanner(System.in);
        System.out.println("������Ҫ�ϲ�.java�ļ��ĵ�ǰ·��:");
        String url = sr.next();
        File file = new File(url);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            try {
                merge(files);
                System.out.println("�ϳɳɹ�");
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("�ϲ�ʧ��");
            }
        }
    }

    // �ϲ��ļ�
    public static void merge(File[] files) throws IOException {
        ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>(); // ��ΪVectorЧ�ʵ�
        String FuName = files[0].getParent();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();   //����Ͱ����˺�׺��
            a1.add(new FileInputStream(FuName + "\\" + name)); // ����������ӵ��ļ�����
        }
        final Iterator<FileInputStream> it = a1.iterator(); // ��Ϊ�����������ڲ��࣬����Ҫ��final����
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() { // �����ڲ��࣬Enumeration�ǽӿ�
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public FileInputStream nextElement() {
                return it.next();
            }
        };
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream(FuName + "\\�ϲ���.java"); //д�뵽�ĸ��ļ�
        byte[] buf = new byte[1024 * 5];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        sis.close();
        fos.close();
    }
}
