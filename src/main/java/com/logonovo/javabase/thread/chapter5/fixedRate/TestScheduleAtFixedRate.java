package com.logonovo.javabase.thread.chapter5.fixedRate;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/16 22:53
 */
public class TestScheduleAtFixedRate {
    static class Mytask extends TimerTask {
        @Override
        public void run() {
            System.out.println("begin timer="+new Date());
            System.out.println("end timer="+new Date());

        }
    }

    public static void main(String[] args) {
        TestSchedule.Mytask myTask = new TestSchedule.Mytask();
        System.out.println("现在执行时间:"+new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
        Timer timer = new Timer();
        Date runDate = calendar.getTime();
        timer.scheduleAtFixedRate(myTask, runDate, 2000);
    }
}
