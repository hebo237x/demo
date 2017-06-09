package com.hebo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hebo on 2017/3/8.
 */
@Component
public class AmqpCustomer {

   /* @RabbitListener(queues = "hebo")
    public void dd(String message) {
        System.out.println("消费ddddddddd：" + message);
    }*/

}
