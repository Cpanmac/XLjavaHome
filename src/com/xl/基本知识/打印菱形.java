package com.xl.����֪ʶ;
import java.util.Scanner;

public class ��ӡ���� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("������Ҫ��ӡƴ�������ϰ�������ε�����,rows = ");
		int rows = input.nextInt();
		int i, j, k; // ��ʼ������
		for (i = 1; i <= rows; i++) {
			// ���ѭ����������������̨���յĲ���rows��Ϊ�ϰ�������ε�����
			// ��ѭ��һ���ƿո�����
			for (j = 1; j <= rows - i; j++)
				System.out.print(" ");
			// ��ѭ��������*�����
			for (k = 1; k <= 2 * i - 1; k++) {
				// �ж��Ǳ��еĵ�һ�������һ����ӡ*
				if (k == 1 || k == 2 * i - 1)
					System.out.print("*");
				// �����Ķ�����ո�
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
		// �°��������
		for (i = 1; i <= rows - 1; i++) {
			// ���ѭ�������������°�������α��������һ�Ъ�����rows-1
			for (j = 1; j <= i; j++)
				System.out.print(" ");
			for (k = 1; k < (rows - i) * 2; k++)
				// ��һ��Ϊ1�����һ����(rows-i)*2-1,��Ϊk<(row-i)*2����<=
				if (k == 1 || k == (rows - i) * 2 - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			System.out.println("");
		}
	}
}