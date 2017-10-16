package com.xuan.xutils.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * �ӽ��ܹ�����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:10:59 $
 */
public abstract class SecurityUtils {
    private static final char[] chs = {'L', 'K', 'J', '4', 'D', 'G', 'F', 'V', 'R', 'T', 'Y', 'B', 'N', 'U', 'P', 'W', '3', 'E', '5', 'H', 'M', '7', 'Q', '9', 'S', 'A', 'Z', 'X', '8', 'C', '6', '2'};

    /**
     * ����������ܣ����ֻ�ܼ��� 30 ���ֽڳ��ȵ��ַ�����
     * <p>
     * <p>
     * <b>��ͬһ���ַ��������ܺ�����Ŀ����ǲ���ͬ�ģ��������ж������Ƿ����ʱ�����ܲ������Ľ��бȶԣ�����������ıȶԡ�</b>
     * </p>
     *
     * @param source Դ�ַ���
     * @return ���ܺ��ַ���
     * @see {@link #decodeBySelf(String)}
     */
    public static String encodeBySelf(String source) {
        if (source == null) {
            throw new NullPointerException("source can't be null");
        }
        if (source.length() > 30) {
            throw new IllegalArgumentException("the length of source must be less than 31, actual was " + source.length());
        }
        String plainText = source;
        byte[] plainTextBytes = plainText.getBytes();
        byte[] encodedBytes1 = new byte[30];
        byte[] encodedBytes2 = new byte[30];
        int n1 = 0, n2 = 0;
        for (int i = 0; i < plainTextBytes.length; i++) {
            if ((i + 1) % 2 != 0) { // ����λ
                encodedBytes1[n1++] = (byte) get32Hi(plainTextBytes[i] * 4);
                encodedBytes1[n1++] = (byte) get32Low(plainTextBytes[i] * 4);
            } else { // ż��λ
                encodedBytes2[n2++] = (byte) get32Hi(plainTextBytes[i] * 4);
                encodedBytes2[n2++] = (byte) get32Low(plainTextBytes[i] * 4);
            }
        }
        while (n1 < 30) {
            encodedBytes1[n1++] = (byte) getRandom(32);
        }
        while (n2 < 30) {
            encodedBytes2[n2++] = (byte) getRandom(32);
        }
        int pos1 = getRandom(plainTextBytes.length);
        int pos2 = getRandom(plainTextBytes.length);
        sort(encodedBytes1, pos1);
        sort(encodedBytes2, pos2);
        int check = (sumSqual(encodedBytes1) + sumSqual(encodedBytes2)) % 32;
        byte[] encodedArray = new byte[64];
        encodedArray[0] = (byte) pos1;
        encodedArray[1] = (byte) pos2;
        System.arraycopy(encodedBytes1, 0, encodedArray, 2, encodedBytes1.length);
        System.arraycopy(encodedBytes2, 0, encodedArray, 2 + encodedBytes1.length, encodedBytes2.length);
        encodedArray[encodedArray.length - 2] = (byte) plainText.length();
        encodedArray[encodedArray.length - 1] = (byte) check;
        byte[] ps = new byte[encodedArray.length];
        for (int i = 0; i < encodedArray.length; i++) {
            ps[i] = (byte) chs[encodedArray[i]];
        }
        return new String(ps);
    }

