package com.xl.a;

import com.xl.util.FileTool;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllFile {
    private Frame f; // ����ֱ�Ӽ̳�Frame,�Ϳ���ֱ�ӵ�������ķ�����
    private TextField tf; // �ı���
    private Button but; // ��ť
    private TextArea ta; // ����ʾ�ı��Ķ�������

    public static void main(String[] args) {
        new AllFile().init();
    }

    /**
     * ��ʼ���ؼ� void
     */
    public void init() {
        f = new Frame("�鿴ָ��Ŀ¼�����е��ļ�");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());
        tf = new TextField(60);// �ı�����
        but = new Button("�鿴");
        ta = new TextArea(25, 70);
        f.add(tf);
        f.add(but);
        f.add(ta);
        initEvent();
        f.setVisible(true); // ��ʾ
    }

    /**
     * ��ʼ���¼� void
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
        // ��button����¼�
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exec();
            }
        });
    }

    /**
     * ִ��
     */
    public void exec() {
        String dirPath = tf.getText().trim();
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            ta.setText("");// �����ǰ��
            List<File> list = new ArrayList<File>();
            FileTool.queryAll(dir, list);
            if (list.size() > 300) {
                ta.setText("��Ŀ¼���ļ�̫����");
                return;
            }
            if (list.size() == 0) {
                ta.setText("��Ŀ¼û���ļ�");
            }
            for (File f : list) {
                ta.append(f.getAbsolutePath() + "\r\n");
            }
        } else {
            ta.setText("������Ŀ¼");
        }
    }
}
