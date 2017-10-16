package com.xuan.xutils.utils;

/**
 * ����������֡��ַ����Ĺ�����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:10:13 $
 */
public abstract class RandomUtils {
    // û����� I��O ��ԭ���Ǳ�������� 1��0 ����
    private static final String ALPHA_NUMERIC = "ABCDEFGHJKLMNPQRSTUVWXYZ123456789";

    /**
     * ����һ���̶���Χ��min-max ֮�䣩�������������
     *
     * @param min ��Сֵ��
     * @param max ���ֵ
     * @return min-max ֮���������������� min��max
     */
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * �����̶����ȵ�������ִ���
     *
     * @param length ����
     * @return ������ִ�
     */
    public static String getRandomNum(int length) {
        return (Double.toString(Math.random())).substring(2, (2 + length));
    }

    /**
     * �����̶����ȵ������ĸ���ִ���������ĸΪ��д��ʽ��
     *
     * @param length ����
     * @return �����ĸ���ִ�
     */
    public static String getRandomStr(int length) {
        char[] randomBytes = new char[length];
        for (int i = 0; i < length; i++) {
            randomBytes[i] = ALPHA_NUMERIC.charAt(getRandomInt(0, ALPHA_NUMERIC.length() - 1));
        }
        return new String(randomBytes);
    }

    /**
     * �����̶����ȵ������ĸ���ִ���������ĸΪСд��ʽ��
     *
     * @param length ����
     * @return �����ĸ���ִ�
     */
    public static String getRandomStrLowerCase(int length) {
        return getRandomStr(length).toLowerCase();
    }
}
