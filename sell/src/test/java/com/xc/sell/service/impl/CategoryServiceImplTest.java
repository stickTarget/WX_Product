package com.xc.sell.service.impl;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * create by 姜 sir
 * 2018/3/29 10:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService= new CategoryServiceImpl();
    @Test
    public void findOne() {
        ProductCategory result = categoryService.findOne(1);
        System.err.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = categoryService.findAll();
        System.out.println(result.size());
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        System.out.println(result.size());
        Assert.assertNotEquals(0,result.size());
    }


    @Test
    public void save() {
        ProductCategory productCategory =new ProductCategory("豆奶粉",4);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}