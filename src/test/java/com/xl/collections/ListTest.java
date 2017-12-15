package com.xl.collections;

import com.xl.entity.Student;
import com.xl.util.ListUtil;
import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class ListTest {
    List<String> list = new ArrayList<String>();
    List<Student> studentList = new ArrayList<Student>();
    @Before
    public void init() {
        list.add("张三");
        list.add("张三");
        list.add("李四");
        for (int i = 0; i < 3; i++) {
            Student s = new Student();
            s.setName("测试"+i);
            studentList.add(s);
        }
        Student s = new Student();
        s.setName("测试0");
        studentList.add(s);
    }

    /**
     * 去重
     */
    @Test
    public void distinctTest() {
        Print.info(studentList);
        //不能去重
        Print.info(ListUtil.distinct(studentList));
        Print.info(new ArrayList<>(new HashSet<>(studentList)));

        Print.info(ListUtil.distinct(list));
    }

    /**
     * 转化为数组
     */
    @Test
    public void arrayTest() {
        Print.info(Arrays.toString(list.toArray()));
    }
}
