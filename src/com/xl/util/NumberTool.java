package com.xl.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * File Desc:  ���ֹ�����
 * Product Name: SIRM
 * Module Name: Common
 * Author:      �˶�ǿ
 * History:     2011-03-13 created by �˶�ǿ
 */
public class NumberTool {
    public static final int YI = 100000000;//һ��
    public static final int WAN = 10000;//һ��
    private static final int FourDecimalMedian = 4;  //С��λ��

    /**
     * ��objectת�������ͣ�������Ķ�����nullʱ����ָ����ֵ
     *
     * @param o
     * @param dv
     * @return
     */
    public static Integer safeToInteger(Object o, Integer dv) {
        Integer r = dv;
        if (o != null) {
            try {
                r = new Integer(String.valueOf(o));
            } catch (Exception ex) {
            }
        }
        return r;
    }

    /**
     * ��objectת�������ͣ�������Ķ�����nullʱ����ָ����ֵ
     *
     * @param o
     * @param dv
     * @return
     */
    public static Double safeToDouble(Object o, Double dv) {
        Double r = dv;
        if (o != null) {
            try {
                r = new Double(String.valueOf(o));
                if (r.isNaN()) {
                    return dv;
                }
            } catch (Exception ex) {
            }
        }
        return r;
    }

    /**
     * ��objectת�������ͣ�������Ķ�����nullʱ����ָ����ֵ
     *
     * @param o     ��ֵ
     * @param dv    Ĭ��ֵ
     * @param round ��ЧС��λ��
     * @return
     */
    public static Double safeToDouble(Object o, Double dv, int round) {
        Double r = dv;
        if (o != null) {
            try {
                r = new Double(String.valueOf(o));
                if (r.isNaN()) {
                    return dv;
                }
            } catch (Exception ex) {
            }
        }
        r = new BigDecimal(r).setScale(round, BigDecimal.ROUND_HALF_UP).doubleValue();
        return r;
    }

    /**
     * ��objectת�������ͣ�������Ķ�����nullʱ����ָ����ֵ
     *
     * @param o
     * @param dv
     * @return
     */
    public static Float safeToFloat(Object o, Float dv) {
        Float r = dv;
        if (o != null) {
            try {
                r = new Float(String.valueOf(o));
                if (r.isNaN()) {
                    return dv;
                }
            } catch (Exception ex) {
            }
        }
        return r;
    }

    /**
     * ��objectת����float��������Ķ�����nullʱ����ָ����ֵ
     *
     * @param o     ��ֵ
     * @param dv    Ĭ��ֵ
     * @param round ��ЧС��λ��
     */
    public static Float safeToFloat(Object o, Float dv, int round) {
        Float r = dv;
        if (o != null) {
            try {
                r = new Float(String.valueOf(o));
                if (r.isNaN()) {
                    return dv;
                }
            } catch (Exception ex) {
            }
        }
        r = new BigDecimal(r).setScale(round, BigDecimal.ROUND_HALF_UP).floatValue();
        return r;
    }

