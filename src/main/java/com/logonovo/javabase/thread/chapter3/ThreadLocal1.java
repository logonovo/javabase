package com.logonovo.javabase.thread.chapter3;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/13 22:24
 */
public class ThreadLocal1 {
    public static ThreadLocal t1 = new ThreadLocal();
    public static void main(String[] args) {
        if(t1.get() == null){
            System.out.println("没有默认值");
            t1.set("设置值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
