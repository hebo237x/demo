package com.hebo.java.thread.syn;

import java.util.concurrent.locks.LockSupport;

/**
 * @author bo.he@ttpai.cn
 */
public class TestSynchronizedLock {
    public synchronized void printAcc(){
        System.out.println("print msg");
    }

    public void print(){
        TestSynchronizedLock lock = new TestSynchronizedLock();
        int a = lock.hashCode();
        synchronized (lock){
            int b = lock.hashCode();
        }
        int c = lock.hashCode();
        int d = 32;
        LockSupport.park(this);
    }


    public static void main(String[] args)throws Exception {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                LockSupport.parkNanos(10000000000L);
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
    }
}
