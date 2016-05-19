package com.xl.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBuf {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter("1(1).java"));
            br = new BufferedReader(new FileReader("1.java"));
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush(); // ������ˢ����������ͣ��
            }
        } catch (IOException e) {
            throw new RuntimeException("д��ʧ�ܣ�");
        } finally {
            try {
                if (bw != null && bw != null) {
                    br.close();
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("��ȡ�ر�ʧ��");
            }
        }
    }
}
