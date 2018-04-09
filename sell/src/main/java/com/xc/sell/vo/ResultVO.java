package com.xc.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * create by 姜 sir
 * 2018/3/31 0:02
 */
@Data
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String msg = "";

    /**
     * 具体内容
     */
    private T data;
}
