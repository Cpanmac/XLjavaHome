/**
 * ��½����
 * JTextField
 */
package com.xl.gui;

import javax.swing.*;
import java.awt.*;

public class ��¼���� extends JFrame {
    //�������
    JPanel jp1, jp2, jp3, jp4;
    JLabel jlb1, jlb2;
    JButton jb1, jb2;
    JTextField jtf1, jtf2;

    //���캯��
    public ��¼����() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jlb1 = new JLabel("�û���");
        jlb2 = new JLabel("�� ��");
        jb1 = new JButton("��¼");
        jb2 = new JButton("ȡ��");
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        //���ò��ֹ���
        this.setLayout(new GridLayout(3, 1));
        //����������
        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp3.add(jb1);
        jp3.add(jb2);
        //���뵽JFrame
        this.setTitle("��¼����");
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setSize(300, 150);
        this.setResizable(false);
        //�˳������˳�jvm
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��ʾ
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ��¼���� demo = new ��¼����();
    }
}
