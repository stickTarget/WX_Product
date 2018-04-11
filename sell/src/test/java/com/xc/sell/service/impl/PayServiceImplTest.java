package com.xc.sell.service.impl;

import com.xc.sell.dto.OrderDTO;
import com.xc.sell.service.OrderService;
import com.xc.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/10 11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception{
        OrderDTO orderDTO =orderService.findOne("112112");
        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        //微信退款需要证书
        OrderDTO orderDTO =orderService.findOne("112112");
        payService.refund(orderDTO);
    }
}