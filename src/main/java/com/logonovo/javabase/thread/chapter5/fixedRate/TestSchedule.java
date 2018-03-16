package com.logonovo.javabase.thread.chapter5.fixedRate;


import java.util.*;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/16 22:48
 */
public class TestSchedule {
    static class Mytask extends TimerTask{
        @Override
        public void run() {
            System.out.println("begin timer="+new Date());
            System.out.println("end timer="+new Date());

        }
    }

    public static void main(String[] args) {
        Mytask myTask = new Mytask();
        System.out.println("现在执行时间:"+new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
        Timer timer = new Timer();
        Date runDate = calendar.getTime();
        timer.schedule(myTask, runDate, 2000);
    }
}
