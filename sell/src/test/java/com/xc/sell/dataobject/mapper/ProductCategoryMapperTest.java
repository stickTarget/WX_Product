package com.xc.sell.dataobject.mapper;

import com.xc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/4/13 21:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String ,Object> map = new HashMap<>();
        map.put("category_name","热搜" );
        map.put("category_type","101" );
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result );
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryName("类搜");
        productCategory.setCategoryType(12);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result );
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = mapper.findByCategoryType(101);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = mapper.findByCategoryName("热搜");
        Assert.assertNotEquals(0,result.size() );
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType(102, "我是热搜");
        Assert.assertEquals(1,result );
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryName("类搜");
        productCategory.setCategoryType(12);
        int result = mapper.updateByObject(productCategory);
        Assert.assertNotNull(result );
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(102);
        Assert.assertEquals(1,result );
    }
}