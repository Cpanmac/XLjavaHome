package com.xl.����֪ʶ;

import java.util.Scanner;

/**
 * 3.ģ������ȡǮ ����ͨ���û������������֤��Ȼ������ȡǮ�Ľ� ��ǮҪС��1000������100�ı���������������Ͼ�������ѭ������ʾȡ�����
 * ������ǣ�����ʾ��������ȡǮ�Ľ� ���������󣬾���ʾ��Ϣ�������
 */
public class ģ������ȡǮ {
	public static void main(String[] args) {
		String userName = "fengshuai";
		int userPassWord = 123456;
		String name;
		int passWord;
		int money;
		boolean bl = true;
		Scanner sr = new Scanner(System.in);
		do {
			System.out.print("�������û�����");
			name = sr.next();
			System.out.print("���������룺");
			passWord = sr.nextInt();
			if ((!name.equals(userName)) || (passWord != userPassWord)) {
				System.out.println("���������������������룡");
			}
		} // ��ô������������ʾ�����ѭ��
		while ((!name.equals(userName)) || (passWord != userPassWord));
		do {
			System.out.println("��������Ҫȡ�Ľ�");
			money = sr.nextInt();
			for (; money < 1000 && money % 100 == 0;) {
				break;
			}
			System.out.println("����ȡ����Ϊ��" + money);
			if (money >= 1000 || money % 100 != 0) {
				System.out.println("�������ȡ�����������������룺");// �����ѭ����ô��
			}
		} while ((money >= 1000 || money % 100 != 0));
	}
}
