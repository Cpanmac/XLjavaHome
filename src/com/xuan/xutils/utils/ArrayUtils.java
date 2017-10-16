package com.xuan.xutils.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ���鹤����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:56:54 $
 */
public abstract class ArrayUtils {
    /**
     * ��ʾ�ַ�����������ݣ���,�ָ�
     *
     * @param args �ַ�������
     * @return �ַ������������
     */
    public static String toString(String[] args) {
        return toString(args, ",");
    }

    /**
     * ��ʾ�ַ������������
     *
     * @param args      �ַ�������
     * @param separator �ָ���
     * @return �ַ������������
     */
    public static String toString(String[] args, String separator) {
        if (args == null || args.length == 0) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                buffer.append(separator);
            }
            buffer.append(args[i]);
        }
        return buffer.toString();
    }

    /**
     * ȡ���ַ�������ĵ�һ��Ԫ��
     *
     * @param stringArray �ַ�������
     * @return �ַ�������ĵ�һ��Ԫ��
     */
    public static String getFirst(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return null;
        }
        return stringArray[0];
    }

    /**
     * ȡ������ĵ�һ��Ԫ��
     *
     * @param array ����
     * @return ����ĵ�һ��Ԫ��
     */
    public static Object getFirst(Object[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }

    /**
     * ��Listת�����ַ�������
     *
     * @param list �ַ���List
     * @return �ַ�������
     */
    public static String[] toArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    /**
     * ��Setת�����ַ�������
     *
     * @param set �ַ���Set
     * @return �ַ�������
     */
    public static String[] toArray(Set<String> set) {
        return set.toArray(new String[set.size()]);
    }

    /**
     * �ж��ַ��������Ƿ����ָ�����ַ���
     *
     * @param array �ַ�������
     * @param str   ָ�����ַ���
     * @return ����true������false
     */
    public static boolean contains(String[] array, String str) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null && str == null) {
                return true;
            }
            if (array[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * �ж��ַ��������Ƿ��в�ΪEmpty��ֵ
     *
     * @param args �ַ�������
     * @return ��true������false
     */
    public static boolean hasValue(String[] args) {
        if (args == null || args.length == 0 || (args.length == 1 && args[0] == null)) {
            return false;
        }
        for (int i = 0, length = args.length; i < length; i++) {
            if (args[i] != null || args[i].trim().length() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * ������������
     *
     * @param first ��һ������
     * @param last  ��һ������
     * @return ���ݺϲ��������
     */
    public static Object[] combine(Object[] first, Object[] last) {
        if (first.length == 0 && last.length == 0) {
            return null;
        }
        Object[] result = new Object[first.length + last.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(last, 0, result, first.length, last.length);
        return result;
    }

    /**
     * ������ת���� �б��������Ϊ null����᷵��һ�����б�
     *
     * @param array ����
     * @return �б����
     */
    public static List<Object> toList(Object[] array) {
        ArrayList<Object> list = new ArrayList<Object>();
        if (array == null) {
            return list;
        }
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    /**
     * ����ַ��������е�null
     *
     * @param array �ַ�������
     * @return ���null����ַ�������
     */
    public static String[] clearNull(String[] array) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                list.add(array[i]);
            }
        }
        return toArray(list);
    }
}
