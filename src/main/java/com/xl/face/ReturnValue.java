package com.xl.face;

import com.xl.util.Print;

/**
 * @author 徐立
 * @Decription 优柔寡断的返回值
 * @date 2014-5-15
 */
public class ReturnValue {
    public static void main(String[] args) {
        Print.info(decision());
    }

    @SuppressWarnings("finally")
    public static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
