package com.xl.base;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.junit.Test;

import java.io.File;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/9
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
@Log4j
//@CommonsLog
//@lombok.extern.java.Log
public class LogTest {
    private FileAppender getFileAppender() {
        return (FileAppender) log.getAppender("appender2");
    }

    @Test
    public void demoTest() {
        Enumeration allAppenders = log.getAllAppenders();
        log.info(allAppenders);
        while (allAppenders.hasMoreElements()) {
            log.info(allAppenders.nextElement());
        }
        log.info(getFile());
    }

    public File getFile() {
        return new File(((DailyRollingFileAppender) getFileAppender()).getFile());
    }
}
