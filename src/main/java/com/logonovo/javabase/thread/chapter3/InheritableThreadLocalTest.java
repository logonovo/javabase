package com.logonovo.javabase.thread.chapter3;

import java.util.Date;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/13 22:31
 */
public class InheritableThreadLocalTest extends InheritableThreadLocal implements Runnable {

    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Thread线程中取值:"+Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main线程中取值:"+Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            InheritableThreadLocalTest test = new InheritableThreadLocalTest();
            Thread thread = new Thread(test);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
