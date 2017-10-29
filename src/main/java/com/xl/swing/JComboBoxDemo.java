package com.xl.swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxDemo extends JFrame {
    protected JLabel selectionLabel;
    protected JComboBox fieldComboBox;
    protected JPanel topPanel;
    protected JButton retrievalButton;
    protected JTextField keywordText;
    protected String fieldSelected;
    protected JList bookListBox; //��ʾ��������ͼ����Ϣ
    protected JButton detailsButton;//�鿴ĳ��ͼ�����ϸ��Ϣ�İ�ť
    protected JScrollPane bookScrollPane; // ��JList����JScrollPane���ֹ����˵�Ч��
    protected JPanel bottomPanel;//�м�����
    private Container container;

    public JComboBoxDemo() {
        container = this.getContentPane();
        selectionLabel = new JLabel("������ʽ"); // ��ǩ
        fieldComboBox = new JComboBox(); // ������������б�
        fieldComboBox.addItem("��ѡ��...");
        fieldComboBox.addItem("����");
        fieldComboBox.addItem("ISBN��");
        fieldComboBox.addItem("����");
        fieldComboBox.addItem("����");
        //ע���¼�������FieldSelectedListenerΪ�ڲ���
        fieldComboBox.addItemListener(new FieldSelectedListener());
        keywordText = new JTextField("java", 20); // ��ʾ�����ؼ��ֵ��ı���
        retrievalButton = new JButton("����"); //�ύ���ť
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        keywordText.setSize(topPanel.getWidth() / 2, topPanel.getWidth());
        topPanel.add(selectionLabel);
        topPanel.add(fieldComboBox);
        topPanel.add(keywordText);
        topPanel.add(retrievalButton);
        //��Ӻ���Ĵ���JList��ʾ��������
        this.add(BorderLayout.NORTH, topPanel);
        this.setTitle("ͼ�����ϵͳͼ���ѯ");
        this.setSize(600, 450);
        this.setVisible(true);
        //Ϊ������ť����¼�������
        retrievalButton.addActionListener(new RetrievalActionListener());
        bookListBox = new JList();
        //�����б�һ��ֻ��ѡ��һ�����������ѡ
        bookListBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Ϊ�б�ע���¼������ߣ����û�ѡ��ı���д���
        bookListBox.addListSelectionListener(new BookSelectionListener());
        bookScrollPane = new JScrollPane(bookListBox);
        this.add(BorderLayout.CENTER, bookScrollPane);
        //�����ʾĳһ������������ť
        detailsButton = new JButton("��ϸ...");
        //detailsButton.addActionListener(new DetailsActionListener());
        detailsButton.setEnabled(false); //��ʼ�����ã�ѡ������Ϊ����
        bottomPanel = new JPanel();
        bottomPanel.add(detailsButton);
        this.add(BorderLayout.SOUTH, bottomPanel);
    }

    public static void main(String[] arg) {
        new JComboBoxDemo();
    }

    class FieldSelectedListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                fieldSelected = (String) fieldComboBox.getSelectedItem();
            }
        }
    }

    class RetrievalActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //�˴�ʵ�����ݿ����ݵļ������������ض���Ϣ�������13��
            Object data[] = {"Java�������廪��ѧ", "�������Java �Ű�һ ��������"};
            bookListBox.setListData(data);
        }
    }

    class BookSelectionListener implements ListSelectionListener {
        //���б��ѡ�����仯ʱ��ִ�и÷����������
        public void valueChanged(ListSelectionEvent event) {
            if (bookListBox.isSelectionEmpty()) { //�ж��Ƿ�ѡ��������
                detailsButton.setEnabled(false);
            } else {
                detailsButton.setEnabled(true); //ʹ����ϸ����ť���ã��Լ��������ϸ��Ϣ
            }
        }
    }
}