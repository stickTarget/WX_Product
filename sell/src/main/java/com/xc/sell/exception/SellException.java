package com.xc.sell.exception;

import com.xc.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * 自定义异常
 * create by 姜 sir
 * 2018/4/3 9:49
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMag());

        this.code = resultEnum.getCode();

    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
