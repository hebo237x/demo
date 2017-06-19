package com.hebo.java.thread.map;

import java.util.Map;

/**
 * Created by hebo on 2017/6/16.
 */
public class MapPutThread extends Thread {
    static int counter = 0;
    static Object lock = new Object();
    private Map<String, Integer> map;
    private String key = this.getId() + "";
    MapPutThread(Map<String, Integer> map) {
        synchronized (lock) {
            counter++;
        }
        this.map = map;
    }
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            map.put(key, i);
        }
        synchronized (lock) {
            counter--;
        }
    }

}
