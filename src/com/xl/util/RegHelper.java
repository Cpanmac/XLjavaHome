package com.xl.util;

/**
 * @Decription ƥ�临�ӵ�����
 * 
 * @date 2014-1-25
 * 
 * @author ����
 * 
 */
public class RegHelper {
	private String reg;

	public RegHelper() {

	}

	public RegHelper(String reg) {
		this.reg = reg;
	}

	public RegHelper append(String reg) {
		this.reg = this.reg + ".+?" + reg;
		return this;
	}

	@Override
	public String toString() {
		return reg;
	}

}
