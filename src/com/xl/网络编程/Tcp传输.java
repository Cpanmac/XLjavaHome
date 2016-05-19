package com.xl.������;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 1.tcp��Ϊ�ͻ��˺ͷ����
 2.�ͻ��˷�ΪSocket
 ����˶�Ӧ�Ķ�����ServerSocket

 */

/*
 �ͻ��ˣ�
 ��Ϊtcp���������ӵģ������ڽ���socket����ʱ����Ҫ�з���˵Ĵ��ڣ����ӳɹ����γ�ͨ·���ڸ�ͨ·�������ݴ���
 ���󣺸�����˷���һ���ı����ݡ�
 ���裺
 1.����Socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿�

 */
class TcpClient {
    public static void main(String[] args) throws Exception {
        // �����ͻ��˵�socket����ָ��Ŀ�ĵ������Ͷ˿�
        Socket s = new Socket("192.168.1.254", 10003);
        OutputStream out = s.getOutputStream();
        out.write("top ge men lai le".getBytes());
        s.close();
    }
}

/*
  ���󣺶���̵�������ݲ���ӡ�ڿ���̨�ϡ� 
  �������� 
  1.�����������˵�socket����ServerSocket(); ������һ���˿�
  2.��ȡ���ӹ����Ŀͻ��˶��� ͨ��ServerSocket��accept�����������������������ʽ��
  3.�ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��񣬲���ȡ���ÿͻ��˵Ķ�ȡ������ȡ���͹��������� 4.�رտͻ��ˡ�����ѡ��
 */
class TcpServer {
    public static void main(String[] args) throws Exception {
        // ���������Socket���񣬲�����һ���˿�
        ServerSocket ss = new ServerSocket(10003);
        // ͨ��accept�������ӹ����Ŀͻ��˶���
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println("ip��ַ�ǣ�" + ip);
        // ��ȡ�ͻ��˷��͹��������ݣ���ôҪ�ÿͻ��˵Ķ����ȡ����ȡ����
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf, 0, len));
        // udpͨ�����ݰ���ȡ�Է�IP
        s.close(); // �ضԷ�,
        ss.close();// ��ѡ����
    }
}

public class Tcp���� {
    public static void main(String[] args) {
    }
}
