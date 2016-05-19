package com.xl.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 13-12-26
 * Time: ����4:21
 * To change this template use File | Settings | File Templates.
 */
public class NumberCalculateUtil {
    //��
    public static final Integer UNIT_W = 10000;
    //����
    public static final Integer UNIT_BW = 1000000;
    //��
    public static final Integer UNIT_Y = 100000000;
    //��λ
    public static final String[] UNIT = {"��Ԫ", "����Ԫ", "��Ԫ"};

    /**
     * �����ݼ򵥼ӷ�����
     *
     * @param numbers
     * @return
     */
    public static BigDecimal numberAddCalculate(String[] numbers) {
        BigDecimal decimal = new BigDecimal(0D);
        for (String num : numbers) {
            if (StringUtil.isNotEmpty(num)) {
                decimal = decimal.add(new BigDecimal(formatNumber(num, "0")));
            }
        }
        return decimal;
    }

    /**
     * ��λ
     *
     * @param numbers
     * @param unit
     * @return
     */
    public static BigDecimal multiplyCalculate(String numbers, int unit) {
        BigDecimal decimal = new BigDecimal(formatNumber(numbers, "0"));
        return decimal.multiply(new BigDecimal(unit));
    }

    /**
     * �����ݼ򵥼�������
     *
     * @param number  ����
     * @param numbers ������
     * @return
     */
    public static BigDecimal subtractCalculate(String number, String[] numbers) {
        BigDecimal decimal = new BigDecimal(formatNumber(number, "0"));
        for (String num : numbers) {
            if (StringUtil.isNotEmpty(num)) {
                decimal = decimal.subtract(new BigDecimal(formatNumber(num, "0")));
            }
        }
        return decimal;
    }

    /**
     * �����ݼ򵥳˷�����
     *
     * @param numbers
     * @return
     */
    public static BigDecimal multiplyCalculate(String[] numbers) {
        BigDecimal decimal = new BigDecimal(1);
        for (String num : numbers) {
            if (StringUtil.isNotEmpty(num)) {
                decimal = decimal.multiply(new BigDecimal(formatNumber(num, "0")));
            }
        }
        return decimal;
    }

    /**
     * �����ݼ򵥳�������
     *
     * @param number  ����
     * @param numbers ������
     * @return
     */
    public static BigDecimal divideCalculate(String number, String[] numbers) {
        BigDecimal decimal = new BigDecimal(formatNumber(number, "0"));
        for (String num : numbers) {
            if (StringUtil.isNotEmpty(num)) {
                decimal = decimal.divide(new BigDecimal(formatNumber(num, "1")), 15, BigDecimal.ROUND_HALF_UP);
            }
        }
        return decimal;
    }

    /**
     * ��λ
     *
     * @param number
     * @param unit
     * @return
     */
    public static BigDecimal divideCalculate(String number, int unit) {
        BigDecimal decimal = new BigDecimal(formatNumber(number, "0"));
        return decimal.divide(new BigDecimal(unit), 15, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ��ʽ��λ
     *
     * @param number
     * @return
     */
    public static String formatUnit(String number) {
        BigDecimal decimal = divideCalculate(number, UNIT_W);
        DecimalFormat format = null;
        if (decimal.intValue() <= 0) {
            return NumberTool.formateNumber(decimal.doubleValue(), "#,##0.00") + "Ԫ";
        }
        if (decimal.intValue() < 100) {
            return NumberTool.formateNumber(decimal.doubleValue(), "#,###.#####") + UNIT[0];
        }
        decimal = divideCalculate(number, UNIT_BW);
        if (decimal.intValue() < 100) {
            return NumberTool.formateNumber(decimal.doubleValue(), "#,###.#######") + UNIT[1];
        }
        decimal = divideCalculate(number, UNIT_Y);
        return NumberTool.formateNumber(decimal.doubleValue(), "#,###.#########") + UNIT[2];
    }

    /**
     * ��ʽ��number����
     *
     * @param num
     * @return
     */
    public static String formatNumber(String num, String dev) {
        if (StringUtil.isNotEmpty(num))
            return dev;
        return num.replaceAll(",", "").trim();
    }

    public static void main(String[] args) {
        System.out.print(NumberCalculateUtil.multiplyCalculate("808", NumberCalculateUtil.UNIT_Y));
    }
}
