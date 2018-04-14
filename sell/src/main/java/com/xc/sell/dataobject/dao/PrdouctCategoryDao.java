package com.xc.sell.dataobject.dao;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * create by 姜 sir
 * 2018/4/13 21:48
 */
public class PrdouctCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String,Object> map){
        return mapper.insertByMap(map);
    }
}
