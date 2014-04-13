package com.xl.Properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		// setAndGet();
		// method_1();
		loadDemo();
	}

	// load������ԭ��

	public static void loadDemo() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		InputStreamReader isr = new InputStreamReader(fis); // û����Ļ������ֽ�������
		prop.load(isr);
		// System.out.println(prop);
		// �޸���������
		prop.setProperty("wangwu", "39");
		prop.list(System.out); // �г�����Ŀ¼
		// store �����洢���ļ�
		FileOutputStream fos = new FileOutputStream("info1.txt");
		prop.store(fos, "haha");

		prop.list(System.out);
		isr.close();
		fos.close();
		fis.close();
	}

	/*
	 * ��ʾ����ν����е����ݴ洢�������С� ��Ҫ��info.txt�м�ֵ���ݴ洢�������н��в����� 1.��һ������info.txt�ļ�����
	 * 2.��ȡһ�����ݣ������������á�=�������и 3.�Ⱥ������Ϊ�����ұ���Ϊֵ���洢��Properties������
	 */
	// ���úͻ�ȡԪ�ء�
	public static void method_1() throws IOException {
		Properties prop = new Properties();
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] arr = line.split("=");
			prop.setProperty(arr[0], arr[1]); // �����ݴ洢��Properties����
			// System.out.println(line);
		}
		br.close();
		System.out.println(prop);

	}

	public static void setAndGet() {
		Properties prop = new Properties();
		prop.setProperty("����", "30");
		prop.setProperty("lisi", "39");
		System.out.println(prop); // {����=30, lisi=39}
		String value = prop.getProperty("lisi"); // ��ȡֵ
		System.out.println(value);
		// ��ӡ��
		Set<String> names = prop.stringPropertyNames();
		for (String s : names)
			System.out.println(s + ":" + prop.getProperty(s));
	}

}
