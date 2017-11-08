package com.xl;

import com.github.ExcelUtils;
import com.xl.entity.Student1;
import com.xl.util.FileTool;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017-10-17
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class ExcelTest {
    @Test
    public void excel2Object() throws Exception {
        File path = FileTool.getResourceFile("students_01.xlsx");
        log.info("读取全部：");
        List<Student1> students = ExcelUtils.getInstance().readExcel2Objects(path.getAbsolutePath(), Student1.class);
        for (Student1 stu : students) {
            log.info(stu);
        }
        log.info("读取指定行数：");
        students = ExcelUtils.getInstance().readExcel2Objects(path.getAbsolutePath(), Student1.class, 0, 3, 0);
        for (Student1 stu : students) {
            log.info(stu);
        }
    }

    @Test
    public void excel2Object2() throws Exception {
        File f = FileTool.createResourceFile("excel/students_02.xlsx");
        // 不基于注解,将Excel内容读至List<List<String>>对象内
        List<List<String>> lists = ExcelUtils.getInstance().readExcel2List(f.getAbsolutePath(), 1, 3, 0);
        System.out.println("读取Excel至String数组：");
        for (List<String> list : lists) {
            System.out.println(list);
        }
     /* 报错  // 基于注解,将Excel内容读至List<Student2>对象内 b
        File f2 = FileTool.createResourceFile("excel/students_03.xlsx");
        List<Student2> students = ExcelUtils.getInstance().readExcel2Objects(f2.getAbsolutePath(), Student2.class, 0);
        System.out.println("读取Excel至对象数组(支持类型转换)：");
        for (Student2 st : students) {
            System.out.println(st);
        }*/
    }

    @Test
    public void testObject2Excel() throws Exception {
        String tempPath = FileTool.getResourceFile("excel/normal_template.xlsx").getPath();
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("1010001", "盖伦", "六年级三班"));
        list.add(new Student1("1010002", "古尔丹", "一年级三班"));
        list.add(new Student1("1010003", "蒙多(被开除了)", "六年级一班"));
        list.add(new Student1("1010004", "萝卜特", "三年级二班"));
        list.add(new Student1("1010005", "奥拉基", "三年级二班"));
        list.add(new Student1("1010006", "得嘞", "四年级二班"));
        list.add(new Student1("1010007", "瓜娃子", "五年级一班"));
        list.add(new Student1("1010008", "战三", "二年级一班"));
        list.add(new Student1("1010009", "李四", "一年级一班"));
        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");
        // 基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(tempPath, 0, list, data, Student1.class, false, FileTool.createResourceFile("excel/A.xlsx").getPath());
        // 不基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(list, Student1.class, true, null, true, FileTool.createResourceFile("excel/b.xlsx").getPath());
    }

    @Test
    public void testMap2Excel() throws Exception {
        Map<String, List<?>> classes = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");
        classes.put("class_one", Arrays.asList(new Student1("1010009", "李四", "一年级一班"), new Student1("1010002", "古尔丹", "一年级三班")));
        classes.put("class_two", Collections.singletonList(new Student1("1010008", "战三", "二年级一班")));
        classes.put("class_three", Arrays.asList(new Student1("1010004", "萝卜特", "三年级二班"), new Student1("1010005", "奥拉基", "三年级二班")));
        classes.put("class_four", Collections.singletonList(new Student1("1010006", "得嘞", "四年级二班")));
        classes.put("class_six", Arrays.asList(new Student1("1010001", "盖伦", "六年级三班"), new Student1("1010003", "蒙多", "六年级一班")));
        ExcelUtils.getInstance().exportObject2Excel("D:\\IdeaSpace\\Excel4J\\src\\test\\resource\\map_template.xlsx", 0, classes, data, Student1.class, false, "C.xlsx");
    }

    @Test
    public void testList2Excel() throws Exception {
        List<List<String>> list2 = new ArrayList<>();
        List<String> header = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> _list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                _list.add(i + " -- " + j);
            }
            list2.add(_list);
            header.add(i + "---栏");
        }
        ExcelUtils.getInstance().exportObjects2Excel(list2, header, "D:\\D.xlsx");
    }
}
