package com.hebo.java.thread.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hebo on 2017/6/15.
 * synchronized 测试
 */
public class MySynchronizedFun implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void synMethod(Integer a1){
        synchronized(a1) {
            System.out.println(a1);
        }
    }

    public static void main(String[] args){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    synMethod(index);
                }
            });
        }

        MySynchronizedFun mt = new MySynchronizedFun();
        Thread t1 = new Thread(mt, "t1");
        Thread t2 = new Thread(mt, "t2");
        Thread t3 = new Thread(mt, "t3");
        Thread t4 = new Thread(mt, "t4");
        Thread t5 = new Thread(mt, "t5");
        Thread t6 = new Thread(mt, "t6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
