package com.xl.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
public class ListUtil {
    /**
     * 重去掉复
     *
     * @param list
     * @return
     */
    public static List distinct(List list) {
        return new ArrayList(new HashSet(list));
    }
}
