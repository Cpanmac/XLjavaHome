package com.xl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    // Ψһ���л���ʶ
    public static final long serialVersionUID = 42L; // ֵ�Լ�ȡ��
    private int age = 13;
    public String name = "����name";
    // transient ���ֶ��޷����л������Դ�������ʱ�򲻻ᴫ��ȥ
    transient String pas;
    // private int password=123;
    private String password;
    private String birthday;
}
