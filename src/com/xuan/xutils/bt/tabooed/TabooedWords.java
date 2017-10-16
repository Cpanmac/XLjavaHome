package com.xuan.xutils.bt.tabooed;

import com.xuan.xutils.io.IOUtils;
import com.xuan.xutils.utils.Validators;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * ���дʻ���. ������ȡ��Դ�ļ�(Ĭ��Ϊtabooed.words)�еĴʻ�.
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:24:31 $
 */
public class TabooedWords {
    private final Set<String> tabooedWords = new HashSet<String>();

    /**
     * ��Ĭ�ϵ����дʻ��ļ��ж�ȡ�ʻ�, ��ʼ�����дʻ��б�.
     */
    public synchronized void initialize() {
        InputStream in = TabooedWords.class.getClassLoader().getResourceAsStream("tabooed.words");
        initialize(in, "UTF-8");
    }

    /**
     * ��ָ�������дʻ��������ж�ȡ�ʻ�, ��ʼ�����дʻ��б�.
     *
     * @param in      ���дʻ�������
     * @param charset ���뷽ʽ
     */
    public synchronized void initialize(InputStream in, String charset) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, charset));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!Validators.isEmpty(line)) {
                    tabooedWords.add(line.toLowerCase());
                }
            }
        } catch (Exception e) {
            // Ignore
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    /**
     * ��ȡ���ж�ȡ�������дʻ�.
     *
     * @return ���дʻ�
     */
    public Set<String> getTabooedWords() {
        return tabooedWords;
    }
}
