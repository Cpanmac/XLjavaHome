package com.xl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    // Ψһ���л���ʶ
    public static final long serialVersionUID = 42L; // ֵ�Լ�ȡ��
    public String name = "����name";
    private int age = 13;
    // private int password=123;
    private String password;
    private String birthday;
    /**
     * transient ���ֶ��޷����л������Դ�������ʱ�򲻻ᴫ��ȥ
     */
    transient String pas;
}
