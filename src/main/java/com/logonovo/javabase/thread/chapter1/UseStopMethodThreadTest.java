package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/3 22:18
 */
public class UseStopMethodThreadTest extends Thread {
    private int i = 0;
    @Override
    public void run() {
        super.run();
        try {
            while(true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Thread thread = new UseStopMethodThreadTest();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
