package com.xc.sell.service.impl;

import com.xc.sell.config.WechatAccountConfig;
import com.xc.sell.dto.OrderDTO;
import com.xc.sell.service.OrderService;
import com.xc.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/12 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PushMessageIServicemplTest {


    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("112112");
        pushMessageService.orderStatus(orderDTO);
    }
}