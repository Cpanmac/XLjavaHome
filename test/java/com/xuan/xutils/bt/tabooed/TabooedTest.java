package com.xuan.xutils.bt.tabooed;

import org.junit.Test;

import java.util.List;

/**
 * ���дʲ���
 * <p>
 * Created by xuan on 17/8/8.
 */
public class TabooedTest {
    private final static String TEXT = "����һ��ѧϰjava��С����,��˵���������кܶ����д�.�����й���Ҳ����˵ô,����̫ʧ����.��������.��Ҳ�еİ�";

    @Test
    public void testGetTabooedWords() {
        /**
         * ���������������ܲ��Ǻܺ�����,���ܸ����дʵĹؼ��ֶ����й�ϵ
         */
        List<String> tabooedList = TabooedUtils.getTabooedWords(TEXT);
        System.out.println("++++++++++tabooedList:" + tabooedList);
    }
}
