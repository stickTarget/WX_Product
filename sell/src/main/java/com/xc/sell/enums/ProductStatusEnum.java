package com.xc.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 * create by 姜 sir
 * 2018/3/30 23:15
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架"),
    ;
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
