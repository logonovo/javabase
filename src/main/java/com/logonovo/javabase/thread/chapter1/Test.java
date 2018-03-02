package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:23
 */
public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
