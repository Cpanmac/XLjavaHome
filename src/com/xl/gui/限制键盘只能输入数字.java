package com.xl.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ���Ƽ���ֻ���������� {
    private Frame f = null;
    private Button but = null;
    private TextField tf; // ���һ���ı���

    ���Ƽ���ֻ����������() {
        init();
    }

    public static void main(String[] args) {
        new ���Ƽ���ֻ����������();
    }

    public void init() {
        f = new Frame("my frame");
        // ��Frame���л������á�
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout()); // �����ر��
        tf = new TextField(20); // ���ı���ĳ�������Ϊ20
        // ������ť
        but = new Button("����һ����ť"); // ���췽�����ð�ť�ڵ�����
        // �������ӵ�frame��
        f.add(tf);
        f.add(but);
        myEvent(); // ����һ�´����ϵ��¼�.
        // ��ʾ����;
        f.setVisible(true);
    }

    private void myEvent() // �¼���ȫ������װ�����������
    {
        f.addWindowListener(new WindowAdapter() // ���ָ���Ķ������������Խ��շ��Դ˰�ť�Ķ����¼���
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // �����ı���ֻ����������
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) // ���̰��µ��¼�
            {
                // ��ȡ������Code��
                int code = e.getKeyCode();
                StringBuilder sb = new StringBuilder();
                if (!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) // ������µļ��̴��ڵ���0С�ڵ���9
                {
                    System.out.println(code + "�Ƿ�");
                    sb.append(code);
                    System.out.print(sb.toString());
                    e.consume(); // ���μ�,ʹ���޷������ı���
                }
            }
        });
        but.addActionListener(new ActionListener() // ���ָ���Ķ������������Խ��շ��Դ˰�ť�Ķ����¼�
        {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action ok"); // ����������У�������������ü����ϵĿո����
            }
        });
        // ����ť���һ�����̼���.
        but.addKeyListener(new KeyAdapter() // ��button�¼�Դ��Ӽ���
        {
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyChar()+".."+e.getKeyCode());
                // //��¼���̵��ַ�����ֵ
                System.out.println(KeyEvent.getKeyText(e.getKeyChar()) + ".." + e.getKeyCode()); // ���ذ�ʲô��KeyEvent.getKeyText(e.getKeyChar())
                // if(e.getKeyCode() == 27) //27��Ese��ť
                // if(e.getKeyCode() ==KeyEvent.VK_ENTER) //���س�����,���Ǿ�̬����
                // System.exit(0);
                // ��Ctrl+�س�����
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
                    System.out.println("������");
            }
        });
        but.addMouseListener(new MouseAdapter() // ��ť������¼�
        {
            private int count = 1;
            private int clickCount = 1; // ������굥��������

            /*
             * //��굥������ public void mouseClicked(MouseEvent e) {
             * System.out.println("��굥�������"); }
             */
            // �������˫������
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                    System.out.println("˫������" + clickCount++);
            }

            public void mouseEntered(MouseEvent e) // �ƶ�����ť�ϣ��ᴥ��
            {
                System.out.println("�����뵽�����" + count++);
            }
        });
    }
}
