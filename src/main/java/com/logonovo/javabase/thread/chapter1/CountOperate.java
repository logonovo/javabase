package com.logonovo.javabase.thread.chapter1;

import java.util.concurrent.CountDownLatch;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 23:36
 */
public class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate -- begin");
        System.out.println("Thread.currentThread().getName()="+ Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("CountOperate -- end");
    }

    @Override
    public void run() {
        System.out.println("run -- begin");
        System.out.println("Thread.currentThread().getName()="+ Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("run -- end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }
}
