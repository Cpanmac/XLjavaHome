package com.xl.internet;

import com.xl.util.Print;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDemo {
    @SuppressWarnings("deprecation")
    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "dse中国sdf";
        String _s = java.net.URLEncoder.encode(s);
        Print.println(_s);
        _s = java.net.URLEncoder.encode(s, "UTF-8");
        Print.println(_s);
        _s = java.net.URLEncoder.encode(s, "GBK");
        Print.println(_s);
        s = URLDecoder.decode(s);
        Print.println(s);
    }
}
