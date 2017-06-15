package com.hebo.java.thread.callable;

import java.util.concurrent.Callable;

/**
 * Created by hebo on 2017/6/9.
 * 使用Callable创建线程
 */
public class MyCallable implements Callable<Integer> {

    private int i = 0;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
