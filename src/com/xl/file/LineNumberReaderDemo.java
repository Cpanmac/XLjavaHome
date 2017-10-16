package com.xl.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    /**
     * @param ����
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        FileReader fr = new FileReader("1.java");
        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        lnr.setLineNumber(0); // ������ʼ�к� �����ľʹ�1��ʼ
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
