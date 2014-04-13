package com.xl.file;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class �����ı��ļ� {
	/**
	 * @param ��C��һ���ı��ļ����Ƶ�D��
	 *            �� ԭ�� ���ǽ�C���µ��ļ����ݴ洢��D�̵�һ���ļ��� ���裺 1.��D�̴���һ���ļ������ڴ洢C���е��ļ��е�����
	 *            2.�����ȡ����C���ļ����� 3.ͨ�����ϵĶ�д������ݵĴ洢��4.�ر���Դ ���ߣ�����
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ����һ�������ַ�����洢C�̵����ݣ���copy��D��
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("c:/hello.txt");
			fw = new FileWriter("d:/hello.txt");
			char[] buf = new char[1024]; // �����ַ�����洢��ȡ��������
			int len = 0; // רҵȡ��Ϊlen
			while ((len = fr.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len)); // ��ӡ�ļ��е�����,�в��������˷ѿռ�
			}
			fw.write(buf);
		} 
//		catch (FileNotFoundException e) {
//			e.printStackTrace();		} 
		catch (IOException e) {
			throw new RuntimeException("��дʧ��");
		} finally {
			try {
				if (fr != null && fw != null) {
					fr.close();
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("����");
			}
		}
		// copy_1();
	}
	// ����������һ��дһ��,��̫��
	public static void copy_1() throws IOException {
		FileWriter fw = new FileWriter("1.txt"); // Ŀ�ĵ�
		FileReader fr = new FileReader("1.java"); // ���������ļ�
		int ch = 0;
		while ((ch = fr.read()) != -1) { // ��һ��дһ��
			fw.write(ch);
			System.out.println(ch);
		}
		fr.close();
		fw.close();
	}
}
