package com.xl.entity;

import com.module.mybatis.annotations.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "user")
public class User implements Serializable {
    private int id;
    private int age;
    private String name;
    private String passWord;
}
