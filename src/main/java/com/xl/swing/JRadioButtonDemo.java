package com.xl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class JRadioButtonDemo extends JFrame {
    protected JPanel topPanel;
    protected JScrollPane bookInLibScrollPane;// ��Ž�����Ϣ�����
    protected JTable borrowInfoTable; //��ʾ������Ϣ�ı��
    private Container container;

    public JRadioButtonDemo() {
        container = this.getContentPane();//��ȡ���ݴ���
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // ���ñ߿��ı���ʾ��Ϣ
        topPanel.setBorder(BorderFactory.createTitledBorder("���Ĳ�ѯѡ��"));
        JRadioButton currBorrowButton = new JRadioButton("��ǰ����");
        JRadioButton oldBorrowButton = new JRadioButton("��ʷ����");
        topPanel.add(currBorrowButton); //���������������
        topPanel.add(oldBorrowButton); //���������������
        // ע���¼��������򣬶�ActionEvent�¼���������
        currBorrowButton.addActionListener(new CurrentBorrowInfoListener());
        oldBorrowButton.addActionListener(new OldBorrowInfoListener());
        /** ��2��RadioButton����Ž�ButtonGroup�У���ʵ�ֶ�ѡһ */
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(currBorrowButton);
        buttonGroup1.add(oldBorrowButton);
        this.add(BorderLayout.NORTH, topPanel); //�����������ӵ����ݴ�����
        this.setTitle("ͼ�����ϵͳ�ҵĽ���"); //���ñ���
        this.setSize(600, 450);//���ô�С
        this.setVisible(true);//���ÿɼ���
    }

    public static void main(String[] arg) {
        new JRadioButtonDemo();
    }

    class CurrentBorrowInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // �ѵ�ǰ������Ϣ�����ݿ�ȡ�����Ա�����ʽ��ʾ����������ʵ�ּ�13��
            Vector allBorrowInfoVector = new Vector();// ������е��е���������
            Vector rowVector1 = new Vector();// ��ŵ�һ�����ݵ�����
            //Ϊ��һ�е����������趨ֵ��ʵ��Ӧ�����ݿ��ȡ��Ϣ��������������Ϊ��������
            rowVector1.add("java�������");
            rowVector1.add("������");
            rowVector1.add("�廪��ѧ������");
            rowVector1.add("09-09-08");
            rowVector1.add("09-12-08");
            rowVector1.add("");
            rowVector1.add("0");
            rowVector1.add("0");
            allBorrowInfoVector.add(rowVector1);//�ѵ�һ���������
            rowVector1 = new Vector();// ��ŵڶ�������
            rowVector1.add("java");
            rowVector1.add("�Ű�һ");
            rowVector1.add("�廪��ѧ������");
            rowVector1.add("09-10-10");
            rowVector1.add("10-01-10");
            rowVector1.add("");
            rowVector1.add("0");
            rowVector1.add("0");
            allBorrowInfoVector.add(rowVector1);
            /*��̬����������������ͨ����ά�������*/
            /*Object borrowinf[][]={{"java�������","������","�廪��ѧ������", "09-09-08", "09-12-08", "","0","0"},{"java","�Ű�һ","�廪��ѧ������","09-10-10","10-01-10","","0","0"}};*/
            Vector borrowHead = new Vector(); // �洢��ͷ��Ϣ������
            borrowHead.add("����");
            borrowHead.add("����");
            borrowHead.add("����");
            borrowHead.add("��������");
            borrowHead.add("Ӧ������");
            borrowHead.add("�黹����");
            borrowHead.add("��������");
            borrowHead.add("������");
			/*��̬����������������ͨ��һά�������*/
			/* Object tableHead[]={"����","����","����","��������","Ӧ������","�黹����","��������", "������"};*/
            // ���ɾ������ݺͱ�ͷ�ı��
            // borrowInfoTable = new JTable(borrowinf, tableHead); //�������������ɱ��
            borrowInfoTable = new JTable(allBorrowInfoVector, borrowHead);//�������������ɱ��
            borrowInfoTable.setEnabled(false);//���ñ���ǲ��ɱ༭�ģ�ֻ��ʾ��Ϣ
            borrowInfoTable.setPreferredScrollableViewportSize(new Dimension(0, 120));
            bookInLibScrollPane = new JScrollPane();
            bookInLibScrollPane.setViewportView(borrowInfoTable); //���õ��������
            //������ʾ��Ϣ
            bookInLibScrollPane.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
            add(BorderLayout.CENTER, bookInLibScrollPane); //��ӵ����ݴ�����
            validate();//ˢ�´���
        }
    }

    class OldBorrowInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // ����ʷ������Ϣ�����ݿ�ȡ�����Ա�����ʽ��ʾ����������ʵ�ּ�13��
        }
    }
}