package com.xc.sell.dto;

import lombok.Data;

/**
 * 购物车
 * create by 姜 sir
 * 2018/4/3 10:22
 */
@Data
public class CatDTO {
    /** 商品ID. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CatDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
