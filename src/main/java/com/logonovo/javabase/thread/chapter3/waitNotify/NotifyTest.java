package com.logonovo.javabase.thread.chapter3.waitNotify;

import java.util.Objects;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/7 23:00
 */
public class NotifyTest extends Thread {
    private Object lock;

    public NotifyTest(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            //lock.notify();
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadNotifyOne a = new ThreadNotifyOne(lock);
            a.start();
            ThreadNotifyOne b = new ThreadNotifyOne(lock);
            b.start();
            ThreadNotifyOne c = new ThreadNotifyOne(lock);
            c.start();
            ThreadNotifyOne d = new ThreadNotifyOne(lock);
            d.start();
            ThreadNotifyOne e = new ThreadNotifyOne(lock);
            e.start();
            Thread.sleep(1000);

            NotifyTest notify = new NotifyTest(lock);
            notify.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadNotifyOne extends Thread{
    private Object lock;

    public ThreadNotifyOne(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("begin wait() ThreadName="+Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait() ThreadName="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
