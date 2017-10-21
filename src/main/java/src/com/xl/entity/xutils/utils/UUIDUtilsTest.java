package com.xl.entity.xutils.utils;

import com.xuan.xutils.utils.UUIDUtils;
import org.junit.Test;

/**
 * Created by xuan on 17/6/7.
 */
public class UUIDUtilsTest {
    @Test
    public void testUuid() {
        String uuid = UUIDUtils.uuid();
        System.out.println("++++++++++uuid:" + uuid);
    }
}
