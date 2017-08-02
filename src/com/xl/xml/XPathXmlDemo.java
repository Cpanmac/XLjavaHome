package com.xl.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

//���xml�ĵ��ܴ�.���ٶ�λ��Ҫ������
/*
 "/"��ʾ����·��
 "//"��ʾ���·��
 "*"��ʾ������*֮ǰ��·������λ��Ԫ��

 */
public class XPathXmlDemo {
    /*
     * "//foo/bar"��ȡ�����е�bar�ڵ�"//foo/bar/author" �õ���һ���ڵ�
	 */ File f = new File("xml/book.xml"); // Ҫ���ص�xml�ļ�

    @Test
    public void test() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(f);
        // select��������xpath���ʽ
        String value = document.selectSingleNode("//����").getText(); // ��ȡ��һ�����ߵ�ֵ
        System.out.println(value);
    }

    // ����users.xml�Ƿ��к��û�ƥ����û���������
    @Test
    public void find() throws DocumentException {
        String username = "aaa";
        String password = "123";
        // ���xml�ĵ��Ƿ���ƥ��
        SAXReader reader = new SAXReader();
        f = new File("xml/User.xml");
        Document document = reader.read(f);
        // 1:���b����Ҫ������������,�����Ҳ���
        // �ҳ����е�user�ڵ�
        Node node = document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']"); // �ض��ַ���
        if (node == null) {
            System.out.println("�û������������");
        } else {
            System.out.println("��½�ɹ�");
        }
    }
}
