package com.xuan.xutils.bt.tabooed;

import com.xuan.xutils.utils.Validators;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ���ı����ݽ������дʻ���˵Ĺ����ࡣ
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:24:01 $
 */
public abstract class TabooedUtils {
    private static final TabooedTools tabooedTools = TabooedTools.getInstance();

    /**
     * ���ı����ݽ��й��ˣ���ȡ���д��ڵ����дʻ㡣
     *
     * @param content ��Ҫ���й��˵�����
     * @return ���˵����дʻ��б�
     */
    public static List<String> getTabooedWords(String content) {
        if (Validators.isEmpty(content)) {
            return Collections.emptyList();
        }
        return tabooedTools.getTabooedWords(content);
    }

    /**
     * ���ı����ݽ��м�飬��֤�Ƿ�������дʻ㡣
     *
     * @param content ��Ҫ���м�������
     * @return ����������дʻ㷵�� <code>true</code>�����򷵻� <code>false</code>��
     */
    public static boolean isTabooed(String content) {
        return !getTabooedWords(content).isEmpty();
    }

    /**
     * �˷�������ʵ���ڲ�����JVM����������¼��ش�����дʻ����Դ�ļ���
     */
    public static void reloadTabooedWords() {
        tabooedTools.initialize();
    }

    /**
     * �˷������ڼ���Ӧ�ó����ⲿ�����дʻ�⣬�������ݿ���洢�Ĵʿ⣨ʹ�ø÷�����tabooed.words����Ĵʻ���Ч��
     *
     * @param tabooedWords
     */
    public static void setTabooedWordsResource(Collection<String> tabooedWords) {
        tabooedTools.setTabooedWords(tabooedWords);
    }

    public static TabooedTools getTabooedTools() {
        return tabooedTools;
    }
}
