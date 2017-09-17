package com.xl.collections;

import com.xl.a.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo {
    String[] strings = new String[]{"223", "21", "sa"};
    private int[] intArray = new int[]{3, 56, 1, 4, 76721, 343, 1};

    /**
     * @param pData ����
     * @param left  ����Ŀ�ʼλ�ô�0��ʼ
     * @param right ����Ľ���λ��
     */
    public static void QuickSort(int[] pData, int left, int right) {
        int i, j;
        int middle, temp;
        i = left;
        j = right;
        middle = pData[left];
        while (true) {
            while ((++i) < right - 1 && pData[i] < middle)
                ; // ����ߵڶ���Ԫ�ؿ�ʼ���ҳ���middle���Ԫ��
            while ((--j) > left && pData[j] > middle)
                ; // ���ұߵ�һ��Ԫ�ؿ�ʼ���ҳ���middleС��Ԫ��
            if (i >= j) // �� i С�� j ��ʱ�򣬽�������Ԫ�ص�λ��
                break;
            temp = pData[i];
            pData[i] = pData[j];
            pData[j] = temp;
        }
        // �����������˼��pData[left] �� pData[j] ���н������������γ�����pData[j]Ϊ���ĵ����飬�±�С��
        // j��Ԫ�ر�pData[j]С���±����j��Ԫ�ر�pData[j]��
        pData[left] = pData[j];
        pData[j] = middle;
        // ��pData[j]��ߵ�Ԫ�أ����õݹ�
        if (left < j)
            QuickSort(pData, left, j);
        // ��pData[j]�ұߵ�Ԫ�أ����õݹ�
        if (right > i)
            QuickSort(pData, i, right);
    }

    public static void main(String[] args) {
        // int[] arr = {2,4,5};
        // System.out.println(Arrays.toString(arr));
        Integer[] arr = {1123, 12, 11, 13, 1};
        // List<int[]> list = Arrays.asList(arr); // ������ǵ�ַ дint�����
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });
        System.out.println(Arrays.toString(arr));
        // System.out.println(list);
        // Integer[] nums = { 2, 4, 5, 3, 0, 9 }; // �Զ�װ��
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
     * �������鳤��10%+10
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
