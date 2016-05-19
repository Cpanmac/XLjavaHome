package com.xl.������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 ���󣺽���һ���ı�ת����������
 �ͻ��˸�����˷����ı�������˻Ὣ�ı�ת���ɴ�д���ظ��ͻ���
 ���ҿͻ��˿��Բ��˵Ľ����ı�ת�������ͻ�������over��ת������

 ������
 �ͻ��ˣ�
 ��Ȼ�ǲ����豸�ϵ����ݣ���ô����ʹ��IO����������װio����˼��
 Դ������¼��
 Ŀ�ģ������豸�������������
 ���Ҳ������������ı����ݡ�����ѡ���ַ�����
 ����
 1.��������
 2.��ȡ����¼��
 3.�����ݷ�������ˡ�
 4.��ȡ����˷��صĴ�д���ݡ�
 5.����������Դ��
 �����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʼ��뻺��

 */
class TransClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 10005);
        // ���ľ�����ת���õĿ����д
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in)); // Դ�������ȡ���������������
        BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));// ����Ŀ��������������������
        // ����һ��socket����������ȡ����˷��صĴ�д��Ϣ
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;
        while ((line = bufr.readLine()) != null) { // ���ļ���
            bufOut.write(line);
            if ("over".equals(line)) // д����ͻ��over����ȥ
                break;
            String str = bufIn.readLine(); // �����Ƿ���������������Ϣ
            System.out.println("server:" + str);
        }
        bufr.close();
        s.close();
    }
}

/*
 * �ͻ��� Դ��socket��ȡ�� Ŀ�ģ�socket����� �����ı���װ��һ�¡�
 */
class TransServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10005);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println("�ͻ���Ip" + ip);// ���Լ�����û����
        // OutputStream os=s.getOutputStream();
        // InputStream is =s.getInputStream();
        // Ҫһ���еĶ��ŷ���
        // ��ȡsocket��ȡ���е�����
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // Ŀ�ġ�socket�����������д����д�뵽socket������������͸��ͻ���
        BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        while ((line = bufIn.readLine()) != null) {
            bufOut.write(line.toUpperCase());
        }
        s.close();
        ss.close();
    }
}

/*
 * �����ӳ��ֵ�����. ���󣺿ͻ��˺ͷ���˶���Ī���ĵȵȡ� Ϊʲô�أ� ��Ϊ�ͻ��˺ͷ���˶�������ʽ��������Щ����û�ж���������ǡ���ô��һֱ��
 * ���������ˣ����ڵȴ�
 */
public class Tcp��ϰ����һ���ı�ת�������� {
}
