package com.xuan.xutils.utils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * һЩ�������ַ���,����,���ֵ�У�鹤��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:44:21 $
 */
public abstract class Validators {
    /**
     * �������ĵ�������ʽ��
     */
    private static final String REGEX_SIMPLE_CHINESE = "^[\u4E00-\u9FA5]+$";
    /**
     * ��ĸ���ֵ�������ʽ��
     */
    private static final String REGEX_ALPHANUMERIC = "[a-zA-Z0-9]+";
    /**
     * �����򸡵�����������ʽ��
     */
    private static final String REGEX_NUMERIC = "(\\+|-){0,1}(\\d+)([.]?)(\\d*)";
    /**
     * ���֤�����������ʽ��
     */
    private static final String REGEX_ID_CARD = "(\\d{14}|\\d{17})(\\d|x|X)";
    /**
     * ���������������ʽ��
     */
    private static final String REGEX_EMAIL = ".+@.+\\.[a-z]+";

    /**
     * �ж��ַ����Ƿ�ֻ������ĸ������.
     *
     * @param str �ַ���
     * @return ����ַ���ֻ������ĸ������, �򷵻� <code>true</code>, ���򷵻� <code>false</code>.
     */
    public static boolean isAlphanumeric(String str) {
        return isRegexMatch(str, REGEX_ALPHANUMERIC);
    }

    /**
     * <p>
     * Checks if a String is whitespace, empty ("") or null.
     * </p>
     * <p>
     * <pre>
     *   Validators.isBlank(null)                = true
     *   Validators.isBlank(&quot;&quot;)        = true
     *   Validators.isBlank(&quot; &quot;)       = true
     *   Validators.isBlank(&quot;bob&quot;)     = false
     *   Validators.isBlank(&quot;  bob  &quot;) = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * �Ƿ��ǺϷ��������ַ���(���Ƹ�ʽ:2017-03-01�ǺϷ���)
     * <p>
     * <pre>
     *   Validators.isBlank(&quot;2017-03-01&quot;)       = true
     *   Validators.isBlank(&quot;2017-0301&quot;)        = false
     * </pre>
     *
     * @param str �����ַ���
     * @return ��true������false
     */
    public static boolean isDate(String str) {
        if (isEmpty(str) || str.length() > 10) {
            return false;
        }
        String[] items = str.split("-");
        if (items.length != 3) {
            return false;
        }
        if (!isNumber(items[0], 1900, 9999) || !isNumber(items[1], 1, 12)) {
            return false;
        }
        int year = Integer.parseInt(items[0]);
        int month = Integer.parseInt(items[1]);
        return isNumber(items[2], 1, DateUtils.getMaxDayOfMonth(year, month - 1));
    }

    /**
     * �Ƿ��ǺϷ�������ʱ���ַ���
     * <p>
     * <pre>
     *   Validators.isDateTime(&quot;2017-03-01 12:03:01&quot;)       = true
     *   Validators.isDateTime(&quot;2017-03-01 12:0301&quot;)        = false
     * </pre>
     *
     * @param str ����ʱ���ַ���
     * @return ��true������false
     */
    public static boolean isDateTime(String str) {
        if (isEmpty(str) || str.length() > 20) {
            return false;
        }
        String[] items = str.split(" ");
        if (items.length != 2) {
            return false;
        }
        return isDate(items[0]) && isTime(items[1]);
    }

    /**
     * �ж��ַ����Ƿ��ǺϷ��ĵ��������ַ.
     *
     * @param str �ַ���
     * @return ��true������false
     */
    public static boolean isEmail(String str) {
        return isRegexMatch(str, REGEX_EMAIL);
    }

    /**
     * ������Ϊ<code>null</code>, ���߳���Ϊ0, ���߳���Ϊ1��Ԫ�ص�ֵΪ<code>null</code>ʱ���� <code>true</code>.
     *
     * @param args
     * @return true/false
     */
    public static boolean isEmpty(Object[] args) {
        return args == null || args.length == 0 || (args.length == 1 && args[0] == null);
    }

