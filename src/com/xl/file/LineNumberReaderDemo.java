package com.xl.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    /**
     * @param 徐立
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        FileReader fr = new FileReader("1.java");
        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        lnr.setLineNumber(0); // 设置起始行号 ，正文就从1开始
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
