package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//������Ϊ�¼������ߣ���Ҫʵ�ֶ�Ӧ��ItemListener�ӿ�
public class JCheckBoxDemo extends JFrame implements ItemListener {
    int red = 0, green = 0, blue = 0; // ������ɫ������ֵ
    private JLabel lb1; // ��Ϊ��ɫ�壬������ѡ��ɫ��ͬ������ɫ��֮�仯
    private JCheckBox ckb1, ckb2, ckb3; // ����졢�̡�����ɫ�Ƿ�ѡ�еĸ�ѡ��
    private Container container;

    public JCheckBoxDemo() {
        container = this.getContentPane();
        ckb1 = new JCheckBox("��ɫ"); // ������ѡ������ַ���Ϊ��ʾ��Ϣ
        ckb2 = new JCheckBox("��ɫ");
        ckb3 = new JCheckBox("��ɫ");
        lb1 = new JLabel(); // �����ձ�ǩ��Ϊ��ɫ��
        lb1.setMaximumSize(new Dimension(150, 200)); // ���óߴ�
        container.add(lb1, BorderLayout.CENTER); // �������ӵ�������
        JPanel p1 = new JPanel();
        p1.add(ckb1);
        p1.add(ckb2);
        p1.add(ckb3);
        // Ϊ���ע���¼��������򣬶�ItemEvent�¼����д���
        ckb1.addItemListener(this);
        ckb2.addItemListener(this);
        ckb3.addItemListener(this);
        if (1 == 1) {
            System.out.println("111");
        }
        container.add(p1, BorderLayout.SOUTH);
        // Ϊ����ע�ᴰ���¼��������򣬼����������������ʽ����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�˳�ϵͳ
        this.setTitle("ͼ�����ϵͳJCheckBoxʾ��");
        this.setSize(600, 450);
        this.setVisible(true);
    }

    public static void main(String[] arg) {
        new JCheckBoxDemo();
    }

    // ItemListener�ӿ��з�����ʵ�ְ�ť��״̬�����ı�ʱ�÷������ᱻ����
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() == ckb1) // �ж��¼�Դ
            if (e.getStateChange() == ItemEvent.SELECTED) // �ж����������û�б�ѡ��
                red = 255;
            else
                red = 0;
        if (e.getItem() == ckb2)
            if (ckb2.isSelected()) //�ж�����Ƿ�ѡ�У�ѡ��Ϊtrue����Ϊfalse
                green = 255;
            else
                green = 0;
        if (e.getSource() == ckb3)
            if (e.getStateChange() == ItemEvent.SELECTED)
                blue = 255;
            else
                blue = 0;
        lb1.setOpaque(true);// ���ñ�ǩΪ��͸����ʹ��ǩ����ɫ��ʾ����
        lb1.setBackground(new Color(red, green, blue));// ���ñ�ǩ�ı�����ɫ
    }
}