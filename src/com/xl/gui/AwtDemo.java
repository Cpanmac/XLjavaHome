package com.xl.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AwtDemo {
	public static void main(String[] args) {
		// �޷��رյ�ԭ��û�����Ч�����¼���������
		Frame f = new Frame("������"); // ����һ��������ɼ��� Frame
		// ��ʵ��,new���߱�Ĭ�ϵĹ���������Ϊ�߽�ʽ������
		f.setTitle("Title");
		f.setSize(500, 400); // 500�Ǻ����꣬100�ߵ������� ��ֵ��С
		f.setLocation(300, 200); // ��Ϊ���ǳ��������Ͻǣ����ڵ�����
		// ����ť���ô���
		f.setLayout(new FlowLayout());
		// ��Ӱ�ť
		Button b = new Button("����һ����ť");

		
		// ��Ӱ�ť
		
		f.add(b); // ûָ���;�����䣬��������һ����ť
		//����ť���ʱ��,���Բ��ִ���˳��ǰ��
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=1;
				System.out.println(i);
			}
		});
		
		// �����ڲ���
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) // �صĶ���
			{
				System.out.println("�ҹ�");
				System.exit(0);
			}

			public void windowActivated(WindowEvent e) // ǰ��ʱ��������Ϊ
			{
				System.out.println("active");
			}

			public void windowOpened(WindowEvent e) // ��ʱ��ʾ��
			{
				System.out.println("�ұ�����");
			}
		});

		f.setVisible(true); // public void setVisible(boolean b)��Ϊ true����ʹWindow �ɼ����������� Window��
		// ���߳�û�رգ�ֻҪ����ͼ�λ����棬�ͻ��һ���̡߳�
		// System.out.println("Hello World!");
	}
}

/*
 * class MyWin implements WindowListener { //����7������������ֻ�õ��رյĶ���
 * //����������û���õ�������ȱ���븴д }
 */

