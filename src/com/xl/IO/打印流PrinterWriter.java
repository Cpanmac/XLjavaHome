package com.xl.IO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ��ӡ��PrinterWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(System.out); //����д�뵽����̨
        // PrintWriter out = new PrintWriter(System.out,true);
        // //���дtrue,����Ϳ��Բ�дflush, ��ln��Ǿ��Զ�ˢ��
        // PrintWriter out = new PrintWriter(new FileWriter("a.txt")); //ˢ���������
        PrintWriter out = new PrintWriter(new FileWriter("a.txt"), true); // ��дˢ��ln����ˢ��
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line))
                break;
            out.write(line.toUpperCase());
            out.println();
            // out.flush();
        }
        out.close();
        bufr.close();
    }
}
