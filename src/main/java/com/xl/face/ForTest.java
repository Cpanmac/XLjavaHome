package com.xl.face;

import com.xl.util.Print;

/**
 * @author 徐立
 * @Decription 无情的增量操作
 * @date 2014-5-15
 */
public class ForTest {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        Print.println(j);
    }
}

