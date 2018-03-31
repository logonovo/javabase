package com.logonovo.javabase.thread.chapter7;

import java.util.concurrent.Semaphore;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/31 21:59
 */
public class Limiting {

    public static Semaphore semaphore = new Semaphore(10);

    public void doSomething() throws InterruptedException {
        semaphore.acquire();
        if(semaphore.getQueueLength() > 0){
            System.out.println("limit");
            return;
        }
        System.out.println("do something"+semaphore.availablePermits());
        Thread.sleep(2000);
        semaphore.release();
    }

    public static void main(String[] args) {
        Limiting l = new Limiting();
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
