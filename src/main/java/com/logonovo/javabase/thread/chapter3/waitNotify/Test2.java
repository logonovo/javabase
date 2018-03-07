package com.logonovo.javabase.thread.chapter3.waitNotify;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/7 22:35
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("syn 上面");
            synchronized (lock){
                System.out.println("sync 第一行");
                lock.wait();//WAITING (on object monitor)
                System.out.println("wait 下的代码");
            }
            System.out.println("syn 下面的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
