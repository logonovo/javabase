package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:23
 */
public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("运行结束");
    }
}