    /**
     * �ַ����Ƿ�ΪEmpty��null�Ϳո�����Empty
     *
     * @param str �ַ���
     * @return true/false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * �жϼ����Ƿ�Ϊ�ա�
     *
     * @param <T>        ���Ϸ���
     * @param collection ���϶���
     * @return �����϶���Ϊ <code>null</code> ���߳���Ϊ��ʱ���� <code>true</code>�����򷵻� <code>false</code>��
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * �ж�Map�Ƿ�Ϊ��
     *
     * @param map Map����
     * @param <K>
     * @param <V>
     * @return ��Map����Ϊ <code>null</code> ����Ԫ��Ϊ���Ƿ��� <code>true</code>�����򷵻� <code>false</code>��
     */
    public static <K, V> boolean isEmptyMap(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    /**
     * <p>
     * Validating for ID card number.
     * </p>
     *
     * @param str string to be validated
     * @return If the str is valid ID card number return <code>true</code>, otherwise return <code>false</code>.
     */
    public static boolean isIdCardNumber(String str) {
        // 15λ��18����, 14���ּ�x(X)�ַ���17���ּ�x(X)�ַ����ǺϷ���
        return isRegexMatch(str, REGEX_ID_CARD);
    }

    /**
     * �Ƿ�Ϊ���ֵ��ַ�����
     *
     * @param str �ַ���
     * @return true/false
     */
    public static boolean isNumber(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * �Ƿ��ǹ̶���Χ�ڵ����ֵ��ַ���
     *
     * @param str
     * @param min
     * @param max
     * @return true/false
     */
    public static boolean isNumber(String str, int min, int max) {
        if (!isNumber(str)) {
            return false;
        }
        int number = Integer.parseInt(str);
        return number >= min && number <= max;
    }

    /**
     * �ж��ַ��Ƿ�Ϊ�����򸡵���. <br>
     *
     * @param str �ַ���
     * @return ��Ϊ�����򸡵����򷵻� <code>true</code>, ���򷵻� <code>false</code>
     */
    public static boolean isNumeric(String str) {
        return isRegexMatch(str, REGEX_NUMERIC);
    }

    /**
     * �ж��ַ��Ƿ�Ϊ���Ͼ���Ҫ��������򸡵�����
     *
     * @param str         �ַ���
     * @param fractionNum С�����ֵ���������λ��
     * @return ��Ϊ�����򸡵����򷵻� <code>true</code>, ���򷵻� <code>false</code>
     */
    public static boolean isNumeric(String str, int fractionNum) {
        if (isEmpty(str)) {
            return false;
        }
        // �����򸡵���
        String regex = "(\\+|-){0,1}(\\d+)([.]?)(\\d{0," + fractionNum + "})";
        return Pattern.matches(regex, str);
    }

    /**
     * �ж��Ƿ��ǺϷ����ʱ�
     *
     * @param str �ַ���
     * @return true/false
     */
    public static boolean isPostcode(String str) {
        if (isEmpty(str)) {
            return false;
        }
        if (str.length() != 6 || !Validators.isNumber(str)) {
            return false;
        }
        return true;
    }

    /**
     * �ж��Ƿ��ǹ̶����ȷ�Χ�ڵ��ַ���
     *
     * @param str
     * @param minLength
     * @param maxLength
     * @return true/false
     */
    public static boolean isString(String str, int minLength, int maxLength) {
        if (str == null) {
            return false;
        }
        if (minLength < 0) {
            return str.length() <= maxLength;
        } else if (maxLength < 0) {
            return str.length() >= minLength;
        } else {
            return str.length() >= minLength && str.length() <= maxLength;
        }
    }

    /**
     * �ж��Ƿ��ǺϷ���ʱ���ַ�����
     *
     * @param str �ַ���
     * @return true/false
     */
    public static boolean isTime(String str) {
        if (isEmpty(str) || str.length() > 8) {
            return false;
        }
        String[] items = str.split(":");
        if (items.length != 2 && items.length != 3) {
            return false;
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i].length() != 2 && items[i].length() != 1) {
                return false;
            }
        }
        return !(!isNumber(items[0], 0, 23) || !isNumber(items[1], 0, 59) || (items.length == 3 && !isNumber(items[2], 0, 59)));
    }

    /**
     * �Ƿ��Ǽ��������ַ�����
     *
     * @param str �ַ���
     * @return true/false
     */
    public static boolean isSimpleChinese(String str) {
        return isRegexMatch(str, REGEX_SIMPLE_CHINESE);
    }

    /**
     * �ж��ַ����Ƿ�ƥ����������ʽ��
     *
     * @param str   �ַ���
     * @param regex ������ʽ
     * @return true/false
     */
    public static boolean isRegexMatch(String str, String regex) {
        return str != null && str.matches(regex);
    }
}
