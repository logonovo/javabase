package com.logonovo.javabase.thread.chapter5.timerCancelTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/16 22:34
 */
public class MyTaskA extends TimerTask{
    private int i;

    public MyTaskA(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第"+i+"次没有被cancel取消");
    }

    public static void main(String[] args) {
        int i = 0;
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        while (true){
            i++;
            Timer timer = new Timer();
            MyTaskA myTaskA = new MyTaskA(i);
            timer.schedule(myTaskA, runDate);
            timer.cancel();
        }
    }
}
