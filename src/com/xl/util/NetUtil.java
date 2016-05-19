package com.xl.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetUtil {
    /**
     * ����url������html�ı�
     *
     * @param url url��ַ
     * @return
     */
    public static String getContent(String url) {
        try {
            URL _url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
            conn.setReadTimeout(20000); // ���ó�ʱ
            conn.setRequestMethod("GET"); // Ĭ����GET,���Բ�������
            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                byte[] content = StreamTool.getBytes(is);
                String code = conn.getHeaderField("Content-Type");
                if (code.contains("GBK")) {
                    return new String(content, "GBK");
                } else {
                    return new String(content, "utf-8"); // Ĭ����UTF-8����
                }
            } else {
                throw new IllegalStateException("��������ʧ��");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ͨ��url��ȡ������
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(String url) {
        try {
            URL _url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
            conn.setConnectTimeout(20000);
            // conn.setRequestMethod("get");//Ϊ�˻�ȡ������Դ,��get����ᱨ�쳣
            int code = conn.getResponseCode();
            if (code == 200) {
                return conn.getInputStream();
            }
        } catch (Exception e) {
            throw new RuntimeException("��ȡurlʧ��");
        }
        return null;
    }
}
