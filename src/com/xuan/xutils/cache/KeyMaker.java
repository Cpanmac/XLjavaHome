package com.xuan.xutils.cache;

/**
 * �������ɹ��ߣ��������ɷŵ������еļ����ָ���ΪTab��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:40:30 $
 */
public class KeyMaker {
    private static final String SEPARATOR = "\t";

    /**
     * ���췽��
     */
    public KeyMaker() {
    }

    /**
     * �������ַ������һ����
     *
     * @param arg1 �ַ���1
     * @param arg2 �ַ���2
     * @return ��
     */
    public static String getKey(String arg1, String arg2) {
        StringBuilder key = new StringBuilder();
        key.append(arg1);
        key.append(SEPARATOR);
        key.append(arg2);
        return key.toString();
    }

    /**
     * �������ַ������һ����
     *
     * @param arg1 �ַ���1
     * @param arg2 �ַ���2
     * @param arg3 �ַ���3
     * @return ��
     */
    public static String getKey(String arg1, String arg2, String arg3) {
        StringBuilder key = new StringBuilder();
        key.append(arg1);
        key.append(SEPARATOR);
        key.append(arg2);
        key.append(SEPARATOR);
        key.append(arg3);
        return key.toString();
    }

    /**
     * ���ַ���������������һ����
     *
     * @param args �ַ�������
     * @return ��
     */
    public static String getKey(String[] args) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                key.append(SEPARATOR);
            }
            key.append(args[i]);
        }
        return key.toString();
    }

    /**
     * �ָ����Ϊ�ַ�������
     *
     * @param key ��
     * @return �ַ�������
     */
    public static String[] splitKey(String key) {
        return key.split(SEPARATOR);
    }
}
