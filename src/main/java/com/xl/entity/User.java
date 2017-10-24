package com.xl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private int age;
    private String name;
    private String passWord;
}
