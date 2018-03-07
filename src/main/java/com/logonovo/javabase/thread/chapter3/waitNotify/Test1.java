package com.logonovo.javabase.thread.chapter3.waitNotify;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/7 22:34
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String s = new String("");
            s.wait();//抛IllegalMonitorStateException，没有同步加锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
