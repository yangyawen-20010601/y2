package com.example.springbootrbbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootRbbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

        Map<String ,Object> map = new HashMap<>();
        map.put("msg","发的第一个消息");
        map.put("data", Arrays.asList("hellowyyw",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","bdqn.news",map);
    }
    @Test
    public void recevie(){
        Object o = rabbitTemplate.receiveAndConvert("bdqn.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
