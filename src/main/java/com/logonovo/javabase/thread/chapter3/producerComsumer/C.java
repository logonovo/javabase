package com.logonovo.javabase.thread.chapter3.producerComsumer;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/8 22:38
 */
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者"+Thread.currentThread().getName()+" waiting 了");
                    lock.wait();
                }
                System.out.println("消费者 "+Thread.currentThread().getName()+" RUNNABLE了");
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
