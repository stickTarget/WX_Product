package com.xc.sell.dto;

import com.xc.sell.dataobject.OrderDetail;
import com.xc.sell.dataobject.OrderMaster;
import com.xc.sell.enums.OrderStatusEnum;
import com.xc.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * create by 姜 sir
 * 2018/4/3 9:36
 */
@Data
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
    private Date createTime;

    /** 更新时间. */
    private  Date updateTime;

    List<OrderDetail> orderDetailList;
}
