package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//������Ϊ�¼������ߣ���Ҫʵ�ֶ�Ӧ�Ľӿ�
public class JTextFieldDemo extends JFrame implements ActionListener {
    private JLabel lb2;
    private JTextField t1, t2;

    public JTextFieldDemo() {
        this.setLayout(new FlowLayout()); //���ò��ֹ���
        JLabel lb1 = new JLabel("������һ����������");
        lb2 = new JLabel("1�������ĺ�Ϊ��");// ������ǩ�����ַ���Ϊ��ʾ��Ϣ
        t1 = new JTextField(10);// ���������ı��������ʾ10���ַ�
        t2 = new JTextField(10);
        this.add(lb1); // �������ӵ�������
        this.add(t1);
        this.add(lb2);
        this.add(t2);
        t1.addActionListener(this);// Ϊ�ı���ע��ActionEvent�¼�������
        // Ϊ����ע�ᴰ���¼��������򣬼����������������ʽ����
        this.addWindowListener(new WindowAdapter() {// �����࿪ʼ
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } // ���ڹر�
        });// ���������
        this.setTitle("ͼ�����ϵͳJTextFieldʾ��");//���ô������
        this.setSize(600, 450);//���ô��ڴ�С
        this.setVisible(true);//���ô���Ŀɼ���
    }

    public static void main(String[] arg) {
        new JTextFieldDemo();
    }

    public void actionPerformed(ActionEvent e) { // ActionListener�ӿ��з�����ʵ��
        // getText()��ȡ�ı�����������ݣ�ת��Ϊ������ֵ
        int n = Integer.parseInt(t1.getText());
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum = sum + i;
        t2.setText(String.valueOf(sum)); // �޸��ı����������
    }
}