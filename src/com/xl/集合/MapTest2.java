package com.xl.集合;
/*
需求：对学生对象的年龄进行升序排序。
因为数据是以键值对形式存在的。
所以要使用可以排序的Map集合。TreeMap。
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

//老师写的按姓名排序
class StuNameComparator implements Comparator<Student5> // 因为TreeMap这个容器自身具备比较性，构造方法，Student就不需要实现接口
{
    public int compare(Student5 s1, Student5 s2) {
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0) {
            return num = s1.getAge() - s2.getAge();
        }
        return num;
    }
}

class MapTest2 {
    public static void main(String[] args) {
        TreeMap<Student5, String> tm = new TreeMap<Student5, String>(new StuNameComparator());
        tm.put(new Student5("lisi2", 21), "beijing");
        tm.put(new Student5("lisi1lisi2", 22), "shanghai");
        tm.put(new Student5("lisi3", 23), "naijing");
        tm.put(new Student5("lisi4", 21), "wuhan");
        /*
         * Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		 * Iterator<Map.Entry<Student,String>> iter = entrySet.iterator(); while
		 * (iter.hasNext()) { Map.Entry<Student,String> me = iter.next();
		 * Student stu = me.getKey(); String addr = me.getValue();
		 * System.out.println("姓名:"+stu+"住址是："+addr);
		 * 
		 * 
		 * }
		 */
        Set<Student5> keySet = tm.keySet();
        Iterator<Student5> it = keySet.iterator();
        while (it.hasNext()) {
            Student5 stu = it.next();
            String addr = tm.get(stu); // 这中方式要这样取
            System.out.println(stu + ".." + addr);
        }
    }
}

class Student5 implements Comparable<Student5> // 当有比较类时，该类可以不用实现Comparable接口
{
    private String name;
    private int age;

    Student5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * public int compareTo(Student s) //这是按年龄排序 { int num = new
     * Integer(this.age).compareTo(new Integer(s.age)); //包装类具备比较性 if (num==0) {
     * return this.name.compareTo(s.name); } return num; }
     *
     * /* public int compareTo(Student s) //我写的按姓名排序 { int num =
     * this.name.compareTo(s.name); if (num==0) { return new
     * Integer(this.age).compareTo(new Integer(s.age)); } return num; }
     */
    /*
     * 这部分代码是保证学生的唯一性的 public int hashCode() //因为比较是根据哈希表排序，所以要覆写 { return
	 * name.hashCode()+age*34; } public boolean equals(Object obj) { if (!(obj
	 * instanceof Student)) //如果传进来不是Student { //return false; 意义不大，应该抛出异常
	 * //throw new RuntimeException("类型不匹配"); //运行异常的父类太大了 throw new
	 * ClassCastException("类型不匹配"); //这个是小弟 } Student s = (Student)obj; return
	 * this.name.equals(s.name) && this.age==s.age; }
	 */
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + ":" + age;
    }

    @Override
    public int compareTo(Student5 o) {
        // TODO Auto-generated method stub
        return 0;
    }
}