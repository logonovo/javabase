package com.logonovo.javabase.thread.chapter3.TwoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/7 22:18
 */
public class MyList {
    volatile private List list = new ArrayList();
    public void add(){
        list.add("logonovo");
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(list);
        b.setName("a");
        b.start();
    }
}
class ThreadA extends Thread{
    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("add "+(i+1)+" element");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadB extends Thread{
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true){
                if(list.size() == 5){
                    System.out.println("==5了，线程b要退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}