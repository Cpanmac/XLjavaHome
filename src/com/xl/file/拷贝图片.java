package com.xl.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*复制一个图片
 思路：
 1.用字节读取流对象和图片关联。
 2.用字节写入流对象创建图片文件。用于存储获取到的图片数据
 3.通过循环读写，完成数据的存储
 4.关闭资源。
 用字符流也可以复制图片，但有可能复制完了看不了
 */
public class 拷贝图片 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("c:/2.jpg"); // 存储的目标文件路径
            fis = new FileInputStream("c:/1.jpg"); // 关联 源文件
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            // TODO: handle exception
            throw new RuntimeException("复制文件失败");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException("读取关闭失败");
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException("写入关闭失败");
            }
        }
    }
}
