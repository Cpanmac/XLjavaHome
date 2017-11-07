package com.xl.util;

import org.junit.Test;

import java.awt.*;

public class ZipUtilsTest {
    @Test
    public void uncompression() throws Exception {
 ZipUtils.uncompression(FileTool.getResourceFile("1.txt"), Desktop.getDesktop().toString());
    }
}