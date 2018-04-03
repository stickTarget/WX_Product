package com.xc.sell.service;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.dto.CatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * create by 姜 sir
 * 2018/3/30 23:08
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //增加库存
    void increaseStock(List<CatDTO> catDTOList);

    //减少库存
    void decreaseStock (List<CatDTO> catDTOList);
}
