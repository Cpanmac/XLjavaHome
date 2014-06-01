package com.xl.集合;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapDemo {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");
		// 获取map集合的所有键的Set集合,keySet();
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		// 有了Set集合。就可以获取其迭代器
		Iterator<Map.Entry<String, String>> it = entrySet.iterator(); // 迭代器和Set里面一致
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next(); // 这也要写
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
	}
	
	/**
	 * keySet().toArray()转换为数组
	 */
	@Test
	public void 将Map集合改成两个String数组() {
		Map<String, String> query = new HashMap<String, String>();
		query.put("02", "zhangsan2");
		query.put("03", "zhangsan3");
		query.put("01", "zhangsan1");
		query.put("04", "zhangsan4");
		String[] params = new String[query.size()];
		String[] paramsValue = new String[query.size()];
		query.keySet().toArray(params);
		query.values().toArray(paramsValue);
		System.out.println(Arrays.toString(params));
		System.out.println(Arrays.toString(paramsValue));
		// 不转换直接强转String数据,转换失败
		Object[] strs = query.keySet().toArray();
		System.out.println(Arrays.toString(strs));
	}
}
