package com.xl.xml;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 * �¼�����ķ�ʽ����XML,�¼��������г���Ա��д
 */
public class SAX����xml�ӿ�ʵ�� {
    //ʵ��ContentHandler�ӿڴ�����
    @Test
    public void read() throws Exception {
        // 1.������������
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.�õ�������
        SAXParser sp = factory.newSAXParser();
        // 3.�õ���ȡ��
        XMLReader reader = sp.getXMLReader();
        // 4.�������ݴ�����
        TagValueHandler handler = new TagValueHandler();
        reader.setContentHandler(handler);
        // 5.��ȡxml�ĵ�����
        reader.parse("book.xml");
    }
}

// ���ݴ�����,�õ�xml�ĵ�����,�ӿ�
class TagValueHandler implements ContentHandler {
    // ��ȡ
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // ��ӡ���е��ĵ�����
        System.out.println(new String(ch));
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("������!");
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }

    // ��ʼ��ȡ
    @Override
    public void startDocument() throws SAXException {
        System.out.println("��ʼ��ȡ");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("<" + qName + ">");
        // �п����׳���ָ���쳣
        for (int i = 0; atts != null && i < atts.getLength(); i++) {
            String attName = atts.getQName(i);
            String attValue = atts.getValue(i);
            System.out.println(attName + "=" + attValue);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
}