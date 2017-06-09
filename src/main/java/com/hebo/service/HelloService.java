package com.hebo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hebo on 2017/3/8.
 * hello
 */
@Component
public class HelloService {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/1 * * * * ?}")
    public void print(){
        //System.out.println("1秒输出一次："+ simpleDateFormat.format(new Date()));
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String sayHello(){
        return "你好何博";
    }
}
