package com.xl.io;

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
                bw.flush(); // 别忘记刷新下流，怕停电
            }
        } catch (IOException e) {
            throw new RuntimeException("写入失败！");
        } finally {
            try {
                if (bw != null && bw != null) {
                    br.close();
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("读取关闭失败");
            }
        }
    }
}
