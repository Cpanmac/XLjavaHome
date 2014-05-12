package com.xl.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.junit.Test;

import com.xl.entity.User;

/**
 * @Decription
 * 
 * @date 2014年4月13日
 * 
 * @author 徐立
 * 
 */
public class JsonDemo {

	@Test
	public void 测试() {
		User user = new User();
		user.setName("phl");
		user.setAge(25);
		User user2 = new User();
		user2.setName("luckybird");
		user2.setAge(26);

		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);

		JSONObject json = JSONObject.fromObject(user);
		System.out.println(json);
		System.out.println(json.toString());

		// ********************************************************
		JSON json2 = JSONSerializer.toJSON(list);
		System.out.println(json2.toString());
		//
		json2 = JSONSerializer.toJSON(new User());
		System.out.println(json2.toString());
	}

}
