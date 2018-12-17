package com.hebo.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bo.he@ttpai.cn 线程等待，通知
 */
public class ThreadWaitAndNotify {
    static boolean flag = true;
    static volatile boolean volatileFlag = true;
    static Object lock = new Object();


    static class Wait implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            synchronized (lock) {
                System.out.println("Wait线程获取到锁");
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ",flag:" + flag + ",time:" + sdf.format
                                (new Date()));
                        System.out.println("Wait线程等待并释放当前锁");
                        lock.wait();//等待并释放当前锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ",flag:" + flag + ",time:" + sdf.format(new Date()));
            }
        }
    }


    static class Notify implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            synchronized (lock) {
                System.out.println("Notify线程获取到锁");
                System.out.println(Thread.currentThread().getName() + ",flag:" + flag + ",time:" + sdf.format(new Date()));
                System.out.println("Notify线程通知其他等待线程进入同步队列");
                lock.notifyAll();
                flag = false;
                ThreadState.second(5);
            }
            synchronized (lock) {
                System.out.println("Notify线程再次获取到锁");
                ThreadState.second(5);
            }

        }
    }


    static class VolatileWait implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (volatileFlag) {
                System.out.println(Thread.currentThread().getName() + ",volatileFlag:" + volatileFlag + ",time:" + sdf.format
                        (new Date()));
                System.out.println("sleep 5s");
                ThreadState.second(5);
            }
            System.out.println(Thread.currentThread().getName() + ",volatileFlag:" + volatileFlag + ",time:" + sdf.format(new Date()));
        }
    }


    static class VolatileNotify implements Runnable {
        @Override
        public void run() {
            while (volatileFlag){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("改变volatileFlag = false");
                ThreadState.second(15);
                volatileFlag = false;
            }
        }
    }

    public static void main(String[] args) {
       /* Wait wait = new Wait();
        new Thread(wait, "WaitThread").start();
        ThreadState.second(1);
        Notify notify = new Notify();
        new Thread(notify, "NotifyThread").start();
        ThreadState.second(2);*/


        new Thread(new VolatileWait(), "VolatileWaitThread").start();
        ThreadState.second(1);
        new Thread(new VolatileNotify(), "VolatileNotifyThread").start();

    }


}
