package com.xl.file;

import com.xl.util.FileTool;
import com.xl.util.Print;
import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/16
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class FileTest {
    @Test
    public void spTest() {
        Print.info(File.separator);           //\
        Print.info(File.separatorChar);       //\
        Print.info(File.pathSeparator);       //;
        Print.info(File.pathSeparatorChar);   //;
    }

    @Test
    public void getDeskTest() {
        Print.info(FileTool.getDesktopPath());
    }
}
