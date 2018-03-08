package com.logonovo.javabase.thread.chapter3.producerComsumer;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/8 22:38
 */
public class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者"+Thread.currentThread().getName()+" waiting 了");
                    lock.wait();
                }
                System.out.println("生产者 "+Thread.currentThread().getName()+" RUNNABLE了");
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
