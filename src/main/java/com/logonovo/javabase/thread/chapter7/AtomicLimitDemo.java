package com.logonovo.javabase.thread.chapter7;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/4/13 22:22
 */
public class AtomicLimitDemo {
    public static void main(String[] args) {
        AtomicLong atomic = new AtomicLong();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (atomic.incrementAndGet() > 10) {
                        System.out.println("limited");
                        return;
                    }
                    System.out.println("working");
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                     e.printStackTrace();
                } finally {
                    atomic.decrementAndGet();
                }
            }
        };
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}
