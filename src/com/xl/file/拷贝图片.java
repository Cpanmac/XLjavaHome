package com.xl.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*����һ��ͼƬ
 ˼·��
 1.���ֽڶ�ȡ�������ͼƬ������
 2.���ֽ�д�������󴴽�ͼƬ�ļ������ڴ洢��ȡ����ͼƬ����
 3.ͨ��ѭ����д��������ݵĴ洢
 4.�ر���Դ��
 ���ַ���Ҳ���Ը���ͼƬ�����п��ܸ������˿�����
 */
public class ����ͼƬ {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("c:/2.jpg"); // �洢��Ŀ���ļ�·��
            fis = new FileInputStream("c:/1.jpg"); // ���� Դ�ļ�
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            // TODO: handle exception
            throw new RuntimeException("�����ļ�ʧ��");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException("��ȡ�ر�ʧ��");
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException("д��ر�ʧ��");
            }
        }
    }
}
