package com.xl.file;

import com.xl.util.Print;
import org.junit.Test;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class ResourceBundleTest {
    private static final String BUNDLE_NAME = "stream.messages"; //$NON-NLS-1$
    /**
     * 可以直接读取properties
     */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    @Test
    public void demoTest() {
        Print.info(RESOURCE_BUNDLE.getBaseBundleName());
        Enumeration<String> enumeration = RESOURCE_BUNDLE.getKeys();
        while (enumeration.hasMoreElements()) {
            Print.info(enumeration.nextElement());
        }
    }
}