    /**
     * ����������ܡ�������ǺϷ��ļ��ܴ������Ȳ���64���ֽڣ�����ֱ�ӷ���ԭ�ַ�����
     *
     * @param str ���ܵ��ַ���
     * @return ���ܺ��ַ���
     * @see {@link #encodeBySelf(String)}
     */
    public static String decodeBySelf(String str) {
        // ������ǺϷ��ļ��ܴ�����ֱ�ӷ���
        if (str == null || str.length() != 64) {
            return str;
        }
        byte[] bb = new byte[str.length()];
        byte[] sb = str.getBytes();
        for (int i = 0; i < sb.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((byte) chs[j]) == sb[i]) {
                    bb[i] = (byte) j;
                    break;
                }
            }
        }
        int sl = bb[bb.length - 2];
        int p1 = bb[0];
        int p2 = bb[1];
        byte[] bb1 = new byte[30];
        byte[] bb2 = new byte[30];
        int bb2l;
        if (sl % 2 == 0) {
            bb2l = sl;
        } else {
            bb2l = sl - 1;
        }
        System.arraycopy(bb, 2, bb1, 0, bb1.length);
        System.arraycopy(bb, 2 + bb1.length, bb2, 0, bb2.length);
        unsort(bb1, p1);
        unsort(bb2, p2);
        byte[] oldb = new byte[sl];
        for (int i = 0; i < sl; i += 2) {
            oldb[i] = (byte) (getIntFrom32(bb1[i], bb1[i + 1]) / 4);
            if (i + 1 < bb2l) {
                oldb[i + 1] = (byte) (getIntFrom32(bb2[i], bb2[i + 1]) / 4);
            }
        }
        return new String(oldb);
    }

    /**
     * ʹ�� SHA1 ���ܡ�
     *
     * @param str Դ�ַ���
     * @return ���ܺ��ַ���
     */
    public static String encodeBySHA1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            return com.xuan.xutils.utils.StringUtils.toHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not encodeBySHA1", e);
        }
    }

    /**
     * ʹ�� MD5 ���ַ������ܡ�
     *
     * @param str Դ�ַ���
     * @return ���ܺ��ַ���
     */
    public static String encodeByMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return StringUtils.toHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not encodeByMD5", e);
        }
    }

    /**
     * ʹ�� MD5 ���ֽ�������ܡ�
     *
     * @param bytes Դ�ַ� byte ����
     * @return ���ܺ��ַ���
     */
    public static String encodeByMD5(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            return StringUtils.toHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not encodeByMD5", e);
        }
    }

    /**
     * ʹ��36���ƽ��롣
     *
     * @param str ������ַ���
     * @return ������ַ���
     * @see {@link #encodeBy36Radix(String)}
     */
    public static String decodeBy36Radix(String str) {
        int length = str.length();
        byte[] bytes = null;
        if (length % 11 == 0) {
            bytes = new byte[length / 11 * 7];
        } else {
            bytes = new byte[(length / 11 + 1) * 7];
        }
        int index = 0;
        int offset = 0;
        do {
            String sub = null;
            if (index + 11 < length) {
                sub = str.substring(index, index + 11);
            } else {
                sub = str.substring(index);
            }
            long l = Long.parseLong(sub, 36);
            for (int i = 0; i < 7; i++) {
                byte b = (byte) (l >> ((6 - i) * 8));
                if (b != 0) {
                    bytes[offset++] = b;
                }
            }
            index += 11;
        } while (index < length);
        return new String(bytes, 0, offset);
    }

    /**
     * ʹ��36���ƽ��б��롣
     *
     * @param str Դ�ַ���
     * @return ������ַ���
     * @see {@link #decodeBy36Radix(String)}
     */
    public static String encodeBy36Radix(String str) {
        byte[] bytes = str.getBytes();
        int index = 0;
        StringBuilder StringBuilder = new StringBuilder();
        boolean isSeven = true;
        do {
            byte[] longBytes = new byte[8];
            if (index + 7 < bytes.length) {
                System.arraycopy(bytes, index, longBytes, 1, 7);
            } else {
                int i = bytes.length - index;
                System.arraycopy(bytes, index, longBytes, 8 - i, i);
                isSeven = false;
            }
            long longval = toLong(longBytes);
            if (isSeven) {
                StringBuilder.append(StringUtils.enoughZero(Long.toString(longval, 36), 11));
            } else {
                StringBuilder.append(Long.toString(longval, 36));
            }
            index += 7;
        } while (index < bytes.length);
        return StringBuilder.toString();
    }

    private static long toLong(byte[] bytes) {
        return ((((long) bytes[0] & 0xff) << 56) | (((long) bytes[1] & 0xff) << 48) | (((long) bytes[2] & 0xff) << 40) | (((long) bytes[3] & 0xff) << 32) | (((long) bytes[4] & 0xff) << 24) | (((long) bytes[5] & 0xff) << 16) | (((long) bytes[6] & 0xff) << 8) | (((long) bytes[7] & 0xff) << 0));
    }

    private static int sumSqual(byte[] b) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += (int) Math.pow(b[i], 2);
        }
        return sum;
    }

    private static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    private static void sort(byte[] b, int pos) {
        byte[] tmp = new byte[pos];
        System.arraycopy(b, 0, tmp, 0, pos);
        System.arraycopy(b, pos, b, 0, b.length - pos);
        System.arraycopy(tmp, 0, b, b.length - pos, pos);
    }

    private static void unsort(byte[] b, int pos) {
        byte[] tmp = new byte[pos];
        System.arraycopy(b, b.length - pos, tmp, 0, pos);
        System.arraycopy(b, 0, b, pos, b.length - pos);
        System.arraycopy(tmp, 0, b, 0, pos);
    }

    private static int get32Low(int num) {
        return num % 32;
    }

    private static int get32Hi(int num) {
        return num / 32;
    }

    private static int getIntFrom32(int hi, int low) {
        return hi * 32 + low;
    }
}
