package com.xl.face;

/**
 * @author ����
 * @Decription ����Ѷϵķ���ֵ
 * @date 2014-5-15
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
