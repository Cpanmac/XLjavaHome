package com.xl.util;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017/10/11
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class CMDUtil {
    /**
     * �ر�java����
     *
     * @throws IOException
     */
    public static void closeJava() throws IOException {
        Runtime.getRuntime().exec("taskkill /f /t /im java.exe");
    }
}
