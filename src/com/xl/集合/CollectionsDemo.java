package com.xl.����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CollectionsDemo {
    public static void main(String[] args) {
        binarySearchDemo();
    }

    /*
     * public static void sortDemo() { List<String> list = new
     * ArrayList<String>(); list.add("abcd"); list.add("aaa"); list.add("z");
     * list.add("zz"); list.add("kkk"); list.add("qq"); //���߱��Ƚ��ԣ��������� sop(list);
     * // Collections.sort(list); //���ܸ�Set����������ΪSet������TreeSet
     * Collections.sort(list,new StrLenComparator()); sop(list); String max =
     * Collections.max(list); sop(max); }
     */
    public static void sop(Object obj) {
        System.out.println(obj);
    }

    public static void binarySearchDemo() {
        List<String> list = new ArrayList<String>();
        list.add("abcd");
        list.add("aaa");
        list.add("z");
        list.add("zz");
        list.add("kkk");
        list.add("qq");
        Collections.sort(list);
        sop(list);
        // int index = Collections.binarySearch(list,"abcwerd");
        // //����list�����е�aaa,���ؽǱ꣬����������򷵻ظ���
        // sop("index="+index);
        int index = halfSearch(list, "abs", null);
        sop(index);
    }

    public static int halfSearch(List<String> list, String key, Comparator<String> cmp) // �����߱��Ƚ���ʱ������Ӹ�
    {
        int max, min, mid; // �۰����������
        max = list.size() - 1;
        min = 0;
        while (min <= max) {
            mid = (max + min) >> 1; // ���ֵ+��Сֵ����2.�����м�ֵ
            String str = list.get(mid);
            // int num =str.compareTo(key); //�м�Ǳ��Ԫ����key�Ƚ�
            int num = cmp.compare(key, str); // ���˱Ƚ�����ô��
            if (num > 0) {
                max = mid - 1;
            } else if (num < 0)
                min = mid + 1;
            else
                return mid; // �м�ֵ
        }
        return -min - 1; // ��������min
    }
}

class StrLenComparator implements Comparator<String> // �ַ������ȱȽ���
{
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        if (s1.length() < s2.length())
            return -1;
        return s1.compareTo(s2);
    }
}
