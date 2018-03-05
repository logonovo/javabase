package com.logonovo.javabase.thread.chapter2;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/5 22:18
 */
public class RunThread extends Thread {
    volatile private boolean isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run");
        while(isRunning == true){

        }
        System.out.println("线程被停止了");
    }

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
