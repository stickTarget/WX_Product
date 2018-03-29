package com.xc.sell.service.impl;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.repository.ProductCategoryRepository;
import com.xc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by 姜 sir
 * 2018/3/29 10:27
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;


    @Override
    public ProductCategory findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> list) {
        return repository.findByCategoryTypeIn(list);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