    /**
     * String���� ת BigDecimal����
     *
     * @return paraValue
     */
    public static BigDecimal stringToBigDecimal(String paraValue) {
        try {
            BigDecimal bDecimal = null;
            if (paraValue.indexOf("%") == -1) {
                return new BigDecimal(Double.valueOf(paraValue.trim().replace(",", ""))).setScale(4, BigDecimal.ROUND_HALF_UP);
            } else {
                return new BigDecimal(Double.valueOf(paraValue.trim().replace("%", "")) / 100).setScale(FourDecimalMedian, BigDecimal.ROUND_HALF_UP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * String���� ת BigDecimal����
     *
     * @return paraValue
     */
    public static BigDecimal stringToBigDecimalTwoSpilt(String paraValue) {
        try {
            BigDecimal bDecimal = null;
            if (paraValue.indexOf("%") == -1) {
                return new BigDecimal(Double.valueOf(paraValue.trim().replace(",", ""))).setScale(2, BigDecimal.ROUND_HALF_UP);
            } else {
                return new BigDecimal(Double.valueOf(paraValue.trim().replace("%", "")) / 100).setScale(FourDecimalMedian, BigDecimal.ROUND_HALF_UP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * aParaValueֵ - bParaValueֵ
     *
     * @return BigDecimal
     */
    public static BigDecimal aSubtractB(BigDecimal aParaValue, BigDecimal bParaValue) {
        try {
            return aParaValue.subtract(bParaValue).setScale(FourDecimalMedian, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * aParaValueֵ / bParaValueֵ
     *
     * @return BigDecimal
     */
    public static BigDecimal aDivideB(BigDecimal aParaValue, BigDecimal bParaValue) {
        try {
            return aParaValue.divide(bParaValue, FourDecimalMedian).setScale(FourDecimalMedian, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static double avg(double[] sequenceArr) {
        if (sequenceArr != null && sequenceArr.length > 0) {
            double sum = 0.00;
            int T = sequenceArr.length;
            for (int i = 0; i < T; i++) {
                sum += sequenceArr[i];
            }
            return sum / T;
        }
        return 0.00;
    }

    public static double round(double value, int count) {
        int t = (int) Math.pow(10.0, (double) (count + 1));
        return ((double) Math.round(value * t)) / t;
    }

    public static Double getFourDecimalNumber(Number number) {
        if (number == null || (0.00 == number.doubleValue())) {
            return 0.0000;
        }
        NumberFormat format = new DecimalFormat("##0.0000");
        return Double.valueOf(format.format(number));
    }

    /**
     * ��ָ��Map�л�ȡָ��Key�� ֵ��������ֵתΪInteger�ͣ���Map��ָ��Key�����ڣ���ֱ�ӷ���Ĭ��ֵ
     *
     * @param map          Map
     * @param key          Key
     * @param defaultValue Ĭ��ֵ
     * @return ��Mapֵת�����Integerֵ�����������򷵻�Ĭ��ֵ
     */
    public static Integer convertMapKeyToInt(Map map, String key, Integer defaultValue) {
        return safeToInteger(map.get(key), defaultValue);
    }

    /**
     * ��ָ��Map�л�ȡָ��Key��ֵ��������ֵתΪInteger�ͣ���Map��ָ��Key�����ڣ���ֱ�ӷ���0
     *
     * @param map Map
     * @param key Key
     * @return ��Mapֵת�����Integerֵ�����������򷵻�0
     */
    public static Integer convertMapKeyToInt(Map map, String key) {
        return convertMapKeyToInt(map, key, 0);
    }

    /**
     * ��int����ת�����Զ��ŷָ����ַ���
     *
     * @param intArray
     * @return
     */
    public static String convertIntArrayToString(int[] intArray) {
        if (intArray.length <= 0)
            return "";
        String _string = "";
        for (int _int : intArray) {
            _string += _string.equals("") ? new Integer(_int).toString() : "," + new Integer(_int).toString();
        }
        return _string;
    }

    /**
     * �ṩ��ȷ�ļӷ����㡣
     *
     * @param v1
     * @param v2
     * @return ���������ĺ�
     */
    public static Double safeAdd(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.add(b2).doubleValue();
        }
        return null;
    }

    /**
     * �ṩ��ȷ�ļ������㡣
     *
     * @param v1 ����
     * @param v2 ������
     * @return ���������Ĳ�
     */
    public static Double safeSub(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.subtract(b2).doubleValue();
        }
        return null;
    }

    /**
     * �ṩ��ȷ�ĳ�������,ʹ��Ĭ�Ͼ�ȷ�ȡ�
     *
     * @param v1 ����
     * @param v2 ������
     * @return ��������������
     */
    public static Double safeDiv(Double v1, Double v2) {
        return safeDiv(v1, v2, FourDecimalMedian);
    }

    /**
     * �ṩ��ȷ�ĳ������㡣
     *
     * @param v1    ����
     * @param v2    ������
     * @param sacle ��ȷ��
     * @return ��������������
     */
    public static Double safeDiv(Double v1, Double v2, int sacle) {
        if (v1 != null && v2 != null && v2 != 0.0) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, sacle, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return null;
    }

    /**
     * �ṩ��ȷ�ĳ˷����㡣
     *
     * @param v1
     * @param v2
     * @return ���������Ļ�
     */
    public static Double safeMul(Double v1, Double v2) {
        if (v1 != null && v2 != null) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.multiply(b2).doubleValue();
        }
        return null;
    }

    /**
     * ��ʽ������
     *
     * @param number  ����
     * @param pattern ��ʽ
     * @return
     */
    public static String formateNumber(double number, String pattern) {
        if (number == 0) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }

    public static String formatNumber(String number, String pattern) {
        if (StringUtil.isEmpty(number)) {
            return "";
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(safeToDouble(number, 0D));
    }
}

