package com.xl.xml.sax;

import java.io.UnsupportedEncodingException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.xl.util.FileTool;

public class SAX解析指定标签的内容继承实现 {
	private String xmlPath;

	@Before
	public void init() throws UnsupportedEncodingException {
		xmlPath = FileTool.getCurrentPath(this) + "\\book.xml";
		System.out.println(xmlPath);
	}

	@Test
	public void read() throws Exception {
		// 1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.得到解析器
		SAXParser sp = factory.newSAXParser();
		// 3.得到读取器
		XMLReader reader = sp.getXMLReader();
		// 4.设置内容处理器
		ListHandler2 handler = new ListHandler2();
		reader.setContentHandler(handler);
		// 5.读取xml文档内容
		reader.parse(xmlPath);

	}
}

// 继承DefaultHandler,这个解析器是按顺序读的,要覆盖3个方法
class ListHandler2 extends DefaultHandler {
	private String currentTag; // 记录当前解析到的是什么标签
	private int needNumber = 1; // 记录想获取的第几个作者标签的值
	private int currentNumber; // 当前解析到第几个

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) {
		// 将标签名赋值给currentTag
		currentTag = name;
		// 当解析到第一个作者的时候currentNumber++
		if (currentTag.equals("作者")) {
			currentNumber++;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		if ("作者".equals(currentTag) && currentNumber == needNumber) {
			// 这就是标签里面的内容
			System.out.println(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) {
		// 当读到结束标签的时候置为空
		currentTag = null;

	}
}