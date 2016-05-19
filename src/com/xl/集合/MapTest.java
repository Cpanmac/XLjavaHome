package com.xl.集合;
/*
学生属性：姓名，年龄。 
注意：姓名和年龄相同的视为同一个学生。
保证学生的唯一性。
1.描述学生。
2.定义map容器。将学生作为键，地址作为值。存入
3.获取map集合中的元素
比较hasCode,equals.容器用二叉树
如果一个类有N多对象，最好让其具备自然顺序。做两件事，实现，覆盖

 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Student2 implements Comparable<Student2> // 第16天06
{
    private String name;
    private int age;

    Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student2 s) {
        int num = new Integer(this.age).compareTo(new Integer(s.age));
        if (num == 0) {
            return this.name.compareTo(s.name);
        }
        return num;
    }

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
}

class MapTest {
    public static void main(String[] args) {
        HashMap<Student2, String> hm = new HashMap<Student2, String>();
        hm.put(new Student2("lisi1", 21), "beijing");
        hm.put(new Student2("lisi2", 22), "shanghai");
        hm.put(new Student2("lisi3", 23), "naijing");
        hm.put(new Student2("lisi4", 24), "wuhan");
        // 第一种取出方式：KeySet
        Set<Student2> keySet = hm.keySet();
        Iterator<Student2> it = keySet.iterator();
        while (it.hasNext()) {
            Student2 stu = it.next();
            String addr = hm.get(stu); // 取出的
            System.out.println(stu + ".." + addr);
        }
        // 第二种取出方式entrySet
        Set<Map.Entry<Student2, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<Student2, String>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<Student2, String> me = iter.next();
            Student2 stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu + "..." + addr);
        }
    }
}
