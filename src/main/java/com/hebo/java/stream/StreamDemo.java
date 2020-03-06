package com.hebo.java.stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bo.he@ttpai.cn
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        boolean allMatch = list.stream().allMatch(t -> t.equals(1));
        boolean anyMatch = list.stream().anyMatch(t -> t.equals(1));
        boolean noneMatch = list.stream().noneMatch(t -> t.equals(1));
        List<Integer> f1 = list.stream().filter(t -> t.equals(1)).collect(Collectors.toList());
        List<Integer> m1 = list.stream().map(t -> t).collect(Collectors.toList());
        Map<String, Integer> m2 = list.stream().map(t -> t).collect(Collectors.toMap(String::valueOf, t -> t));
        System.out.println("是否都是1,allMatch:" + allMatch);
        System.out.println("是否有个是1,anyMatch:" + anyMatch);
        System.out.println("是否全部不是1,noneMatch:" + noneMatch);
        System.out.println("f1" + JSON.toJSONString(f1));
        System.out.println("m1" + JSON.toJSONString(m1));
        System.out.println("m2" + JSON.toJSONString(m2));

        System.out.println(f());
        System.out.println(a());
    }

    private static  boolean f(){
        try {
            return true;
        }catch (Exception e){
            return true;
        }finally {
            return false;
        }
    }

    private static  Integer a(){
        Integer a = 1;
        try {
            return a = 6;
        }catch (Exception e){
            return a = 7;
        }finally {
            return a = 8;
        }
    }
}
