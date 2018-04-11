package com.xc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xc.sell.dataobject.OrderDetail;
import com.xc.sell.enums.OrderStatusEnum;
import com.xc.sell.enums.PayStatusEnum;
import com.xc.sell.utils.EnumUtil;
import com.xc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by 姜 sir
 * 2018/4/3 9:36
 */
@Data
/*@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)*/
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class OrderDTO {
    private String orderId;

    /** 买家名称. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态默认0新订单. */
    private Integer orderStatus;

    /** 支付状态默认0,未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private  Date updateTime;

    List<OrderDetail> orderDetailList = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(Integer code){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class );
    }
    @JsonIgnore
    public PayStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class );
    }
}
