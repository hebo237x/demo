package com.hebo.java.thread.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hebo on 2017/6/16.
 */
public class MapTest {

    public static void main(String[] args) throws Exception {
        Map<String, Integer> hashmapSync = Collections.synchronizedMap(new HashMap<String, Integer>());
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, Integer> hashtable = new Hashtable<String, Integer>();
        long totalA = 0;
        long totalB = 0;
        long totalC = 0;
        for (int i = 0; i <= 10; i++) {
            totalA += testPut(hashmapSync);
            totalB += testPut(concurrentHashMap);
            totalC += testPut(hashtable);
        }
        System.out.println("Put time HashMapSync=" + totalA + "ms.");
        System.out.println("Put time ConcurrentHashMap=" + totalB + "ms.");
        System.out.println("Put time Hashtable=" + totalC + "ms.");
        totalA = 0;
        totalB = 0;
        totalC = 0;
        for (int i = 0; i <= 10; i++) {
            totalA += testGet(hashmapSync);
            totalB += testGet(concurrentHashMap);
            totalC += testGet(hashtable);
        }
        System.out.println("Get time HashMapSync=" + totalA + "ms.");
        System.out.println("Get time ConcurrentHashMap=" + totalB + "ms.");
        System.out.println("Get time Hashtable=" + totalC + "ms.");
    }


    public static long testPut(Map<String, Integer> map) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new MapPutThread(map).start();
        }
        while (MapPutThread.counter > 0) {
            Thread.sleep(1);
        }
        return System.currentTimeMillis() - start;
    }
    public static long testGet(Map<String, Integer> map) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new MapPutThread(map).start();
        }
        while (MapPutThread.counter > 0) {
            Thread.sleep(1);
        }
        return System.currentTimeMillis() - start;
    }
}
