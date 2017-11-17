package com.xl.a;

import com.xl.util.FileTool;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/16
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class FileTest {
    private final static Logger LOGGER = Logger.getLogger(FileTest.class);

    @Test
    public void spTest() {
        LOGGER.info(File.separator);           //\
        LOGGER.info(File.separatorChar);       //\
        LOGGER.info(File.pathSeparator);       //;
        LOGGER.info(File.pathSeparatorChar);   //;
    }

    @Test
    public void getDeskTest() {
        log.info(FileTool.getDesktopPath());
    }
}
