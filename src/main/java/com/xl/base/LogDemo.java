package com.xl.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/9
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class LogDemo {
    private final static Logger LOGGER = Logger.getLogger(LogDemo.class);
     private static final Log log = LogFactory.getLog(LogDemo.class);
    @Test
    public void logTest() {
        LOGGER.info("测试");
        log.info("测试");
    }
}
