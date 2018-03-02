package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:25
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(){

    }

    public MyThread(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        count --;
        System.out.println("由"+Thread.currentThread().getName()+"计算，count="+count);
    }

    public static void main(String[] args) {


        MyThread same = new MyThread();
        Thread a = new Thread(same,"A");
        Thread b = new Thread(same,"B");
        Thread c = new Thread(same,"C");
        Thread d = new Thread(same,"D");
        Thread e = new Thread(same,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
