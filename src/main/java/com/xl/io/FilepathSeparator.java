package com.xl.io;

import com.xl.util.Print;
import org.junit.Test;

import java.io.File;

public class FilepathSeparator {
    @Test
    public void filepathSeparatorTest() {
        Print.info("pathSeparator：" + File.pathSeparator); // 调用静态常量
        Print.info("pathSeparatorChar" + File.pathSeparatorChar);
        Print.info("separator：" + File.separator); // 调用静态常量
        Print.info("separatorChar:" + File.separatorChar);
        Print.info(";");
    }
}
