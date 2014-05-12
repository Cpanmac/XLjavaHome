package com.xl.html;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Iterator;

import org.dom4j.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import com.xl.util.FileTool;

/**
 * @Decription 利用Jsoup解析html
 * 
 * @date 2014年3月19日
 * 
 * @author 徐立
 * 
 */
public class HtmlDemo {
	/** 要解析的html */
	private File file;
	org.jsoup.nodes.Document doc;

	@Before
	public void init() throws IOException {
		file = new File(FileTool.getCurrentPath(this),
				"个人开公司的流程，以后用得着（经典）.html");
		doc = Jsoup.parse(file, "UTF-8");
	}

	@Test
	public void read() throws DocumentException, IOException {
		Elements content = doc.getElementsByTag("title");
		// System.out.println(content.html());
		Elements body = doc.getElementsByTag("body");
		// System.out.println(body.html().replaceAll("[\\s\\r\\n]+", " "));
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
