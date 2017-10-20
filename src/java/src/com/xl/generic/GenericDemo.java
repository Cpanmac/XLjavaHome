package com.xl.generic;

import java.util.ArrayList;
import java.util.Iterator;

class GenericDemo {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("abc01");
        a1.add("abc0991");
        a1.add("abc014");
        //	a1.add(new Integer(4));   会出ClassCastException异常，编译没问题，运行异常
        Iterator<String> it = a1.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s + ":" + s.length());
        }
    }
}
