package com.xc.sell.service.impl;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.dto.CatDTO;
import com.xc.sell.enums.ProductStatusEnum;
import com.xc.sell.enums.ResultEnum;
import com.xc.sell.exception.SellException;
import com.xc.sell.repository.ProductInfoRepository;
import com.xc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.util.List;

/**
 * 商品
 * create by 姜 sir
 * 2018/3/30 23:13
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatusIn(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CatDTO> catDTOList) {
        for (CatDTO catDTO : catDTOList) {
            ProductInfo productInfo = repository.findOne(catDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + catDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CatDTO> catDTOList) {
        for (CatDTO catDTO : catDTOList) {
            ProductInfo productInfo = repository.findOne(catDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - catDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);

        }
    }
}
