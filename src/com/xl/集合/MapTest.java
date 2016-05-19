package com.xl.����;
/*
ѧ�����ԣ����������䡣 
ע�⣺������������ͬ����Ϊͬһ��ѧ����
��֤ѧ����Ψһ�ԡ�
1.����ѧ����
2.����map��������ѧ����Ϊ������ַ��Ϊֵ������
3.��ȡmap�����е�Ԫ��
�Ƚ�hasCode,equals.�����ö�����
���һ������N������������߱���Ȼ˳���������£�ʵ�֣�����

 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Student2 implements Comparable<Student2> // ��16��06
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
     * �ⲿ�ִ����Ǳ�֤ѧ����Ψһ�Ե� public int hashCode() //��Ϊ�Ƚ��Ǹ��ݹ�ϣ����������Ҫ��д { return
     * name.hashCode()+age*34; } public boolean equals(Object obj) { if (!(obj
     * instanceof Student)) //�������������Student { //return false; ���岻��Ӧ���׳��쳣
     * //throw new RuntimeException("���Ͳ�ƥ��"); //�����쳣�ĸ���̫���� throw new
     * ClassCastException("���Ͳ�ƥ��"); //�����С�� } Student s = (Student)obj; return
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
        // ��һ��ȡ����ʽ��KeySet
        Set<Student2> keySet = hm.keySet();
        Iterator<Student2> it = keySet.iterator();
        while (it.hasNext()) {
            Student2 stu = it.next();
            String addr = hm.get(stu); // ȡ����
            System.out.println(stu + ".." + addr);
        }
        // �ڶ���ȡ����ʽentrySet
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
