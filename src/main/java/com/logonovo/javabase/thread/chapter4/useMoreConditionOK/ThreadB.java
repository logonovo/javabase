package com.logonovo.javabase.thread.chapter4.useMoreConditionOK;


/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/14 21:46
 */
public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitB();
    }

}
