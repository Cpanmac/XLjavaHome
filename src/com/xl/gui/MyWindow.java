package com.xl.gui;

/*
 ��ϰ-�г�ָ��Ŀ¼����

 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyWindow {
    private Frame f; // ����ֱ�Ӽ̳�Frame,�Ϳ���ֱ�ӵ�������ķ�����
    private TextField tf; // �ı���
    private Button but; // ��ť
    private TextArea ta; // ����ʾ�ı��Ķ�������
    private Dialog d; // Dialog��������һ���ı���ʾ��һ��ȷ����ť
    private Label lab;
    private Button okBut;

    MyWindow() {
        init();
    }

    public static void main(String[] args) {
        new MyWindow();
    }

    public void init() // ��ʹ
    {
        f = new Frame("��ʾָ��·���µ��ļ�");
        f.setBounds(300, 100, 600, 500); // ���ָ�Frame������Ļ��ߵľ��룬�����ϱߵľ��롣�ı������곤�ȣ������곤��
        f.setLayout(new FlowLayout()); // ���ò��ֹ��������֣�Ĭ���Ǳ߽粼�֣������ָ�϶���������ȫ���
        // tf = new TextField(30); //�ı�����
        // �����������
        tf = new TextField(60);
        but = new Button("ת��"); // ��ť������
        // ta = new TextArea(15,40); //�ı�����
        ta = new TextArea(25, 70);
        d = new Dialog(f, "��ʾ��Ϣ-self", true); // ģʽtrue
        // ������ӵ�Frame������,���Ϊfalse�������ƹ��Ի��򣬼�����������
        d.setBounds(400, 200, 200, 150); // �Ի����λ��
        d.setLayout(new FlowLayout());
        lab = new Label(); // ��ʼ������֪��ɶ��Ϣ
        okBut = new Button("ȷ��"); // ���ȷ����ť
        d.add(lab);
        d.add(okBut);
        f.add(tf);
        f.add(but);
        f.add(ta);
        myEvent();// �¼�
        f.setVisible(true); // ��ʾ����
    }

    private void myEvent() {
        okBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.addWindowListener(new WindowAdapter() // ����رմ������¼�
        {
            public void windowClosing(WindowEvent e) // ���ùر��¼�
            {
                d.setVisible(false); // �ء����ܹص����ͰѶԻ���ȡ��
            }
        });
        f.addWindowListener(new WindowAdapter() // ����رմ������¼�
        {
            public void windowClosing(WindowEvent e) // ���ùر��¼�
            {
                System.exit(0);
            }
        });
        // ȷ���¼�Դ���ı���
        but.addActionListener(new ActionListener() // ���ת����ť�������¼�
        {
            // ��ȡ�ı�����
            public void actionPerformed(ActionEvent e) {
                // ����Ŀ¼
                showDir();
            }
        });
        // ��������ť�����س����� tf�ı���
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    showDir();
            }
        });
        /*
         * //��ʾ String text = tf.getText(); tf.setText(""); //��������ա� //�����ı����������
		 * ta.setText(text); //���ַ������ı���������ʾ // System.out.print(text);
		 */
        // ��װһ�¹���
    }

    private void showDir() {
        String dirPath = tf.getText();
        File dir = new File(dirPath); // ��װ�ɶ���
        if (dir.exists() && dir.isDirectory()) // �����Ŀ¼���Ҵ���
        {
            ta.setText(""); // ����ǰ�����
            String[] names = dir.list();
            for (String name : names) {
                // ta.setText(name+"\r\n"); //��������������Ḳ�ǣ�
                ta.append(name + "\r\n"); // ׷���ı�
            }
        } else {
            // ������ʾ�Ĵ�����Ϣ����
            String info = "���������Ϣ��" + dirPath + "�Ǵ���ġ�����������";
            lab.setText(info); // ����Ϣ���뵽�ı���
            d.setVisible(true); // �öԻ�����ʾ
        }
    }
}
