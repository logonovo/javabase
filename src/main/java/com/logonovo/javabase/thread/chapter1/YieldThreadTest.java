package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/4 10:33
 */
public class YieldThreadTest extends Thread{
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            //Thread.yield();
            count += count+(i+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时:"+(endTime-beginTime)+" ms");
    }

    public static void main(String[] args) {
        Thread thread = new YieldThreadTest();
        thread.start();
    }
}
