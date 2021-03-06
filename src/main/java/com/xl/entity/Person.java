package com.xl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    // 唯一序列化标识
    public static final long serialVersionUID = 42L; // 值自己取名
    public String name = "这是name";
    private int age = 13;
    // private int password=123;
    private String password;
    private String birthday;
    /**
     * transient 该字段无法序列化，所以传输对象的时候不会传过去
     */
    transient String pas;
}
