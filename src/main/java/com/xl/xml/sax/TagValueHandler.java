package com.xl.xml.sax;

import com.xl.util.Print;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * Created with IntelliJ IDEA. 内容处理器,得到xml文档内容,接口
 *
 * @author: 徐立
 * Date: 2017-11-21
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class TagValueHandler implements ContentHandler {
    // 读取
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 打印所有的文档内容
        Print.info(new String(ch));
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Print.info("结束了!");
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
        Print.info("开始读取");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        Print.info("<" + qName + ">");
        // 有可能抛出空指针异常
        for (int i = 0; atts != null && i < atts.getLength(); i++) {
            String attName = atts.getQName(i);
            String attValue = atts.getValue(i);
            Print.info(attName + "=" + attValue);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
}