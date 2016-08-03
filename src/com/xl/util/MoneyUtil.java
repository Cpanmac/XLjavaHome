/*
 *���ҹ�����
 * Amount2RMB.java 2008-6-15
 */
package com.xl.util;

import org.apache.log4j.Logger;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyUtil {
    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$"); // �����Ƿָ�������ȷ��
    private static final char[] RMB_NUMS = "��Ҽ��������½��ƾ�".toCharArray();
    private static final String[] UNITS = {"Ԫ", "��", "��", "��"};
    private static final String[] U1 = {"", "ʰ", "��", "Ǫ"};
    private static final String[] U2 = {"", "��", "��"};
    private static final String[] unms = new String[]{"��", "һ", "��", "��", "��", "��", "��", "��", "��", "��"};
    private static final String[] digits = new String[]{"", "ʮ", "��", "ǧ"};
    private static final String[] units = new String[]{"", "��", "��", "����"};
    private static Logger LOGGER = Logger.getLogger(MoneyUtil.class);

    public static String amountToChinese(double amount, boolean withUnit) {
        if (amount == 0) {
            return convert("0.00");
        }
        DecimalFormat format = new DecimalFormat("####0.00");
        String toDo = format.format(amount);
        String result = convert(toDo);
        if (!withUnit) {
            result = result.replaceAll("Ԫ", "");
            result = result.replaceAll("��", "");
            result = result.replaceAll("��", "");
            result = result.replaceAll("��", "");
        }
        return result;
    }

    public static String numberToChinese(Integer number) {
        return transfrom(StringUtil.safeToString(number, ""));
    }

    private static String transfrom(String x) {
        if (null == x) {
            return "";
        }
        if (0 == x.length()) {
            return "";
        }
        if (!checkIsNumbers(x)) {
            return "";
        }
        if (x.length() > 16) {
            return "";
        }
        if (x.equals("0")) {
            return "��";
        }
        //ȥ���ַ����ײ���0�����磺0010->10
        int fm;
        for (fm = 0; fm < x.length(); fm++) {
            if (x.charAt(fm) != '0') {
                break;
            }
        }
        x = x.substring(fm);//ȥ�����
        //���ַ�������һЩ�飬���磺123456789->1,2345,6789
        String result = "";
        int p = 0;
        int m = x.length() % 4;
        int k = (m > 0 ? x.length() / 4 + 1 : x.length() / 4);
        //������ߵ����鿪ʼ������ѭ��
        for (int i = k; i > 0; i--) {
            int len = 4;
            if (i == k && m != 0)//��iΪ����ߵ�����ʱ���鳤�ȿ����б仯
            {
                len = m;
            }
            String s = x.substring(p, p + len);
            int le = s.length();
            for (int j = 0; j < le; j++) {
                int n = Integer.parseInt(s.substring(j, j + 1));
                if (0 == n) {
                    if (j < le - 1 && Integer.parseInt(s.substring(j + 1, j + 2)) > 0 && !result.endsWith(unms[0])) {//�������������Ϊ���һλ && ��һλ���ִ���0 && ��ǰû�мӹ����㡱
                        result += unms[0];
                    }
                } else {
                    if (!(n == 1 && (result.endsWith(unms[0]) || result.length() == 0) && j == le - 2)) {//����1013һǧ��"ʮ��"��1113 һǧһ��"һʮ��"
                        result += unms[n];
                    }
                    result += digits[le - j - 1];
                }
            }
            if (0 != Integer.parseInt(s))//����������ֲ�ȫ�� 0 ������ϵ�λ�����ڣ�����
            {
                result += units[i - 1];
            }
            p += len;
        }
        return result;
    }

    //����ַ���s�Ƿ�ȫΪ����
    private static boolean checkIsNumbers(String x) {
        if (null == x) {
            return false;
        }
        for (Character c : x.toCharArray()) {
            if (c.compareTo('0') < 0 || c.compareTo('9') > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * �����������ֵ��ڻ�����12λ��С������2λ��ת��Ϊ���Ĵ�д��ʽ.
     *
     * @param amount �������
     * @return ���Ĵ�д
     * @throws IllegalArgumentException
     */
    public static String convert(String amount) throws IllegalArgumentException {
        // ȥ���ָ���
        amount = amount.replace(",", "");
        // ��֤�����ȷ��
        if (amount.equals("0.00")) {
            return "��Ԫ��";
        }
        Matcher matcher = AMOUNT_PATTERN.matcher(amount);
        if (!matcher.find()) {
            LOGGER.error("����������ת��ʧ�ܣ�[" + amount + "]");
            return "";
            //            throw new IllegalArgumentException("����������.");
        }
        String integer = matcher.group(1); // ��������
        String fraction = matcher.group(2); // С������
        String result = "";
        if (!integer.equals("0")) {
            result += integer2rmb(integer) + UNITS[0]; // ��������
        }
        if (fraction.equals("00")) {
            result += UNITS[3]; // ���[��]
        } else if (fraction.startsWith("0") && integer.equals("0")) {
            result += fraction2rmb(fraction).substring(1); // ȥ����ǰ���[��]
        } else {
            result += fraction2rmb(fraction); // С������
        }
        return result;
    }

    // �����С������ת��Ϊ���Ĵ�д
    private static String fraction2rmb(String fraction) {
        char jiao = fraction.charAt(0); // ��
        char fen = fraction.charAt(1); // ��
        return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS[1] : "")) + (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS[2] : "");
    }

    // �������������ת��Ϊ���Ĵ�д
    private static String integer2rmb(String integer) {
        StringBuilder buffer = new StringBuilder();
        // �Ӹ�λ����ʼת��
        int i, j;
        for (i = integer.length() - 1, j = 0; i >= 0; i--, j++) {
            char n = integer.charAt(i);
            if (n == '0') {
                // ��n��0��n���ұ�һλ����0ʱ������[��]
                if (i < integer.length() - 1 && integer.charAt(i + 1) != '0') {
                    buffer.append(RMB_NUMS[0]);
                }
                // ����[��]����[��]
                if (j % 4 == 0) {
                    if (i > 0 && integer.charAt(i - 1) != '0' || i > 1 && integer.charAt(i - 2) != '0' || i > 2 && integer.charAt(i - 3) != '0') {
                        buffer.append(U2[j / 4]);
                    }
                }
            } else {
                if (j % 4 == 0) {
                    buffer.append(U2[j / 4]);     // ����[��]����[��]
                }
                buffer.append(U1[j % 4]);         // ����[ʰ]��[��]��[Ǫ]
                buffer.append(RMB_NUMS[n - '0']); // ��������
            }
        }
        return buffer.reverse().toString();
    }

    public static String formatMoney(Object num) {
        String numStr = "0";
        if (num != null) {
            numStr = num + "";
            String[] numStrs = numStr.split("\\.");
            String left = numStrs[0];
            String right = "0";
            if (numStrs.length == 2) {
                right = numStrs[1];
            }
        }
        return numStr;
    }

    /**
     * ��double���͵�����ת��Ϊ###,###,###.00����ʽ
     *
     * @param
     * @return
     */
    public static String formatDoubleToMoney(Object object) {
        String str = "";
        double d = NumberTool.safeToDouble(object, 0.00);
        if (d != 0) {
            NumberFormat numberFormat = DecimalFormat.getCurrencyInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            str = numberFormat.format(d).replace("��", "");
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(formatMoney(111111111111111.11111111111111111));
        // System.out.println(convert("600000000000"));
        System.out.println(amountToChinese(600000000000.45678d, true));
        System.out.println(convert("600000000000.00"));
        System.out.println("Ҽ��½Ǫ�������Ԫ�㷡��".equals(convert("16,409.02")));
        System.out.println("ҼǪ�������Ԫ���".equals(convert("1,409.50")));
        System.out.println("½Ǫ����ԪҼ������".equals(convert("6,007.14")));
        System.out.println("ҼǪ½�۰�ʰԪ���Ƿ���".equals(convert("1,680.32")));
        System.out.println("���۷�ʰ��Ԫ������".equals(convert("325.04")));
        System.out.println("��Ǫ���۷�ʰҼԪ��".equals(convert("4,321.00")));
        System.out.println("Ҽ��".equals(convert("0.01")));
        System.out.println(convert("1234,5678,9012.34").equals("ҼǪ������ʰ������Ǫ½����ʰ�����Ǫ��Ҽʰ��Ԫ��������"));
        System.out.println(convert("1000,1000,1000.10").equals("ҼǪ����ҼǪ����ҼǪԪҼ��"));
        System.out.println(convert("9009,9009,9009.99").equals("��Ǫ����ھ�Ǫ������Ǫ���Ԫ���Ǿ���"));
        System.out.println(convert("5432,0001,0001.01").equals("��Ǫ������ʰ������Ҽ����ҼԪ��Ҽ��"));
        System.out.println(convert("1000,0000,1110.00").equals("ҼǪ����ҼǪҼ��ҼʰԪ��"));
        System.out.println(convert("1010,0000,0001.11").equals("ҼǪ��Ҽʰ����ҼԪҼ��Ҽ��"));
        System.out.println(convert("1000,0000,0000.01").equals("ҼǪ��Ԫ��Ҽ��"));
    }
}
