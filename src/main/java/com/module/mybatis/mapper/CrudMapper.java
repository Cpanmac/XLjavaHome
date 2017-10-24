package com.module.mybatis.mapper;

import java.util.List;

/**
 * Mapper继承该接口后，无需编写mapper.xml文件，即可获得CRUD功能
 * 
 * @param <T>
 */
public interface CrudMapper<T> {

	/**
	 * 新增
	 */
	public int insertOne(T entity);

	/**
	 * 根据主键删除，主键名默认为id
	 */
	public int deleteByPK(Object pk);

	/**
	 * 根据主键修改，主键名默认为id
	 */
	public int updateByPK(T entity);

	/**
	 * 根据主键查找，主键名默认为id
	 */
	public T selectByPK(Object pk);

	/**
	 * 查询全部
	 */
	public List<T> selectAll();

}
