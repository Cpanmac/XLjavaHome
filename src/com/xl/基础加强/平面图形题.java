package com.xl.������ǿ;

import org.junit.Test;

//�ö�ά������,��excel���滭ͼ

public class ƽ��ͼ���� {
	// 3 7
	// 2 4 6 8
	// 1 5 9
	// ��ӡM
	@Test
	public void test1() {
		/*
		 * int[][] arr = new int[3][9]; arr[2][0] = 1; arr[1][1] = 2; arr[0][2]
		 * = 3; arr[1][3] = 4; arr[2][4] = 5; arr[1][5] = 6;
		 */
		// ����x�ı仯:21012 yһֱ����
		int num = 17;
		int height = num / 4 + 1;
		int width = num;
		// ����Ŀ�,��
		int[][] arr = new int[height][width];

		int x = height - 1; // x����ʼֵ
		int y = 0; // y����ʼֵ
		boolean flag = false;
		for (int i = 1; i <= num; i++) {
			arr[x][y] = i;
			y++;
			// x = y % 2;
			// ����ѫ��ʦ�Ľ���˼·:
			if (!flag) {
				x--;
			}
			if (flag) {
				x++;
			}
			if (x < 0) {
				flag = true;
				x = x + 2;
			}
			if (x > height - 1) {
				flag = false;
				x = x - 2;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					// Ҫ�Գ�,�������ݵĳ��ȶԳ�
					System.out.print("   ");
				} else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
	}
}
