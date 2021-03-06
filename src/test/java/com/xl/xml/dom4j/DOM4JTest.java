package com.xl.xml.dom4j;

import com.xl.encode.Encode;
import com.xl.util.FileTool;
import com.xl.util.Print;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
//乱码产生原因:io流
//本身是按utf-8来的

/**
 * @author 徐立
 * @Decription 1.创建解析器。<br/>2.
 * @date 2014-5-11
 */
public class DOM4JTest {
    /**
     * 要解析的xml
     */
    private File file;
    /**
     * 解析器
     */
    private SAXReader saxReader;
    /**
     * 文档对象
     */
    private Document document;

    @Before
    public void init() throws UnsupportedEncodingException, DocumentException {
        file = FileTool.getResourceFile("xml\\book.xml");
        saxReader = new SAXReader();
        document = saxReader.read(file);
    }

    @Test
    public void getEncoding() {
        Print.info(document.getXMLEncoding());
        Print.info(document.getName());
    }

    @Test
    public void createNoEncoding() throws IOException {
        XMLWriter writer = new XMLWriter(new FileOutputStream(file));
        writer.write(document);
        writer.close();
    }

    // 方法二,解决编码问题:FileOutputStream
    @Test
    public void add() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element book = document.getRootElement();
        book.addElement("售价").setText("208");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(com.xl.encode.Encode.UTF);
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    // 增:在第一本指定的位置添加一个新的售价:<售价>305元</售价>,用list.add添加
    @Test
    public void add2() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element books = document.getRootElement();
        // 得到书
        Element book = books.element("书");
        Print.info(book.getName());
        // 得到书的所有子节点
        List list = book.elements();
        // 创建节点
        Element price = DocumentHelper.createElement("售价");
        price.setText("305元");
        // 在第二个位置添加
        list.add(2, price);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            // 打印list集合里面的内容
            Print.info(it.next());
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(com.xl.encode.Encode.UTF);
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    // 删:删除刚才加的节点,得到父节点删除自己
    @Test
    public void delete() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element price = document.getRootElement().element("书").element("售价");
        price.getParent().remove(price);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(com.xl.encode.Encode.UTF);
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    @Test
    public void deleteAllTest() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element e = document.getRootElement();
        List<Element> children = e.elements();
        for (Element e1 : children) {
            e.remove(e1);
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(com.xl.encode.Encode.UTF);
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
        FileTool.open(file);
    }

    @Test
    public void read() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        // 先得根节点,不能直接按节点名得
        Element root = document.getRootElement();
        // Element book=root.element("书");
        // 要得到第二本书的文本
        Element book = (Element) root.elements("书").get(1);
        String value = book.element("书名").getText();
        Print.info(value);
        // 得到第二本书的属性值
        value = book.element("书名").attributeValue("name");
        Print.info(value);
    }

    /**
     * 改:得到节点setText方法
     *
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        // 得到第二本书
        Element book = (Element) document.getRootElement().elements("书").get(1);
        book.element("作者").setText("哈喽");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(com.xl.encode.Encode.UTF);
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    /**
     * 写:在第一本书添加一个新的售价,OutputStreamWriter
     */
    @Test
    public void write() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element book = document.getRootElement();
        book.addElement("售价").setText("209元");
        // OutputStreamWriter可以指定码表
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file, true), com.xl.encode.Encode.UTF));
        // 创建格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(Encode.GBK);
        // 两个编码要一致就不会出现乱码
        writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file), Encode.GBK), format);
        writer.write(document);
        writer.close();
    }

    @After
    public void after() throws IOException {
        FileTool.open(file);
    }
}
