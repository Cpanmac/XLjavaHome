package com.xuan.xutils.utils;

import java.math.BigDecimal;

/**
 * ���� Java �ļ����Ͳ��ܹ���ȷ�ĶԸ������������㣬�˹������ṩ��ȷ�ĸ��������㣬�����Ӽ��˳�����������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:53:36 $
 */
public abstract class MathUtils {
    /**
     * Ĭ�ϳ������㾫��
     */
    private static final int DEFAULT_DIV_SCALE = 10;

    /**
     * �ṩ��ȷ�ļӷ����㡣
     *
     * @param v1 ������
     * @param v2 ����
     * @return ���������ĺ�
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = createBigDecimal(v1);
        BigDecimal b2 = createBigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��С�����Ժ�10λ���Ժ�������������롣
     *
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEFAULT_DIV_SCALE);
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㡣 �����������������ʱ����scale����ָ�����ȣ��Ժ�������������롣
     *
     * @param v1    ������
     * @param v2    ����
     * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
     * @return ������������
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = createBigDecimal(v1);
        BigDecimal b2 = createBigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * �ж� double ֵ�Ƿ�Ƿ���ֵΪ Infinite ���� NaN ����ʾ�Ƿ���
     *
     * @param v doube ֵ
     * @return ���ֵΪ Infinite ���� NaN �򷵻� <code>true</code>�����򷵻� <code>false</code>��
     */
    public static boolean isInvalidDouble(double v) {
        return Double.isInfinite(v) || Double.isNaN(v);
    }

    /**
     * �ṩ��ȷ�ĳ˷����㡣
     *
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ļ�
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = createBigDecimal(v1);
        BigDecimal b2 = createBigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * �ṩ��ȷ��С��λ�������봦����� v �ǷǷ��ģ���ԭ�����ء�
     *
     * @param v     ��Ҫ�������������
     * @param scale С���������λ
     * @return ���������Ľ��
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (isInvalidDouble(v)) {
            return v;
        }
        BigDecimal b = createBigDecimal(v);
        return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * �ṩ��ȷ�ļ������㡣
     *
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ĳ�
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = createBigDecimal(v1);
        BigDecimal b2 = createBigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * ���� BigDecimal ���ַ������������г�ʼ����
     *
     * @param v double ֵ
     * @return BigDecimal ����
     */
    private static BigDecimal createBigDecimal(double v) {
        return new BigDecimal(Double.toString(v));
    }
}
