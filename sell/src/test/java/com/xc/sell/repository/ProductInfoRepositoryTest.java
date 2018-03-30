package com.xc.sell.repository;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.service.ProductInfoService;
import com.xc.sell.service.impl.ProductInfoServiceImpl;
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
 * 2018/3/30 23:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.4));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一盘很好吃的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    };

    @Test
    public void findByProductStatusIn() {
        List<ProductInfo> result = repository.findByProductStatusIn(0);
        Assert.assertNotEquals(0,result.size());
    }
}