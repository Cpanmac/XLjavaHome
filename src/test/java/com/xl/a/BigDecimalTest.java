package com.xl.a;

import com.xl.util.Print;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * @Date: 2017-11-28
 * @Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class BigDecimalTest {
    @Test
    public void demoTest() {
        BigDecimal a= new BigDecimal(1.1);
        Print.info(a.add(new BigDecimal(2)));
        Print.info(a);
    }
}
