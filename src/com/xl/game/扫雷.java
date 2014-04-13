package com.xl.game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ɨ�� extends JFrame {
	JButton Mine_Button[][] = new JButton[15][15];
	int[][] mine;

	public ɨ��() {
		InitFrame();
	}

	private void InitFrame() {
		this.setLayout(new GridLayout(15, 15));
		this.setBounds(100, 100, 733, 600);// ��������Ļ������λ�ú����ĸ߶�
		this.setTitle("ɨ��");
		this.setVisible(true);

	}

	// ������������
	public void InitMine() {
		mine = new int[15][15];// ����һ����ά����
		int Mine_count = (int) (15 * 15 / 7);// ����32����
		// ���������ÿһ����Ϊ��
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				mine[i][j] = 0;

			}
		}

		for (int i = 0; i < Mine_count; i++) {
			// �������һ������
			int x = (int) (Math.random() * 15);
			int y = (int) (Math.random() * 15);
			// �������������ף�ѭ��������1

			if (mine[x][y] == -1) {
				--i;
			} else {// ��������λ����Ϊ��
				mine[x][y] = -1;
			}
			// ������Χ��ť�����ּ�1
			for (int j = -1; j <= 1; j++) {// ���������
				for (int k = -1; k <= 1; k++) {// �������
					if (x + j >= 0 && y + k >= 0 && x + j < 15 && y + k < 15) {// �ж��Ƿ�Խ��
						if (mine[x + j][y + k] != -1) {// ��������׵Ļ�����1
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

	// ���������ʵ����Ӧ�İ�ť

	public void InitButton() {

		// ���������ť
		// ����һ����ť

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

		// �����ʼ����

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
					Mine_Button[i][j].setBackground(Color.black);// ֻҪ�û�����һ���ף��ͻ���ʾȫ������
				}
			}
		}
	}

	public static void main(String[] args) {
		ɨ�� mine = new ɨ��();
		mine.InitButton();
	}
}
