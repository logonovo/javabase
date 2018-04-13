package com.logonovo.javabase.thread.chapter7;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/31 22:59
 */
public class RateLimiterDemo {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
        RateLimiter rateLimiter = RateLimiter.create(10);
        while (true){
            rateLimiter.acquire();
            System.out.println(simpleDateFormat.format(new Date()));
        }
    }
}
