package com.xc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.omg.CORBA.StringHolder;

import java.math.BigDecimal;

/**
 * 商品
 * create by 姜 sir
 * 2018/3/31 0:22
 */
@Data
public class ProductVO {

    @JsonProperty("id")
    private Integer productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
