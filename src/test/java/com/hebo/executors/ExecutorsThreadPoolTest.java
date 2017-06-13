package com.hebo.executors;

/**
 * Created by hebo on 2017/6/13.
 */
public class ExecutorsThreadPoolTest {

    public static void main(String[] args) {
        ExecutorsThreadPool.newCachedThreadPoolCreate();
        ExecutorsThreadPool.newFixedThreadPoolCreate();
        ExecutorsThreadPool.newScheduledThreadPoolCreate();
        ExecutorsThreadPool.newSingleThreadExecutorCreate();
    }
}