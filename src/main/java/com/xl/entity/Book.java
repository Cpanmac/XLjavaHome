package com.xl.entity;

import com.xl.util.Print;
import lombok.Data;
import org.junit.Test;

@Data
public class Book {
    private String name;
    private String author;
    private String price; //因为有元,所以直接设置成String
    /**
     * boolean类型获取是is
     */
    private boolean hasRight;

    @Test
    public void sysoTest() {
        Book b = new Book();
        b.setAuthor("111");
        Print.info(b);
        Print.info(b.isHasRight());
        b.setHasRight(true);
        Print.info(b.isHasRight());
    }
}
