package com.xl.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.xl.entity.Book;

public class 实际开发中的SAX解析 {

	@Test
	public void read() throws Exception {
		// 1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.得到解析器
		SAXParser sp = factory.newSAXParser();
		// 3.得到读取器
		XMLReader reader = sp.getXMLReader();
		// 4.设置内容处理器
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler);
		// 5.读取xml文档内容
		reader.parse("book.xml");
		List list = handler.getBooks();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.getName() + ".." + book.getAuthor() + ".."
					+ book.getPrice());
		}
	}
}

// 把XML文档中的每一本书封装到一个book对象,并把多个book对象放在一个list集合中
class BeanListHandler extends DefaultHandler {
	private List list = new ArrayList();
	private String currentTag;
	private Book book;

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		currentTag = name;
		if ("书".equals(currentTag)) {
			book = new Book();
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("书名".equals(currentTag)) {
			String name = new String(ch, start, length);
			book.setName(name);
		}
		if ("作者".equals(currentTag)) {
			String author = new String(ch, start, length);
			book.setAuthor(author);
		}
		if ("售价".equals(currentTag)) {
			String price = new String(ch, start, length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 当结束标签为书的时候说明全部存到了book对象,这个时候存进List
		if (qName.equals("书")) {
			list.add(book);
			// book=null; //这个可以去掉
		}
		// 如果currentTag不等于null会出空指针异常,
		currentTag = null;
	}

	// 提供List
	public List getBooks() {
		return list;
	}

}