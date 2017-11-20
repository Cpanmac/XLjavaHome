package com.xl.face;

import com.xl.util.Print;

public class GoodBye {
    public static void main(String[] args) {
        try {
            Print.println("Hello world");
            System.exit(0);
        } finally {
            Print.println("Goodbye world");
        }
    }
}
