package com.logonovo.javabase.thread.chapter4.useMoreConditionOK;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/14 21:56
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        myService.signalA();
    }
}
