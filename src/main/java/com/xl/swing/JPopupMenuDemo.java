package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPopupMenuDemo extends JFrame {
    JPopupMenu popMenu = new JPopupMenu();

    public JPopupMenuDemo() {
        Container container = this.getContentPane();
        this.addMouseListener(new mouseLis());
        /* ����4���˵������ӵ�����ʽ�˵��� */
        JMenuItem save = new JMenuItem("Save");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem exit = new JMenuItem("Exit");
        popMenu.add(save);
        popMenu.add(cut);
        popMenu.add(copy);
        popMenu.addSeparator(); // ���һ���ָ���
        popMenu.add(exit);
        this.show(true);
        this.setSize(600, 450);
    }

    public static void main(String[] args) {
        new JPopupMenuDemo();
    }

    class mouseLis extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) // �ж��Ƿ�����������Ҽ�
                popMenu.show(e.getComponent(), e.getX(), e.getY()); // �ڵ�ǰλ����ʾ
        }
    }
}