package com.hebo.java.thread;

/**
 * @author bo.he@ttpai.cn  Thread.join 线程A内执行线程B.join   线程A需要引用线程B Thread 然后join
 */
public class ThreadJoin {

    static class Join implements Runnable {

        private Thread thread;

        public Join(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行");
        }
    }

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Join(thread), "" + i);
            thread1.start();
            thread = thread1;
        }
    }
}
