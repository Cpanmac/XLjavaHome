package com.itcast.面试;

import org.junit.Test;

/**
 * @Decription 计数器问题，运算符的优先级
 * 
 * @date 2014-5-15
 * 
 * @author 徐立
 *
 */
public class Clock {
	
	@Test
	public void test1(){
		int minutes = 0; 
	  for (int ms = 0; ms < 60; ms++) 
	      if (ms % 60*1000 == 0) 
	          minutes++; 
	  System.out.println(minutes); 
	}
	@Test
	public void test2() {
	  int minutes = 0; 
	  for (int ms = 0; ms < 60*60*1000; ms++)  
	      if (ms % 60*1000 == 0) 
	          minutes++; 
	  System.out.println(minutes); 
	}
	
	@Test
	public void test3(){
		  int minutes = 0; 
		  for (int ms = 0; ms < 60*60*1000; ms++) 
		      if (ms % (60*1000) == 0) 
		          minutes++; 
		  System.out.println(minutes); 
	}
}
