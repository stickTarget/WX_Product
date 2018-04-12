package com.xc.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * create by 姜 sir
 * 2018/4/12 9:43
 */
@Data
public class ProductForm {
    /** 商品id*/
    private String productId;

    /** 商品名称*/
    private String productName;

    /** 商品价格*/
    private BigDecimal productPrice;

    /** 商品库存*/
    private Integer productStock;

    /** 商品描述*/
    private String productDescription;

    /** 商品图片*/
    private String productIcon;

     /** 商品类型*/
    private Integer categoryType;
}
