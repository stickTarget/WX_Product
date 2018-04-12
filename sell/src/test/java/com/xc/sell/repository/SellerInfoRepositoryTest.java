package com.xc.sell.repository;

import com.xc.sell.dataobject.SellerInfo;
import com.xc.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/12 13:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo =new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    };

    @Test
    public void findByOpenid()throws Exception {
      //  sellerInfoRepository.findByOpenid()
        SellerInfo result=sellerInfoRepository.findByOpenid("abc");
        Assert.assertEquals("abc",result.getOpenid());
    }
}