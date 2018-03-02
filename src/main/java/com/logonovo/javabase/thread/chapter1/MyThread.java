package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:25
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
