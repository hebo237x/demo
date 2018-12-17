package com.hebo.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author bo.he@ttpai.cn 线程状态
 */
public class ThreadState {

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true){
                second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
                synchronized (Blocked.class){
                    while (true){
                        second(100);
                    }
                }
        }
    }

    static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args){
        new Thread(new TimeWaiting(),"TimeWaiting").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Blocked(),"Blocked-1").start();
        new Thread(new Blocked(),"Blocked-2").start();
    }
}
