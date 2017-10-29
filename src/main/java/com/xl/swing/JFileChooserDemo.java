package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooserDemo extends JFrame implements ActionListener {
    JFileChooser fc = new JFileChooser(); // �����ļ��Ի������
    JButton open, save;

    public JFileChooserDemo() {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        this.setTitle("�ļ��Ի�����ʾ����");
        open = new JButton("���ļ�"); // �������ť
        save = new JButton("�����ļ�");
        open.addActionListener(this);// Ϊ�¼�ע��
        save.addActionListener(this);
        container.add(open); // ��ӵ����ݴ�����
        container.add(save);
        this.show(true);
        this.setSize(600, 450);
    }

    public static void main(String args[]) {
        JFileChooserDemo fcd = new JFileChooserDemo();
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // �õ��¼�Դ
        if (button == open) {// ѡ����ǡ��򿪡���ť
            int select = fc.showOpenDialog(this); // ��ʾ���ļ��Ի���
            if (select == JFileChooser.APPROVE_OPTION) { // ѡ����Ƿ�Ϊȷ��
                File file = fc.getSelectedFile(); // ����ѡ�񴴽��ļ�����
                // ����Ļ����ʾ���ļ����ļ���
                System.out.println("�ļ�" + file.getName() + "����");
            } else
                System.out.println("�򿪲�����ȡ��");
        }
        if (button == save) {//ѡ����ǡ����桱��ť
            int select = fc.showSaveDialog(this); //��ʾ�����桱�ļ��Ի���
            if (select == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("�ļ�" + file.getName() + "������");
            } else
                System.out.println("���������ȡ��");
        }
    }
}