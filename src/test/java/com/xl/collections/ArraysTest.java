package com.xl.collections;

import com.xl.util.ArrayUtil;
import com.xl.util.Print;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    String[] strings = new String[]{"223", "21", "sa"};
    private int[] intArray = new int[]{3, 56, 1, 4, 76721, 343, 1};

    public static void main(String[] args) {
        // int[] arr = {2,4,5};
        // Print.print(Arrays.toString(arr));
        Integer[] arr = {1123, 12, 11, 13, 1};
        // List<int[]> list = Arrays.asList(arr); // 输出的是地址 写int会出错
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });
        Print.info(Arrays.toString(arr));
    }

    @Test
    public void testSystemOut() {
        Print.info(Arrays.toString(intArray));
        Print.info(Arrays.asList(intArray));
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
        Print.info(Arrays.toString(intArray));
    }

    /**
     * 扩大数组长度10%+10
     */
    @Test
    public void length() {
        int length = intArray.length;
        ArrayUtil.arrayAddLength(intArray, 10);
        Print.info(intArray.length);
        ArrayUtil.arrayAddLength(intArray, 2);
        Print.info(intArray.length);
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
        Print.info(obj.getClass().getName());
        int i = 0;
        for (Object o : obj) {
            Print.info(i);
            i++;
            Print.info(o.toString());
        }
    }
}
