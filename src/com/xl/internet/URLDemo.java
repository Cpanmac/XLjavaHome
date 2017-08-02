package com.xl.internet;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDemo {
    @SuppressWarnings("deprecation")
    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "dseÖÐ¹úsdf";
        String _s = java.net.URLEncoder.encode(s);
        System.out.println(_s);
        _s = java.net.URLEncoder.encode(s, "UTF-8");
        System.out.println(_s);
        _s = java.net.URLEncoder.encode(s, "GBK");
        System.out.println(_s);
        s = URLDecoder.decode(s);
        System.out.println(s);
    }
}
