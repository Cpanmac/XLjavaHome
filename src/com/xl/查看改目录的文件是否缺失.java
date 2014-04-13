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
 * @Decription 怎么判断？就是查看从最小数到最大数之间是否缺失
 * 
 * @date 2014-1-18
 * 
 * @author 徐立
 * 
 */
public class 查看改目录的文件是否缺失 {
	public static void main(String[] args) {
		String src = "J:/java/黑马程序员毕向东";
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
