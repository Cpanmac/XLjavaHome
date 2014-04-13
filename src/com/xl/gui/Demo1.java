package com.xl.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.junit.Test;

//GUI���
public class Demo1 {

	@Test
	public void test1() {
		// ����һ�����ɼ�����
		Frame f = new Frame();

		// ���ô���Ĵ�С
		f.setSize(200, 250);

		// ������ʾ��λ��
		f.setLocation(300, 200);

		// ��������ʾ����
		f.setVisible(true);

		// Ϊ��������¼����¼������������¼�Դ
		f.addWindowListener(new MyWindowListener());

		try {
			Thread.sleep(10000); // ���̵߳ȴ�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// ������ģʽ
class MyWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		// ȡ���¼�Դ
		Frame frame = (Frame) e.getSource();
		frame.setVisible(false);
		System.exit(0);
	}
}

// 1.�¼�������,����̫�鷳�˿���ѡ��������ģʽ
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
		System.out.println("�Ǻ�");
		// ȡ���¼�Դ
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
