package com.xl.集合;

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
     * list.add("zz"); list.add("kkk"); list.add("qq"); //不具备比较性，不能排序 sop(list);
     * // Collections.sort(list); //不能给Set集合排序，因为Set集合有TreeSet
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
        // //查找list集合中的aaa,返回角标，如果不存在则返回负数
        // sop("index="+index);
        int index = halfSearch(list, "abs", null);
        sop(index);
    }

    public static int halfSearch(List<String> list, String key, Comparator<String> cmp) // 当不具备比较性时，后面加个
    {
        int max, min, mid; // 折半的三个变量
        max = list.size() - 1;
        min = 0;
        while (min <= max) {
            mid = (max + min) >> 1; // 最大值+最小值除以2.就是中间值
            String str = list.get(mid);
            // int num =str.compareTo(key); //中间角标的元素与key比较
            int num = cmp.compare(key, str); // 加了比较器怎么比
            if (num > 0) {
                max = mid - 1;
            } else if (num < 0)
                min = mid + 1;
            else
                return mid; // 中间值
        }
        return -min - 1; // 插入点就是min
    }
}

class StrLenComparator implements Comparator<String> // 字符串长度比较器
{
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        if (s1.length() < s2.length())
            return -1;
        return s1.compareTo(s2);
    }
}
