package com.xl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xl.util.FileUtil;

/**
 * @Decription ��ô�жϣ����ǲ鿴����С���������֮���Ƿ�ȱʧ
 * 
 * @date 2014-1-18
 * 
 * @author ����
 * 
 */
public class �鿴��Ŀ¼���ļ��Ƿ�ȱʧ {
	public static void main(String[] args) {
		String src = "J:/java/�������Ա����";
		List<File> fileList = new ArrayList<File>();
		FileUtil.queryAll(fileList, new File(src));
		Pattern p = Pattern.compile("(\\d{2}).+(\\d{2})");
		p=Pattern.compile("(\\d{2}).+?");
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int temp = 1;
		for (File file : fileList) {
			Matcher m = p.matcher(file.getName());
			m.find();
				System.out.println(m.group(1));
//				i = new Integer(m.group(1));
//				if (temp != i) {
//					list.clear();
//					temp = i;
				
//				int key = new Integer(m.group(2));
//				list.add(key);
//				map.put(i, list);
			}
//		}
//		Set<Integer> key = map.keySet();
//		for (Integer _key : key) {
//			List<Integer> _list = map.get(_key);
//			System.out.println(_key + ":" + _list);
//		}
	}
}
