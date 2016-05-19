package com.xl.IO;

import com.xl.util.NetUtil;
import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerDemo {
    @Test
    public void ¶ÁÈ¡Á÷() {
        String content = NetUtil.getContent("http://www.hao123.com");
        Scanner sr = new Scanner(content);
        String s;
        Pattern p = Pattern.compile(".+");
        while ((s = sr.findInLine(p)) != null) {
            System.out.println(s);
        }
    }
}
