package com.xl.gui;

/*
 ��ϰ-�г�ָ��Ŀ¼����

 */
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

class MyWindowDemo {
	private Frame f; // ����ֱ�Ӽ̳�Frame,�Ϳ���ֱ�ӵ�������ķ�����
	private TextField tf; // �ı���
	private Button but; // ��ť
	private TextArea ta; // ����ʾ�ı��Ķ�������

	MyWindowDemo() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500); // ���ָ�Frame������Ļ��ߵľ��룬�����ϱߵľ��롣�ı������곤�ȣ������곤��
		f.setLayout(new FlowLayout()); // ���ò��ֹ��������֣�Ĭ���Ǳ߽粼�֣������ָ�϶���������ȫ���

		// tf = new TextField(30);
		// �����������
		tf = new TextField(60); // �ı�����

		but = new Button("ת��"); // ��ť������
		// ta = new TextArea(15,40); //�ı�����
		ta = new TextArea(25, 70);
		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();// �¼�

		f.setVisible(true); // ��ʾ����
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() // ����رմ������¼�
		{
			public void windowClosing(WindowEvent e) // ���ùر��¼�
			{
				System.exit(0);
			}
		});
		// ȷ���¼�Դ���ı���
		but.addActionListener(new ActionListener() // ���ת����ť�������¼�
		{
			// ��ȡ�ı�����
			public void actionPerformed(ActionEvent e) {
				// ����Ŀ¼
				String dirPath = tf.getText();
				File dir = new File(dirPath); // ��װ�ɶ���
				if (dir.exists() && dir.isDirectory()) // �����Ŀ¼���Ҵ���
				{
					ta.setText(""); // ����ǰ�����
					String[] names = dir.list();
					for (String name : names) {
						// ta.setText(name+"\r\n"); //��������������Ḳ�ǣ�
						ta.append(name + "\r\n"); // ׷���ı�
					}
				}

				/*
				 * //��ʾ String text = tf.getText(); tf.setText(""); //��������ա�
				 * //�����ı���������� ta.setText(text); //���ַ������ı���������ʾ //
				 * System.out.print(text);
				 */
			}
		});

	}

	public static void main(String[] args) {
		new MyWindowDemo();
	}
}
