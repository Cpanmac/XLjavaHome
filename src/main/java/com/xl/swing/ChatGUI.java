package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGUI extends JFrame implements ActionListener {
    private final Container container;
    private final JButton send; // ���Ͱ�ť
    private final JTextArea chatContent; // ����������
    private final JTextField sentence; // ������Ϣ��

    private ChatGUI() {
        setLocation(300, 200);
        super.setTitle("���촰��");// ���ô��ڱ���
        this.setSize(400, 300); // ���ô��ڴ�С
        container = this.getContentPane(); // ��������ڵ��������
        container.setLayout(new BorderLayout()); // ���ò��ַ�ʽΪBorderLayout
        JScrollPane centerPanel = new JScrollPane(); // �������ڴ�������¼�Ĺ������
        chatContent = new JTextArea(); // ��������������ݵĶ����ı�����������
        centerPanel.setViewportView(chatContent); // ���ı�������������
        // ���������ŵ������������������
        container.add(centerPanel, BorderLayout.CENTER);
        chatContent.setEditable(false); // ���ı�����Ϊ���ɱ༭״̬
        // �����ײ������󣬴�������ǩ�������������Ͱ�ť
        JPanel bottomPanel = new JPanel();
        sentence = new JTextField(20); // �����ı������ж��󣬴��ÿ�ε���������
        send = new JButton("����"); // ������ť����
        bottomPanel.add(new JLabel("������Ϣ")); // ����ǩ��ӵ��ײ����
        bottomPanel.add(sentence); // ��������������ӵ��ײ������
        bottomPanel.add(send); // �ѷ��Ͱ�ť��ӵ��ײ������
        container.add(bottomPanel, BorderLayout.SOUTH);// ���ײ������������ڵĵײ�
        send.addActionListener(this); // ע�ᷢ�Ͱ�ť�Ķ����¼�
        sentence.addActionListener(this); // ע���������Ķ����¼�
        this.setVisible(true); // ��ʾ������
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�˳�ϵͳ
    }

    public static void main(String[] arg) {
        new ChatGUI();
    }

    public void actionPerformed(ActionEvent e) {
        String str = sentence.getText(); // ��ȡ���������������Ϣ
        if (str != null && !str.equals("")) // ����������ݲ�Ϊ�գ�������Ϣ
            chatContent.append("����:  " + str + "\n");// �����˷��͵�������Ϣ׷�ӵ�����������
        else
            chatContent.append("������Ϣ����Ϊ��\n");
        sentence.setText(""); // ����������������
    }
}