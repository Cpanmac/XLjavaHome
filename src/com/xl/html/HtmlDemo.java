package com.xl.html;

import com.xl.util.FileTool;
import com.xl.util.RegTool;
import org.dom4j.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 * @author 徐立
 * @Decription 利用Jsoup解析html
 * @date 2014年3月19日
 */
public class HtmlDemo {
    org.jsoup.nodes.Document doc;
    /**
     * 要解析的html
     */
    private File file;
    private URL url;
    private int timeout = 5000;

    @Before
    public void init() throws IOException {
        file = new File(FileTool.getCurrentPath(this), "个人开公司的流程，以后用得着（经典）.html");
        doc = Jsoup.parse(file, "UTF-8");
        url = new URL("http://www.baidu.com/baidu?word=%E9%A3%8E%E6%99%AF&ie=utf-8&tn=98012088_2_dg&1402964659639");
        url = new URL("http://bbs.goumin.com/thread-2939853-1-1.html");
    }

    /**
     * 大写小写都可以
     *
     * @throws DocumentException
     * @throws IOException
     */
    @Test
    public void read() throws DocumentException, IOException {
        Elements content = doc.getElementsByTag("title");
        // System.out.println(content.html());
        content = doc.getElementsByTag("TITLE");
        System.out.println(content);
        Elements body = doc.getElementsByTag("body");
        // System.out.println(body.html().replaceAll("[\\s\\r\\n]+", " "));
    }

    @Test
    public void internet() throws IOException {
        doc = Jsoup.parse(url, timeout);
        // System.out.println(doc);
        Elements e = doc.getElementsByTag("a");
        String content = e.toString().replaceAll("\r", " ");
        // System.out.println(content);
        String[] str = RegTool.getContent(content, "home.php.*?_blank.*?>(.*?)<", 1);
        System.out.println(Arrays.toString(str));
        // while(e.hasText()){
        // System.out.println(e.attr("href"));
        // }
    }

    @Test
    public void a() {
        Elements a = doc.getElementsByTag("a");
        for (Element e : a) {
            System.out.println(e);
            System.out.println(e.attr("href"));
        }
    }
}
