package com.hebo.thread;

import com.hebo.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebo on 2017/6/9.
 */
public class ArrayListThread {
    private static volatile int i = 0;
    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> list.add("3")).start();

        new Thread(() -> list.add("4")).start();
        System.out.println(JsonUtils.toJSONString(list));
    }


}
