package com.xl.face;

import com.xl.util.Print;

public class UnicodeTest {
    public static void main(String[] args) {
        // \u0022 是双引号的 Unicode转义字符 
        Print.println("a\u0022.length() +\u0022b".length());
        Print.println("a".length() + "b".length());
    }
}
