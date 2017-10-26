package com.xl;

import cn.amumu.spring.orm.Student;
import cn.amumu.spring.service.StudentService;
import com.xl.collections.CaseInsensitiveMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/9/28
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class XLTest {
    @Test
    public void mapTest() {
        Map map = new CaseInsensitiveMap();
        map.put("aaa", 11);
        map.put("aAA", 22);
        map.put("aAA", "测试");
        map.put("aA1A", "测试");
        map.put("aA1A", "测试2");
        System.out.println(map);
    }

    static Logger logger = LoggerFactory.getLogger(XLTest.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentServiceImpl");
        Student s = new Student();
        s.setName("测试");
        s.setAge(15);
        studentService.saveStudent(s);
        logger.info("findAll : " + studentService.findAll().size());
        context.close();
    }
}
