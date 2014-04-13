package com.xl.基础加强;

import org.junit.Test;

//用二维数组解决,在excel里面画图

public class 平面图形题 {
	// 3 7
	// 2 4 6 8
	// 1 5 9
	// 打印M
	@Test
	public void test1() {
		/*
		 * int[][] arr = new int[3][9]; arr[2][0] = 1; arr[1][1] = 2; arr[0][2]
		 * = 3; arr[1][3] = 4; arr[2][4] = 5; arr[1][5] = 6;
		 */
		// 发现x的变化:21012 y一直递增
		int num = 17;
		int height = num / 4 + 1;
		int width = num;
		// 数组的宽,高
		int[][] arr = new int[height][width];

		int x = height - 1; // x的起始值
		int y = 0; // y的起始值
		boolean flag = false;
		for (int i = 1; i <= num; i++) {
			arr[x][y] = i;
			y++;
			// x = y % 2;
			// 方立勋老师的解题思路:
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
					// 要对称,根据数据的长度对称
					System.out.print("   ");
				} else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
	}
}
