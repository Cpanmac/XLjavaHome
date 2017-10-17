package com.xl.entity;

import lombok.Data;
import org.junit.Test;

@Data
public class Book {
    private String name;
    private String author;
    private String price; //因为有元,所以直接设置成String

    @Test
    public void sysoTest() {
        Book b = new Book();
        b.setAuthor("111");
        System.out.println(b);
    }
}
