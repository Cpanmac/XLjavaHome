package com.xl.base;
/** 1.����һ�����֣�1-7,�ж�����������������е����죬����1��Ӧ�ľ�������һ����
 ����0������ѭ��
 */

import java.util.Scanner;

public class ���������ж����ڼ� {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String name = null;
		int no;

		while (true) {
			System.out.println("������һ������(1-7)���������0�������");
			no = input.nextInt();
			if (no < 0 || no > 7) {
				System.out.println("����������� �����������룡��");
				continue;
			}
			if (no == 0) {
				System.out.println("���� ллʹ��");
				break;
			}
			switch (no) {
			case 1:
				name = "����һ";
				break;
			case 2:
				name = "���ڶ�";
				break;
			case 3:
				name = "������";
				break;
			case 4:
				name = "������";
				break;
			case 5:
				name = "������";
				break;
			case 6:
				name = "������";

				break;
			case 7:
				name = "������";
				break;

			}
			if (no == 0) {
				break;
			}

			System.out.println(name);

		}

	}

}