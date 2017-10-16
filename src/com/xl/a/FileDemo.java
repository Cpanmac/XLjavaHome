package com.xl.a;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: –Ï¡¢
 * Date: 2017/10/16
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class FileDemo {
    private final static Logger LOGGER = Logger.getLogger(FileDemo.class);

    @Test
    public void spTest() {
        LOGGER.info(File.separator);
        LOGGER.info(File.separatorChar);
        LOGGER.info(File.pathSeparator);
        LOGGER.info(File.pathSeparatorChar);
    }
}
