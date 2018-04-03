package com.xc.sell.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 * create by 姜 sir
 * 2018/4/1 16:44
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
