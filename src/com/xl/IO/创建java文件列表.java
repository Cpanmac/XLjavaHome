package com.xl.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 ��java�ļ��ľ���·���洢���ı��ļ��С�
 ����һ��java�ļ��б���ļ�
 ˼·��
 1.��ָ����Ŀ¼���еݹ顣
 2.��ȡ�ݹ�������е�java�ļ���·��
 3.����Щ���ݴ洢�������С�
 4.�������е�����д�뵽һ���ļ���

 */
public class ����java�ļ��б� {
    public static void main(String[] args) {
        File dir = new File("D:/abc");
        List<File> list = new ArrayList<File>();
        fileToList(dir, list); // �����Ϳ�����ӽ�list����
        System.out.println(list.size());
        System.out.println(list);
        try {
            // �ļ�����
            File file = new File(dir, "javaList.txt");
            writeToFile(list, file.toString()); // ��Ϊ�洢���ַ�����
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ���ļ��洢������
    public static void fileToList(File dir, List<File> list) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                fileToList(file, list);
            else {
                if (file.getName().endsWith(".java")) // �����java�Ͱ��ļ�����洢��������ȥ
                    list.add(file);
            }
        }
    }

    public static void writeToFile(List<File> list, String javaListFile) throws IOException { // ������ı�,��Ϊ���������쳣�������ʶ
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(javaListFile));
            for (File f : list) {
                String path = f.getAbsolutePath(); // ��ȡÿ���ļ��ľ���·��
                bufw.write(path);
                bufw.flush();
            }
        } catch (IOException e) {
            // TODO: handle exception
            throw e; // ������ �����ͣ�Ļ�����RuntimeException
        } finally {
            try {
                if (bufw != null)
                    bufw.close();
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
