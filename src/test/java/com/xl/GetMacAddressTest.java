package com.xl;

import com.xl.util.MacAddress;
import com.xl.util.Print;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/10/18
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class GetMacAddressTest {
    @Test
    public void getMacAddress() throws Exception {
        Print.info(MacAddress.getMacAddress("127.0.0.1"));
    }
}