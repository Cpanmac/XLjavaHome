package com.xl.����;
/*
���󣺶�ѧ����������������������
��Ϊ�������Լ�ֵ����ʽ���ڵġ�
����Ҫʹ�ÿ��������Map���ϡ�TreeMap��
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

//��ʦд�İ���������
class StuNameComparator implements Comparator<Student5> // ��ΪTreeMap�����������߱��Ƚ��ԣ����췽����Student�Ͳ���Ҫʵ�ֽӿ�
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
		 * System.out.println("����:"+stu+"סַ�ǣ�"+addr);
		 * 
		 * 
		 * }
		 */
        Set<Student5> keySet = tm.keySet();
        Iterator<Student5> it = keySet.iterator();
        while (it.hasNext()) {
            Student5 stu = it.next();
            String addr = tm.get(stu); // ���з�ʽҪ����ȡ
            System.out.println(stu + ".." + addr);
        }
    }
}

class Student5 implements Comparable<Student5> // ���бȽ���ʱ��������Բ���ʵ��Comparable�ӿ�
{
    private String name;
    private int age;

    Student5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * public int compareTo(Student s) //���ǰ��������� { int num = new
     * Integer(this.age).compareTo(new Integer(s.age)); //��װ��߱��Ƚ��� if (num==0) {
     * return this.name.compareTo(s.name); } return num; }
     *
     * /* public int compareTo(Student s) //��д�İ��������� { int num =
     * this.name.compareTo(s.name); if (num==0) { return new
     * Integer(this.age).compareTo(new Integer(s.age)); } return num; }
     */
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

    @Override
    public int compareTo(Student5 o) {
        // TODO Auto-generated method stub
        return 0;
    }
}