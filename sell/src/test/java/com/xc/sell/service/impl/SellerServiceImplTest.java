package com.xc.sell.service.impl;

import com.xc.sell.dataobject.SellerInfo;
import com.xc.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/12 14:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid = "abc";

    @Autowired
    SellerService sellerService;

    @Test
    public void findSellerInfoByOnpenid() {
        SellerInfo result = sellerService.findSellerInfoByOnpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }
}