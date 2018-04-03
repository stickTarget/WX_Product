package com.xc.sell.enums;

import lombok.Getter;

/**
 * create by 姜 sir
 * 2018/4/3 9:50
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ;
    private Integer code;

    private String mag;

    ResultEnum(Integer code, String mag) {
        this.code = code;
        this.mag = mag;
    }
}
