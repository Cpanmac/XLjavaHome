package com.xl.Tcp;

import com.xl.util.Print;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10004);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        Print.info("客户端的IP地址是：" + ip);
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        Print.info(new String(buf, 0, len));
        java.io.OutputStream out = s.getOutputStream();
        Thread.sleep(5000);//阻塞式方法
        out.write("哥们收到，你也好，客户端发送".getBytes());
        s.close();
        ss.close();
    }
}
