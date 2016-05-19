package com.xl.Regex;

import com.xl.util.RegTool;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ����
 * @Decription ((())()) ��һ���������ǵ�һ�飬�ڶ����������ǵڶ��顣�ܹ����������ž��м���
 * @date 2014-1-12
 */
public class RegDemo {
    /**
     * ƥ�����
     */
    private String reg = "";
    /**
     * ƥ������
     */
    private String content;

    private void getLazy(String content, Lazy l) {
        Pattern p = Pattern.compile(l.getReg());
        Matcher m = p.matcher(content);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * ���ظ���ȥ�� <br/>
     * $1�ܻ�ȡ��һ��
     */
    @Test
    public void replaceAllDemo() {
        String str = "111232233333"; // ��һ����ĸ������
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
    }

    @Test
    public void ��������() {
        String s = "<span>a</span><span>b</span>";
        getLazy(s, new Lazy() {
            @Override
            public String getReg() {
                // �������
                return "<span.+span>";
            }
        });
        getLazy(s, new Lazy() {
            @Override
            public String getReg() {
                // ���裬ƥ�����ĺ�������ʺž���
                return "<span.+?span>";
            }
        });
    }

    /**
     * ��������[\\u4E00-\\u9FFF]+
     */
    @Test
    public void ƥ������() {
        String str = "zh�ڷ��޷�angsa�й�n.lisi.wangwu";
        String reg = "[\\u4E00-\\u9FFF]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            sb.append(m.group() + "\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test�Ƿ�����() {
        String s1 = "����";
        String s2 = "��aa��";
        String s3 = "331";
        String s4 = "";
        String s5 = null;
        ƥ����վ();
    }

    @Test
    public void ƥ����վ() {
        reg = "http{0,4}.+|www.+";
        content = "http://pan.baidu.com/share/link?shareid=160389&uk=3977244385\r\nhttp://pan.baidu.com/share/link?shareid=160394&uk=3977244385\r\nwww.hao123.com";
        String[] strs = RegTool.getContent(content, reg);
        System.out.println(Arrays.toString(strs));
    }

    private interface Lazy {
        String getReg();
    }
}
