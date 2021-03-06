package com.xl.io;

import com.xl.util.FileTool;
import com.xl.util.Print;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 注意：如果用writeUIF(String str)写的话，用转换流读不出来，只能用对应的读取方式读取,英文不涉及编码
 *
 * @author Administrator
 */
public class DataStreamTest {
    private File file = FileTool.getResourceFile("1.txt");

    public DataStreamTest() throws UnsupportedEncodingException {
    }

    /**
     * 写入
     *
     * @throws IOException
     */
    @Test
    public void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(1);
        dos.writeBoolean(true);
        dos.writeDouble(9452.123);
        dos.write(123);
        dos.writeInt(2);
        dos.close();
        Print.info("写入成功");
        FileTool.open(file);
    }

    /**
     * 读取
     *
     * @throws IOException
     */
    @Test
    public void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        // 读反的话传出来的数据是错误的, 先读double的话 就是读八个字节
        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();
        int num2 = dis.readInt();
        Print.info("num=" + num);
        Print.info("b=" + b);
        Print.info("d=" + d);
        Print.info("num2=" + num2);
        dis.close();
    }

    @Test
    public void readUTFDemo() throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        String s = dis.readUTF();
        Print.info(s);
        Print.info(dis.available());
        s = dis.readUTF();
        Print.info(s);
    }

    @Test
    public void writeUTFDemo() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeUTF("hello"); // 这样是没问题的
        dos.writeUTF("你好");
        dos.close();
    }
}
