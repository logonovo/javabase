package com.logonovo.javabase.thread.chapter2;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/4 21:49
 */
public class SynchronizedReenterLock extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    public static void main(String[] args) {
        SynchronizedReenterLock thread = new SynchronizedReenterLock();
        thread.start();
    }
}
class Service{
    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");
    }
}
