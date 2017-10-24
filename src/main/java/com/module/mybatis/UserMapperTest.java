package com.module.mybatis;

import com.xl.util.FileTool;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;

public class UserMapperTest {

	public static void main(String[] args) {
		String resource = "mybatis.xml";
		InputStream in = FileTool.getResourceInputStream(resource);

		// 此处采用MybatisSessionFactoryBuilder构建SqlSessionFactory，目的是引入CrudMapper功能
		SqlSessionFactory sessionFactory = new MybatisSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);

		// 此处的selectByPK被UserMapper.xml中的selectByPK覆盖了
		User user = userMapper.selectByPK(2);
		System.out.println(user);

		user.setName("update_" + user.getName());
		// updateByPK是从CrudMapper中继承而来的，UserMapper.xml中并没有申明改sql
		userMapper.updateByPK(user);

		// 此处的selectByPK被UserMapper.xml中的selectByPK覆盖了
		user = userMapper.selectByPK(user.getPk());
		System.out.println(user);

		session.commit();
	}
}
