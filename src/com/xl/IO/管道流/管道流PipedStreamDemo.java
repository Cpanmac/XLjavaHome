package com.xl.IO.�ܵ���;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class �ܵ���PipedStreamDemo {
    public static void main(String[] args) {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        try {
            in.connect(out); // ����
            Read r = new Read(in);
            Write w = new Write(out);
            new Thread(r).start();
            new Thread(w).start();
        } catch (IOException e) {
            throw new RuntimeException("����ʧ�ܣ�");
        }
    }
}
