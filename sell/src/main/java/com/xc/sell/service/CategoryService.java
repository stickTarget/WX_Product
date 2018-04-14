package com.xc.sell.service;

import com.xc.sell.dataobject.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类目
 * create by 姜 sir
 * 2018/3/29 10:19
 */
public interface CategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);
}
