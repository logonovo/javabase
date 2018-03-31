package com.logonovo.javabase.thread.chapter7;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/31 22:14
 */
public class Limiting2 {

    private static AtomicLong atomicLong = new AtomicLong();

    public void doSomething() throws InterruptedException {
        try{
            if(atomicLong.incrementAndGet() > 10){
                System.out.println("limited");
                return;
            }
            System.out.println("do something");
            Thread.sleep(2000);
        }finally {
            atomicLong.decrementAndGet();
        }
    }

    public static void main(String[] args) {
        Limiting2 l = new Limiting2();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    l.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(runnable).start();
        }
    }
}
