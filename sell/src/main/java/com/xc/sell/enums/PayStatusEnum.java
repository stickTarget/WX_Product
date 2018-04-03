package com.xc.sell.enums;

import lombok.Getter;

/**
 * 支付枚举类
 * create by 姜 sir
 * 2018/4/3 8:37
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private String mag;

    PayStatusEnum(Integer code, String mag) {
        this.code = code;
        this.mag = mag;
    }
}
