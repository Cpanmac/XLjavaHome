package com.xl.xml.dom4j;

import com.xl.util.FileTool;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
//�������ԭ��:io��
//�����ǰ�utf-8����

/**
 * @author ����
 * @Decription 1.������������<br/>2.
 * @date 2014-5-11
 */
public class DOM4JDemo {
    /**
     * Ҫ������xml
     */
    private File file;
    /**
     * ������
     */
    private SAXReader saxReader;
    /**
     * �ĵ�����
     */
    private Document document;

    @Test
    public void createNoEncoding() {
        File file = new File("a");
        //XMLWriter writer = new XMLWriter(new FileOutputStream(file));
        //writer.write(document);
        //writer.close();
    }

    // ������,�����������:FileOutputStream
    @Test
    public void add() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element book = document.getRootElement();
        book.addElement("�ۼ�").setText("208");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    // ��:�ڵ�һ��ָ����λ�����һ���µ��ۼ�:<�ۼ�>305Ԫ</�ۼ�>,��list.add���
    @Test
    public void add2() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element books = document.getRootElement();
        // �õ���
        Element book = books.element("��");
        System.out.println(book.getName());
        // �õ���������ӽڵ�
        List list = book.elements();
        // �����ڵ�
        Element price = DocumentHelper.createElement("�ۼ�");
        price.setText("305Ԫ");
        // �ڵڶ���λ�����
        list.add(2, price);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            // ��ӡlist�������������
            System.out.println(it.next());
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    // ɾ:ɾ���ղżӵĽڵ�,�õ����ڵ�ɾ���Լ�
    @Test
    public void delete() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element price = document.getRootElement().element("��").element("�ۼ�");
        price.getParent().remove(price);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
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
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
        FileTool.open(file);
    }

    @Before
    public void init() throws UnsupportedEncodingException, DocumentException {
        file = new File(FileTool.getCurrentPath(this), "book.xml");
        saxReader = new SAXReader();
        document = saxReader.read(file);
    }

    @Test
    public void queryAll() {
    }

    @Test
    public void getEncoding() {
        System.out.println(document.getXMLEncoding());
        System.out.println(document.getName());
    }

    @Test
    public void read() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        // �ȵø��ڵ�,����ֱ�Ӱ��ڵ�����
        Element root = document.getRootElement();
        // Element book=root.element("��");
        // Ҫ�õ��ڶ�������ı�
        Element book = (Element) root.elements("��").get(1);
        String value = book.element("����").getText();
        System.out.println(value);
        // �õ��ڶ����������ֵ
        value = book.element("����").attributeValue("name");
        System.out.println(value);
    }

    // ��:�õ��ڵ�setText����
    @Test
    public void update() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        // �õ��ڶ�����
        Element book = (Element) document.getRootElement().elements("��").get(1);
        book.element("����").setText("���");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
    }

    // д:�ڵ�һ�������һ���µ��ۼ�,OutputStreamWriter
    @Test
    public void write() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element book = document.getRootElement();
        book.addElement("�ۼ�").setText("209Ԫ");
        // OutputStreamWriter����ָ�����
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"));
        // ������ʽ�������
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gb2312");
        // ��������Ҫһ�¾Ͳ����������
        writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file), "gb2312"), format);
        writer.write(document);
        writer.close();
    }
}
