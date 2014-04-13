package com.xl.集合;
/*
map扩展知识。  存储多个HashMap集合

map集合被使用是因为具备映射关系。

"yureban" "01" "zhangsan";

"yureban" "03" "lisi";

"jiuyeban" 01" "wangwu";
"jiuyeban" "02" "zhaoliu";
一个学校有多个教室每个教室都有名称，
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Student4 implements Comparable<Student4> {
	private String id;
	private String name;
	private int age;

	Student4(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public int compareTo(Student4 s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if (num == 0) {
			return this.name.compareTo(s.name);
		}
		return num;
	}
}

public class MapDemo3 { // 之前房间存的Map集合，现在房间存的List集合
	public static void demo() // 一个教室对应很多Student对象
	{
		Map czbk = new HashMap(); // 右边的值改为List，ArrayList也可以
		List reyu = new ArrayList<Student4>();
		List jiuye = new ArrayList<Student4>();
		czbk.put("yureban", reyu);
		czbk.put("jiuyeban", jiuye);
		reyu.add(new Student4("01", "zhagnsa"));
		reyu.add(new Student4("04", "wangwu"));
		jiuye.add(new Student4("01", "zhouqi"));
		jiuye.add(new Student4("02", "zhaoli"));
		Iterator<String> it = czbk.keySet().iterator(); // 上面两行合成一行
		while (it.hasNext()) {
			String roomName = it.next(); // 取出教室的名字赋值给roomName
			List<Student4> room = (List<Student4>) czbk.get(roomName); // 就把下面的代码复制，改为
			System.out.println(roomName);
			getInfos(room);
		}

	}

	public static void getInfos(List<Student4> list) {
		Iterator<Student4> it = list.iterator();
		while (it.hasNext()) {
			Student4 s = it.next();
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		demo();
		/*
		 * HashMap<String,HashMap<String,String>> czbk = new
		 * HashMap<String,HashMap<String,String>>(); HashMap<String,String> yure
		 * = new HashMap<String,String>(); HashMap<String,String> jiuye = new
		 * HashMap<String,String>(); czbk.put("yureban",yure);
		 * czbk.put("jiuyeban",jiuye); //右边这个 yure.put("01","zhangsan");
		 * yure.put("02","lisi"); jiuye.put("01","zhaoliu");
		 * jiuye.put("02","wangwu"); // getStudentInfo(jiuye); //
		 * getStudentInfo(yure); /*
		 * Set<Map.Entry<String,HashMap<String,String>>> entrySet =
		 * czbk.entrySet(); //建立Map.Entry集合来存储键值
		 * Iterator<Map.Entry<String,HashMap<String,String>>> iter =
		 * entrySet.iterator(); //建立MAp.Entry的迭代器 while (iter.hasNext()) {
		 * Map.Entry<String,HashMap<String,String>> me = iter.next(); //建立
		 * Map.Entry集合来接受键值 String key = me.getKey(); //getKey接受左边的
		 * HashMap<String,String> hm = me.getValue(); //getValue接受右边的
		 * System.out.println("key:"+key+".."+hm); getStudentInfo(hm); }
		 */
		// Set<String> keySet= czbk.keySet(); //用Set集合就直接取左边的
		// 键值，右边的用getStudentInfo
		// Iterator<String> it = keySet.iterator();
		/*
		 * Iterator<String> it =czbk.keySet().iterator(); //上面两行合成一行
		 * while(it.hasNext()) { String roomName= it.next();
		 * //取出教室的名字赋值给roomName HashMap<String,String> room= czbk.get(roomName);
		 * //根据HashMap的特 点根据键得到右边的值 System.out.println(roomName);
		 * getStudentInfo(room); }
		 */
	}

	public static void getStudentInfo(HashMap<String, String> roomMap) // 其中一个
	// 教室创建方法定义功能取出
	{
		Iterator<String> it = roomMap.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			String name = roomMap.get(id);
			System.out.println(id + ":" + name);
		}
	}
}
