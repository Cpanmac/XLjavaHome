package com.xl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * ���ֹ�����<br>
 * ���ھ�ȷֵ����Ӧ��ʹ�� {@link BigDecimal}<br>
 * JDK7��<strong>BigDecimal(double val)</strong>���췽���Ľ����һ���Ĳ���Ԥ֪�ԣ����磺
 * <p>
 * <pre>
 * new BigDecimal(0.1)
 * </pre>
 * <p>
 * ��ʾ�Ĳ���<strong>0.1</strong>����<strong>0.1000000000000000055511151231257827021181583404541015625</strong>
 * <p>
 * <p>
 * ������Ϊ0.1�޷�׼ȷ�ı�ʾΪdouble�����Ӧ��ʹ��<strong>new BigDecimal(String)</strong>��
 * </p>
 * ��ؽ��ܣ�
 * <ul>
 * <li>http://www.oschina.net/code/snippet_563112_25237</li>
 * <li>https://github.com/venusdrogon/feilong-core/wiki/one-jdk7-bug-thinking</li>
 * </ul>
 *
 * @author Looly
 */
public class NumberUtil {
    /**
     * Ĭ�ϳ������㾫��
     */
    private static final int DEFAUT_DIV_SCALE = 10;

    private NumberUtil() {
    }

