package com.logonovo.javabase.thread.chapter3.waitNotify;

import java.util.Objects;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/7 22:41
 */
public class ThreadA extends Thread {
    private Object lock;
    private String flag;

    public ThreadA(Object lock,String flag) {
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                if("wait".equals(flag)){
                    System.out.println("开始wait time="+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("结束wait time="+System.currentTimeMillis());
                }else{
                    System.out.println("开始notify time="+System.currentTimeMillis());
                    lock.notify();
                    System.out.println("结束notify time="+System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock, "wait");
            a.setName("A");
            a.start();
            Thread.sleep(3000);
            ThreadA b = new ThreadA(lock, "notify");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
