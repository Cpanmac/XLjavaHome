package com.xl.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.google.gson.JsonElement;
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
		System.out.println(json.toString());

		// ********************************************************
//		JSON json2 = JSONSerializer.toJSON(list);
//		System.out.println(json2.toString());
//
//		json2 = JSONSerializer.toJSON(new User());
//		System.out.println(json2.toString());
	}

	@Test
	public void 测试2() throws InstantiationException, IllegalAccessException {
		Class clazz = JsonElement.class;
		JsonElement je = (JsonElement) clazz.newInstance();
		String s = je.toString();
		System.out.println(s);
	}
}
