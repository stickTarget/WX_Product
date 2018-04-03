package com.xc.sell.repository;

import com.xc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/3 8:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private final String OPENID ="110110";
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void findByOpenid() {
            PageRequest request = new PageRequest(1,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getTotalElements());
        System.out.println(result.getContent());
        System.out.println(result.getSize());

    }
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("师弟");
        orderMaster.setBuyerPhone("12345654321");
        orderMaster.setBuyerAddress("中关村");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(5.2));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}