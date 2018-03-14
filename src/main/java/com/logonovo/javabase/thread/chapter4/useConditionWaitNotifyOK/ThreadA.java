package com.logonovo.javabase.thread.chapter4.useConditionWaitNotifyOK;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/14 21:46
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        Thread.sleep(3000);
        service.signal();
    }
}
