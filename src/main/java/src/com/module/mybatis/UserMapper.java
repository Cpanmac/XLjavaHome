package com.module.mybatis;

import com.module.mybatis.mapper.CrudMapper;

/**
 * 继承CrudMapper，就自动拥有CRUD方法
 */
public interface UserMapper extends CrudMapper<User> {

}
