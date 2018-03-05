package com.logonovo.javabase.thread.chapter2;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/5 22:01
 */
public class StringSynchroizedObject {
    public static void print(String param){
        try {
            synchronized (param){
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringThreadA a = new StringThreadA("a");
        a.setName("A");
        a.start();

        StringThreadA b = new StringThreadA("a");
        b.setName("B");
        b.start();
    }
}

class StringThreadA extends Thread{
    private String param;

    public StringThreadA(String param) {
        this.param = param;
    }

    @Override
    public void run() {
        StringSynchroizedObject.print(param);
    }
}
