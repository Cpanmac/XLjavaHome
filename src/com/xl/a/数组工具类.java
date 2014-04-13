package com.xl.a;


/*
 ��̬��Ӧ��
 ÿһ��Ӧ�ó����ж��й��ԵĹ��ܣ����Խ���Щ���ܽ��г�ȡ��������װ��
 �Ա㸴��
 1.��Ȼ����ͨ������ArrayTool�Ķ���ʹ����Щ���߲�δ��װ�������ݡ�
 2.���������ÿһ��������û���õ�ArrayTool�����е��������ݡ�

 ����������̬�󣬿��Է���ʹ�ã����Ǹ��໹�ǿ��Ա���������������
 Ϊ�˸�Ϊ�Ͻ���ǿ�Ƹ��಻�ܽ������� ���Խ���˽�л�
 */
class ArrayTool {

	private ArrayTool() {
	}; // ֻ���������ò��ܴ�������

	/**
	 * ����int��������ֵ
	 * 
	 * @param arr
	 * @return int
	 */
	public static int getMax(int[] arr) {
		int max = 0;
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > arr[max])
				max = x;
		}
		return arr[max];
	}

	/**
	 * ���������е���Сֵ
	 * 
	 * @param arr
	 * @return int
	 */
	public int getMin(int[] arr) {
		int min = 0;
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] < arr[min])
				min = x;
		}
		return arr[min];
	}

	/**
	 * ����λ��
	 * @param arr
	 * @param a
	 * @param b void
	 */
	public void swap(int[] arr, int a, int b) // ����
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void bubbleSort(int[] arr) {
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - x - 1; y++) {
				if (arr[y] > arr[y + 1]) {
					swap(arr, y, y + 1);
				}
			}
		}
	}
}