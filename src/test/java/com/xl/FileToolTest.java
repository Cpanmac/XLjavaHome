package com.xl;

import com.xl.util.FileTool;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/16
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class FileToolTest {
    @Test
    public void pathTest() throws UnsupportedEncodingException {
        FileTool.getResourceFile("1.txt");
    }
}
