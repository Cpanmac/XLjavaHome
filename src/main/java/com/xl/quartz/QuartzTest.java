package com.xl.quartz;

import com.xl.util.Print;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 10/21 0021
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            String job_name = "动态任务调度";
            Print.println("【任务启动】开始(每10秒输出一次)...");
            QuartzManager.addJob(job_name, QuartzJob.class, "0/10 * * * * ?");
            Thread.sleep(5000);
            Print.println("【修改时间】开始(每2秒输出一次)...");
            QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?");
            Thread.sleep(6000);
            Print.println("【移除定时】开始...");
            QuartzManager.removeJob(job_name);
            Print.println("【移除定时】成功");
            Print.println("【再次添加定时任务】开始(每10秒输出一次)...");
            QuartzManager.addJob(job_name, QuartzJob.class, "*/10 * * * * ?");
            Thread.sleep(60000);
            Print.println("【移除定时】开始...");
            QuartzManager.removeJob(job_name);
            Print.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    public static String getCron(java.util.Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
}
