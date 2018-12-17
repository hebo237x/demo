package com.hebo.java.thread.connectionpool;

import java.util.LinkedList;

/**
 * @author bo.he@ttpai.cn
 */
public class ConnectionPool {

    private LinkedList<String> pool = new LinkedList<>();


    public ConnectionPool(int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                pool.addLast(String.valueOf(i));
            }
        }
    }
}
