package com.xl.xml;

import com.xl.util.FileTool;
import org.junit.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class XmlDemo {
    File file;

    public void init() throws UnsupportedEncodingException {
        file = new File(FileTool.getCurrentPath(this), "User.xml");
    }

    @Test
    public void test() {
        try {
            long lasting = System.currentTimeMillis();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(file);
            NodeList n1 = doc.getElementsByTagName("name");
            for (int i = 0; i < n1.getLength(); i++) {
                System.out.print(doc.getElementsByTagName("psw"));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
