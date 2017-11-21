package com.xl.url;

import com.xl.util.FileTool;
import com.xl.util.Print;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
    /**
     * 获取该类目录下资源文件的URL
     *
     * @param clazz    类
     * @param resource 1.null或""或/:返回不包括自己得URL<br/>
     *                 2.:当前classpath的绝对路径
     * @return URL .class文件对应的绝对路径
     */
    public static URL getURL(Class clazz, String resource) {
        if (resource == null) {
            resource = "";
        }
        return clazz.getResource(resource);
    }

    @Test
    public void testUrl() throws Exception {
        String s = "http://www.hao123.com.com/juruboba/";
        URL url = new URL(s);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5000); // 5秒获取不到就超时
        Print.info(url.getProtocol() + url.getHost());
        conn.setRequestProperty("if-modifyed-since", System.currentTimeMillis() + ""); //  还不清楚这是做啥的
        Print.info(conn.getHeaderFields());
        // HTTPURL拥有更多的方法
        int code = conn.getResponseCode();// 200为返回成功,404找不到页面,500服务器出错
        Print.info("response状态码" + code);
        Print.info("请求方式:" + conn.getRequestMethod());
        Print.info("编码方式:" + conn.getHeaderField("Content-Type"));
        Print.info(conn.getURL());
    }

    @Test
    public void testGetURL() throws IOException {
        URL u = getURL(FileTool.class, "/");
        Print.info(u); // file:/D:/mywork/javaSE/bin/util/1
        Print.info(u.getContent()); // 如果有资源java.io.BufferedInputStream@983d95
        Print.info(u.getDefaultPort()); // -1
        Print.info(u.getPath()); // /D:/mywork/javaSE/bin/util/1
        Print.info(u.getFile()); // /D:/mywork/javaSE/bin/util/1
        File file = new File(u.getFile());
        Print.info(file.getAbsolutePath());// D:\mywork\javaSE\bin\\util
        File parent = file.getParentFile().getParentFile();
        Print.info(parent); // 当前工程的绝对路径D:\mywork\javaSE
    }
}
