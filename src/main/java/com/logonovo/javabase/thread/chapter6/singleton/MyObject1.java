package com.logonovo.javabase.thread.chapter6.singleton;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/16 23:06
 */
public class MyObject1 {
    private volatile static MyObject1 myObject;

    public MyObject1() {
    }

    public static MyObject1 getInstance(){
        try {
            if(myObject == null){
                Thread.sleep(3000);
                synchronized (MyObject1.class){
                    if(myObject == null){
                        myObject = new MyObject1();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }

    static class MyThread1 extends Thread{

        @Override
        public void run() {
            System.out.println(MyObject1.getInstance().hashCode());
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
    }
}
