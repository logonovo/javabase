package com.logonovo.javabase.thread.chapter2;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/5 21:48
 */
public class SynchronizedStaticMethod extends Thread {
    @Override
    public void run() {
        super.run();
        ServiceA.printA();
    }

    public static void main(String[] args) {
        SynchronizedStaticMethod a = new SynchronizedStaticMethod();
        a.setName("a");
        a.start();

        ThreadB b = new ThreadB();
        b.setName("b");
        b.start();

        try {
            synchronized (ServiceA.class){
                System.out.println("lock class:"+System.currentTimeMillis());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class ThreadB extends Thread{
    @Override
    public void run() {
        ServiceA.printB();
    }
}T
class ServiceA{
    synchronized public static void printA(){
        try {
            System.out.println("enter a"+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("leave a"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB(){
        System.out.println("enter b"+System.currentTimeMillis());
        System.out.println("leave b"+System.currentTimeMillis());
    }
}
