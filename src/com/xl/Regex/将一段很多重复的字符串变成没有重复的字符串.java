package com.xl.Regex;

/*
 需求：
 将下列字符串转车：我要学编程。
 思路：
 1.如果只想找到该字符是否是对是错，使用匹配。
 2.如果将已有的字符串变成另一个字符串，替换。
 3.如果按照自定的方式将字符传变成多个字符串。切割。获取规则以外的子串
 4.想要拿到符合需求的字符串字串，获取。获取符合规则的字串。

 */
public class 将一段很多重复的字符串变成没有重复的字符串 {
    public static void main(String[] args) {
        test_1();
    }

    public static void test_1() {
        String str = "我我...我我...我要..要要...学学...学学学...编编...程程..程...程...";
        /*
         * 将已有字符串变成另一个字符串，使用替换功能。 1.可以先将. 去掉。 2.再将重复的内容变成单个的内容
		 */
        str = str.replaceAll("\\.+", "");
        System.out.println(str);
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
    }
}
