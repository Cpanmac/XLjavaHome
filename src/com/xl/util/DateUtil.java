package com.xl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmm");
    private static SimpleDateFormat sfm = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getDate() {
        Date date = new Date();
        return tf.format(date);
    }

    /**
     * ���ַ���ת������������ yyyy-MM-dd
     *
     * @param date ������ַ���
     * @return ת���ɵ�����ֵ
     */
    public static Date parseDate(String date) {
        Date ret = null;
        if (date != null && date != "") {
            try {
                ret = df.parse(date);
            } catch (ParseException e) {
                ret = null;
            }
        }
        return ret;
    }

    /**
     * ���ַ���ת������������ yyyy-MM-dd HH:mm:ss
     *
     * @param date �����ַ���
     * @return ת���ɵ�����ֵ
     */
    public static Date parseTime(String date) {
        Date ret = null;
        if (date != null && date != "") {
            try {
                ret = tf.parse(date);
            } catch (ParseException e) {
                ret = null;
            }
        }
        return ret;
    }

    /**
     * ����������ת����"yyyy-MM-dd"�ַ���
     *
     * @param date ���������ֵ
     * @return �ַ������͵�����ֵ
     */
    public static String formatDate(Date date) {
        String ret = "";
        try {
            ret = df.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    /**
     * ����������ת����"yyyyMMdd"�ַ���
     *
     * @param date ���������ֵ
     * @return �ַ������͵�����ֵ
     */
    public static String formatDateString(Date date) {
        String ret = "";
        try {
            ret = sf.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    /**
     * �ļ��ϴ�ʱ,�����ļ��� ����������ת����"yyyyMMddHHmmssSSS"�ַ���
     *
     * @param date
     * @return �ַ������͵�����ֵ
     */
    public static String formatFileUploadTime(Date date) {
        String ret = "";
        try {
            ret = sfm.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    /**
     * ����������ת����"yyyy-MM-dd  HH:mm:ss"�ַ���
     *
     * @param date
     * @return �����ַ������͵�����ֵ
     */
    public static String formatTime(Date date) {
        String ret = "";
        try {
            ret = tf.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }
}
