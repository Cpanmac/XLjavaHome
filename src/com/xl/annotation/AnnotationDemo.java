package com.xl.annotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017/10/16
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationDemo {
    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("��ȥ�ķ�������");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "����", comments = "Main method", date = "Nov 17 2012", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        for (Method method : AnnotationDemo.class.getClassLoader().loadClass(("com.xl.annotation.AnnotationDemo")).getMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                for (Annotation anno : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation in Method '" + method + "' : " + anno);
                }
                MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                if (methodAnno.revision() == 1) {
                    System.out.println("Method with revision no 1 = " + method);
                }
            }
        }
    }

    @Override
    @MethodInfo(author = "����", comments = "Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "����toString����";
    }
}
