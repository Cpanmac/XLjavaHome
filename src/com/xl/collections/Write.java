package com.xl.collections;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Write implements Runnable { // 写入
    private PipedOutputStream out;

    Write(PipedOutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            System.out.println("开始写入数据，等待6秒后");
            Thread.sleep(6000);  //让线程休息6秒
            out.write("piped la是a".getBytes());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException("管道输出流失败");
        } catch (InterruptedException e) {  //处理中断的异常
            throw new RuntimeException("终端异常");
        }
    }
}
