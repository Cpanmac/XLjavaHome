package com.xl.a;

import com.xl.util.FileTool;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllFile {
    private Frame f; // 可以直接继承Frame,就可以直接调用里面的方法了
    private TextField tf; // 文本框
    private Button but; // 按钮
    private TextArea ta; // 是显示文本的多行区域

    public static void main(String[] args) {
        new AllFile().init();
    }

    /**
     * 初始化控件 void
     */
    public void init() {
        f = new Frame("查看指定目录下所有的文件");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());
        tf = new TextField(60);// 文本长度
        but = new Button("查看");
        ta = new TextArea(25, 70);
        f.add(tf);
        f.add(but);
        f.add(ta);
        initEvent();
        f.setVisible(true); // 显示
    }

    /**
     * 初始化事件 void
     */
    private void initEvent() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    exec();
                }
            }
        });
        // 给button添加事件
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exec();
            }
        });
    }

    /**
     * 执行
     */
    public void exec() {
        String dirPath = tf.getText().trim();
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            ta.setText("");// 清空以前得
            List<File> list = new ArrayList<File>();
            FileTool.queryAll(dir, list);
            if (list.size() > 300) {
                ta.setText("该目录下文件太多了");
                return;
            }
            if (list.size() == 0) {
                ta.setText("该目录没有文件");
            }
            for (File f : list) {
                ta.append(f.getAbsolutePath() + "\r\n");
            }
        } else {
            ta.setText("请输入目录");
        }
    }
}
