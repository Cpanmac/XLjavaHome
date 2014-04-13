package com.xl.a;


import java.io.Serializable;

public class 序列化唯一标识 implements Serializable{
public static final long serialVersionUID = 42L;     //值自己取名

	transient String name;
	int age;
	序列化唯一标识(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "name:"+name+"  age:"+age;
	}
}
