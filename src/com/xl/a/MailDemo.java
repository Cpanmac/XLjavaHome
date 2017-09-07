package com.xl.a;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailDemo {
    @Test
    public void getMails_1() throws IOException {
        URL url = new URL("http://tieba.baidu.com/p/1766362875");
        url = new URL("http://movie.douban.com/subject/2998425/discussion/40146400/");
        URLConnection conn = url.openConnection();
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        String mailreg = "\\w+@\\w+(\\.\\w+)+";
        Pattern p = Pattern.compile(mailreg);
        while ((line = bufIn.readLine()) != null)  //»»³ÉbufIn
        {
            //			System.out.println(line);
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
        bufIn.close();
    }
}
