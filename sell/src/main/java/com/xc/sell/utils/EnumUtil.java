package com.xc.sell.utils;

import com.xc.sell.enums.CodeEnum;

/**
 * create by 姜 sir
 * 2018/4/11 21:24
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    };
}
