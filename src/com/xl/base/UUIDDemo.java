package com.xl.base;

import java.util.UUID;

import org.junit.Test;

public class UUIDDemo {
	@Test
	public void test1() {
		UUID u = UUID.randomUUID();
		System.out.println(u.toString().length());
		System.out.println(u);
	}
}
