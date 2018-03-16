package com.logonovo.javabase.thread.chapter6.singleton;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/16 23:10
 */
public class MyObject2 {

    private static class MyObjectHolder{
        private static MyObject2 object = new MyObject2();
    }
    private  MyObject2(){
    }

    public static MyObject2 getInstance(){
        return MyObjectHolder.object;
    }

    static class MyThread2 extends Thread{

        @Override
        public void run() {
            System.out.println(MyObject2.getInstance().hashCode());
        }
    }

     public static void main(String[] args) {
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        MyThread2 t3 = new MyThread2();
        t1.start();
        t2.start();
        t3.start();
    }
}
