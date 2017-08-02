package com.xl.collections;

import java.util.ArrayList;
import java.util.Arrays;

class CollectionToArray {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("abc1");
        a1.add("abc2");
        a1.add("abc3");
        String[] arr = a1.toArray(new String[-5]);
        System.out.println(Arrays.toString(arr));
    }
}
