package com.xc.sell.service.impl;

import com.xc.sell.dataobject.OrderDetail;
import com.xc.sell.dto.OrderDTO;
import com.xc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/3 10:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("中关村");
        orderDTO.setBuyerName("小澈");
        orderDTO.setBuyerPhone("11111111111");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList =new ArrayList<>();

        OrderDetail o1= new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);
        OrderDetail o2= new OrderDetail();
        o2.setProductId("123458");
        o2.setProductQuantity(3);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result=={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}