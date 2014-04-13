package com.xl.gui;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 �˵��������Ӳ˵����ֿ�����Ӳ˵���Menu extends MenuItem,Menu add(MenuItem)
 */
public class MyMenuDemo
{
	public static void main(String[] args)
	{
		new MyMenuDemo();
	}

	private Frame f;
	private Menu FileMenu; // �ļ��˵�
	private MenuBar mb, bar; // �˵���
	private MenuItem openItem, saveItem, closeItem; // �򿪣����棬�ر���Ŀ
	private FileDialog openDia, saveDia; // ���öԻ���������ļ��������ļ�
	private TextArea ta; // ����ı��������ڴ�ѡ����ļ�
	private File file;

	MyMenuDemo()
	{
		init();
	}

	public void init()
	{
		f = new Frame("myWindow");
		f.setBounds(300, 100, 600, 600);
		// f.setLayout(new FlowLayout()); // ��ʽ����,����ı���Ļ����ѿ�����Ĭ�ϵ�
		// System.out.println(f.getExtendeState()); //����int���ͻ�ȡ�˴����״̬��0

		bar = new MenuBar();// ��ʼ���˵���
		// m = new Menu("�ļ�");
		ta = new TextArea();
		FileMenu = new Menu("�ļ�"); // ��ʼ���˵�

		openItem = new MenuItem("��");
		saveItem = new MenuItem("����");
		closeItem = new MenuItem("�˳�");
		FileMenu.add(openItem);
		FileMenu.add(saveItem);
		FileMenu.add(closeItem);
		bar.add(FileMenu); // ���˵�����˵�����
		f.setMenuBar(bar);// ���˵�����ӽ����
		openDia = new FileDialog(f, "��Ҫ��", FileDialog.LOAD); // �����ģʽ��дҲ���ԣ�Ĭ�ϵľ��Ǵ�
		saveDia = new FileDialog(f, "��Ҫ����", FileDialog.SAVE); // ����
		f.add(ta);
		myEvent();

		f.setVisible(true);
		// �Լ�����
		// System.out.println(closeItem.isEnabled());// �Ƿ������˲˵���
		// System.out.println(closeItem.paramString()); // ���ش�״̬���ַ���
	}

	private void myEvent()
	{
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (file == null)
				{
				saveDia.setVisible(true); // ��ʾ����,���Բ���ʾ�����ļ�������ʱ��ʾ
				String dirPath = saveDia.getDirectory();// ��ȡ�洢��·��
				String fileName = saveDia.getFile();// ��ȡ�洢���ļ���
				if (dirPath == null || fileName == null)
					return;
				file = new File(dirPath,fileName);	
				}
				try{
				BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
				String text = ta.getText(); //���ı�������ı�����text
				bufw.write(text);
			//	bufw.flush();
				bufw.close();
				}catch(IOException ex){
				throw new RuntimeException("д��ʧ�ܣ�");

			}}});

		openItem.addActionListener(new ActionListener() // ����򿪵��¼�
		{
			public void actionPerformed(ActionEvent e)
			{
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();// ��ô��ļ���·��
				String fileName = openDia.getFile();
				System.out.println(dirPath + "  " + fileName);
				// ���ûѡ���ļ��ͻ����ָ���쳣��Ŀ¼�У��ļ�û�С����Ե��ж�
				if (dirPath == null || fileName == null)
					return;
				ta.setText(""); // ÿ�δ򿪶����֮ǰ���ı�
				file = new File(dirPath, fileName);
				try
				{
					BufferedReader bufr = new BufferedReader(new FileReader(
							file));
					String line = null;
					while ((line = bufr.readLine()) != null)
					{
						ta.append(line + "\r\n"); // ����ȡ���ļ���ӵ��ı���
					}
					bufr.close();
				}
				catch (IOException ew)
				{
					throw new RuntimeException("��ȡʧ��");
				}

			}

		});

		closeItem.addActionListener(new ActionListener() // ����˵��˳��������¼�
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO �Զ����ɵķ������
						System.exit(0);

					}

				});

		f.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

	}
}
