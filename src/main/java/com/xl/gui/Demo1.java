package com.xl.gui;

import org.junit.Test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//GUI编程
public class Demo1 {
    @Test
    public void test1() {
        // 创建一个不可见窗体
        Frame f = new Frame();
        // 设置窗体的大小
        f.setSize(200, 250);
        // 设置显示的位置
        f.setLocation(300, 200);
        // 将窗体显示出来
        f.setVisible(true);
        // 为窗体添加事件（事件监听器监听事件源
        f.addWindowListener(new MyWindowListener());
        try {
            Thread.sleep(10000); // 让线程等待
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

// 适配器模式
class MyWindowListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        // 取得事件源
        Frame frame = (Frame) e.getSource();
        frame.setVisible(false);
        System.exit(0);
    }
}

// 1.事件监听器,这样太麻烦了可以选择适配器模式
class MyWindowListener1 implements WindowListener {
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("呵呵");
        // 取得事件源
        Frame frame = (Frame) e.getSource();
        frame.setVisible(false);
        System.exit(0);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }
}
