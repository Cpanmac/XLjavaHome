package com.xl.IO.转换流的编码表;

/*
 有5个学生，每个学生有3门课的成绩，
 从键盘输入以上数据（包括，三门课成绩）
 输入的格式：如：zhangsan，30，40，60计算出总成绩，并把学生的信息和计算出的总分数高低顺序放在磁盘文件"stud.txt"中
 1.描述学生对象。
 2.定义一个可操作学生对象的工具类

 思路：
 1.通过获取键盘录入的一行数据，并将该行中的信息取出封装成学生对象。
 2.因为学生对象有很多，那么就需要存储，使用到集合。因为要对学生的总分进行排序，所以可以使用TreeSet.(没映射关系)
 3.将集合的信息写入到一个文件中。
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
        // 需求：现在要求用分数从高到低比较，现在不能改变，就传一个比较器
        Comparator<Student> cmp = Collections.reverseOrder(); // 返回反向比较器
        Set<Student> stus = StudentInfoTool.getStudents(cmp); // 由高分到低分排序
        // Set<Student> stu = StudentInfoTool.getStudents(); //有低分到高分排序
        StudentInfoTool.write2File(stus);
    }
}

class StudentInfoTool // 学生工具类，里面的方法都是静态的
{
    public static Set<Student> getStudents() throws IOException {
        return getStudents(null); // 默认的比较器，传入空值
    }

    // 既要声明异常又要处理
    // 静态方法获取屏幕上录入的信息，并保存到集合stus
    public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException // 有比较器的
    {
        BufferedReader bufr = null;
        // 这里要多加个判断
        Set<Student> stus = null;
        if (cmp == null) // 如果为空就为默认的
            stus = new TreeSet<Student>();
        else
            stus = new TreeSet<Student>(cmp); // 带上比较器的集合
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in)); // 读取键盘录入的信息
            String line = null;
            // 建立集合stus，二叉树集合，自动排序
            while ((line = bufr.readLine()) != null) {
                if ("over".equals(line)) // 读取录入的信息停不下来，
                    break;
                // 拿逗号切
                String[] info = line.split(","); // 切割后
                // parseInt(String s) //对S进行10进制的解析
                Student stu = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                stus.add(stu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufr.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭失败！");
            }
        }
        return stus;
    }

    // 将集合信息写入到文件
    public static void write2File(Set<Student> stus) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));
        for (Student stu : stus) {
            bufw.write(stu.toString() + "\t"); // 学生信息，
            // bufw.write(stu.getSum()); //总分这样写无法识别，因为最后八位
            bufw.write(stu.getSum() + "");
            bufw.newLine(); // 换行
            bufw.flush(); // 刷新
        }
        bufw.close();
    }
}

// 学生类自己的表示形式
class Student implements Serializable, Comparable<Student> // 按分数比较，所以要实现Comparable
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

    // 覆写compareTo
    public int compareTo(Student s) {
        // 先比较总分，如果总分一样就按姓名排序
        int num = new Integer(this.sum).compareTo(new Integer(s.sum)); // Integer具备了比较性,这是总分从低到高的排序
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

    // 复写hashCode
    public int hashCode() {
        return name.hashCode() + sum * 78; // 改变哈希值
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            throw new ClassCastException("类型不匹配"); // Runtime的子类
        Student s = (Student) obj;
        return this.name.equals(s.name) && this.sum == s.sum; // 不用写get方法
    }

    public String toString() {
        return "student[" + name + "," + ma + "," + ch + "," + en + "]";
    }
}