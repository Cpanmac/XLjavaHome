package com.itcast.面试;

/**
 * @Decription 优柔寡断的返回值
 * @date 2014-5-15
 * @author 徐立
 */
public class ReturnValue {
    
    public static void main(String[] args) {
        System.out.println(decision());
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
