package com.xl.face;

import com.xl.util.Print;

public class MyClass {
    public static void main(String[] args) {
        Print.info(MyClass.class.getName().
                replaceAll("\\.", "/") + ".class");
    }
}

