package com.xl.enumdemo;

import com.xl.util.Print;
import org.junit.Test;

//特殊的java类，每一个枚举相当一个枚举实例对象。
//注意：
//构造函数必须私有
public class EnumTest {
    @Test
    public void test() {
        // 1. 获取枚举的名称
        Print.info(Grade.C.name());
        Print.info(Grade.D.getValue());
        Print.info(Grade.D.name());
        Print.info(Grade.D.localeValue());
        // 2.将字符串改成枚举。valueOf
        String str = "B";
        // Grade g=Grade.valueOf(Grade.class,str);
        Grade g = Grade.valueOf(str);
        Print.info(g);
        //		3.返回所有的枚举值,在文档中没有。
        Grade[] gs = Grade.values();
        for (Grade g1 : gs) {
            Print.info(g1);
        }
    }
}
