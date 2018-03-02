package com.logonovo.javabase.thread.chapter1;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/2 22:25
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(){
        System.out.println(Thread.currentThread().getName());
    }

    public MyThread(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public synchronized void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        //print
        // main
        // Thread-0
        //构造函数由main线程调用，run方法由Thread-0线程调用
    }
}
