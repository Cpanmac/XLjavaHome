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

class 限制键盘只能输入数字 {
    private Frame f = null;
    private Button but = null;
    private TextField tf; // 添加一个文本框

    限制键盘只能输入数字() {
        init();
    }

    public static void main(String[] args) {
        new 限制键盘只能输入数字();
    }

    public void init() {
        f = new Frame("my frame");
        // 对Frame进行基本设置。
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout()); // 不想特别大
        tf = new TextField(20); // 将文本框的长度设置为20
        // 建立按钮
        but = new Button("这是一个按钮"); // 构造方法设置按钮内的内容
        // 将组件添加到frame中
        f.add(tf);
        f.add(but);
        myEvent(); // 加载一下窗体上的事件.
        // 显示窗体;
        f.setVisible(true);
    }

    private void myEvent() // 事件，全部都封装到这个方法中
    {
        f.addWindowListener(new WindowAdapter() // 添加指定的动作侦听器，以接收发自此按钮的动作事件。
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 限制文本框只能输入数字
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) // 键盘按下的事件
            {
                // 获取按键的Code码
                int code = e.getKeyCode();
                StringBuilder sb = new StringBuilder();
                if (!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) // 如果按下的键盘大于等于0小于等于9
                {
                    System.out.println(code + "非法");
                    sb.append(code);
                    System.out.print(sb.toString());
                    e.consume(); // 屏蔽键,使键无法进入文本框！
                }
            }
        });
        but.addActionListener(new ActionListener() // 添加指定的动作侦听器，以接收发自此按钮的动作事件
        {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action ok"); // 比下面后运行，不过这个可以用键盘上的空格控制
            }
        });
        // 给按钮添加一个键盘监听.
        but.addKeyListener(new KeyAdapter() // 在button事件源添加监听
        {
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyChar()+".."+e.getKeyCode());
                // //记录键盘的字符和数值
                System.out.println(KeyEvent.getKeyText(e.getKeyChar()) + ".." + e.getKeyCode()); // 返回按什么键KeyEvent.getKeyText(e.getKeyChar())
                // if(e.getKeyCode() == 27) //27是Ese按钮
                // if(e.getKeyCode() ==KeyEvent.VK_ENTER) //按回车结束,都是静态常量
                // System.exit(0);
                // 按Ctrl+回车结束
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
                    System.out.println("结束！");
            }
        });
        but.addMouseListener(new MouseAdapter() // 按钮的鼠标事件
        {
            private int count = 1;
            private int clickCount = 1; // 定义鼠标单机计数器

            /*
             * //鼠标单机动作 public void mouseClicked(MouseEvent e) {
             * System.out.println("鼠标单机该组件"); }
             */
            // 设置鼠标双击动作
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                    System.out.println("双击动作" + clickCount++);
            }

            public void mouseEntered(MouseEvent e) // 移动到按钮上，会触发
            {
                System.out.println("鼠标进入到该组件" + count++);
            }
        });
    }
}
