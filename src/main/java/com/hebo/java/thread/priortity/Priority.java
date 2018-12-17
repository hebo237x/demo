package com.hebo.java.thread.priortity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author bo.he@ttpai.cn 线程优先级
 */
public class Priority {

    private static volatile boolean notEnd = true;

    static class Job implements Runnable {

        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notEnd) {
                jobCount++;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int pri = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(pri);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(pri);
            thread.start();
        }
        TimeUnit.SECONDS.sleep(2L);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("JOB PRI:" + job.priority + " COUNT:" + job.jobCount);
        }
    }

}
