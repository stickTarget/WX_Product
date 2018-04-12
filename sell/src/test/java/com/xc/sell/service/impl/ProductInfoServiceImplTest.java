package com.xc.sell.service.impl;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.enums.ProductStatusEnum;
import com.xc.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/3/30 23:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService service =new ProductInfoServiceImpl();

    @Test
    public void findOne() {
        ProductInfo result = service.findOne("123456");
        Assert.assertEquals("123456",result.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest request =new PageRequest(0,2);
        Page<ProductInfo> result = service.findAll(request);
       /* System.out.println(result.getTotalElements());*/
       Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = service.findUpAll();
        System.out.println(result.size());
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.4));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一盘很好吃的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = service.onSale("123123");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatus() );
    }

    @Test
    public void offSale() {
        ProductInfo productInfo = service.onSale("123123");
        Assert.assertEquals(ProductStatusEnum.DOWN,productInfo.getProductStatus() );
    }
}