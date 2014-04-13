package com.xl.a;


/*
 静态的应用
 每一个应用程序中都有共性的功能，可以将这些功能进行抽取，独立封装。
 以便复用
 1.虽然可以通过建立ArrayTool的对象使用这些工具并未封装特有数据。
 2.操作数组的每一个方法都没有用到ArrayTool对象中的特有数据。

 将方法都静态后，可以方便使用，但是该类还是可以被其他程序建立对象。
 为了更为严谨，强制该类不能建立对象 可以将类私有化
 */
class ArrayTool {

	private ArrayTool() {
	}; // 只能类名调用不能创建对象

	/**
	 * 返回int数组的最大值
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
	 * 返回数组中的最小值
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
	 * 交换位置
	 * @param arr
	 * @param a
	 * @param b void
	 */
	public void swap(int[] arr, int a, int b) // 调序
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