package com.xl.collections;

import com.xl.util.Print;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListTest {
    @Test
    public void arrayTest() {
        LinkedList<String> link = new LinkedList<String>();
        link.addFirst("java01");
        link.addFirst("java02");
        link.addFirst("java02");
        link.addFirst("java03");
        link.addFirst("java04");
        link.addFirst("java05");
        link.addFirst("java06");
        Print.println(link.getFirst());
        Print.println(link.getLast());
        // 不用迭代器清空所有元素
        Print.println(Arrays.toString(link.toArray()));
    }
}
