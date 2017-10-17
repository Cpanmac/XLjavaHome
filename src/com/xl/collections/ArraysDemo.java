package com.xl.collections;

import com.xl.a.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo {
    String[] strings = new String[]{"223", "21", "sa"};
    private int[] intArray = new int[]{3, 56, 1, 4, 76721, 343, 1};

    /**
     * @param pData 数组
     * @param left  排序的开始位置从0开始
     * @param right 排序的结束位置
     */
    public static void QuickSort(int[] pData, int left, int right) {
        int i, j;
        int middle, temp;
        i = left;
        j = right;
        middle = pData[left];
        while (true) {
            while ((++i) < right - 1 && pData[i] < middle)
                ; // 从左边第二个元素开始，找出比middle大的元素
            while ((--j) > left && pData[j] > middle)
                ; // 从右边第一个元素开始，找出比middle小的元素
            if (i >= j) // 当 i 小于 j 的时候，交换两个元素的位置
                break;
            temp = pData[i];
            pData[i] = pData[j];
            pData[j] = temp;
        }
        // 下面两句的意思：pData[left] 和 pData[j] 进行交换，这样就形成了以pData[j]为中心的数组，下标小于
        // j的元素比pData[j]小，下标大于j的元素比pData[j]大。
        pData[left] = pData[j];
        pData[j] = middle;
        // 对pData[j]左边的元素，调用递归
        if (left < j)
            QuickSort(pData, left, j);
        // 对pData[j]右边的元素，调用递归
        if (right > i)
            QuickSort(pData, i, right);
    }

    public static void main(String[] args) {
        // int[] arr = {2,4,5};
        // System.out.println(Arrays.toString(arr));
        Integer[] arr = {1123, 12, 11, 13, 1};
        // List<int[]> list = Arrays.asList(arr); // 输出的是地址 写int会出错
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });
        System.out.println(Arrays.toString(arr));
        // System.out.println(list);
        // Integer[] nums = { 2, 4, 5, 3, 0, 9 }; // 自动装箱
        // List<Integer> li = Arrays.asList(nums);
        // System.out.println(li);
        // Collections.reverse(li);
        // System.out.println(li);
    }

    @Test
    public void testSystemOut() {
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.asList(intArray));
    }

    @Test
    public void testSort() {
        QuickSort(intArray, 0, 3);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * 扩大数组长度10%+10
     */
    @Test
    public void length() {
        int length = intArray.length;
        ArrayUtil.arrayAddLength(intArray, 10);
        System.out.println(intArray.length);
        ArrayUtil.arrayAddLength(intArray, 2);
        System.out.println(intArray.length);
    }

    @Test
    public void copy() {
        String[] a = new String[]{"referf", "dswefwf", "regre"};
        p(a);
        String[] b;
        a = Arrays.copyOf(a, a.length + 1);
        p(a);
    }

    private void p(Object[] obj) {
        System.out.println(obj.getClass().getName());
        int i = 0;
        for (Object o : obj) {
            System.out.println(i);
            i++;
            System.out.println(o.toString());
        }
    }
}
