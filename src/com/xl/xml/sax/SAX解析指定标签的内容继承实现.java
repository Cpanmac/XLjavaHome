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

public class SAX����ָ����ǩ�����ݼ̳�ʵ�� {
	private String xmlPath;

	@Before
	public void init() throws UnsupportedEncodingException {
		xmlPath = FileTool.getCurrentPath(this) + "\\book.xml";
		System.out.println(xmlPath);
	}

	@Test
	public void read() throws Exception {
		// 1.������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.�õ�������
		SAXParser sp = factory.newSAXParser();
		// 3.�õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		// 4.�������ݴ�����
		ListHandler2 handler = new ListHandler2();
		reader.setContentHandler(handler);
		// 5.��ȡxml�ĵ�����
		reader.parse(xmlPath);

	}
}

// �̳�DefaultHandler,����������ǰ�˳�����,Ҫ����3������
class ListHandler2 extends DefaultHandler {
	private String currentTag; // ��¼��ǰ����������ʲô��ǩ
	private int needNumber = 1; // ��¼���ȡ�ĵڼ������߱�ǩ��ֵ
	private int currentNumber; // ��ǰ�������ڼ���

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) {
		// ����ǩ����ֵ��currentTag
		currentTag = name;
		// ����������һ�����ߵ�ʱ��currentNumber++
		if (currentTag.equals("����")) {
			currentNumber++;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		if ("����".equals(currentTag) && currentNumber == needNumber) {
			// ����Ǳ�ǩ���������
			System.out.println(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) {
		// ������������ǩ��ʱ����Ϊ��
		currentTag = null;

	}
}