package com.xc.sell.service;

import com.xc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * create by 姜 sir
 * 2018/3/29 10:19
 */
public interface CategoryService {

    /**
     * 通过id查询ProductCategory类目
     * @param id
     * @return
     */
    ProductCategory findOne(Integer id);

    /**
     * 查询所有ProductCategory对象
     * @return
     */
    List<ProductCategory> findAll();

    /** 通过CategoryType查询所有ProductCate对象 */
    List<ProductCategory> findByCategoryType(List<Integer> list);

    /**
     * 通过id删除 对象
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加对象
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
