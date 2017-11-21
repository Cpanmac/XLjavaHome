package com.xl.socket;

import com.xl.util.Print;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        ss = new ServerSocket(9900);
        Print.info("服务器启动中...");
        while (true) {
            Socket s = ss.accept();
            Thread t = new Thread(new MyThread(s));
            t.start();
        }
    }
}
