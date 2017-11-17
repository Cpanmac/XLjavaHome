package com.xl.collections;

import com.xl.util.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo {
    String[] strings = new String[]{"223", "21", "sa"};
    private int[] intArray = new int[]{3, 56, 1, 4, 76721, 343, 1};

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
    public void inTest() {
        int[] ints = new int[3001];
        for (int i = 0; 1 < 3001; i++) {
            ints[i] = i;
        }
    }

    @Test
    public void testSort() {
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
