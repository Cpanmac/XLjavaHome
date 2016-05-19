package com.xl.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ����
 * @Decription ���򹤾���
 * @date 2013-12-21
 */
public class RegTool {
    /**
     * �õ����е�����
     *
     * @param content
     * @return
     */
    public static String[] getChinese(String content) {
        return getContent(content, "[\\u4E00-\\u9FFF]+");
    }

    /**
     * �Ƿ�ƥ��ָ������
     *
     * @param s
     * @param reg
     * @return
     */
    public static boolean isMatch(String s, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        return m.find();
    }

    /**
     * �������з���������
     *
     * @param content
     * @param regex
     * @return
     */
    public static String[] getContent(String content, String regex) {
        return getContent(content, regex, 0);
    }

    /**
     * ���ط��������ļ���
     *
     * @param content ����
     * @param regex   ����
     * @param params  ���
     * @return List<String>
     */
    public static String[] getContent(String content, String regex, int... params) {
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex,// Pattern.MULTILINE | //����ģʽ
                // Pattern.DOTALL | //ƥ���κ��ַ����������з���
                Pattern.UNICODE_CASE);
        Matcher m = p.matcher(content);
        while (m.find()) {
            for (int i = 0; i < params.length; i++) {
                list.add(m.group(params[i]));
            }
        }
        String[] strs = new String[list.size()];
        return list.toArray(strs);
    }

    /**
     * ƥ�����е�Email
     *
     * @param content
     * @return
     */
    public static String[] getEmail(String content) {
        return getContent(content, "[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+");
    }

    /**
     * ����http
     *
     * @param content
     * @return List<String>
     */
    public static String[] getHttpUrl(String content) {
        return getContent(content, "(http://.+)[\"|']", 1);
    }

    public static boolean isHttpUrl(String content) {
        return isMatch(content, "http://\\w+");
    }

    /**
     * ƥ�����е�ͼƬ��ʽ
     *
     * @param content
     * @return
     */
    public static String[] getImageURL(String content) {
        return getContent(content, "(http://.+?[jpg][pni][gf])");
    }

    /**
     * �ж��Ƿ�����
     *
     * @param s
     * @return
     */
    public static boolean isChinese(String s) {
        if (s == null) {
            return false;
        }
        return Pattern.matches("[\u4E00-\u9FFF]+", s);
    }

    /**
     * ȥ�������ϵĿո�
     *
     * @param content
     * @param regex
     * @return String
     */
    public static String trim(String content) {
        return content.replaceAll("\\s{2,}", "");
    }

    // -----------------------------------���ǲ���------------------------------------------------
    @Test
    public void testGetEmail() {
        String s = "Ϋ��1239s�ҷ·�dfs0812093@qq.com";
        String[] strs = getEmail(s);
        System.out.println(Arrays.toString(strs));
    }
}
