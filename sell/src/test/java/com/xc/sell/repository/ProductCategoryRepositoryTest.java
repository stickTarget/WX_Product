package com.xc.sell.repository;

import com.xc.sell.dataobject.ProductCategory;
import org.aspectj.lang.annotation.AfterReturning;
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
 * 2018/3/29 0:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory repositoryOne = repository.findOne(1);
        System.out.println(repositoryOne.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("瓜子",6);
        ProductCategory result = repository.save(productCategory);
        result=null;
        Assert.assertNotNull(result);
        /*Assert.assertNotEquals(null,result);*/

    }

    @Test
    @AfterReturning
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}