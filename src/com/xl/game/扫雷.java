package com.xl.game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 扫雷 extends JFrame {
	JButton Mine_Button[][] = new JButton[15][15];
	int[][] mine;

	public 扫雷() {
		InitFrame();
	}

	private void InitFrame() {
		this.setLayout(new GridLayout(15, 15));
		this.setBounds(100, 100, 733, 600);// 设置在屏幕出现在位置和它的高度
		this.setTitle("扫雷");
		this.setVisible(true);

	}

	// 布置雷区矩阵
	public void InitMine() {
		mine = new int[15][15];// 定义一个二维数组
		int Mine_count = (int) (15 * 15 / 7);// 布置32个雷
		// 让数组里的每一个都为零
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				mine[i][j] = 0;

			}
		}

		for (int i = 0; i < Mine_count; i++) {
			// 随机产生一个坐标
			int x = (int) (Math.random() * 15);
			int y = (int) (Math.random() * 15);
			// 如果这个坐标是雷，循环次数加1

			if (mine[x][y] == -1) {
				--i;
			} else {// 否则把这个位置设为雷
				mine[x][y] = -1;
			}
			// 导致周围按钮的数字加1
			for (int j = -1; j <= 1; j++) {// 这个代表行
				for (int k = -1; k <= 1; k++) {// 这个是列
					if (x + j >= 0 && y + k >= 0 && x + j < 15 && y + k < 15) {// 判断是否越界
						if (mine[x + j][y + k] != -1) {// 如果不是雷的话，加1
							++mine[x + j][y + k];
						}
					}
				}
			}

		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.println(mine[i][j]);
			}
		}

	}

	// 下面具体来实现相应的按钮

	public void InitButton() {

		// 加入各个按钮
		// 声明一个按钮

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				Mine_Button[i][j] = new JButton();
				Mine_Button[i][j].setName(i + ":" + j);
				Mine_Button[i][j].setBackground(Color.white);
				Mine_Button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						JButton button = (JButton) e.getSource();
						String name = button.getName();
						String[] spliteStr = name.split(":");
						int i = Integer.parseInt(spliteStr[0]);
						int j = Integer.parseInt(spliteStr[1]);
						findMine(i, j);

					}

				});

				this.add(Mine_Button[i][j]);

			}

			InitMine();
		}

		// 布完后开始安雷

	}

	public void findMine(int i, int j) {
		if (mine[i][j] == -1) {
			showmine();
		} else if (mine[i][j] > 0) {
			Mine_Button[i][j].setText(mine[i][j] + "");
		} else if (mine[i][j] == 0) {
			Mine_Button[i][j].setText(mine[i][j] + "");
			mine[i][j] = -6;
			for (int m = -1; m <= 1; m++) {
				for (int n = -1; n <= 1; n++) {
					if (i + m >= 0 & i + m < 15 & j + n >= 0 & j + n < 15) {
						findMine(i + m, j + n);
					}
				}
			}
		}
	}

	public void showmine() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (mine[i][j] == -1) {
					Mine_Button[i][j].setBackground(Color.black);// 只要用户点中一个雷，就会显示全部的雷
				}
			}
		}
	}

	public static void main(String[] args) {
		扫雷 mine = new 扫雷();
		mine.InitButton();
	}
}
