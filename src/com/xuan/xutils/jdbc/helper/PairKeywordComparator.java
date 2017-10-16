package com.xuan.xutils.jdbc.helper;

import java.util.Comparator;

/**
 * �ؼ�������Ƚ���
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:49:24 $
 */
public class PairKeywordComparator implements Comparator<PairKeyword> {
    @Override
    public int compare(PairKeyword keyword0, PairKeyword keyword1) {
        return keyword0.getIndex() > keyword1.getIndex() ? 1 : -1;
    }
}
