package com.xl.IO.ת�����ı����;

/*
 ��5��ѧ����ÿ��ѧ����3�ſεĳɼ���
 �Ӽ��������������ݣ����������ſγɼ���
 ����ĸ�ʽ���磺zhangsan��30��40��60������ܳɼ�������ѧ������Ϣ�ͼ�������ܷ����ߵ�˳����ڴ����ļ�"stud.txt"��
 1.����ѧ������
 2.����һ���ɲ���ѧ������Ĺ�����

 ˼·��
 1.ͨ����ȡ����¼���һ�����ݣ����������е���Ϣȡ����װ��ѧ������
 2.��Ϊѧ�������кܶ࣬��ô����Ҫ�洢��ʹ�õ����ϡ���ΪҪ��ѧ�����ֽܷ����������Կ���ʹ��TreeSet.(ûӳ���ϵ)
 3.�����ϵ���Ϣд�뵽һ���ļ��С�
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class StudentInfoTest {
    public static void main(String[] args) throws IOException {
        // ��������Ҫ���÷����Ӹߵ��ͱȽϣ����ڲ��ܸı䣬�ʹ�һ���Ƚ���
        Comparator<Student> cmp = Collections.reverseOrder(); // ���ط���Ƚ���
        Set<Student> stus = StudentInfoTool.getStudents(cmp); // �ɸ߷ֵ��ͷ�����
        // Set<Student> stu = StudentInfoTool.getStudents(); //�еͷֵ��߷�����
        StudentInfoTool.write2File(stus);
    }
}

class StudentInfoTool // ѧ�������࣬����ķ������Ǿ�̬��
{
    public static Set<Student> getStudents() throws IOException {
        return getStudents(null); // Ĭ�ϵıȽ����������ֵ
    }

    // ��Ҫ�����쳣��Ҫ����
    // ��̬������ȡ��Ļ��¼�����Ϣ�������浽����stus
    public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException // �бȽ�����
    {
        BufferedReader bufr = null;
        // ����Ҫ��Ӹ��ж�
        Set<Student> stus = null;
        if (cmp == null) // ���Ϊ�վ�ΪĬ�ϵ�
            stus = new TreeSet<Student>();
        else
            stus = new TreeSet<Student>(cmp); // ���ϱȽ����ļ���
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in)); // ��ȡ����¼�����Ϣ
            String line = null;
            // ��������stus�����������ϣ��Զ�����
            while ((line = bufr.readLine()) != null) {
                if ("over".equals(line)) // ��ȡ¼�����Ϣͣ��������
                    break;
                // �ö�����
                String[] info = line.split(","); // �и��
                // parseInt(String s) //��S����10���ƵĽ���
                Student stu = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                stus.add(stu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufr.close();
            } catch (IOException e) {
                throw new RuntimeException("�ر�ʧ�ܣ�");
            }
        }
        return stus;
    }

    // ��������Ϣд�뵽�ļ�
    public static void write2File(Set<Student> stus) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));
        for (Student stu : stus) {
            bufw.write(stu.toString() + "\t"); // ѧ����Ϣ��
            // bufw.write(stu.getSum()); //�ܷ�����д�޷�ʶ����Ϊ����λ
            bufw.write(stu.getSum() + "");
            bufw.newLine(); // ����
            bufw.flush(); // ˢ��
        }
        bufw.close();
    }
}

// ѧ�����Լ��ı�ʾ��ʽ
class Student implements Serializable, Comparable<Student> // �������Ƚϣ�����Ҫʵ��Comparable
{
    private String name;
    private int ma, ch, en;
    private int sum;

    Student(String name, int ma, int ch, int en) {
        this.name = name;
        this.ma = ma;
        this.ch = ch;
        this.en = en;
        sum = ma + ch + en;
    }

    // ��дcompareTo
    public int compareTo(Student s) {
        // �ȱȽ��ܷ֣�����ܷ�һ���Ͱ���������
        int num = new Integer(this.sum).compareTo(new Integer(s.sum)); // Integer�߱��˱Ƚ���,�����ִܷӵ͵��ߵ�����
        if (num == 0)
            return this.name.compareTo(s.name);
        return num;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    // ��дhashCode
    public int hashCode() {
        return name.hashCode() + sum * 78; // �ı��ϣֵ
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            throw new ClassCastException("���Ͳ�ƥ��"); // Runtime������
        Student s = (Student) obj;
        return this.name.equals(s.name) && this.sum == s.sum; // ����дget����
    }

    public String toString() {
        return "student[" + name + "," + ma + "," + ch + "," + en + "]";
    }
}