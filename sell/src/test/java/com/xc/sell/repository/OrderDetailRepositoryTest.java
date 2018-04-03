package com.xc.sell.repository;

import com.xc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/3 9:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("11111111");
        System.out.println(result);
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void saveTest(){
        OrderDetail orderDetail =new OrderDetail();
        orderDetail.setDetailId("123456780");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("111112");
        orderDetail.setProductName("");
        orderDetail.setProductQuantity(89);
        orderDetail.setProductPrice(new BigDecimal(3.2));
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    };
}