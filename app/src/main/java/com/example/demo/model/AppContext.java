package com.example.demo.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppContext {

    /**
     * 保存当前登录用户信息
     */
    public static User curUser;

    /**
     * 线程池
     */
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,5,0,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(512),
            new ThreadPoolExecutor.DiscardPolicy());
}
