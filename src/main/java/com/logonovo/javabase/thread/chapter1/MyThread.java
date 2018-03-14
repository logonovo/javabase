package com.logonovo.javabase.thread.chapter1;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:25
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(){
        System.out.println(Thread.currentThread().getName());
    }

    public MyThread(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public synchronized void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i="+(i+1));
        }
        this.suspend();
    }

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            thread.sleep(2000);
            thread.interrupt();

            System.out.println(thread.isInterrupted());//false
            System.out.println(thread.isInterrupted());//false

            Thread.currentThread().interrupt();
            System.out.println(Thread.interrupted());//true
            System.out.println(Thread.interrupted());//false
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
