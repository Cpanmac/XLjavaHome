package com.xl.internet;

import com.xl.encode.Encode;
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
        Print.info(_s);
        _s = java.net.URLEncoder.encode(s, Encode.UTF);
        Print.info(_s);
        _s = java.net.URLEncoder.encode(s, Encode.GBK);
        Print.info(_s);
        s = URLDecoder.decode(s);
        Print.info(s);
    }
}
