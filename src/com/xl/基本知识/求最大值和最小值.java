package com.xl.����֪ʶ;
import java.util.Scanner;

/**
 * 4.������һ�������ֵ����Сֵ���������飩
 * 
 */
public class �����ֵ����Сֵ{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������뼸�����֣�");
		int i = input.nextInt();// �����������
		int num[] = new int[i];// ����ĳ���
		System.out.print("�������֣�");
		num[0] = input.nextInt();
		int max = num[0];
		int min = num[0];
		for (int x = 1; x < i; x++) {
			System.out.print("�������֣�");
			num[x] = input.nextInt();
		}
		for (int j = 1; j < num.length; j++) {
			if (max < num[j]) {
				max = num[j];
			}

			if (min > num[j]) {
				min = num[j];
			}

		}
		System.out.println("���ֵΪ��" + max + "  " + "��СֵΪ��" + min);
	}
}
