package com.sxw.springbootproducer;

import com.sxw.entity.Order;
import com.sxw.springbootproducer.producer.OrderSender;
import com.sxw.springbootproducer.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProducerApplicationTests {
    @Autowired private OrderService orderService;
    @Autowired private OrderSender orderSender;

    @Test
    public void testSend() throws Exception {
        Order order = new Order();
        order.setId(2018092210);
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID().toString());
        orderService.createOrder(order);
    }

    @Test
    public void testSend1(){
        Order order = new Order();
        order.setId(2018092104);
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID().toString());
        orderSender.send(order);
    }
}
