package com.logonovo.javabase.thread.chapter4.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/15 22:18
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try {
            lock.readLock().lock();
            System.out.println("获取读锁:"+System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        try {
            lock.writeLock().lock();
            System.out.println("获取写锁:"+System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        };
        Thread a = new Thread(runnable);
        a.start();
        Thread b = new Thread(runnable);
        b.start();


        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        };
        Thread c  = new Thread(runnable2);
        c.start();

        Thread d = new Thread(runnable2);
        d.start();
    }
}
