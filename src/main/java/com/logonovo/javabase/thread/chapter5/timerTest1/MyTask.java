package com.logonovo.javabase.thread.chapter5.timerTest1;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/15 22:31
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为"+System.currentTimeMillis());
    }

    public static void main(String[] args) {
        System.out.println("当前时间为"+System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Timer timer = new Timer();
        MyTask task = new MyTask();
        timer.schedule(task, calendar.getTime());
    }
}
