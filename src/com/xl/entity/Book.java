package com.xl.entity;

import lombok.Data;
import org.junit.Test;

@Data
public class Book {
    private String name;
    private String author;
    private String price; //��Ϊ��Ԫ,����ֱ�����ó�String

    @Test
    public void sysoTest() {
        Book b = new Book();
        b.setAuthor("111");
        System.out.println(b);
    }
}
