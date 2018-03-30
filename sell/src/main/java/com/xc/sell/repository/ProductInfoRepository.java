package com.xc.sell.repository;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 * create by 姜 sir
 * 2018/3/30 22:15
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatusIn(Integer status);
}
