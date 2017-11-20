package com.xl.io;

import com.xl.util.Print;
import org.junit.Test;

import java.io.File;

public class FilepathSeparator {
    @Test
    public void filepathSeparatorTest() {
        Print.println("pathSeparator：" + File.pathSeparator); // 调用静态常量
        Print.println("pathSeparatorChar" + File.pathSeparatorChar);
        Print.println("separator：" + File.separator); // 调用静态常量
        Print.println("separatorChar:" + File.separatorChar);
        Print.println(";");
    }
}
