package com.xuan.xutils.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * IO������������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2013-9-4 ����7:22:40 $
 */
public abstract class IOUtils {
    private static final int EOF = -1;
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    /**
     * ĬĬ�Ĺرտɹر���
     *
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

    /**
     * ��������ָ������д���������
     *
     * @param data     �ַ�������
     * @param output   �����
     * @param encoding ����
     * @throws IOException
     */
    public static void write(String data, OutputStream output, String encoding) throws IOException {
        if (data != null) {
            output.write(data.getBytes(Charsets.toCharset(encoding)));
        }
    }

    /**
     * ���ֽ�����ָ����������ַ���
     *
     * @param input    ������
     * @param encoding ����
     * @return
     * @throws IOException
     */
    public static String toString(InputStream input, String encoding) throws IOException {
        // ���ֽ���ת���ַ���
        InputStreamReader in = new InputStreamReader(input, Charsets.toCharset(encoding));
        int n = 0;
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        while (EOF != (n = in.read(buffer))) {
            if (null != buffer) {
                builder.append(buffer, 0, n);
            }
        }
        return builder.toString();
    }

    /**
     * ������׼ȷ�Ķ���ָ���ֽڣ���ȡ����ϸ��ö�ȡ����ֽ����ʹ����longSize���бȽϣ�ֻҪ����˲ŷ������ݣ������׳��쳣
     *
     * @param input    ������
     * @param longSize ������������������
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input, long longSize) throws IOException {
        if (longSize > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("�����������Ȳ��ܳ���int�ܱ�ʾ�ķ�Χ����ǰ���ȣ� " + longSize);
        }
        int size = (int) longSize;// ת��int
        if (size < 0) {
            throw new IllegalArgumentException("�����������ȱ�����ڵ���0����ǰ���ȣ� " + size);
        }
        if (size == 0) {
            return new byte[0];
        }
        byte[] data = new byte[size];
        int offset = 0;
        int readed;
        while (offset < size && (readed = input.read(data, offset, size - offset)) != EOF) {
            offset += readed;
        }
        if (offset != size) {
            throw new IOException("ʵ�ʶ�ȡ�����ĳ��Ⱥ������ĳ��Ȳ�һ�£�ʵ�ʶ�ȡ���ȣ�" + offset + ", ��������: " + size);
        }
        return data;
    }
}
