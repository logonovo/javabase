package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:23
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("A");
        System.out.println("begin == "+thread.isAlive());
        thread.start();
        Thread.sleep(1000);
        System.out.println("end == "+thread.isAlive());
    }
}
