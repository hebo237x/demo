package com.hebo.java.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bo.he@ttpai.cn
 * @date 2018/9/30
 */
public class Pair<K,V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static <A> A getMiddle(A[] a) {
        return a[a.length / 2];
    }

    public static void main(String[] args){
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("泛型测试,item = " + item);
        }
    }
}
