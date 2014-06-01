package com.itcast.面试;

/**
 * @Decription 无情的增量操作
 * 
 * @date 2014-5-15
 * 
 * @author 徐立
 *
 */
public class ForTest {
	public static void main(String[] args) {
        int j = 0; 
        for (int i = 0; i < 100; i++){ 
          j = j++; 
        }
        System.out.println(j); 
	}
}

