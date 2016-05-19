package com.xl.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ����ʹ�ô��� { // ����д��ϵͳ�ļ����棬������ɾ����
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        File file = new File("count.properties"); // ��ֹ�쳣���ȷ�װ�ɶ��󣬿��Խ����жϣ���������
        if (!file.exists()) // ����ļ������ھʹ���
            file.createNewFile();
        FileInputStream fis = new FileInputStream(file); // ��չ������������Ϣ
        prop.load(fis);
        int count = 0;// ������
        String value = prop.getProperty("time");
        if (value != null) { // �����Ϊ�գ�������
            count = Integer.parseInt(value);
            if (count >= 2) {
                System.out.println("���ã�ʹ�ô����ѵ�����Ǯ�������ע��Ļ������Ļ�����ð��");
                return;
            }
        }
        count++; // ���Ϊ�գ��Ͱ�0++
        prop.setProperty("time", count + "");
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "");
        fos.close();
        fis.close();
    }
}
/*
 * ����10����XML���������� <Person> <person> id="001"> <name>zhangsan</name>
 * <age>30</age> <address>bj</address> <person>id=="002"> ....
 * 
 * </Person>
 * 
 * Document�࣬����ȡ����Щ���ݣ������൱�鷳�����������˹���dom4j dom for java (4��fourг��)
 */

