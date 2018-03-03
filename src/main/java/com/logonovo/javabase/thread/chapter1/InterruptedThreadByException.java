package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/3 22:09
 */
public class InterruptedThreadByException extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if(this.isInterrupted()){
                System.out.println("已经停止");
                break;
            }
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) {
        try {
            Thread thread = new InterruptedThreadByException();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
