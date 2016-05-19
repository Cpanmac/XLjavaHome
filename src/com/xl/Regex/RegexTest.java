package com.xl.Regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    @Test
    public void search1() {
        Pattern p = Pattern.compile("java");
        Matcher m = p.matcher("java Java JAVa qjaval JaVa IloveJAVA you hateJava afasdfasdf");
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void search2() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE); /*
                                                                         * Pattern.
																		 * CASE_INSENSITIVE
																		 * :
																		 * ��������
																		 * ����Сд
																		 */
        Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void search3() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
        StringBuffer buf = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(buf, "888"); /* ����ǰ�ҵ��Ľ����滻���һ��ú�ŵ�buf��ȥ */
        }
        m.appendTail(buf);
        System.out.println(buf);
    }

    /**
     * �������
     */
    @Test
    public void group1() {
        Pattern p = Pattern.compile("\\d{3,5}[a-z]{2}");
        p = Pattern.compile("(\\d{1})([a-z])");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println("��0�鼴����ƥ����ַ���:" + m.group(0));
            System.out.println("��1�鼴�ǵ�1��()���ַ���:" + m.group(1));
            System.out.println("��2�鼴�ǵ�2��()���ַ���:" + m.group(2));
        }
    }

    /* ������� */
    @Test
    public void fun1() {
        // 3��10���ַ��������һλ����:û���ʺţ�һ�γ�10���ַ����ֲ�ƥ�������³�һ���ַ���ȥƥ��
        Pattern p = Pattern.compile("[a-z]{3,10}[0-9]");
        String s = "aaaa5bbbb6";
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.start() + "-" + m.end());
        } else {
            System.out.println("not match!");
        }
    }

    /* ��ǿģʽ */
    @Test
    public void fun2() {
        Pattern p = Pattern.compile(".{3,10}?[0-9]");
        /* ��һ�γ�3���ַ������ϲ�����ʱ���ĸ���ʾ���ӣ���˲����� ���ٳԽ�һλ����ʱ���� */
        String s = "aaaa5bbbb68";
        Matcher m = p.matcher(s);
        if (m.find())
            System.out.println(m.start() + "-" + m.end());
        else
            System.out.println("not match!");
    }

    /* һ�㲻��:ռ��ģʽ */
    @Test
    public void fun3() {
        Pattern p = Pattern.compile(".{3,10}+[0-9]");/* һ�γ�10���ַ����Ҳ������� */
        String s = "aaaa5bbbb6";
        Matcher m = p.matcher(s);
        if (m.find())
            System.out.println(m.start() + "-" + m.end());
        else
            System.out.println("not match!");
    }

    @Test
    public void fun4() {
        Pattern p = Pattern.compile(".{3}"); // ƥ��3���ַ���
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void fun5() {
        Pattern p = Pattern.compile(".{2,8}(?=a)"); // (?=a)����ʾ�ǲ�����(������a)����ʾ�������ַ���a
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void fun6() {
        Pattern p = Pattern.compile("(?=a).{3}");
        // (?=a)����ʾ�ǲ�����(������a)����ʾ��a��ͷ���������ַ� ,����a
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void fun7() {
        Pattern p = Pattern.compile(".{3}(?=!a)");
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void fun8() {
        Pattern p = Pattern.compile(".{3}(?<=a)"); /* �Ӻ���ǰ��������a�� */
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * ��ǰ����
     */
    @Test
    public void fun9() {
        Pattern p = Pattern.compile("(\\d\\d)\\1");/* 1:��ʾ�����ҵ��Ľ�������ǰ���ҵ���һģһ�� */
        String s = "232312";
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
    }

    /**
     * ��ǰ����
     */
    @Test
    public void fun10() {
        Pattern p = Pattern.compile("(\\d(\\d))\\2");
        // (\\d(\\d)):�����������飺�ڶ�����ץ������2 �����\\2:��ʾ�����Ҫ�͵ڶ���ץ������һ��
        String s = "122";
        Matcher m = p.matcher(s);
        System.out.println(m.matches() + ":" + m.group(2));
    }

    @Test
    public void fun11() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        System.out.println("Java".matches("(?i)(java)")); /* (?i)�ǲ�����:������ļ�д */
    }

	/*
     * ��ʹ��Pattern.compile����ʱ�����Լ������������ʽ��ƥ����Ϊ�Ĳ����� Pattern Pattern.compile(String
	 * regex, int flag)
	 * 
	 * flag��ȡֵ��Χ���£� Pattern.CANON_EQ
	 * ���ҽ��������ַ���"����ֽ�(canonical decomposition)"����ȫ��ͬ�������
	 * �����϶�ƥ�䡣�������������־֮�󣬱��ʽ"a\u030A"
	 * ��ƥ��"?"��Ĭ������£�������"�淶�����(canonical equivalence)"��
	 * Pattern.CASE_INSENSITIVE(?i)
	 * Ĭ������£���Сд�����е�ƥ��ֻ������US-ASCII�ַ����������־���ñ��ʽ���Դ�Сд����ƥ��
	 * ��Ҫ���Unicode�ַ����д�С�����е�ƥ�䣬ֻҪ��UNICODE_CASE�������־�����������ˡ� Pattern.COMMENTS(?x)
	 * ������ģʽ��
	 * ��ƥ��ʱ�����(������ʽ���)�ո��ַ�(����ע������ָ���ʽ���"\\s"������ָ���ʽ��Ŀո�tab���س�֮��)��ע�ʹ�#��ʼ��
	 * һֱ�����н��� ������ͨ��Ƕ��ʽ�ı�־������Unix��ģʽ�� Pattern.DOTALL(?s)
	 * ������ģʽ�£����ʽ''.''����ƥ�������ַ���������ʾһ�еĽ�������Ĭ������£����ʽ''.''��ƥ���еĽ�������
	 * Pattern.MULTILINE (?m) ������ģʽ�£�
	 * ''^''��''$''�ֱ�ƥ��һ�еĿ�ʼ�ͽ��������⣬''^''��Ȼƥ���ַ����Ŀ�ʼ��''$''Ҳƥ���ַ����Ľ�����Ĭ������£����������ʽ����ƥ���ַ����Ŀ�ʼ�ͽ�����
	 * Pattern.UNICODE_CASE (?u)
	 * �����ģʽ�£�����㻹������CASE_INSENSITIVE��־����ô�����Unicode�ַ����д�Сд�����е�ƥ��
	 * ��Ĭ������£���Сд�����е�ƥ��ֻ������US-ASCII�ַ����� Pattern.UNIX_LINES(?d)
	 * �����ģʽ�£�ֻ��''\n''�ű�����һ�е���ֹ��������''.''��''^''���Լ�''$''����ƥ�䡣
	 */
}
