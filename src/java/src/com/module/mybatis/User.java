package com.module.mybatis;

import com.module.mybatis.annotations.PK;
import com.module.mybatis.annotations.Table;

@Table(name = "user")
public class User {
    @PK(auto = true)
    private long pk;
    private String name;

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return pk + "：" + name;
    }
}
