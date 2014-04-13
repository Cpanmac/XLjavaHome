package com.xl.∂‡œﬂ≥Ã;

import org.junit.Test;

public class ThreadDemo implements Runnable {

	@Override
	public void run() {
		System.out.println(1);
	}

	@Test
	public void test1() {
		System.out.println(1);
		new Thread(this).run();
	}

}
