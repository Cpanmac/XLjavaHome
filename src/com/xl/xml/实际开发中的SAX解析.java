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

public class ʵ�ʿ����е�SAX���� {

	@Test
	public void read() throws Exception {
		// 1.������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.�õ�������
		SAXParser sp = factory.newSAXParser();
		// 3.�õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		// 4.�������ݴ�����
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler);
		// 5.��ȡxml�ĵ�����
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

// ��XML�ĵ��е�ÿһ�����װ��һ��book����,���Ѷ��book�������һ��list������
class BeanListHandler extends DefaultHandler {
	private List list = new ArrayList();
	private String currentTag;
	private Book book;

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		currentTag = name;
		if ("��".equals(currentTag)) {
			book = new Book();
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("����".equals(currentTag)) {
			String name = new String(ch, start, length);
			book.setName(name);
		}
		if ("����".equals(currentTag)) {
			String author = new String(ch, start, length);
			book.setAuthor(author);
		}
		if ("�ۼ�".equals(currentTag)) {
			String price = new String(ch, start, length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// ��������ǩΪ���ʱ��˵��ȫ���浽��book����,���ʱ����List
		if (qName.equals("��")) {
			list.add(book);
			// book=null; //�������ȥ��
		}
		// ���currentTag������null�����ָ���쳣,
		currentTag = null;
	}

	// �ṩList
	public List getBooks() {
		return list;
	}

}