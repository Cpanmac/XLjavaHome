package com.xl.io.DataStream;

import com.xl.util.Print;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        writeData();
        readData();
    }

    public static void readData() throws IOException {
        //按顺序读，别瞎读,读反的话是错的！
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();
        String s = dis.readUTF();
        Print.println("num=" + num);
        Print.println("b=" + b);
        Print.println("d=" + d);
        Print.println("s=" + s);
        dis.close();
    }

    public static void writeData() throws IOException  //写入
    {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeInt(234);  //4个字节
        dos.writeBoolean(true);  //1个字节
        dos.writeDouble(912.112); //8个字节 生成的txt文件肯定是13个字节
        dos.writeUTF("哈喽");    //以UTF-8修改版写入，只能用相应的读取方式读取，用转换流，读不出
        dos.close();
    }
}
