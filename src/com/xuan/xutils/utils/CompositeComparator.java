package com.xuan.xutils.utils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * ��������ֶε������������ıȽ�����
 * <p>
 * <p>
 * ��������ϣ�Compositor��ģʽ����һЩ���в�ͬ���ܵ������������һ����������飬<br>
 * Ȼ��ͨ������ĳ��������ѭ�������е�����Ԫ�أ���󷵻��û�����Ҫ�Ľ����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:18:35 $
 */
public class CompositeComparator<T> implements Comparator<T> {
    /**
     * �Ƚ����б�, Խ�����б�ǰ��ıȽ������ȼ�Խ��.
     */
    private final List<Comparator<T>> comparatorList = new LinkedList<Comparator<T>>();

    /**
     * ��ȡ�Ƚ����б�.
     */
    public List<Comparator<T>> getComparatorList() {
        return comparatorList;
    }

    /**
     * ���һ���Ƚ������Ƚ����б���.
     */
    public void addComparator(Comparator<T> comparator) {
        if (comparator == null) {
            return;
        }
        comparatorList.add(comparator);
    }

    /**
     * ��Ӷ���Ƚ������Ƚ����б���.
     */
    public void addComparators(Comparator<T>[] comparators) {
        if (comparators == null) {
            return;
        }
        for (int i = 0; i < comparators.length; i++) {
            comparatorList.add(comparators[i]);
        }
    }

    /**
     * ���ݱȽ����б��еıȽ��������ȼ����Զ����������. ���ȼ��ߵıȽ������ȱ�ʹ��.<br>
     * ���������ȽϽ�����, ������ʹ��������ȼ��ıȽ������бȽ�.
     */
    @Override
    public int compare(T o1, T o2) {
        for (Comparator<T> comparator : comparatorList) {
            int result = comparator.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
