package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    Container container;

    public MainFrame() {
        this.setTitle("��ӭʹ��ͼ�����ϵͳ ");// ���ñ���
        container = this.getContentPane(); // ��ȡĬ�ϵ����ݴ���
        container.setLayout(new BorderLayout()); // ���ò��ָ�ʽ
        JMenuBar menuBar = new JMenuBar(); // �����˵���
        buildMainMenu(menuBar); // ����齨�˵��ķ���
        this.setJMenuBar(menuBar); // �Ѳ˵����ҵ��ô�����
        this.show(true); // ��ʾ����
        this.setSize(600, 450); // ���ô��ڴ�С
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    /* �����˵�������ƪ�����ޣ����������˵��ļ���ͼ����Ϣ��ѯ�Ͱ����˵� */
    protected void buildMainMenu(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("�ļ�(F)"); // �ļ��˵��Ĵ���
        JMenuItem exitMenuItem = new JMenuItem("�˳�");
        /* Ϊ�¼�ע�ᣬ��ActionEvent�¼��������� */
        exitMenuItem.addActionListener(new ExitActionListener());
        fileMenu.add(exitMenuItem); // ���˳��˵�����ӵ��˵���
        menuBar.add(fileMenu);// �ļ��˵���ӵ��˵�����
        /* ����ͼ����Ϣ��ѯ�˵�* */
        JMenu libMenu = new JMenu("�ݲؼ���(B)");
        libMenu.setMnemonic(KeyEvent.VK_B);// ��ͼ������˵��������Ǽ�
        JMenuItem libMenuItem = new JMenuItem("��Ŀ����");
        JMenuItem myBorrowMenuItem = new JMenuItem("�ҵĽ���");
        libMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));// �趨��ݼ�
        // Ϊ�¼�ע�ᣬBookInLibraryActionListenerΪ�ڲ���
        libMenuItem.addActionListener(new BookInLibraryActionListener());
        myBorrowMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));// �趨��ݼ�
        myBorrowMenuItem.addActionListener(new MyBorrowActionListener());
        libMenu.add(libMenuItem); // �Ѳ˵�����ӵ���ѯ�˵���
        libMenu.add(myBorrowMenuItem);
        menuBar.add(libMenu); // ��ѯ�˵���ӵ��˵�����
        /* �����˵��Ĵ��� */
        JMenu helpMenu = new JMenu("����(H)");
        helpMenu.setMnemonic(KeyEvent.VK_H);//�������˵��������Ǽ�
        JMenuItem aboutMenuItem = new JMenuItem("����");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.addActionListener(new AboutActionListener());// Ϊ�¼�ע��
        helpMenu.add(aboutMenuItem); // �ѹ��ڲ˵�����ӵ������˵���
        menuBar.add(helpMenu); // �����˵���ӵ��˵�����
    }

    /* libMenuItem�¼�Դ���¼�������������8-16���Jlist��Ĵ��� */
    class BookInLibraryActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new JComboBoxDemo();
        }
    }

    /* �ҵĽ��ĵ��¼�������������8-16���JTable��Ĵ��� */
    class MyBorrowActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new JRadioButtonDemo();
        }
    }

    /* �����˵��й��ڲ˵�����¼������� */
    class AboutActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
			/* ��ʱΪ�պ�ӶԻ��� */
        }
    }

    /* �ļ��˵����˳��˵�����¼������� */
    class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            dispose();
            System.exit(0);
        }
    }
}