    /**
     * �ṩ��ȷ�ļӷ�����
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     */
    public static double add(double v1, double v2) {
        return add(Double.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * �ṩ��ȷ�ļӷ�����
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     * @since 3.0.8
     */
    public static BigDecimal add(String v1, String v2) {
        final BigDecimal b1 = new BigDecimal(v1);
        final BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * �ṩ��ȷ�ļ�������
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     */
    public static double sub(double v1, double v2) {
        return sub(Double.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * �ṩ��ȷ�ļ�������
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     * @since 3.0.8
     */
    public static BigDecimal sub(String v1, String v2) {
        final BigDecimal b1 = new BigDecimal(v1);
        final BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * �ṩ��ȷ�ĳ˷�����
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     */
    public static double mul(double v1, double v2) {
        return mul(Double.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * �ṩ��ȷ�ĳ˷�����
     *
     * @param v1 ������
     * @param v2 ����
     * @return ��
     * @since 3.0.8
     */
    public static BigDecimal mul(String v1, String v2) {
        final BigDecimal b1 = new BigDecimal(v1);
        final BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�������������������ʱ��,��ȷ��С�����10λ,�������������
     *
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEFAUT_DIV_SCALE);
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�������������������ʱ��,��ȷ��С�����10λ,�������������
     *
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static BigDecimal div(String v1, String v2) {
        return div(v1, v2, DEFAUT_DIV_SCALE);
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��,�������������
     *
     * @param v1    ������
     * @param v2    ����
     * @param scale ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
     * @return ������������
     */
    public static double div(double v1, double v2, int scale) {
        return div(v1, v2, scale, RoundingMode.HALF_UP);
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��,�������������
     *
     * @param v1    ������
     * @param v2    ����
     * @param scale ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
     * @return ������������
     */
    public static BigDecimal div(String v1, String v2, int scale) {
        return div(v1, v2, scale, RoundingMode.HALF_UP);
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��
     *
     * @param v1           ������
     * @param v2           ����
     * @param scale        ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
     * @param roundingMode ����С����ģʽ {@link RoundingMode}
     * @return ������������
     */
    public static double div(double v1, double v2, int scale, RoundingMode roundingMode) {
        return div(Double.toString(v1), Double.toString(v2), scale, roundingMode).doubleValue();
    }

    /**
     * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��
     *
     * @param v1           ������
     * @param v2           ����
     * @param scale        ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
     * @param roundingMode ����С����ģʽ {@link RoundingMode}
     * @return ������������
     */
    public static BigDecimal div(String v1, String v2, int scale, RoundingMode roundingMode) {
        if (scale < 0) {
            scale = -scale;
        }
        final BigDecimal b1 = new BigDecimal(v1);
        final BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, roundingMode);
    }
    // ------------------------------------------------------------------------------------------- round

    /**
     * �����̶�λ��С��<br>
     * ��������������� {@link RoundingMode#HALF_UP}<br>
     * ���籣��2λС����123.456789 =�� 123.46
     *
     * @param v     ֵ
     * @param scale ����С��λ��
     * @return ��ֵ
     */
    public static double round(double v, int scale) {
        return round(v, scale, RoundingMode.HALF_UP);
    }

    /**
     * �����̶�λ��С��<br>
     * ��������������� {@link RoundingMode#HALF_UP}<br>
     * ���籣��2λС����123.456789 =�� 123.46
     *
     * @param numberStr ����ֵ���ַ���������ʽ
     * @param scale     ����С��λ��
     * @return ��ֵ
     */
    public static double round(String numberStr, int scale) {
        return round(numberStr, scale, RoundingMode.HALF_UP);
    }

    /**
     * �����̶�λ��С��<br>
     * ���籣����λС����123.456789 =�� 123.4567
     *
     * @param v            ֵ
     * @param scale        ����С��λ��
     * @param roundingMode ����С����ģʽ {@link RoundingMode}
     * @return ��ֵ
     */
    public static double round(double v, int scale, RoundingMode roundingMode) {
        return round(Double.toString(v), scale, roundingMode);
    }

    /**
     * �����̶�λ��С��<br>
     * ���籣����λС����123.456789 =�� 123.4567
     *
     * @param numberStr    ����ֵ���ַ���������ʽ
     * @param scale        ����С��λ��
     * @param roundingMode ����С����ģʽ {@link RoundingMode}
     * @return ��ֵ
     */
    public static double round(String numberStr, int scale, RoundingMode roundingMode) {
        final BigDecimal b = new BigDecimal(numberStr);
        return b.setScale(scale, roundingMode).doubleValue();
    }

    /**
     * ����С��λ��������������
     *
     * @param number ������С��������
     * @param digit  ������С��λ��
     * @return ����С������ַ���
     */
    public static String roundStr(double number, int digit) {
        return String.format("%." + digit + 'f', number);
    }
    // ------------------------------------------------------------------------------------------- decimalFormat

    /**
     * ��ʽ��double<br>
     * �� {@link DecimalFormat} ����װ<br>
     *
     * @param pattern ��ʽ ��ʽ����Ҫ�� # �� 0 ����ռλ������ָ�����ֳ��ȡ�0 ��ʾ���λ���������� 0 ��䣬# ��ʾֻҪ�п��ܾͰ������������λ�á�<br>
     *                <ul>
     *                <li>0 =�� ȡһλ����</li>
     *                <li>0.00 =�� ȡһλ��������λС��</li>
     *                <li>00.000 =�� ȡ��λ��������λС��</li>
     *                <li># =�� ȡ������������</li>
     *                <li>#.##% =�� �԰ٷֱȷ�ʽ��������ȡ��λС��</li>
     *                <li>#.#####E0 =�� ��ʾΪ��ѧ����������ȡ��λС��</li>
     *                <li>,### =�� ÿ��λ�Զ��Ž��зָ������磺299,792,458</li>
     *                <li>���ٴ�СΪÿ��,###�� =�� ����ʽǶ���ı�</li>
     *                </ul>
     * @param value   ֵ
     * @return ��ʽ�����ֵ
     */
    public static String decimalFormat(String pattern, double value) {
        return new DecimalFormat(pattern).format(value);
    }

    /**
     * ��ʽ��double<br>
     * �� {@link DecimalFormat} ����װ<br>
     *
     * @param pattern ��ʽ ��ʽ����Ҫ�� # �� 0 ����ռλ������ָ�����ֳ��ȡ�0 ��ʾ���λ���������� 0 ��䣬# ��ʾֻҪ�п��ܾͰ������������λ�á�<br>
     *                <ul>
     *                <li>0 =�� ȡһλ����</li>
     *                <li>0.00 =�� ȡһλ��������λС��</li>
     *                <li>00.000 =�� ȡ��λ��������λС��</li>
     *                <li># =�� ȡ������������</li>
     *                <li>#.##% =�� �԰ٷֱȷ�ʽ��������ȡ��λС��</li>
     *                <li>#.#####E0 =�� ��ʾΪ��ѧ����������ȡ��λС��</li>
     *                <li>,### =�� ÿ��λ�Զ��Ž��зָ������磺299,792,458</li>
     *                <li>���ٴ�СΪÿ��,###�� =�� ����ʽǶ���ı�</li>
     *                </ul>
     * @param value   ֵ
     * @return ��ʽ�����ֵ
     * @since 3.0.5
     */
    public static String decimalFormat(String pattern, long value) {
        return new DecimalFormat(pattern).format(value);
    }
    // ------------------------------------------------------------------------------------------- isXXX

    /**
     * �Ƿ�Ϊ����
     *
     * @param str �ַ���ֵ
     * @return �Ƿ�Ϊ����
     */
    public static boolean isNumber(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        int start = (chars[0] == '-') ? 1 : 0;
        if (sz > start + 1) {
            if (chars[start] == '0' && chars[start + 1] == 'x') {
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f') && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--; // don't want to loop to the last char, check it afterwords
        // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;
            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l' || chars[i] == 'L') {
                // not allowing L with an exponent
                return foundDigit && !hasExp;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }

    /**
     * �ж�String�Ƿ�������
     *
     * @param s String
     * @return �Ƿ�Ϊ����
     */
    public static boolean isInteger(String s) {
        if (StringUtil.isNotEmpty(s))
            return s.matches("^\\d+$");
        else
            return false;
    }

    /**
     * �ж��ַ����Ƿ��Ǹ�����
     *
     * @param s String
     * @return �Ƿ�Ϊ{@link Double}����
     */
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            if (s.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * �Ƿ�������<br>
     * ������������ֳ�������ָ������һ������1����Ȼ����,����1�ʹ�����������,û����������Ȼ������������
     *
     * @param n ����
     * @return �Ƿ�������
     */
    public static boolean isPrimes(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    // ------------------------------------------------------------------------------------------- generateXXX

    /**
     * ���ɲ��ظ������ ���ݸ�������С���ֺ�������֣��Լ�������ĸ���������ָ���Ĳ��ظ�������
     *
     * @param begin ��С���֣�����������
     * @param end   ������֣�������������
     * @param size  ָ������������ĸ���
     * @return ���int����
     */
    public static int[] generateRandomNumber(int begin, int end, int size) throws Exception {
        if (begin > end) {
            int temp = begin;
            begin = end;
            end = temp;
        }
        // �����߼��жϣ�ȷ��begin<end����size���ܴ��ڸñ�ʾ��Χ
        if ((end - begin) < size) {
            throw new Exception("Size is larger than range between begin and end!");
        }
        // ����������������ɣ��������ظ�
        int[] seed = new int[end - begin];
        for (int i = begin; i < end; i++) {
            seed[i - begin] = i;
        }
        int[] ranArr = new int[size];
        Random ran = new Random();
        // ����������Լ����塣
        for (int i = 0; i < size; i++) {
            // �õ�һ��λ��
            int j = ran.nextInt(seed.length - i);
            // �õ��Ǹ�λ�õ���ֵ
            ranArr[i] = seed[j];
            // �����һ��δ�õ����ַŵ�����
            seed[j] = seed[seed.length - 1 - i];
        }
        return ranArr;
    }

    /**
     * ���ɲ��ظ������ ���ݸ�������С���ֺ�������֣��Լ�������ĸ���������ָ���Ĳ��ظ�������
     *
     * @param begin ��С���֣�����������
     * @param end   ������֣�������������
     * @param size  ָ������������ĸ���
     * @return ���int����
     */
    public static Integer[] generateBySet(int begin, int end, int size) throws Exception {
        if (begin > end) {
            int temp = begin;
            begin = end;
            end = temp;
        }
        // �����߼��жϣ�ȷ��begin<end����size���ܴ��ڸñ�ʾ��Χ
        if ((end - begin) < size) {
            throw new Exception("Size is larger than range between begin and end!");
        }
        Random ran = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < size) {
            set.add(begin + ran.nextInt(end - begin));
        }
        Integer[] ranArr = set.toArray(new Integer[size]);
        return ranArr;
    }
    // ------------------------------------------------------------------------------------------- range

    /**
     * ������Χ�ڵ������б�����Ϊ1
     *
     * @param start ��ʼ��������
     * @param stop  ������������
     * @return �����б�
     */
    public static int[] range(int start, int stop) {
        return range(start, stop, 1);
    }

    /**
     * ������Χ�ڵ������б�
     *
     * @param start ��ʼ��������
     * @param stop  ������������
     * @param step  ����
     * @return �����б�
     */
    public static int[] range(int start, int stop, int step) {
        if (start < stop) {
            step = Math.abs(step);
        } else if (start > stop) {
            step = -Math.abs(step);
        } else {// start == end
            return new int[]{start};
        }
        int size = Math.abs((stop - start) / step) + 1;
        int[] values = new int[size];
        int index = 0;
        for (int i = start; (step > 0) ? i <= stop : i >= stop; i += step) {
            values[index] = i;
            index++;
        }
        return values;
    }

    /**
     * ��������Χ�ڵ�������ӵ����м����У�����Ϊ1
     *
     * @param start  ��ʼ��������
     * @param stop   ������������
     * @param values ����
     * @return ����
     */
    public static Collection<Integer> appendRange(int start, int stop, Collection<Integer> values) {
        return appendRange(start, stop, 1, values);
    }

    /**
     * ��������Χ�ڵ�������ӵ����м�����
     *
     * @param start  ��ʼ��������
     * @param stop   ������������
     * @param step   ����
     * @param values ����
     * @return ����
     */
    public static Collection<Integer> appendRange(int start, int stop, int step, Collection<Integer> values) {
        if (start < stop) {
            step = Math.abs(step);
        } else if (start > stop) {
            step = -Math.abs(step);
        } else {// start == end
            values.add(start);
            return values;
        }
        for (int i = start; (step > 0) ? i <= stop : i >= stop; i += step) {
            values.add(i);
        }
        return values;
    }
    // ------------------------------------------------------------------------------------------- others

    /**
     * �׳ˣ�n!
     *
     * @param n ֵ
     * @return �׳�
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * ƽ�����㷨<br>
     * �Ƽ�ʹ�� {@link Math#sqrt(double)}
     *
     * @param x ֵ
     * @return ƽ����
     */
    public static long sqrt(long x) {
        long y = 0;
        long b = (~Long.MAX_VALUE) >>> 1;
        while (b > 0) {
            if (x >= y + b) {
                x -= y + b;
                y >>= 1;
                y += b;
            } else {
                y >>= 1;
            }
            b >>= 2;
        }
        return y;
    }

    /**
     * �������ڼ���˫ɫ�򡢴���͸ע���ķ���<br>
     * �������͸35ѡ5������������processMultiple(7,5); ������ѧ�еģ�C75=7*6/2*1
     *
     * @param selectNum ѡ��С�����
     * @param minNum    ����Ҫѡ�ж��ٸ�С��
     * @return ע��
     */
    public static int processMultiple(int selectNum, int minNum) {
        int result;
        result = mathSubnode(selectNum, minNum) / mathNode(selectNum - minNum);
        return result;
    }

    /**
     * ���Լ��
     *
     * @param m ��һ��ֵ
     * @param n �ڶ���ֵ
     * @return ���Լ��
     */
    public static int divisor(int m, int n) {
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    /**
     * ��С������
     *
     * @param m ��һ��ֵ
     * @param n �ڶ���ֵ
     * @return ��С������
     */
    public static int multiple(int m, int n) {
        return m * n / divisor(m, n);
    }

    /**
     * ������ֶ�Ӧ�Ķ������ַ���
     *
     * @param number ����
     * @return �������ַ���
     */
    public static String getBinaryStr(Number number) {
        if (number instanceof Long) {
            return Long.toBinaryString((Long) number);
        } else if (number instanceof Integer) {
            return Integer.toBinaryString((Integer) number);
        } else {
            return Long.toBinaryString(number.longValue());
        }
    }

    /**
     * ������תint
     *
     * @param binaryStr �������ַ���
     * @return int
     */
    public static int binaryToInt(String binaryStr) {
        return Integer.parseInt(binaryStr, 2);
    }

    /**
     * ������תlong
     *
     * @param binaryStr �������ַ���
     * @return long
     */
    public static long binaryToLong(String binaryStr) {
        return Long.parseLong(binaryStr, 2);
    }
    // ------------------------------------------------------------------------------------------- compare

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Character#compare(char, char)
     * @since 3.0.1
     */
    public static int compare(char x, char y) {
        return x - y;
    }

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Double#compare(double, double)
     * @since 3.0.1
     */
    public static int compare(double x, double y) {
        return Double.compare(x, y);
    }

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Integer#compare(int, int)
     * @since 3.0.1
     */
    public static int compare(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Long#compare(long, long)
     * @since 3.0.1
     */
    public static int compare(long x, long y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Short#compare(short, short)
     * @since 3.0.1
     */
    public static int compare(short x, short y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * �Ƚ�����ֵ�Ĵ�С
     *
     * @param x ��һ��ֵ
     * @param y �ڶ���ֵ
     * @return x==y����0��x&lt;y����-1��x&gt;y����1
     * @see Byte#compare(byte, byte)
     * @since 3.0.1
     */
    public static int compare(byte x, byte y) {
        return x - y;
    }

    /**
     * ����ת�ַ���<br>
     * ����{@link Number#toString()}����ȥ��βС�����������0
     *
     * @param number A Number
     * @return A String.
     */
    public static String toStr(Number number) {
        if (number == null) {
            throw new NullPointerException("Number is null !");
        }
        // ȥ��С�����������0
        String string = number.toString();
        if (string.indexOf('.') > 0 && string.indexOf('e') < 0 && string.indexOf('E') < 0) {
            while (string.endsWith("0")) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.endsWith(".")) {
                string = string.substring(0, string.length() - 1);
            }
        }
        return string;
    }

    /**
     * �Ƿ�հ׷�<br>
     * �հ׷������ո��Ʊ����ȫ�ǿո�Ͳ���Ͽո�<br>
     *
     * @param c �ַ�
     * @return �Ƿ�հ׷�
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     * @since 3.0.6
     */
    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }

    /**
     * �Ƿ�հ׷�<br>
     * �հ׷������ո��Ʊ����ȫ�ǿո�Ͳ���Ͽո�<br>
     *
     * @param c �ַ�
     * @return �Ƿ�հ׷�
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     * @since 3.0.6
     */
    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    /**
     * ����ȷݸ���
     *
     * @param total ����
     * @param part  ÿ�ݵĸ���
     * @return �ֳ��˼���
     * @since 3.0.6
     */
    public static int count(int total, int part) {
        return (total % part == 0) ? (total / part) : (total / part + 1);
    }

    // ------------------------------------------------------------------------------------------- Private method start
    private static int mathSubnode(int selectNum, int minNum) {
        if (selectNum == minNum) {
            return 1;
        } else {
            return selectNum * mathSubnode(selectNum - 1, minNum);
        }
    }

    private static int mathNode(int selectNum) {
        if (selectNum == 0) {
            return 1;
        } else {
            return selectNum * mathNode(selectNum - 1);
        }
    }
    // ------------------------------------------------------------------------------------------- Private method end
}
