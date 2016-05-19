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
 * 事件处理的方式解析XML,事件处理器有程序员编写
 */
public class SAX解析xml接口实现 {
    //实现ContentHandler接口处理器
    @Test
    public void read() throws Exception {
        // 1.创建解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.得到解析器
        SAXParser sp = factory.newSAXParser();
        // 3.得到读取器
        XMLReader reader = sp.getXMLReader();
        // 4.设置内容处理器
        TagValueHandler handler = new TagValueHandler();
        reader.setContentHandler(handler);
        // 5.读取xml文档内容
        reader.parse("book.xml");
    }
}

// 内容处理器,得到xml文档内容,接口
class TagValueHandler implements ContentHandler {
    // 读取
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 打印所有的文档内容
        System.out.println(new String(ch));
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束了!");
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

    // 开始读取
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始读取");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("<" + qName + ">");
        // 有可能抛出空指针异常
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