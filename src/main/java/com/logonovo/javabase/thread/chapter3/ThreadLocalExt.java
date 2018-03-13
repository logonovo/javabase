package com.logonovo.javabase.thread.chapter3;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/13 22:27
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "默认值";
    }

    public static void main(String[] args) {
        ThreadLocalExt t1 = new ThreadLocalExt();
        if (t1.get() == null){
            System.out.println("没有默认值");
            t1.set("新值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());

    }
}
