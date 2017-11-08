package com.xl;

import cn.amumu.spring.orm.Student;
import cn.amumu.spring.service.StudentService;
import com.xl.collections.CaseInsensitiveMap;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/9/28
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
@Log4j
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

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentServiceImpl");
        Student s = new Student();
        s.setName("测试");
        s.setAge(15);
        studentService.saveStudent(s);
        log.info("findAll : " + studentService.findAll().size());
        context.close();
    }
}
