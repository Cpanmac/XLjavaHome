package com.xl.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class JaxpXml {
    @Test
    public void read() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        NodeList list = document.getElementsByTagName("����");
        // getLength��ȡ�б�ڵ���
        System.out.println(list.getLength());
        // ��ȡ�ڵ�
        Node node = list.item(1);
        // ��ȡ�ڵ��е�����
        String content = node.getTextContent();
        System.out.println(content);
    }

    // �õ����еı�ǩ
    @Test
    public void read2() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        // �õ����ڵ�
        Node root = document.getElementsByTagName("���").item(0);
        list(root);
    }

    // �õ�xml�б�ǩ������ֵ:<���� name="xxx">
    @Test
    public void read3() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        // Element��Node������,ǿת
        Element bookName = (Element) document.getElementsByTagName("����").item(0);
        String value = bookName.getAttribute("name");
        System.out.println(value);
    }

    // ��xml�ĵ���ӽڵ�:<�ۼ�>59.00Ԫ</�ۼ�>
    @Test
    public void add() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        // �����ڵ�
        Element price = document.createElement("�ۼ�");
        price.setTextContent("59.00Ԫ");
        // �Ѵ����Ľڵ�ҵ���һ������
        Element book = (Element) document.getElementsByTagName("��").item(0);
        //		book.appendChild(price);
        // �Ѹ��º��ڴ�д��xml�ĵ�
        TransformerFactory tsf = TransformerFactory.newInstance();
        Transformer tf = tsf.newTransformer();
        //		tf.transform(new DOMSource(document), new StreamResult(
        //				new FileOutputStream("xml/book.xml")));
        // ��ָ��λ����ӽڵ�,���ۼ۽ڵ�֮ǰ��
        // �õ��ο��ڵ�refChild
        Element refNode = (Element) document.getElementsByTagName("�ۼ�").item(0);
        // ��Ҫ���صĽڵ�(���ڵ�)book
        // ��book�ڵ��ָ��λ�ò���
        book.insertBefore(price, refNode);
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
        System.out.println("�ļ����³ɹ�!");
    }

    // ��xml�ĵ����name����:<���� name="xxx">59.00Ԫ</����>
    @Test
    public void add2() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        Element bookname = (Element) document.getElementsByTagName("����").item(0);
        bookname.setAttribute("name", "xxxx");
        TransformerFactory tsf = TransformerFactory.newInstance();
        Transformer tf = tsf.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
        System.out.println("�ļ����³ɹ�!");
    }

    //ɾ���ڵ�
    @Test
    public void delete() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");
        //�õ�ɾ���Ľڵ�
        Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
        //		�õ�Ҫɾ���ڵ�İְ�
        //		1.�õõ����ڵ�
        Element book = (Element) e.getParentNode();
        book.removeChild(e);
        TransformerFactory tsf = TransformerFactory.newInstance();
        Transformer tf = tsf.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
        System.out.println("�ļ����³ɹ�!");
        //��д:   e.getParentNode().removeChild(e);
        //ɾ�����ڵ� e.getParentNode().getParentNode().removeChild(e.getParentNode());
    }

    // ��ӡ�ڵ�
    private void list(Node node) {
        // �ж����node�Ǳ�ǩ.�ʹ�ӡ���ı���ʲôҲ����
        if (node instanceof Element) {
            System.out.println(node.getNodeName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            list(child);
        }
    }
}
