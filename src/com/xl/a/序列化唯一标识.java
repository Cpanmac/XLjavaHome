package com.xl.a;


import java.io.Serializable;

public class ���л�Ψһ��ʶ implements Serializable{
public static final long serialVersionUID = 42L;     //ֵ�Լ�ȡ��

	transient String name;
	int age;
	���л�Ψһ��ʶ(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "name:"+name+"  age:"+age;
	}
}
