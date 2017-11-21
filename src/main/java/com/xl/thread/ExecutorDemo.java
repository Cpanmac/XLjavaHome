package com.xl.thread;

import com.xl.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorDemo {
    private static Integer pages = 1; // 网页数
    private static boolean exeFlag = true; // 执行标识

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建ExecutorService 连接池默认连接10个
        while (exeFlag) {
            if (pages <= 100) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Print.info("爬取了第" + pages + "网页...");
                        pages++;
                    }
                });
            } else {
                if (((ThreadPoolExecutor) executorService).getActiveCount() == 0) { // 活动线程个数是0
                    executorService.shutdown(); // 结束所有线程
                    exeFlag = false;
                    Print.info("爬虫任务已经完成");
                }
            }
            try {
                Thread.sleep(100); // 线程休息0.1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
