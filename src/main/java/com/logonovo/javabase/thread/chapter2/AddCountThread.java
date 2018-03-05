package com.logonovo.javabase.thread.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/5 22:28
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.getAndIncrement());

        }
    }

    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();
        Thread t1 = new Thread(countService);
        t1.start();
        Thread t2 = new Thread(countService);
        t2.start();
        Thread t3 = new Thread(countService);
        t3.start();
        Thread t4 = new Thread(countService);
        t4.start();
        Thread t5 = new Thread(countService);
        t5.start();
    }
}
