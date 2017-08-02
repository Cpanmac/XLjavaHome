package com.xl.collections;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("demo.txt", true);
        fw.write("nihao");
        fw.write("\r\n¹þà¶");
        fw.close();
    }
}
