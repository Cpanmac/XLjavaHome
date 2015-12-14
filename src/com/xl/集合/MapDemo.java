package com.xl.����;

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
		// ��ȡmap���ϵ����м���Set����,keySet();
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		// ����Set���ϡ��Ϳ��Ի�ȡ�������
		Iterator<Map.Entry<String, String>> it = entrySet.iterator(); // ��������Set����һ��
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next(); // ��ҲҪд
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
	}
	
	/**
	 * keySet().toArray()ת��Ϊ����
	 */
	@Test
	public void ��Map���ϸĳ�����String����() {
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
		// ��ת��ֱ��ǿתString����,ת��ʧ��
		Object[] strs = query.keySet().toArray();
		System.out.println(Arrays.toString(strs));
	}
}
